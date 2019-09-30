import java.util.*

// using enum type class
enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    // you can add method to enum class. In this case reference to name use in EntityFactory
    fun getFormattedName() = name.toLowerCase().capitalize()
}

interface IdProvider {
    fun getId(): String
}

class Entity private constructor(val id: String) {

    //companion object is a object that is scoped to an instance of another class
    companion object Factory: IdProvider {
        override fun getId(): String {
            return "123"
        }

        const val id = "id"

        fun create() = Entity(getId())
    }
}

sealed class EntitySealed () {
    object Help: EntitySealed() {
        val name = "Help"
    }
    // Data classes are cotton's way of providing very concise, immutable data types
    // you can have different properties and methods on each if these type
    data class Easy(val id: String, val name: String): EntitySealed()
    data class Medium(val id: String, val name: String): EntitySealed()
    data class Hard(val id: String, val name: String, val multiplier: Float): EntitySealed()

}

// you can extend method
fun EntitySealed.Medium.printInfo() {
    println("Medium class: $id")
}

// you can extend properties
val EntitySealed.Medium.info: String
    get() = "some info"

object EntityFactory {
    fun create(type: EntityType): EntitySealed {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            // reference directly type.name to EASY type in enum class
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when(type) {
            EntityType.EASY -> EntitySealed.Easy(id,name)
            EntityType.MEDIUM -> EntitySealed.Medium(id,name)
            EntityType.HARD -> EntitySealed.Hard(id,name, 2f)
            EntityType.HELP -> EntitySealed.Help
        }
    }
}

fun main() {
    // You don't need add Factory name in Kotlin but it is a good practice like a reference
    val entity = Entity.Factory.create()
    // you can access to the properties too
    Entity.id
    // object property
    val entity2 = EntityFactory.create(EntityType.EASY)
    println(entity2)

    val msg = when (EntityFactory.create(EntityType.HELP)) {
        EntitySealed.Help -> "help class"
        is EntitySealed.Easy -> "easy class"
        is EntitySealed.Medium -> "medium class"
        is EntitySealed.Hard -> "hard class"
    }

    println(msg)

    // we can compare two data classes if they are equal each other or not
    val entity1 = EntitySealed.Easy("id", "name")
    val entity3 = EntitySealed.Easy("id", "name")
    val entity4 = EntityFactory.create(EntityType.MEDIUM)

    if(entity4 is EntitySealed.Medium) {
        entity4.printInfo()
        entity4.info
    }

    // if we add === equal that minds that we are checking if the reference is the same
    if (entity1 === entity3) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    EntitySealed.Medium("id", "name").printInfo()
}