# KMeta Grammar Guide

## Overview

KMeta is a Domain-Specific Language (DSL) for defining data metamodels within the *karpfen ecosystem*. 

This guide covers:
- The KMeta grammar and syntax
- How to write KMeta metamodel definitions
- Examples and best practices
- Alternative approaches using the functional API

## Grammar Specification

The KMeta grammar is defined using ANTLR v4 and follows this structure:

### ANTLR Grammar (Kmeta.g4)

```antlr
grammar Kmeta;

// Parser Rules
kmeta_file
    : type_definition* EOF
    ;

type_definition
    : TYPE STRING STRING LBRACE rule_list? RBRACE
    ;

rule_list
    : rule+
    ;

rule
    : prop_rule
    | has_rule
    | knows_rule
    ;

prop_rule
    : PROP LPAREN STRING COMMA rule_value RPAREN
    ;

has_rule
    : HAS LPAREN STRING COMMA rule_value RPAREN
    ;

knows_rule
    : KNOWS LPAREN STRING COMMA rule_value RPAREN
    ;

rule_value
    : STRING
    | LIST LPAREN STRING RPAREN
    ;

// Lexer Rules
TYPE     : 'type' ;
PROP     : 'prop' ;
HAS      : 'has' ;
KNOWS    : 'knows' ;
LIST     : 'list' ;

LBRACE   : '{' ;
RBRACE   : '}' ;
LPAREN   : '(' ;
RPAREN   : ')' ;
COMMA    : ',' ;

STRING   : '"' ( '\\' . | ~["\r\n] )* '"' ;

WS       : [ \t\r\n]+ -> skip ;
```

## KMeta Syntax

### Basic Structure

A KMeta metamodel file consists of one or more type definitions:

```
type "<TypeName>" "<Description>" {
    [prop_statement]*
    [has_statement]*
    [knows_statement]*
}
```

### Type Definition

Each type definition starts with the `type` keyword followed by:
1. **Type Name** (string): The identifier for the type
2. **Description** (string): Documentation describing the type's purpose
3. **Body**: An optional set of statements enclosed in curly braces

```
type "Point" "A point in 2D space" {
    ...
}
```

### Properties (prop)

Properties define atomic data attributes of a type using the `prop` statement:

```
prop("<propertyName>", "<propertyType>")
```

- `<propertyName>`: The identifier for the property
- `<propertyType>`: The data type (e.g., "number", "string", "boolean")

Example:
```
type "Person" "A person entity" {
    prop("name", "string")
    prop("age", "number")
}
```

### Relationships (has)

The `has` statement defines embedded or linked relationships to other types:

```
has("<relationName>", "<TypeName>")
```

or for collections:

```
has("<relationName>", list("<TypeName>"))
```

- `<relationName>`: The identifier for the relationship
- `<TypeName>`: The name of the related type
- `list()`: Optional wrapper indicating a collection of the type

Example:
```
type "Room" "A room containing objects" {
    has("robot", "Robot")
    has("obstacles", list("Obstacle"))
}
```

### Knowledge References (knows)

The `knows` statement defines references or links to other entities without embedding them:

```
knows("<referenceName>", "<TypeName>")
```

or for collections:

```
knows("<referenceName>", list("<TypeName>"))
```

Example:
```
type "Robot" "A cleaning robot" {
    knows("obstacles", list("Obstacle"))
}
```

## Complete Example

The following example defines a metamodel for a robot navigation system:

```
type "Point" "A point in 2D space" {
    prop("x", "number")
    prop("y", "number")
}

type "TwoDObject" "A two-dimensional object with a position and diameter" {
    prop("diameter", "number")
    has("position", "Point")
}

type "Obstacle" "An obstacle in the room" {
    has("boundingBox", "TwoDObject")
}

type "Robot" "A cleaning robot that can move around the room and log its actions" {
    prop("speed", "number")
    prop("log", list("string"))
    has("boundingBox", "TwoDObject")
    knows("obstacles", list("Obstacle"))
}

type "Room" "A room that contains a robot and obstacles" {
    has("robot", "Robot")
    has("obstacles", list("Obstacle"))
    has("top_left", "Point")
    has("top_right", "Point")
    has("bottom_left", "Point")
    has("bottom_right", "Point")
}
```

**The last type defined in a kmeta metamodel is considered the ROOT type. All other types must be reached via embeddings from the root!**

### Description

This metamodel defines:

- **Point**: A simple type with two numeric properties (x, y coordinates)
- **TwoDObject**: A type representing 2D objects with size and position information
- **Obstacle**: A type for objects that block movement in the room
- **Robot**: The main entity representing an autonomous robot with movement capabilities and awareness of obstacles
- **Room**: A container type that structures the spatial environment

