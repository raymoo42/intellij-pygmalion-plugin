package dev.bakakawaii;

import dev.bakakawaii.psi.PygmalionTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

%%

%class PygmalionLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF            = \n|\r\n
WHITE_SPACE     = [\ ]
ARGUMENT        = [a-zA-Z0-9_.\-]+
IDENTIFIER      = [a-zA-Z]+
STRING_LITERAL  = [\"|\'][^\n\f\\]*[\"|\']

FLAG            = [\-]{2}[a-zA-Z]+[a-zA-Z\-]*

%state CMD

%%

<YYINITIAL> {
    {IDENTIFIER}              { yybegin(CMD); return PygmalionTypes.COMMAND; }
}

<CMD> {
    {CRLF}                    { yybegin(YYINITIAL);return PygmalionTypes.CRLF; }

    {FLAG}                    { return PygmalionTypes.FLAGNAME; }
    {STRING_LITERAL}          { return PygmalionTypes.LITERAL; }

    {ARGUMENT}                { return PygmalionTypes.VALUE; }

    {WHITE_SPACE}+            { return TokenType.WHITE_SPACE; }
}

({WHITE_SPACE} | {CRLF})     { return TokenType.WHITE_SPACE; }

[^]                           { return TokenType.BAD_CHARACTER; }
