// Higher order functions are functions that either return another function or that take functions as perimeter values

fun printFilterStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        // if you pass a possible null parameter you can't user lambda
        if(predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

// function like variable
val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

// Not parameter function
fun getPrintPredicate(): (String) -> Boolean {
    return {it.startsWith("J")}
}

fun main() {
    val list = listOf("Kotlin", "Java", "C++", "Javascript")

    printFilterStrings(list) {it.startsWith("k")} // you can specify the lambda outside the parenthesis
    printFilterStrings(list, null)
    printFilterStrings(list, predicate)
    printFilterStrings(list, getPrintPredicate())
}