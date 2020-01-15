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

CRLF            = \R
WHITE_SPACE     = \s
ARGUMENT        = [a-zA-Z0-9_.\-]+
IDENTIFIER      = [a-zA-Z]+
STRING_LITERAL  = [\"|\'][^\n\f\\]*[\"|\']
FLAG            = [\-]{2}[a-zA-Z]+[a-zA-Z\-]*

%state CMD
%state FLAG

%%

<YYINITIAL> {
    {IDENTIFIER}              { yybegin(CMD); return PygmalionTypes.COMMAND; }
}

<CMD> {
    {CRLF}                    { yybegin(YYINITIAL);return TokenType.WHITE_SPACE; }

    {STRING_LITERAL}          { return PygmalionTypes.STRING; }
    {ARGUMENT}                { return PygmalionTypes.ARGUMENT; }

    {FLAG}                    { return PygmalionTypes.FLAGNAME; }
    {WHITE_SPACE}+            { yybegin(CMD); return TokenType.WHITE_SPACE; }
}

<FLAG> {
    {WHITE_SPACE}             { yybegin(FLAG); return TokenType.WHITE_SPACE; }

    {FLAG}                    { yybegin(FLAG); return PygmalionTypes.FLAGNAME; }

    {STRING_LITERAL}          { yybegin(YYINITIAL); return PygmalionTypes.ARGUMENT; }
    [^\n\f\\]+                { yybegin(YYINITIAL); return PygmalionTypes.ARGUMENT; }

    {CRLF}                    { yybegin(YYINITIAL);return TokenType.WHITE_SPACE; }
}

({WHITE_SPACE} | {CRLF})+     { return TokenType.WHITE_SPACE; }

[^]                           { return TokenType.BAD_CHARACTER; }
