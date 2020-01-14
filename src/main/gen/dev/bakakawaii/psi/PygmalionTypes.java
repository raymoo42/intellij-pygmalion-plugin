// This is a generated file. Not intended for manual editing.
package dev.bakakawaii.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import dev.bakakawaii.psi.impl.*;

public interface PygmalionTypes {

  IElementType PROPERTY = new PygmalionElementType("PROPERTY");

  IElementType COMMENT = new PygmalionTokenType("COMMENT");
  IElementType CRLF = new PygmalionTokenType("CRLF");
  IElementType KEY = new PygmalionTokenType("KEY");
  IElementType SEPARATOR = new PygmalionTokenType("SEPARATOR");
  IElementType VALUE = new PygmalionTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new PygmalionPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
