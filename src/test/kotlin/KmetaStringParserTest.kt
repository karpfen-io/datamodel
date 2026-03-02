import dsl.textual.KmetaDSLConverter
import meta.SimplePropertyType
import org.junit.jupiter.api.Assertions.assertTrue
import parser.KmetaFileParser
import kotlin.test.Test
import kotlin.test.assertEquals

class KmetaStringParserTest {

    val content = """
            type "Robot" "A cleaning robot" {
                prop("speed", "number")
                prop("batteryLife", "number")
                has("location", "Location")
            }
            
            type "Location" "A physical location" {
                prop("x", "number")
                prop("y", "number")
            }
            
            type "Person" "A human being" {
                prop("name", "string")
                prop("age", "number")
                has("location", "Location")
            }
            
            type "World" "The world containing robots and persons" {
                has("robots", list("Robot"))
                has("persons", list("Person"))
            }
        """

    @Test
    fun testParseStringDefaultANTLRParserRuntime() {
        val parser = KmetaFileParser()
        val kmetaFile = parser.parseString(content.trimIndent())
        assertEquals(kmetaFile.types.size, 4)
        assertTrue(kmetaFile.types.map { it.name }.containsAll(listOf("Location", "Person", "World", "Robot")))
    }

    @Test
    fun testParserOutputConverter(){
        val metamodel = KmetaDSLConverter.parseKmetaString(content)
        assertEquals(metamodel.types.size, 4)
        assertTrue(metamodel.types.map { it.name }.containsAll(listOf("Location", "Person", "World", "Robot")))
        val personType = metamodel.getTypeByName("Person")
        assertEquals(2, personType?.simpleProperties?.size)
        assertEquals(1, personType?.objectProperties?.size)
        val personAgeProp = personType?.getSimpleProperty("age")
        assertEquals(false, personAgeProp?.isList)
        assertEquals(SimplePropertyType.NUMBER, personAgeProp?.propertyType)
    }

    @Test
    fun testParserOutputConverterFromFile(){
        val filePath = "example/metamodel_dsl_example.kmeta"
        val metamodel = KmetaDSLConverter.parseKmetaFile(filePath)
        assertEquals(metamodel.types.size, 5)
        assertTrue(metamodel.types.map { it.name }.containsAll(listOf("Point", "TwoDObject", "Obstacle", "Robot", "Room")))

        val pointType = metamodel.getTypeByName("Point")
        val twoDObjectType = metamodel.getTypeByName("TwoDObject")
        val obstacleType = metamodel.getTypeByName("Obstacle")
        val robotType = metamodel.getTypeByName("Robot")
        val roomType = metamodel.getTypeByName("Room")

        assertEquals("A point in 2D space", pointType?.comment)
        assertEquals("A two-dimensional object with a position and diameter", twoDObjectType?.comment)
        assertEquals("An obstacle in the room", obstacleType?.comment)
        assertEquals("A cleaning robot that can move around the room and log its actions", robotType?.comment)
        assertEquals("A room that contains a robot and obstacles", roomType?.comment)

        assertEquals(listOf("x", "y"), pointType?.simpleProperties?.map { it.key })
        assertEquals(listOf("diameter"), twoDObjectType?.simpleProperties?.map { it.key })
        assertEquals(emptyList<String>(), obstacleType?.simpleProperties?.map { it.key })
        assertEquals(listOf("speed", "log"), robotType?.simpleProperties?.map { it.key })
        assertEquals(emptyList<String>(), roomType?.simpleProperties?.map { it.key })

        assertEquals(listOf("position"), twoDObjectType?.objectProperties?.map { it.key })
        assertEquals(listOf("boundingBox"), obstacleType?.objectProperties?.map { it.key })
        assertEquals(listOf("boundingBox", "obstacles"), robotType?.objectProperties?.map { it.key })
        assertEquals(listOf("top_left", "top_right", "bottom_left", "bottom_right", "robot", "obstacles").toSet(), roomType?.objectProperties?.map { it.key }?.toSet())

        val robotObstaclesProp = robotType?.getObjectProperty("obstacles")
        assertEquals(true, robotObstaclesProp?.isList)
        assertEquals("Obstacle", robotObstaclesProp?.reference?.classTypeName)
    }

}