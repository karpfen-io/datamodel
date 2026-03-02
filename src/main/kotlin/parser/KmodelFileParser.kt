/**
 * Copyright 2026 Karl Kegel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package parser

import kmodel.KmodelLexer
import kmodel.KmodelParser
import kmodel.KmodelBaseVisitor
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

class KmodelFileParser {

    fun parseFile(filePath: String): KmodelFile {
        val file = File(filePath)
        return parseString(file.readText())
    }

    fun parseString(content: String): KmodelFile {
        val inputStream = CharStreams.fromString(content)
        val lexer = KmodelLexer(inputStream)
        val tokens = CommonTokenStream(lexer)
        val parser = KmodelParser(tokens)

        val parseTree = parser.kmodel_file()
        val visitor = KmodelParseVisitor()

        return visitor.visit(parseTree) ?: KmodelFile(emptyList())
    }
}

class KmodelParseVisitor : KmodelBaseVisitor<KmodelFile>() {

    override fun visitKmodel_file(ctx: KmodelParser.Kmodel_fileContext): KmodelFile {
        val rootObject = visitMakeObjectBlock(ctx.make_object_block())
        return KmodelFile(listOf(rootObject))
    }

    private fun visitMakeObjectBlock(ctx: KmodelParser.Make_object_blockContext): ModelObject {
        val signature = ctx.object_signature()
        val keyAndClassName = parseObjectSignature(signature)
        val key = keyAndClassName.first
        val className = keyAndClassName.second

        val modelObject = ModelObject(key, className)

        val statements = ctx.statement()
        if (statements != null) {
            for (stmt in statements) {
                when {
                    stmt.prop_statement() != null -> {
                        val propStmt = stmt.prop_statement()
                        val propKey = extractStringFromQuotes(propStmt.STRING(0).text)
                        val propValue = extractStringFromQuotes(propStmt.STRING(1).text)
                        modelObject.addProp(propKey, propValue)
                    }
                    stmt.has_statement() != null -> {
                        val hasStmt = stmt.has_statement()
                        val hasKey = extractStringFromQuotes(hasStmt.STRING().text)
                        val childObject = visitMakeObjectBlock(hasStmt.make_object_block())
                        modelObject.addHas(hasKey, childObject)
                    }
                    stmt.knows_statement() != null -> {
                        val knowsStmt = stmt.knows_statement()
                        val knowsKey = extractStringFromQuotes(knowsStmt.STRING(0).text)
                        val knowsValue = extractStringFromQuotes(knowsStmt.STRING(1).text)
                        modelObject.addKnows(knowsKey, knowsValue)
                    }
                }
            }
        }

        return modelObject
    }

    private fun parseObjectSignature(ctx: KmodelParser.Object_signatureContext): Pair<String, String> {
        val firstString = extractStringFromQuotes(ctx.STRING(0).text)

        val key = ctx.children.first().text.removeSurrounding("\"").removeSurrounding("\'")
        val className = ctx.children.last().text.removeSurrounding("\"").removeSurrounding("\'")

        return Pair(key, className)
    }

    private fun extractStringFromQuotes(text: String): String {
        return text.trim('"', '\'')
    }
}

data class KmodelFile(val objects: List<ModelObject>)

data class ModelObject(
    val key: String,
    val className: String
) {
    val props = mutableListOf<ObjectProperty>()
    val has = mutableListOf<HasRelation>()
    val knows = mutableListOf<KnowsRelation>()

    fun addProp(key: String, value: String) {
        props.add(ObjectProperty(key, value))
    }

    fun addHas(key: String, childObject: ModelObject) {
        has.add(HasRelation(key, childObject))
    }

    fun addKnows(key: String, value: String) {
        knows.add(KnowsRelation(key, value))
    }

    override fun toString(): String {
        val keyStr = if (key.isNotEmpty()) "$key:" else ":"
        return "make object \"$keyStr$className\""
    }
}

data class ObjectProperty(val key: String, val value: String)
data class HasRelation(val key: String, val childObject: ModelObject)
data class KnowsRelation(val key: String, val value: String)

