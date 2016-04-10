package comp5541.teamf.eternity;

import android.text.Html;
import android.text.Spanned;

import java.util.regex.Pattern;

class Util {

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
