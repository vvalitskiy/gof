package com.patterns.creational.builder

/**
 * Musician class with Kotlin DSL Builder
 */
open class Musician private constructor(
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

        fun firstName(init: Builder.() -> String) = apply { firstName = init() }
        fun middleName(init: Builder.() -> String) = apply { middleName = init() }
        fun lastName(init: Builder.() -> String) = apply { lastName = init() }
        fun sex(init: Builder.() -> String) = apply { sex = init() }
        fun age(init: Builder.() -> Int) = apply { age = init() }

        fun build() = Musician(this)
    }

    override fun toString(): String {
        return "Musician(firstName='$firstName', middleName='$middleName', lastName='$lastName', age=$age, sex='$sex')"
    }


}

fun buildMusician(block: Musician.Builder.() -> Unit): Musician =
        Musician.Builder().apply(block).build()


/**
 * Run this code for get result of Musician Builder
 */
fun main() {

    val johnPetrucci = buildMusician {
        firstName = "John"
        middleName = "Peter"
        lastName = "Petrucci"
        age = 51
        sex = "male"
    }

    print(johnPetrucci)

    val steveVai = buildMusician {
        firstName = "Steve"
        lastName = "Vai"
        age = 59
        sex = "male"
    }

    print(steveVai)

}