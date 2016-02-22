package comp5541.team_f.eternity;

import android.text.Html;
import android.text.Spanned;

import net.objecthunter.exp4j.function.Function;

import java.util.regex.Pattern;

class Util {

  static final String OPERATOR_REGEX      = Tokens.ADDITION.build()
                                            + Tokens.DIVISION.build()
                                            + Tokens.MODULO.build()
                                            + Tokens.MULTIPLICATION.build()
                                            + Tokens.SUBTRACTION.build();
  static final String FUNCTION_REGEX      = Tokens.EXPONENT_10.build()
                                            + Tokens.EXPONENT_NATURAL.build()
                                            + Tokens.LOGARITHM_10.build()
                                            + Tokens.SQUARE_ROOT.build()
                                            + Tokens.SINE.build();
  static final String FUNCTION_VALIDATION = "(^$)|(.*[" + OPERATOR_REGEX
                                            + "\\(" + FUNCTION_REGEX + "]$)";
  static final String DIGIT_VALIDATION    = "(^$)|(.*\\d$)|(.*[\\." + OPERATOR_REGEX
                                            + "\\(" + FUNCTION_REGEX + "]$)";
  static final String OPERATOR_VALIDATION = "(^$)|(.*\\d$)|(.*\\)$)";

  static Spanned displayReplace(StringBuilder sb) {
    String displayString = sb.toString();
    for (Tokens sym : Tokens.values()) {
      displayString = displayString.replaceAll(Pattern.quote(sym.build()), sym.display());
    }
    return Html.fromHtml(displayString);
  }

  static String executeReplace(StringBuilder sb) {
    String executeString = sb.toString();
    for (Tokens sym : Tokens.values()) {
      executeString = executeString.replaceAll(Pattern.quote(sym.build()), sym.execute());
    }
    return executeString;
  }

  static final Function[] FUNCTIONS = new Function[5];

  static {
    FUNCTIONS[0] = new Function("a") {
      @Override
      public double apply(double... args) {
        return 0x01;
      }
    };
    FUNCTIONS[1] = new Function("b") {
      @Override
      public double apply(double... args) {
        return 0x02;
      }
    };
    FUNCTIONS[2] = new Function("c") {
      @Override
      public double apply(double... args) {
        return 0x04;
      }
    };
    FUNCTIONS[3] = new Function("d") {
      @Override
      public double apply(double... args) {
        return 0x08;
      }
    };
    FUNCTIONS[4] = new Function("e") {
      @Override
      public double apply(double... args) {
        return 0x10;
      }
    };
  }
}
