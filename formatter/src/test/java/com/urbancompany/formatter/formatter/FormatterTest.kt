package com.urbancompany.formatter.formatter

import com.urbancompany.formatter.SpannableStringFormatter
import org.junit.Assert
import org.junit.Test

class FormatterTest {

    @Test
    fun `test text having no property no value`() {
        Assert.assertEquals(
            "SpannableStringParser",
            SpannableStringFormatter
                .text("SpannableStringParser")
                .toString()
        )
    }

    @Test
    fun `test text having single property single value`() {
        Assert.assertEquals(
            "{ `SpannableStringParser` <text-color:`#0000FF`/> }",
            SpannableStringFormatter
                .text("SpannableStringParser")
                .property("text-color", "#0000FF")
                .toString()
        )
    }

    @Test
    fun `test text having single property multiple values`() {
        Assert.assertEquals(
            "{ `SpannableStringParser` <text-decoration:`underline`|`strike-through`/> }",
            SpannableStringFormatter
                .text("SpannableStringParser")
                .property("text-decoration", "underline", "strike-through")
                .toString()
        )
    }

    @Test
    fun `test text having multiple properties multiple values`() {
        Assert.assertEquals(
            "{ `SpannableStringParser` <text-color:`#0000FF`;text-decoration:`underline`|`strike-through`/> }",
            SpannableStringFormatter
                .text("SpannableStringParser")
                .property("text-color", "#0000FF")
                .property("text-decoration", "underline", "strike-through")
                .toString()
        )
    }

    @Test
    fun `test text having single value with reserved characters`() {

        Assert.assertEquals(
            "{ `Click here` <url:`https://www.google.com`/> }",
            SpannableStringFormatter
                .text("Click here")
                .property("url", "https://www.google.com")
                .toString()
        )

        Assert.assertEquals(
            "{ `SpannableStringParser` <property:`value 1`/> }",
            SpannableStringFormatter
                .text("SpannableStringParser")
                .property("property", "value 1")
                .toString()
        )

    }

    @Test
    fun `test text having multiple values with reserved characters`() {

        Assert.assertEquals(
            "{ `Google` <urls:`https://www.one.com`|`https://www.two.com`/> }",
            SpannableStringFormatter
                .text("Google")
                .property("urls", "https://www.one.com", "https://www.two.com")
                .toString()
        )

        Assert.assertEquals(
            "{ `SpannableStringParser` <property:`value 1`|`value 2`/> }",
            SpannableStringFormatter
                .text("SpannableStringParser")
                .property("property", "value 1", "value 2")
                .toString()
        )

    }

    @Test(expected = IllegalArgumentException::class)
    fun `test text having property with invalid character, space`() {
        SpannableStringFormatter
            .text("SpannableStringParser")
            .property("text color", "#0000FF")
            .toString()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test text having property with invalid character, colon`() {
        SpannableStringFormatter
            .text("SpannableStringParser")
            .property(":text-color", "#0000FF")
            .toString()
    }

}
