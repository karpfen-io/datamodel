# KModel Grammar Guide

## Overview

KModel is a Domain-Specific Language (DSL) for defining data model instances within the *karpfen ecosystem*. While KMeta defines the structure and schema of types, KModel creates concrete instances of those types with actual data values.

This guide covers:
- The KModel grammar and syntax
- How to write KModel instance definitions
- Examples and best practices
- Alternative approaches using the functional API

## Grammar Specification

The KModel grammar is defined using ANTLR v4 and follows this structure:

### ANTLR Grammar (Kmodel.g4)

```antlr
grammar Kmodel;

// Parser Rules
kmodel_file
    : make_object_block EOF
    ;

make_object_block
    : MAKE OBJECT object_signature LBRACE statement* RBRACE
    ;

object_signature
    : STRING COLON STRING
    ;

statement
    : prop_statement
    | has_statement
    | knows_statement
    ;

prop_statement
    : PROP LPAREN STRING RPAREN ARROW STRING
    ;

has_statement
    : HAS LPAREN STRING RPAREN ARROW make_object_block
    ;

knows_statement
    : KNOWS LPAREN STRING RPAREN ARROW STRING
    ;

// Lexer Rules
MAKE     : 'make' ;
OBJECT   : 'object' ;
PROP     : 'prop' ;
HAS      : 'has' ;
KNOWS    : 'knows' ;

LBRACE   : '{' ;
RBRACE   : '}' ;
LPAREN   : '(' ;
RPAREN   : ')' ;
COLON    : ':' ;
ARROW    : '->' ;

STRING   : '"' (~["\r\n] | '\\' .)* '"'
         | '\'' (~['\r\n] | '\\' .)* '\''
         ;

WS       : [ \t\r\n]+ -> skip ;
COMMENT  : '//' ~[\r\n]* -> skip ;
```

## KModel Syntax

### Basic Structure

A KModel instance file starts with a single root object definition using the `make object` keyword:

```
make object "<key>:<ClassName>" {
    [prop_statement]*
    [has_statement]*
    [knows_statement]*
}
```

### Object Creation

Each object is created with the `make object` keyword followed by an object signature:

```
make object "<key>":"<ClassName>" {
    ...
}
```

- `<key>`: A unique identifier for this object instance (can be empty for anonymous objects using just `:ClassName`)
- `<ClassName>`: The type of the object, as defined in the metamodel
- `{ ... }`: The object body containing property and relationship assignments

Example:
```
make object "APB 2101":"Room" {
    ...
}
```

### Property Assignment (prop)

Properties assign concrete values to properties defined in the metamodel:

```
prop("<propertyName>") -> "<value>"
```

- `<propertyName>`: The property name as defined in the metamodel
- `<value>`: The concrete value (as a string)

Example:
```
prop("x") -> "5.0"
prop("diameter") -> "1.0"
prop("speed") -> "2.5"
```

### Embedded Objects (has)

The `has` statement assigns child objects to embedded relationships:

```
has("<relationName>") -> make object "<key>":"<ClassName>" {
    ...
}
```

This creates a nested object hierarchy. Child objects can themselves contain nested objects.

Example:
```
has("position") -> make object "pointA":"Point" {
    prop("x") -> "0.0"
    prop("y") -> "10.0"
}
```

### References (knows)

The `knows` statement creates references to other objects by their key:

```
knows("<relationName>") -> "<objectKey>"
```

This allows linking to objects defined elsewhere without duplicating their data.

Example:
```
knows("obstacles") -> "chair"
knows("obstacles") -> "table"
```

## Complete Example

The following example defines a model instance for a robot navigation system:

```
make object "APB 2101":"Room" {
    has("top_left") -> make object "topLeftPoint":"Point" {
        prop("x") -> "0.0"
        prop("y") -> "10.0"
    }
    has("top_right") -> make object "topRightPoint":"Point" {
        prop("x") -> "10.0"
        prop("y") -> "10.0"
    }
    has("bottom_left") -> make object "bottomLeftPoint":"Point" {
        prop("x") -> "0.0"
        prop("y") -> "0.0"
    }
    has("bottom_right") -> make object "bottomRightPoint":"Point" {
        prop("x") -> "0.0"
        prop("y") -> "0.0"
    }
    has("obstacles") -> make object "chair":"Obstacle" {
        has("boundingBox") -> make object "chairBoundingBox":"TwoDObject" {
            prop("diameter") -> "1.0"
            has("position") -> make object "chairPosition":"Point" {
                prop("x") -> "2.0"
                prop("y") -> "3.0"
            }
        }
    }
    has("obstacles") -> make object "table":"Obstacle" {
        has("boundingBox") -> make object "tableBoundingBox":"TwoDObject" {
            prop("diameter") -> "3.0"
            has("position") -> make object "tablePosition":"Point" {
                prop("x") -> "5.0"
                prop("y") -> "7.0"
            }
        }
    }
    has("robot") -> make object "turtle":"Robot" {
        prop("speed") -> "1.0"
        has("boundingBox") -> make object "turtleBoundingBox":"TwoDObject" {
            prop("diameter") -> "1.0"
            has("position") -> make object "turtlePosition":"Point" {
                prop("x") -> "5.0"
                prop("y") -> "5.0"
            }
        }
        knows("obstacles") -> "chair"
        knows("obstacles") -> "table"
    }
}
```

### Description

This model instance creates a concrete room environment with:

- **Root Object**: A Room instance named "APB 2101"
- **Corner Points**: Four Point objects marking the boundaries of the room
- **Obstacles**: Two obstacles (chair and table) with bounding boxes and positions
- **Robot**: A robot (turtle) with speed and bounding box properties
- **References**: The robot knows about the chair and table obstacles

