package dev.bakakawaii;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

public class PygmalionLanguage extends Language {
    public static final PygmalionLanguage INSTANCCE = new PygmalionLanguage();

    public PygmalionLanguage() {
        super("Pygmalion");
    }
}
