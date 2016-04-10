package comp5541.teamf.eternity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

import java.util.regex.Pattern;

public class Calculator {

  private StringBuilder current;
  private StringBuilder previous;
  private int parenthesesDepth;

  public Calculator() {
    this.resetPrevious();
    this.resetCurrent();
  }

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

  /**
   * Increments or decrements <b>parenthesis depth</b> by 1. For use with <b>setKey</b> method.
   *
   * @param flag
   *     <b>1</b> to increment by 1; <b>-1</b> to decrement by 1; default has no impact.
   */
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

  public void clearAll() {
    resetPrevious();
    resetCurrent();
  }

  public void clearExpression() {
    resetCurrent();
  }


  public void evaluateExpression() {
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
          e = new net.objecthunter.exp4j.ExpressionBuilder(Util.executeReplace(previous.toString()))
          .functions(FUNCTIONS).build();
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
      throw err;
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


  public void pressParenthesisRight() {
    if (java.util.regex.Pattern.matches("(.*[\\d\\)]$)", current.toString())
        && parenthesesDepth > 0) {
      parenthesesDepth--;
      current.append(")");
    }
  }

  /**
   * Array of custom <b>exp4j</b> functions.
   */
  static final Function[] FUNCTIONS = new Function[5];

  /**
   * Definition of custom <b>exp4j</b> functions with methods from
   * <b>comp5541.teamf.eternity.Math</b>.
   */
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
        return Math.logarithm10(args[0]);
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