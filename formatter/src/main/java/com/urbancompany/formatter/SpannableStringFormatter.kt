package com.urbancompany.formatter

import com.urbancompany.formatter.formatter.Formatter

object SpannableStringFormatter {

    /**
     * Adds a text into Formatter object.
     * @param text: text to be added.
     *
     * @return Formatter builder object.
     */
    fun text(text: String): Formatter {
        return Formatter(text)
    }

}
