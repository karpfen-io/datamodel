package examples

import parser.KmetaFileParser
import parser.ListValue
import parser.StringValue

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

