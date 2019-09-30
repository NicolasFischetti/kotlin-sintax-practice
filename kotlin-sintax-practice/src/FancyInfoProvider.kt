// In Kotlin  default classes are closed(final) can't be inherited from or extended

class FancyInfoProvider: BasicInfoProvider() {

    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "Fancy Info Provider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy provider")
    }
}