package com.urbancompany.formatter.formatter

import com.urbancompany.parser.tokenize

class Formatter(private val text: String) {

    private val declarations = ArrayList<Declaration>()

    /**
     * Adds a property into Formatter object.
     * @param property: property to be added.
     * @param values: multiple values to be added for a property.
     *
     * @return Formatter builder object.
     */
    fun property(property: String, vararg values: String): Formatter {
        if (property.tokenize().size > 1)
            throw IllegalArgumentException("property text is not valid")

        declarations.add(Declaration(property, values.toList()))

        return this
    }

    /**
     * Converts a Formatter object into SpannableString.
     *
     * @return SpannableString
     */
    override fun toString(): String {
        if (declarations.isEmpty())
            return text

        return "{ `${text}` <${declarations.joinToString(";") { (property, values) -> "${property}:${values.joinToString("|") { value -> "`${value}`" }}" }}/> }"
    }

}
