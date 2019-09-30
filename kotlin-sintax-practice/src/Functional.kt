fun main() {
    val list = listOf("Kotlin", "Java", "C++", "Javascript", null, null)
    val map = list
        // Returns a list containing all elements that are not `null`
        .filterNotNull()
        .filter { it.startsWith("J") }
        .associate { it to it.length }
        .forEach {
        println("${it.value}, ${it.key}")
    }

    // pass a empty value apposed to a null value
    val language = list.filterNotNull().findLast{it.startsWith("Java")}.orEmpty()
    println(language)
}