The structure demonstrates:
- Nested object creation with `has`
- Property assignment with `prop`
- Object references using `knows`
- Object naming conventions for identification

## Key Concepts

### Object Keys and Identifiers

Each object can have an optional key that uniquely identifies it within the model:

```
make object "robotA":"Robot" { ... }    // Named object
make object "_":"Point" { ... }          // Anonymous object with no key
```

Keys are useful for creating references via `knows` statements.

### Hierarchical Structure

KModel creates hierarchical object trees through `has` statements. Objects can be nested arbitrarily deep:

```
make object "root":"Room" {
    has("robot") -> make object "r1":"Robot" {
        has("position") -> make object "_":"Point" {
            prop("x") -> "5.0"
        }
    }
}
```

### Property Values

Properties are assigned string values, which are interpreted according to the property type defined in the metamodel:

```
prop("x") -> "5.0"           // Will be parsed as number
prop("name") -> "Office A"   // Will be kept as string
prop("active") -> "true"     // Will be parsed as boolean
```

### Multiple Relationships

The same relationship can appear multiple times to create collections:

```
has("obstacles") -> make object "chair":"Obstacle" { ... }
has("obstacles") -> make object "table":"Obstacle" { ... }
```

## Best Practices

1. **Consistent Naming**: Use clear and descriptive object keys that reflect their purpose
2. **Flatten When Possible**: Avoid excessive nesting; use references (`knows`) to reduce depth
3. **Data Validation**: Ensure property values match their expected types
4. **Reuse Objects**: Use `knows` statements to reference commonly used objects
5. **Documentation**: Add comments to complex object structures

## Alternative: Functional API

While the KModel DSL provides a declarative approach, you can also build model instances programmatically using the functional API. This is useful for dynamic model generation or integration with application logic.

### Using ModelBuilder

The `ModelBuilder` class provides a fluent API for constructing model instances:

```kotlin
import dsl.functional.ModelBuilder
import instance.Model
import meta.Metamodel

fun setupRobotRoomModel(metamodel: Metamodel): Model {
    val m = ModelBuilder(metamodel)

    val obstacleA = m.makeObject("Obstacle", "chair").apply {
        assignRels(
            mapOf("boundingBox" to m.makeObject("TwoDObject").apply {
                assignProps(mapOf("diameter" to 1.0))
                assignRels(
                    mapOf("position" to m.makeObject("Point").apply {
                        assignProps(mapOf("x" to 2.0, "y" to 3.0))}))}))}

    val obstacleB = m.makeObject("Obstacle", "table").apply {
        assignRels(
            mapOf("boundingBox" to m.makeObject("TwoDObject").apply {
                assignProps(mapOf("diameter" to 3.0))
                assignRels(
                    mapOf("position" to m.makeObject("Point").apply {
                        assignProps(mapOf("x" to 5.0, "y" to 7.0))}))}))}

    val robot = m.makeObject("Robot", "turtle").apply {
        assignProps(mapOf("speed" to 1.0))
        assignRels(
            mapOf("boundingBox" to m.makeObject("TwoDObject").apply {
                assignProps(mapOf("diameter" to 1.0))
                assignRels(
                    mapOf(
                        "position" to m.makeObject("Point").apply {
                            assignProps(mapOf("x" to 5.0, "y" to 5.0))
                        },
                        "obstacles" to listOf(obstacleA, obstacleB)))}))}

    val room = m.makeObject("Room", "APB 2101").apply {
        assignRels(
            mapOf(
                "topLeftCorner" to m.makeObject("Point").apply {
                    assignProps(mapOf("x" to 0.0, "y" to 10.0))
                },
                "topRightCorner" to m.makeObject("Point").apply {
                    assignProps(mapOf("x" to 10.0, "y" to 10.0))
                },
                "bottomLeftCorner" to m.makeObject("Point").apply {
                    assignProps(mapOf("x" to 0.0, "y" to 0.0))
                },
                "bottomRightCorner" to m.makeObject("Point").apply {
                    assignProps(mapOf("x" to 10.0, "y" to 0.0))
                },
                "robot" to robot,
                "obstacles" to listOf(obstacleA, obstacleB)))}

    return m.build()
}
```

### ModelBuilder API Overview

The `ModelBuilder` class provides the following key methods:

#### Object Creation

- `makeObject(className: String)`: Creates an anonymous object of the given class
- `makeObject(className: String, key: String)`: Creates a named object with a unique key

#### Property Assignment

- `assignProps(properties: Map<String, Any>)`: Assigns property values to an object

Supported property types:
- Numeric values: `1.0`, `42`, etc.
- String values: `"text"`
- Boolean values: `true`, `false`

#### Relationship Assignment

- `assignRels(relationships: Map<String, DataObject>)`: Assigns single embedded objects
- `assignRels(relationships: Map<String, List<DataObject>>)`: Assigns lists of objects

#### Model Finalization

- `build()`: Constructs and returns the final model instance

### Method Chaining with apply()

The functional API uses Kotlin's `apply()` function to chain method calls:

```kotlin
val point = m.makeObject("Point", "p1").apply {
    assignProps(mapOf("x" to 5.0, "y" to 10.0))
}
```

This is equivalent to:
```kotlin
val point = m.makeObject("Point", "p1")
point.assignProps(mapOf("x" to 5.0, "y" to 10.0))
```

## Parsing KModel Files

To parse a KModel instance file, use the `KmodelDSLCOnverter` class.
You find this class in the `kotlin/dsl/textual` package. It utilizes ANTLR v4.


## Relationship to KMeta

KModel instances must conform to the structure defined by a KMeta metamodel. The object types, property names, and relationship names referenced in a KModel file must exist in the corresponding metamodel. This ensures data consistency and type safety.

