// This is a generated file. Not intended for manual editing.
package dev.bakakawaii.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static dev.bakakawaii.psi.PygmalionTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class PygmalionParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return simpleFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // literal | value
  public static boolean argument(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "argument")) return false;
    if (!nextTokenIs(builder_, "<argument>", LITERAL, VALUE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ARGUMENT, "<argument>");
    result_ = consumeToken(builder_, LITERAL);
    if (!result_) result_ = consumeToken(builder_, VALUE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (flagname argument?) | flagname
  public static boolean flag(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "flag")) return false;
    if (!nextTokenIs(builder_, FLAGNAME)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = flag_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, FLAGNAME);
    exit_section_(builder_, marker_, FLAG, result_);
    return result_;
  }

  // flagname argument?
  private static boolean flag_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "flag_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FLAGNAME);
    result_ = result_ && flag_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // argument?
  private static boolean flag_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "flag_0_1")) return false;
    argument(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // statement | CRLF
  static boolean item_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item_")) return false;
    if (!nextTokenIs(builder_, "", COMMAND, CRLF)) return false;
    boolean result_;
    result_ = statement(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, CRLF);
    return result_;
  }

  /* ********************************************************** */
  // item_*
  static boolean simpleFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "simpleFile")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!item_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "simpleFile", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // command argument+ flag* CRLF?
  public static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    if (!nextTokenIs(builder_, COMMAND)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMAND);
    result_ = result_ && statement_1(builder_, level_ + 1);
    result_ = result_ && statement_2(builder_, level_ + 1);
    result_ = result_ && statement_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, STATEMENT, result_);
    return result_;
  }

  // argument+
  private static boolean statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = argument(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!argument(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "statement_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // flag*
  private static boolean statement_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!flag(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "statement_2", pos_)) break;
    }
    return true;
  }

  // CRLF?
  private static boolean statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_3")) return false;
    consumeToken(builder_, CRLF);
    return true;
  }

}
