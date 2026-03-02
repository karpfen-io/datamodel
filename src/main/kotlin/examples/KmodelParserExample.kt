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

import parser.KmodelFileParser
import parser.ModelObject

/**
 * MINIMAL DSL PARSER EXAMPLE
 * This example does not use a proper metamodel or any safe type checking.
 * This class just demonstrates how to use the KmodelFileParser to parse a simple Kmodel DSL string and print
 * the resulting ModelObjects in a readable format.
 *
 * FOR SAFE USE, ALWAYS USE THE KmodelDSLConverter TO CONVERT THE PARSER OUTPUT INTO A PROPER MODEL BASED ON A METAMODEL,
 * AND THEN USE THE MODEL IN YOUR APPLICATION.
 */
fun main() {
    val parser = KmodelFileParser()

    val content = """
        make object "APB 2101":"Room" {
            prop("room_number") -> "2101"
            prop("floor") -> "2"
            
            has("top_left") -> make object "_":"Point" {
                prop("x") -> "0.0"
                prop("y") -> "10.0"
            }
            
            has("top_right") -> make object "_":"Point" {
                prop("x") -> "10.0"
                prop("y") -> "10.0"
            }
            
            has("bottom_left") -> make object "_":"Point" {
                prop("x") -> "0.0"
                prop("y") -> "0.0"
            }
            
            has("robot") -> make object "turtle":"Robot" {
                prop("speed") -> "1.0"
                prop("battery_level") -> "85"
                
                has("position") -> make object "_":"Point" {
                    prop("x") -> "5.0"
                    prop("y") -> "5.0"
                }
                
                knows("home_position") -> "charging_station"
                knows("current_task") -> "exploring"
            }
            
            has("obstacles") -> make object "chair":"Obstacle" {
                prop("type") -> "furniture"
                
                has("position") -> make object "_":"Point" {
                    prop("x") -> "2.0"
                    prop("y") -> "3.0"
                }
            }
        }
    """.trimIndent()

    val kmodelFile = parser.parseString(content)

    println("=".repeat(60))
    println("Parsed ${kmodelFile.objects.size} object(s):")
    println("=".repeat(60))

    for (obj in kmodelFile.objects) {
        printObject(obj, indent = 0)
    }

    println("\n" + "=".repeat(60))
}

/**
 * Recursively prints a ModelObject with proper indentation
 */
fun printObject(obj: ModelObject, indent: Int = 0) {
    val prefix = "  ".repeat(indent)
    val nextPrefix = "  ".repeat(indent + 1)

    println("\n${prefix}Object: ${obj}")
    println("$prefix{")

    // Print properties
    if (obj.props.isNotEmpty()) {
        println("$nextPrefix// Properties:")
        for (prop in obj.props) {
            println("$nextPrefix• ${prop.key}: ${prop.value}")
        }
    }

    // Print has relations (recursively)
    if (obj.has.isNotEmpty()) {
        if (obj.props.isNotEmpty()) println()
        println("$nextPrefix// Has Relations:")
        for (hasRel in obj.has) {
            println("$nextPrefix• ${hasRel.key}:")
            printObjectInline(hasRel.childObject, indent + 2)
        }
    }

    // Print knows relations
    if (obj.knows.isNotEmpty()) {
        if (obj.props.isNotEmpty() || obj.has.isNotEmpty()) println()
        println("$nextPrefix// Knows Relations:")
        for (knowsRel in obj.knows) {
            println("$nextPrefix• ${knowsRel.key}: ${knowsRel.value}")
        }
    }

    println("$prefix}")
}

/**
 * Recursively prints a ModelObject with proper indentation for nested objects
 */
fun printObjectInline(obj: ModelObject, indent: Int = 0) {
    val prefix = "  ".repeat(indent)
    val nextPrefix = "  ".repeat(indent + 1)

    println("$prefix${obj} {")

    // Print properties
    if (obj.props.isNotEmpty()) {
        for (prop in obj.props) {
            println("$nextPrefix• ${prop.key}: ${prop.value}")
        }
    }

    // Print has relations (recursively)
    if (obj.has.isNotEmpty()) {
        if (obj.props.isNotEmpty()) println()
        for (hasRel in obj.has) {
            println("$nextPrefix• ${hasRel.key}:")
            printObjectInline(hasRel.childObject, indent + 1)
        }
    }

    // Print knows relations
    if (obj.knows.isNotEmpty()) {
        if (obj.props.isNotEmpty() || obj.has.isNotEmpty()) println()
        for (knowsRel in obj.knows) {
            println("$nextPrefix• ${knowsRel.key}: ${knowsRel.value}")
        }
    }

    println("$prefix}")
}

