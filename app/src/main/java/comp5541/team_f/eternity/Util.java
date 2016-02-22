package comp5541.team_f.eternity;

import android.text.Html;
import android.text.Spanned;

import net.objecthunter.exp4j.function.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Util {

  static final String DIGIT_VALIDATION = "(^$)|(.*\\d$)|(.*[\\.\\+—×÷%\\(∿ℯ⑽㏒√]$)";

  static final String OPERATOR_VALIDATION = "(^$)|(.*\\d$)|(.*\\)$)";

  static final String FUNCTION_VALIDATION = "(^$)|(.*[\\+—×÷%\\(∿ℯ⑽㏒√]$)";

  static Spanned displayReplace(StringBuilder sb) {
    String displayString = sb.toString();
    for (Symbol sym : Symbol.values()) {
      displayString = displayString.replaceAll(Pattern.quote(sym.build()), sym.display());
    }
    return Html.fromHtml(displayString);
  }

  static String executeReplace(StringBuilder sb) {
    String executeString = sb.toString();
    for (Symbol sym : Symbol.values()) {
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
