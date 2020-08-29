package com.urbancompany.formatter.formatter

class Formatter(private val text: String) {

    fun property(property: String, vararg values: String): Formatter {
        return this
    }

    override fun toString(): String {
        return "{ `${text}` </> }"
    }

}
