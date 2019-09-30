// Kotlin interfaces provide default implementation of an interface method

interface PersonInfoProvider {
    // In Kotlin you can define attributes inside interface
    val providerInfo: String

    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

// ---> Adding multiple interfaces

interface SessionInfoProvider {
    fun getSessionId() : String
}


// with abstract we don't need to implement all the methods available  on the interfaces that includes, but it also can't be instantiated
open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {

    // To override a property you need to open this like a class. Problem: If you declare this property open you can access to this directly
    // and modify the property. You need to add protected to not access directly to this property
    protected open val sessionIdPrefix = "Session"

    override fun getSessionId(): String {
        return sessionIdPrefix
    }

    override val providerInfo: String
        get() = "BasicInfoProvider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }
}

fun main() {

    // val provider = FancyInfoProvider()
    
    // Add object to create anonymous inter class
    val provider = object : PersonInfoProvider{
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "id"
    }

    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if(infoProvider !is SessionInfoProvider) {
        println("not a session info provider")
    } else {
        println("is a session info provider")
        // as is  the keyword used to cast something to another type (in this case we don't need it)
       // (infoProvider as SessionInfoProvider).getSessionId()
        infoProvider.getSessionId()
    }
}