package com.patterns.creational.builder

/**
 * Drummer class with basic Builder implementation with Kotlin
 */
open class Drummer private constructor(
        val firstName : String,
        val middleName : String,
        val lastName : String,
        val age : Int,
        val sex : String
) {

    private constructor(builder: Builder) : this(
            builder.firstName,
            builder.middleName,
            builder.lastName,
            builder.age,
            builder.sex
    )

    class Builder {
        var firstName : String = ""
        var middleName : String = ""
        var lastName : String = ""
        var age : Int = 0
        var sex : String = ""

        fun firstName(firstName: String) = apply { this.firstName = firstName }
        fun middleName(middleName: String) = apply { this.middleName = middleName }
        fun lastName(lastName: String) = apply { this.lastName = lastName }
        fun sex(sex: String) = apply { this.sex = sex }
        fun age(age: Int) = apply { this.age = age }

        fun build() = Drummer(firstName, middleName, lastName, age, sex)
    }

    override fun toString(): String {
        return "Drummer(firstName='$firstName', middleName='$middleName', lastName='$lastName', age=$age, sex='$sex')"
    }


}



/**
 * Run this code for get result of Drummer Builder
 */
fun main() {

    val drummer = Drummer.Builder()
            .age(52)
            .firstName("Michael")
            .middleName("Stephen")
            .lastName("Portnoy")
            .sex("female")
            .build()

    print(drummer)

}