## Key Concepts

### Embedded vs. Referenced Relationships

- **has()**: Used for embedded relationships. Child objects are part of the parent's data structure
- **knows()**: Used for referenced relationships. Indicates awareness or links without embedding

### Collections

The `list()` wrapper indicates that a relationship contains multiple instances:

```
has("obstacles", list("Obstacle"))  // Multiple obstacles
prop("log", list("string"))         // Multiple string entries
```

### Type References

Types can reference other types defined in the same metamodel file. Forward references are supported.

## Best Practices

1. **Meaningful Names**: Use clear and descriptive type names and property names
2. **Documentation**: Always provide meaningful descriptions for types
3. **Type Hierarchy**: Organize types logically from simple to complex
4. **Relationship Type**: Distinguish between embedded (has) and referenced (knows) relationships
5. **Collections**: Use list() for one-to-many relationships

## Alternative: Functional API

While the KMeta DSL provides a declarative approach, you can also build metamodels programmatically using the functional API. This is useful for dynamic metamodel generation or complex conditional logic.

### Using MetamodelBuilder

The `MetamodelBuilder` class provides a fluent API for constructing metamodels:

```kotlin
import dsl.functional.MetamodelBuilder

val m = MetamodelBuilder()

m.makeClass(
    name = "Point",
    comment = "A point in 2D space",
    props = listOf(
        m.makeNumber(key = "x"),
        m.makeNumber(key = "y")
    ))

m.makeClass(
    name = "TwoDObject",
    comment = "A two-dimensional object with a position and diameter",
    props = listOf(m.makeNumber(key = "diameter")),
    rels = listOf(m.makeClassProp(key = "position", classT = "Point", relT = m.EMBEDDED))
)

m.makeClass(
    name = "Obstacle",
    comment = "An obstacle in the room that the robot should avoid",
    rels = listOf(m.makeClassProp(key = "boundingBox", classT = "TwoDObject", relT = m.EMBEDDED))
)

m.makeClass(
    name = "Robot",
    comment = "A cleaning robot that can move around the room and log its actions",
    props = listOf(
        m.makeNumber(key = "speed"),
        m.makeStringList(key = "log")),
    rels = listOf(
        m.makeClassProp(key = "boundingBox", classT = "TwoDObject", relT = m.EMBEDDED),
        m.makeClassPropList(key = "obstacles", classT = "Obstacle", relT = m.LINK)
    )
)

m.makeClass(
    name = "Room",
    comment = "A room that contains a robot and some obstacles",
    rels = listOf(
        m.makeClassProp(key = "topLeftCorner", classT = "Point", relT = m.EMBEDDED),
        m.makeClassProp(key = "topRightCorner", classT = "Point", relT = m.EMBEDDED),
        m.makeClassProp(key = "bottomLeftCorner", classT = "Point", relT = m.EMBEDDED),
        m.makeClassProp(key = "bottomRightCorner", classT = "Point", relT = m.EMBEDDED),
        m.makeClassProp(key = "robot", classT = "Robot", relT = m.EMBEDDED),
        m.makeClassPropList(key = "obstacles", classT = "Obstacle", relT = m.EMBEDDED)
    )
)

m.setRoot("Room")
val metamodel = m.build()
```

### MetamodelBuilder API Overview

The `MetamodelBuilder` class provides the following key methods:

#### Property Creation

- `makeNumber(key: String)`: Creates a numeric property
- `makeString(key: String)`: Creates a string property
- `makeBoolean(key: String)`: Creates a boolean property
- `makeStringList(key: String)`: Creates a list of strings

#### Relationship Creation

- `makeClassProp(key: String, classT: String, relT: String)`: Creates a single class relationship
- `makeClassPropList(key: String, classT: String, relT: String)`: Creates a list of class relationships

#### Relationship Types

- `m.EMBEDDED`: For embedded relationships (equivalent to "has" in DSL)
- `m.LINK`: For referenced relationships (equivalent to "knows" in DSL)

#### Class and Metamodel Management

- `makeClass(name: String, comment: String, props: List, rels: List)`: Creates a new type
- `setRoot(name: String)`: Designates the root type for the metamodel
- `build()`: Constructs and returns the final metamodel


## Parsing KMeta Files

To parse a KMeta metamodel file, use the `KmetaDSLCOnverter` class, 
which utilizes the ANTLR parser to read and convert KMeta files into in-memory representations.
You find this class in the `kotlin/dsl/textual` package.

