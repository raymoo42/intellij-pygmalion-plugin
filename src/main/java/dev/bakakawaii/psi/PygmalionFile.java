package dev.bakakawaii.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import dev.bakakawaii.PygmalionFileType;
import dev.bakakawaii.PygmalionIcon;
import dev.bakakawaii.PygmalionLanguage;
import org.assertj.core.annotations.NonNull;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PygmalionFile extends PsiFileBase {
    public PygmalionFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, PygmalionLanguage.INSTANCCE);
    }

    @Override
    @NonNull
    public FileType getFileType() {
        return PygmalionFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Pygmalion config";
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return PygmalionIcon.ICON;
    }
}
