package comp5541.team_f.eternity;

import java.util.regex.Pattern;

/**
 * Created by richard.smith on 2016-02-18.
 */
public class Util {

    static String displayReplace(StringBuilder sb) {

        String buildString = sb.toString();
        String displayString = buildString;
        for (Symbol sym : Symbol.values()) {
            displayString = displayString.replaceAll(Pattern.quote(sym.build()), sym.display());
        }

        return displayString;
    }

    static String executeReplace(StringBuilder sb) {

        String buildString = sb.toString();
        String executeString = buildString;
        for (Symbol sym : Symbol.values()) {
            executeString = executeString.replaceAll(Pattern.quote(sym.build()), sym.execute());
        }

        return executeString;
    }
}
