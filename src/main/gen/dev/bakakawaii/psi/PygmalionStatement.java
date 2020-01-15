// This is a generated file. Not intended for manual editing.
package dev.bakakawaii.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PygmalionStatement extends PsiElement {

  @NotNull
  List<PygmalionArgument> getArgumentList();

  @NotNull
  List<PygmalionFlag> getFlagList();

}
