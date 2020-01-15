// This is a generated file. Not intended for manual editing.
package dev.bakakawaii.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import dev.bakakawaii.psi.impl.*;

public interface PygmalionTypes {

  IElementType ARGUMENT = new PygmalionElementType("ARGUMENT");
  IElementType FLAG = new PygmalionElementType("FLAG");
  IElementType STATEMENT = new PygmalionElementType("STATEMENT");

  IElementType COMMAND = new PygmalionTokenType("command");
  IElementType CRLF = new PygmalionTokenType("CRLF");
  IElementType FLAGNAME = new PygmalionTokenType("flagname");
  IElementType LITERAL = new PygmalionTokenType("literal");
  IElementType VALUE = new PygmalionTokenType("value");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new PygmalionArgumentImpl(node);
      }
      else if (type == FLAG) {
        return new PygmalionFlagImpl(node);
      }
      else if (type == STATEMENT) {
        return new PygmalionStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
