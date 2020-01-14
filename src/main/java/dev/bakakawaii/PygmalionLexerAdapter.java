package dev.bakakawaii;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class PygmalionLexerAdapter extends FlexAdapter {
    public PygmalionLexerAdapter() {
        super(new PygmalionLexer((Reader) null));
    }
}
