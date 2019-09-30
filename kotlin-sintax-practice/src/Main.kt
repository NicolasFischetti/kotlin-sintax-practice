
val name: String = "Nate"
var gretting: String? = null

fun entireGretting() = "Hello Kotlin"

fun sayHello() {
    println(entireGretting())
}

fun sayHelloKotlin(getting: String, itemsToGreet: List<String>) {
    itemsToGreet.forEach { itemToGreet ->
        println("$getting $itemToGreet")
    }
}

// you can use vararg and don't pass a second argument when you use that function
fun sayHelloKotlin2(getting: String, vararg itemsToGreet:String) {
    itemsToGreet.forEach { itemToGreet ->
        println("$getting $itemToGreet")
    }
}

// you can define the default value parameter or default arguments function and only call that
fun greetPerson(greeting: String = "Hello", name: String) = println("$greeting $name")

fun main() {

    // Declaring array and loop. listof, arrayof are inmmutable for mutable values use mutableListOf
    val interestingThings = mutableListOf("Kotlin", "Programming", "Comic Books")
    val interestingThingsImmutable = arrayOf("Kotlin", "Programming", "Comic Books")
    sayHelloKotlin("Hi", interestingThings)

    // vararg can receive a arrayOf passing spreed operator on second parameter before array
    sayHelloKotlin2(getting = "Hi", itemsToGreet = *interestingThingsImmutable)

    // if you use argument sintax for one argument everything that follows that must also be named
    greetPerson(name = "Kotlin")

    // Add new element to array / list
    interestingThings.add("Dogs")

    println(interestingThings.size)
    println(interestingThings[0])

    // traditional for
    for(interestingThing in interestingThings) {
        println(interestingThing)
    }

    // using forEach
    interestingThings.forEach {interestingThing ->
        println(interestingThing)
    }

    // get Index
    interestingThings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at index $index")
    }

    // Add key to value
    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { (key, value) -> println("$key -> $value") }
    map[4] = "d"

    // conditional and when return in a variable example
    val gettingToPrint = if(gretting != null) gretting else "Hi"
    val germinating2 = when(gretting) {
        null -> "Hi"
        else -> gretting
    }
    println(germinating2)
    println(gettingToPrint)

    // classic conditional
    if(gretting != null) {
        println(gretting)
    } else {
        println("Hi")
    }

    // replace switch
    when(gretting) {
        null -> println("Hi")
        else -> println(gretting)
    }

   println(gretting)
   println(name)

   println(entireGretting())
   sayHello()

    ////////////////////////////////////////////////////////////////////////

    //Class declaration
    val person = Person()
    person.firstName
    person.lastName
    person.nickName = "Nico"
    person.nickName = "New Nickname"

    println(person.nickName)

    // call method inside class
    person.printInfo()
}