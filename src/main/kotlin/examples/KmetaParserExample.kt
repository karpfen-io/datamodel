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
package examples

import parser.KmetaFileParser
import parser.ListValue
import parser.StringValue

/**
 * MINIMAL Kmeta DSL PARSER EXAMPLE
 * This example does not use a proper metamodel or any safe type checking.
 * This class just demonstrates how to use the KmetaFileParser to parse a simple Kmeta DSL string and print
 * the resulting ModelObjects in a readable format.
 *
 * FOR SAFE USE, ALWAYS USE THE KmetaDSLConverter TO CONVERT THE PARSER OUTPUT INTO A PROPER MODEL BASED ON A METAMODEL,
 * AND THEN USE THE MODEL IN YOUR APPLICATION.
 */
fun main() {
    val parser = KmetaFileParser()

    val content = """
        type "Person" "A person entity" {
            prop("name", "string")
            prop("age", "number")
            has("address", list("Address"))
            knows("friends", list("Person"))
        }
        
        type "Address" "An address entity" {
            prop("street", "string")
            prop("city", "string")
            prop("zipCode", "string")
        }
    """.trimIndent()

    val kmetaFile = parser.parseString(content)

    println("=".repeat(50))
    println("Parsed ${kmetaFile.types.size} type(s):")
    println("=".repeat(50))

    for (type in kmetaFile.types) {
        println("\nType: ${type.name}")
        println("   Description: ${type.description}")

        if (type.props.isNotEmpty()) {
            println("\n   Properties:")
            for (prop in type.props) {
                val valueStr = when (val v = prop.value) {
                    is StringValue -> v.value
                    is ListValue -> "list(${v.value})"
                }
                println("      • ${prop.key}: $valueStr")
            }
        }

        if (type.has.isNotEmpty()) {
            println("\n   Has:")
            for (hasRule in type.has) {
                val valueStr = when (val v = hasRule.value) {
                    is StringValue -> v.value
                    is ListValue -> "list(${v.value})"
                }
                println("      • ${hasRule.key}: $valueStr")
            }
        }

        if (type.knows.isNotEmpty()) {
            println("\n   Knows:")
            for (knowsRule in type.knows) {
                val valueStr = when (val v = knowsRule.value) {
                    is StringValue -> v.value
                    is ListValue -> "list(${v.value})"
                }
                println("      • ${knowsRule.key}: $valueStr")
            }
        }
    }

    println("\n" + "=".repeat(50))
}

