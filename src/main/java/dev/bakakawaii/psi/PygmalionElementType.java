package dev.bakakawaii.psi;

import com.intellij.psi.tree.IElementType;
import dev.bakakawaii.PygmalionLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PygmalionElementType extends IElementType {
    public PygmalionElementType(@NotNull @NonNls String debugName) {
        super(debugName, PygmalionLanguage.INSTANCCE);
    }


}
