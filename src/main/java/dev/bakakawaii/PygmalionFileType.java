package dev.bakakawaii;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PygmalionFileType extends LanguageFileType {

    public static final PygmalionFileType INSTANCE = new PygmalionFileType();

    public PygmalionFileType() {
        super(PygmalionLanguage.INSTANCCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Pygmalion config";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Pygmalion config";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "pconf";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return PygmalionIcon.ICON;
    }
}
