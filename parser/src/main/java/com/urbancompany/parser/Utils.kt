package com.urbancompany.parser

import com.urbancompany.parser.lexer.Lexer
import com.urbancompany.parser.lexer.Token
import com.urbancompany.parser.parser.Node
import com.urbancompany.parser.parser.Parser

internal fun CharSequence.tokenize(): List<Token> {
    val lexer = Lexer(this)
    val tokens = ArrayList<Token>()
    while (true)
        tokens.add(lexer.nextToken() ?: break)
    return tokens
}

internal fun List<Token>.parse(): List<Node> {
    return Parser(this).parse()
}
