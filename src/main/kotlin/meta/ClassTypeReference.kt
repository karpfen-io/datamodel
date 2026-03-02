package meta

data class ClassTypeReference(
    val associationType: AssociationType,
    val classTypeName: String,
    var classType: ClassType? = null
)