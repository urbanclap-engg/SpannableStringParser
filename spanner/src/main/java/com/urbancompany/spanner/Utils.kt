package com.urbancompany.spanner

import android.util.Log
import com.urbancompany.parser.parser.Node
import com.urbancompany.spanner.spanner.Spanner

internal fun List<Node>.spannify(): CharSequence {
    return Spanner(this).spannify()
}

internal fun safe(block: () -> Unit) {
    try {
        block.invoke()
    } catch (e: Exception) {
        Log.e("SpannableStringParser", e.toString())
    }
}
