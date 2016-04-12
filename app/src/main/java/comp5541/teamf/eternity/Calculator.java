package comp5541.teamf.eternity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

import java.util.regex.Pattern;

/**
 * Calculator model.
 *
 * UI independent calculator implementation.
 */
public class Calculator {

  private StringBuilder currentExpression;
  private StringBuilder previousExpression;
  /** Number of unclosed left parentheses. */
  private int           parenthesesDepth;

  public Calculator() {
    this.resetPreviousExpression();
    this.resetCurrentExpression();
  }

  public void resetPreviousExpression() {
    previousExpression = new StringBuilder("0");
  }

  public String getPreviousExpression() {
    return this.previousExpression.toString();
  }

  public void resetCurrentExpression() {
    currentExpression = new StringBuilder();
    parenthesesDepth = 0;
  }

  public String getCurrentExpression() {
    return this.currentExpression.toString();
  }

  /**
   * Increments or decrements <b>parenthesis depth</b> of current expression by 1.
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

  /**
   * Insert tokens based on common parameters.
   *
   * @param token
   *     Token to be inserted.
   * @param parentheses
   *     Impact on depth of unclosed left parentheses. Can be 1, -1, or 0.
   */
  public void insertToken(final Tokens token, final int parentheses) {
    if (Pattern.matches(token.validate(), currentExpression.toString())) {
      if (parentheses >= 0 || parenthesesDepth >= 1) {
        setParenthesesDepth(parentheses);
        currentExpression.append(token.build());
      }
    }
  }

  /** Safely remove tokens from current expression. */
  public void backspace() {
    if (Pattern.matches(".*[\\)]", currentExpression.toString())) {
      parenthesesDepth++;
    }
    if (Pattern.matches(".*[\\(" + Tokens.FUNCTIONS + "]$", currentExpression.toString())) {
      parenthesesDepth--;
    }
    currentExpression.deleteCharAt(currentExpression.length() - 1);
    if (currentExpression.length() > 0
        && currentExpression.charAt(currentExpression.length() - 1) == Tokens.NEGATION.build()
                                                                                      .charAt(0)) {
      currentExpression.deleteCharAt(currentExpression.length() - 1);
    }
  }

  /** Reset both current expression and previous expression. */
  public void clearAll() {
    resetPreviousExpression();
    resetCurrentExpression();
  }

  /** Reset current expression only. */
  public void clearExpression() {
    resetCurrentExpression();
  }


  /** Evaluate current expression. */
  public void evaluateExpression() throws Exception {
    String temp = previousExpression.toString();
    // Ensure currentExpression is not empty
    if (currentExpression.length() == 0) {
      currentExpression.append("0");
    }
    while (Pattern.matches("[\\(" + Tokens.FUNCTIONS + "\\." + Tokens.OPERATORS + "]",
                           ((Character) currentExpression.charAt(
                               currentExpression.length() - 1)).toString())) {
      // Remove empty left parentheses and functions; append zero if result is empty
      if (Pattern.matches("[\\(" + Tokens.FUNCTIONS + "]",
                          ((Character) currentExpression.charAt(
                              currentExpression.length() - 1)).toString())) {
        parenthesesDepth--;
        currentExpression.deleteCharAt(currentExpression.length() - 1);
        if (currentExpression.length() == 0) {
          currentExpression.append("0");
        }
      }
      // Remove hanging decimal point or operators; append zero if result is empty
      if (Pattern.matches("[\\." + Tokens.OPERATORS + "]",
                          ((Character) currentExpression.charAt(
                              currentExpression.length() - 1)).toString())) {
        currentExpression.deleteCharAt(currentExpression.length() - 1);
        if (currentExpression.length() == 0) {
          currentExpression.append("0");
        }
      }
    }
    // Close remaining parentheses
    for (int i = 0; i < parenthesesDepth; parenthesesDepth--) {
      currentExpression.append(Tokens.PARENTHESIS_RIGHT.build());
    }
    // Append to previousExpression if first character is an operator
    if (Pattern.matches("[" + Tokens.OPERATORS + "]",
                        ((Character) currentExpression.charAt(0)).toString())) {
      if (previousExpression.length() == 0) {
        previousExpression.append("0");
      }
      previousExpression.append(currentExpression);
    } else {
      previousExpression = new StringBuilder(currentExpression);
    }
    try {
      Expression e = new ExpressionBuilder(executeReplace(previousExpression.toString()))
          .functions(FUNCTIONS)
          .build();
      Double result = e.evaluate();
      if (result.isNaN()) {
        previousExpression = new StringBuilder(temp);
        throw new Exception("Not a real number.");
      }
      if (result.isInfinite()) {
        previousExpression = new StringBuilder(temp);
        throw new Exception(result.toString());
      }
      if (result == result.intValue()) {
        currentExpression = new StringBuilder(
            ((Integer) result.intValue()).toString().replace('-', '±'));
      } else {
        currentExpression = new StringBuilder(result.toString().replace('-', '±'));
      }
    } catch (Exception err) {
      previousExpression = new StringBuilder(temp);
      throw err;
    }
  }

  /**
   * Find and replace tokens for execution.
   *
   * @param buildString
   *     String with tokens in build form.
   *
   * @return (String)
   */
  private String executeReplace(String buildString) {
    String executeString = buildString;
    for (Tokens sym : Tokens.values()) {
      executeString = executeString.replaceAll(Pattern.quote(sym.build()), sym.execute());
    }
    return executeString;
  }

  /** Toggle negation on and off for a number at the end of current expression. */
  public void toggleNegation() {
    if (Pattern.matches(Tokens.NEGATION.validate(), currentExpression.toString())) {
      if (Pattern.matches("(.*?)(±\\d+[\\.]?\\d*$)", currentExpression.toString())) {
        Pattern
            p = Pattern
            .compile("(.*?)(±\\d+[\\.]?\\d*$)");
        java.util.regex.Matcher m = p.matcher(currentExpression.toString());
        m.find();
        int position = m.start(2);
        currentExpression.deleteCharAt(position);
      } else {
        Pattern p =
            Pattern.compile(Tokens.NEGATION.validate());
        java.util.regex.Matcher m = p.matcher(currentExpression.toString());
        m.find();
        int position = m.start(2);
        currentExpression.insert(position, Tokens.NEGATION.build());
      }
    }
  }

  /**
   * Array of custom <b>exp4j</b> functions.
   */
  private static final Function[] FUNCTIONS = new Function[5];

  /**
   * Definition of custom <b>exp4j</b> functions with methods from <b>comp5541.teamf.eternity.Math</b>.
   */
  static {
    FUNCTIONS[0] = new Function(Tokens.EXPONENT_10.define()) {
      @Override
      public double apply(double... args) {
        return Math.exponent10(args[0]);
      }
    };
    FUNCTIONS[1] = new Function(Tokens.EXPONENT_NATURAL.define()) {
      @Override
      public double apply(double... args) {
        return Math.exponentNatural(args[0]);
      }
    };
    FUNCTIONS[2] = new Function(Tokens.LOGARITHM_10.define()) {
      @Override
      public double apply(double... args) {
        return Math.logarithm10(args[0]);
      }
    };
    FUNCTIONS[3] = new Function(Tokens.SINE.define()) {
      @Override
      public double apply(double... args) {
        return Math.sine(args[0]);
      }
    };
    FUNCTIONS[4] = new Function(Tokens.SQUARE_ROOT.define()) {
      @Override
      public double apply(double... args) {
        return Math.squareRoot(args[0]);
      }
    };
  }
}