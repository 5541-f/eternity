package comp5541.team_f.eternity;

import android.text.Html;
import android.text.Spanned;

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
}
