package comp5541.teamf.eternity;

import java.util.regex.Pattern;

/**
 * Created by rsmith on 4/9/2016.
 */
public class Calculator {

  public Calculator() {
    this.resetPrevious();
    this.resetCurrent();
  }

  private StringBuilder current;
  private StringBuilder previous;

  private int parenthesesDepth;

  public String getPrevious() {
    return this.previous.toString();
  }

  public void resetPrevious() {
    previous = new StringBuilder("0");
  }

  public void resetCurrent() {
    current = new StringBuilder();
    parenthesesDepth = 0;
  }

  public String getCurrent() {
    return this.current.toString();
  }

  private void setParenthesesDepth(int flag) {
    switch (flag) {
      case 1:
        parenthesesDepth++;
        break;
      case -1:
        parenthesesDepth--;
        break;
      default:
    }
  }

  public void pressKey(final String validation,
                       final String character,
                       final int parentheses) {
    if (Pattern.matches(validation, current.toString())) {
      setParenthesesDepth(parentheses);
      current.append(character);
    }
  }


  public void pressBackspace() {
    if (Pattern.matches(".*[\\)]", current.toString())) {
      parenthesesDepth++;
    }
    if (Pattern.matches(".*[\\(" + Util.FUNCTION_REGEX + "]$", current.toString())) {
      parenthesesDepth--;
    }
    current.deleteCharAt(current.length() - 1);
    if (current.length() > 0
        && current.charAt(current.length() - 1) == Tokens.NEGATION.build().charAt(0)) {
      current.deleteCharAt(current.length() - 1);
    }
  }

  public void pressClearAll() {
    resetPrevious();
    resetCurrent();
  }

  public void pressClearExpression() {
    resetCurrent();
  }


  public void pressEvaluate() {
    // Ensure current is not empty
    if (current.length() == 0) {
      current.append("0");
    }
    // Remove empty left parentheses and functions; append zero if result is empty
    if (Pattern.matches("[\\(" + Util.FUNCTION_REGEX + "]",
                        ((Character) current.charAt(current.length() - 1)).toString())) {
      parenthesesDepth--;
      current.deleteCharAt(current.length() - 1);
      if (current.length() == 0) {
        current.append("0");
      }
    }
    // Remove hanging decimal point or operators; append zero if result is empty
    if (Pattern.matches("[\\." + Util.OPERATOR_REGEX + "]",
                        ((Character) current.charAt(current.length() - 1)).toString())) {
      current.deleteCharAt(current.length() - 1);
      if (current.length() == 0) {
        current.append("0");
      }
    }
    // Close remaining parentheses
    for (int i = 0; i < parenthesesDepth; parenthesesDepth--) {
      current.append(")");
    }
    // Append to previous if first character is an operator
    if (Pattern.matches("[" + Util.OPERATOR_REGEX + "]",
                        ((Character) current.charAt(0)).toString())) {
      if (previous.length() == 0) {
        previous.append("0");
      }
      previous.append(current);
    } else {
      previous = new StringBuilder(current);
    }
    try {
      net.objecthunter.exp4j.Expression
          e = new net.objecthunter.exp4j.ExpressionBuilder(Util.executeReplace(previous))
          .functions(Util.FUNCTIONS).build();
      Double result = e.evaluate();
      if (result == result.intValue()) {
        current =
            new StringBuilder(((Integer) result.intValue()).toString().replace('-', '±'));
      } else {
        current = new StringBuilder(result.toString().replace('-', '±'));
      }
    } catch (Exception err) {
      resetPrevious();
      resetCurrent();
    }
  }


  public void pressNegation() {
    if (java.util.regex.Pattern.matches("(.*?)(\\d+[\\.]?\\d*$)", current.toString())) {
      if (java.util.regex.Pattern.matches("(.*?)(±\\d+[\\.]?\\d*$)", current.toString())) {
        java.util.regex.Pattern
            p = java.util.regex.Pattern
            .compile("(.*?)(±\\d+[\\.]?\\d*$)");
        java.util.regex.Matcher m = p.matcher(current.toString());
        m.find();
        int position = m.start(2);
        current.deleteCharAt(position);
      } else {
        java.util.regex.Pattern p =
            java.util.regex.Pattern.compile("(.*?)(\\d+[\\.]?\\d*$)");
        java.util.regex.Matcher m = p.matcher(current.toString());
        m.find();
        int position = m.start(2);
        current.insert(position, Tokens.NEGATION.build());
      }
    }
  }


  public void pressParenthesisRight(android.view.View v) {
    if (java.util.regex.Pattern.matches("(.*[\\d\\)]$)", current.toString())
        && parenthesesDepth > 0) {
      parenthesesDepth--;
      current.append(")");
    }
  }
}