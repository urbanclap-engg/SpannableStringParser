package com.urbancompany.formatter.formatter

import com.urbancompany.formatter.SpannableStringFormatter
import org.junit.Assert
import org.junit.Test

class FormatterTest {

    @Test
    fun test() {
        Assert.assertEquals(
            "Hello { `SpannableStringParser` <text-color:#0000FF;text-decoration:underline|strike-through/> }",
            SpannableStringFormatter
                .text("SpannableStringParser")
                .property("text-color", "#0000FF")
                .property("text-decoration", "underline", "strike-through")
                .toString()
        )
    }

}
