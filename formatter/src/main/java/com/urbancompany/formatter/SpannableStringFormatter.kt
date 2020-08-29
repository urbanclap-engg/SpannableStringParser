package com.urbancompany.formatter

import com.urbancompany.formatter.formatter.Formatter

object SpannableStringFormatter {

    fun text(text : String) : Formatter {
        return Formatter(text)
    }

}
