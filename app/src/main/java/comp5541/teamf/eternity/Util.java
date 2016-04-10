package comp5541.teamf.eternity;

import android.text.Html;
import android.text.Spanned;

import net.objecthunter.exp4j.function.Function;

import java.util.regex.Pattern;

class Util {

  /**
   * String constant of operator build tokens for use in regular expressions.
   */
  static final String OPERATOR_REGEX      = Tokens.ADDITION.build()
                                            + Tokens.DIVISION.build()
                                            + Tokens.MODULO.build()
                                            + Tokens.MULTIPLICATION.build()
                                            + Tokens.SUBTRACTION.build();
  /**
   * String constant of function build tokens for use in regular expressions.
   */
  static final String FUNCTION_REGEX      = Tokens.EXPONENT_10.build()
                                            + Tokens.EXPONENT_NATURAL.build()
                                            + Tokens.LOGARITHM_10.build()
                                            + Tokens.SQUARE_ROOT.build()
                                            + Tokens.SINE.build();
  /**
   * String constant of regular expression for validation of digits.
   */
  static final String DIGIT_VALIDATION    = "(^$)|(.*\\d$)|(.*[\\." + OPERATOR_REGEX
                                            + "\\(" + FUNCTION_REGEX + "]$)";
  /**
   * String constant of regular expression for validation of function tokens.
   */
  static final String FUNCTION_VALIDATION = "(^$)|(.*[" + OPERATOR_REGEX
                                            + "\\(" + FUNCTION_REGEX + "]$)";
  /**
   * String constant of regular expression for validation of operator tokens.
   */
  static final String OPERATOR_VALIDATION = "(^$)|(.*\\d$)|(.*\\)$)";

  /**
   * Method to find and replace tokens for display.
   * @param s (String)
   * @return (Spanned)
   */
  static Spanned displayReplace(String s) {
    String displayString = s;
    for (Tokens sym : Tokens.values()) {
      displayString = displayString.replaceAll(Pattern.quote(sym.build()), sym.display());
    }
    return Html.fromHtml(displayString);
  }

  /**
   * Method to find and replace tokens for execution.
   * @param s (String)
   * @return (String)
   */
  static String executeReplace(String s) {
    String executeString = s;
    for (Tokens sym : Tokens.values()) {
      executeString = executeString.replaceAll(Pattern.quote(sym.build()), sym.execute());
    }
    return executeString;
  }
}
