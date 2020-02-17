package com.urbancompany.parser

/**
 * Converts a String into SpannableString.
 */
fun CharSequence.parse() = tokenize().parse()
