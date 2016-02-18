package comp5541.team_f.eternity;

/**
 * Created by richard.smith on 2016-02-18.
 */
public class Util {

    static String displayReplace(StringBuilder sb) {

        String buildString = sb.toString();
        String displayString = new String();
        for (Symbol sym : Symbol.values()) {
            displayString = buildString.replace(sym.build(), sym.display());
        }

        return displayString;
    }

    static String executeReplace(StringBuilder sb) {

        String buildString = sb.toString();
        String displayString = new String();
        for (Symbol sym : Symbol.values()) {
            displayString = buildString.replace(sym.build(), sym.display());
        }

        return displayString;
    }
}
