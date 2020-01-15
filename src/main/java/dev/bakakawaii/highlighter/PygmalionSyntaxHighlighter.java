package dev.bakakawaii.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import dev.bakakawaii.PygmalionLexerAdapter;
import dev.bakakawaii.psi.PygmalionTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class PygmalionSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEY = createTextAttributesKey("PYGMALION_COMMAND", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey FLAG = createTextAttributesKey("PYGMALION_FLAG", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey LITERAL = createTextAttributesKey("PYGMALION_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey BAD_KEYS = createTextAttributesKey("PYGMALION_BAD_CHAR", HighlighterColors.BAD_CHARACTER);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new PygmalionLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {

        if (tokenType.equals(PygmalionTypes.COMMAND)) {
            return new TextAttributesKey[]{KEY};

        } else if (tokenType.equals(PygmalionTypes.LITERAL)) {
            return new TextAttributesKey[]{LITERAL};

        } else if (tokenType.equals(PygmalionTypes.FLAGNAME)) {
            return new TextAttributesKey[]{LITERAL};

        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return new TextAttributesKey[]{BAD_KEYS};

        } else
            return new TextAttributesKey[0];
    }
}