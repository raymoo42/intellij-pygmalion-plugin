package dev.bakakawaii.psi;

import com.intellij.psi.tree.IElementType;
import dev.bakakawaii.PygmalionLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PygmalionTokenType extends IElementType {

    public PygmalionTokenType(@NotNull @NonNls String debugName) {
        super(debugName, PygmalionLanguage.INSTANCCE);
    }

    @Override
    public String toString() {
        return "PygmalionTokenType." + super.toString();
    }
}
