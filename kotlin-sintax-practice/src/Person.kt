
// internal mind that this class is public within the module
// private class is only available within the file in witch it's implemented
// public default
class Person(val firstName: String = "Peter", val lastName: String = "Parker") {

    // if this property or method is internal we can accesses to the property when you call the class
    // if this property or method is protected only be available within that class or any subclasses
    // if this property or method is private you can't accesses too
    var nickName: String? = null

        //add set
    set(value) {
        field = value
        println("the new nickname is $value")
    }

        // add get
    get() {
        println("the returned value is $field")

        return field
    }

    // add method
    fun printInfo() {

        // this expression can be better
        // val nickNameToPrint = if(nickName != null) nickName else "No nickname"

        // Mark Colon using Elvis operator for null values
        val nickNameToPrint = nickName ?: "no nickname"

        println("$firstName ($nickNameToPrint) $lastName")
    }

    init {
        println("init 1")
    }

    constructor(): this("Peter", "Parker") {
        println("secondary constructor")
    }

    init {
        println("init 2")
    }

    // always init when the class is call
   /* init {
        firstName = _firstName
        lastName = _lastName
    } */
}