package comp5541.teamf.eternity;

import static comp5541.teamf.eternity.Util.DIGIT_VALIDATION;
import static comp5541.teamf.eternity.Util.FUNCTION_VALIDATION;
import static comp5541.teamf.eternity.Util.OPERATOR_VALIDATION;

/**
 * Enum of mathematical tokens depending on use. Display strings are displayed in the UI; build
 * strings are used to build the strings before execution and prevent usage conflicts; execute
 * strings are those which are recognized by the exp4j library.
 */
enum Tokens {

  EXPONENT_10
      ("⑽", "<tt><small>10ˣ</small></tt>(", "fExpTen(", FUNCTION_VALIDATION),
  EXPONENT_NATURAL
      ("ℯ", "<tt><small>ℯˣ</small></tt>(", "fExpNat(", FUNCTION_VALIDATION),
  LOGARITHM_10
      ("㏒", "<tt><small>log₁₀</small></tt>(", "fLogTen(", FUNCTION_VALIDATION),
  SINE
      ("∿", "<tt><small>sin</small></tt>(", "fSine(", FUNCTION_VALIDATION),
  SQUARE_ROOT
      ("√", "<tt><small>√</small></tt>(", "fSqrt(", FUNCTION_VALIDATION),
  PARENTHESIS_LEFT
      ("(", "(", "(", FUNCTION_VALIDATION),
  PARENTHESIS_RIGHT
      (")", ")", ")", "(.*[\\d\\)]$)"),
  MODULO
      ("%", " <tt><small>mod</small></tt> ", "%", FUNCTION_VALIDATION),
  ADDITION
      ("➕", " + ", "+", OPERATOR_VALIDATION),
  SUBTRACTION
      ("—", " – ", "-", OPERATOR_VALIDATION),
  MULTIPLICATION
      ("×", " × ", "*", OPERATOR_VALIDATION),
  DIVISION
      ("÷", " ÷ ", "/", OPERATOR_VALIDATION),
  NEGATION
      ("±", " -", " -", "(.*?)(\\d+[\\.]?\\d*$)"),
  POINT(".", ".", ".", ".*(?<![\\.\\d])\\d+$"),
  ZERO("0", "0", "0", DIGIT_VALIDATION),
  ONE("1", "1", "1", DIGIT_VALIDATION),
  TWO("2", "2", "2", DIGIT_VALIDATION),
  THREE("3", "3", "3", DIGIT_VALIDATION),
  FOUR("4", "4", "4", DIGIT_VALIDATION),
  FIVE("5", "5", "5", DIGIT_VALIDATION),
  SIX("6", "6", "6", DIGIT_VALIDATION),
  SEVEN("7", "7", "7", DIGIT_VALIDATION),
  EIGHT("8", "8", "8", DIGIT_VALIDATION),
  NINE("9", "9", "9", DIGIT_VALIDATION);

  private final String build;
  private final String display;
  private final String execute;
  private final String validate;

  public String build() {
    return build;
  }

  public String display() {
    return display;
  }

  public String execute() {
    return execute;
  }

  public String validate() {
    return validate;
  }

  Tokens(String build, String display, String execute, String validate) {
    this.build = build;
    this.display = display;
    this.execute = execute;
    this.validate = validate;
  }
}
