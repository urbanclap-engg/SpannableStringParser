package com.urbancompany.spanner

import com.urbancompany.parser.parse

/**
 * Converts a String into SpannableString.
 */
fun CharSequence.spannify() = parse().spannify()
