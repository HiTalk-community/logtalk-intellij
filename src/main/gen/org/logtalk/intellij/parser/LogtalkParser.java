// This is a generated file. Not intended for manual editing.
package org.logtalk.intellij.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.logtalk.intellij.psi.LogtalkTypes.*;
import static org.logtalk.intellij.parser.LogtalkParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LogtalkParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return logtalkFile(b, l + 1);
  }

  /* ********************************************************** */
  // UNQUOTED_ATOM | SYMBOLIC_ATOM | QUOTED_ATOM | MAP_OP
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, UNQUOTED_ATOM);
    if (!r) r = consumeToken(b, SYMBOLIC_ATOM);
    if (!r) r = consumeToken(b, QUOTED_ATOM);
    if (!r) r = consumeToken(b, MAP_OP);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // number|STRING|map_term|variable|compound|atom|parenthesized_block|braced_block|list
  public static boolean basic_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASIC_TERM, "<basic term>");
    r = number(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = map_term(b, l + 1);
    if (!r) r = variable(b, l + 1);
    if (!r) r = compound(b, l + 1);
    if (!r) r = atom(b, l + 1);
    if (!r) r = parenthesized_block(b, l + 1);
    if (!r) r = braced_block(b, l + 1);
    if (!r) r = list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE term? RBRACE
  public static boolean braced_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "braced_block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && braced_block_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BRACED_BLOCK, r);
    return r;
  }

  // term?
  private static boolean braced_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "braced_block_1")) return false;
    term(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // compound_name LPAREN term RPAREN
  public static boolean compound(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound")) return false;
    if (!nextTokenIs(b, "<compound>", QUOTED_COMPOUND_NAME, UNQUOTED_COMPOUND_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPOUND, "<compound>");
    r = compound_name(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && term(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UNQUOTED_COMPOUND_NAME | QUOTED_COMPOUND_NAME
  public static boolean compound_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_name")) return false;
    if (!nextTokenIs(b, "<compound name>", QUOTED_COMPOUND_NAME, UNQUOTED_COMPOUND_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPOUND_NAME, "<compound name>");
    r = consumeToken(b, UNQUOTED_COMPOUND_NAME);
    if (!r) r = consumeToken(b, QUOTED_COMPOUND_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // sentence|COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = sentence(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET term? RBRACKET
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && list_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, LIST, r);
    return r;
  }

  // term?
  private static boolean list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_1")) return false;
    term(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // item_*
  static boolean logtalkFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logtalkFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logtalkFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // UNQUOTED_ATOM | QUOTED_ATOM | variable
  public static boolean map_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_NAME, "<map name>");
    r = consumeToken(b, UNQUOTED_ATOM);
    if (!r) r = consumeToken(b, QUOTED_ATOM);
    if (!r) r = variable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // map_name LBRACE term? RBRACE
  public static boolean map_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_TERM, "<map term>");
    r = map_name(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && map_term_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // term?
  private static boolean map_term_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_term_2")) return false;
    term(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // INTEGER|FLOAT|BIN_NUMBER|OCT_NUMBER|HEX_NUMBER|CHAR_CODE
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, BIN_NUMBER);
    if (!r) r = consumeToken(b, OCT_NUMBER);
    if (!r) r = consumeToken(b, HEX_NUMBER);
    if (!r) r = consumeToken(b, CHAR_CODE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // basic_term term
  public static boolean operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATION, "<operation>");
    r = basic_term(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN term RPAREN
  public static boolean parenthesized_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenthesized_block")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && term(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PARENTHESIZED_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // (KEY? SEPARATOR VALUE?) | KEY
  public static boolean property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = property_0(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    exit_section_(b, l, m, r, false, recover_property_parser_);
    return r;
  }

  // KEY? SEPARATOR VALUE?
  private static boolean property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = property_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && property_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY?
  private static boolean property_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_0")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean property_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  /* ********************************************************** */
  // !(KEY|SEPARATOR|COMMENT)
  static boolean recover_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_property_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY|SEPARATOR|COMMENT
  private static boolean recover_property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_property_0")) return false;
    boolean r;
    r = consumeToken(b, KEY);
    if (!r) r = consumeToken(b, SEPARATOR);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // term DOT
  public static boolean sentence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sentence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SENTENCE, "<sentence>");
    r = term(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // operation|basic_term
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = operation(b, l + 1);
    if (!r) r = basic_term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ANONYMOUS_VARIABLE|NAMED_VARIABLE
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, "<variable>", ANONYMOUS_VARIABLE, NAMED_VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE, "<variable>");
    r = consumeToken(b, ANONYMOUS_VARIABLE);
    if (!r) r = consumeToken(b, NAMED_VARIABLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  static final Parser recover_property_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return recover_property(b, l + 1);
    }
  };
}
