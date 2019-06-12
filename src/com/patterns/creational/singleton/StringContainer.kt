package com.patterns.creational.singleton

/**
 * Singleton StringContainer
 */
object StringContainer {
    val container = mutableListOf<String>()

    fun printAll() {
        val iterator = container.iterator()
        while (iterator.hasNext()) {
            println(iterator.next())
        }
    }
}


/**
 * Run this code for get result of Singleton implementation
 */
fun main() {

    //val instance = StringContainer() - The function invoke() is not found, will not compile

    //The right way to use it
    StringContainer.container.add("Example string #1")
    StringContainer.container.add("Example string #2")
    StringContainer.printAll()
}
