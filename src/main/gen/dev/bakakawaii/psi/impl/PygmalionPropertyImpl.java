// This is a generated file. Not intended for manual editing.
package dev.bakakawaii.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.bakakawaii.psi.PygmalionTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import dev.bakakawaii.psi.*;

public class PygmalionPropertyImpl extends ASTWrapperPsiElement implements PygmalionProperty {

  public PygmalionPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PygmalionVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PygmalionVisitor) accept((PygmalionVisitor)visitor);
    else super.accept(visitor);
  }

}
