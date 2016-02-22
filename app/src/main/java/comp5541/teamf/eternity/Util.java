package comp5541.teamf.eternity;

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
    FUNCTIONS[0] = new Function("fExpTen") {
      @Override
      public double apply(double... args) {
        return Math.exponent10(args[0]);
      }
    };
    FUNCTIONS[1] = new Function("fExpNat") {
      @Override
      public double apply(double... args) {
        return Math.exponentNatural(args[0]);
      }
    };
    FUNCTIONS[2] = new Function("fLogTen") {
      @Override
      public double apply(double... args) {
        return Math.logrithm10(args[0]);
      }
    };
    FUNCTIONS[3] = new Function("fSine") {
      @Override
      public double apply(double... args) {
        return Math.sine(args[0]);
      }
    };
    FUNCTIONS[4] = new Function("fSqrt") {
      @Override
      public double apply(double... args) {
        return Math.squareRoot(args[0]);
      }
    };
  }
}
