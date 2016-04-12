package comp5541.teamf.eternity;

/**
 * Enum of types of tokens based on common behaviours.
 */
enum Type {
  DIGIT,
  FUNCTION,
  NEGATION,
  OPERATOR,
  PARENTHESIS_LEFT,
  PARENTHESIS_RIGHT,
  POINT
}

/**
 * Enum of mathematical tokens depending on use. Display strings are displayed in the UI; build
 * strings are used to build the strings before execution and prevent usage conflicts; execute
 * strings are those which are recognized by the exp4j library; validation strings are those used to
 * decide if a token can be inserted without resulting in a syntactically invalid expression;.
 */
enum Tokens {

  EXPONENT_10("⑽", "10ˣ", "fExpTen(", Type.FUNCTION),
  EXPONENT_NATURAL("ℯ", "ℯˣ", "fExpNat(", Type.FUNCTION),
  LOGARITHM_10("㏒", "log₁₀", "fLogTen(", Type.FUNCTION),
  SINE("∿", "sin", "fSine(", Type.FUNCTION),
  SQUARE_ROOT("√", "√", "fSqrt(", Type.FUNCTION),
  PARENTHESIS_LEFT("(", "(", "(", Type.PARENTHESIS_LEFT),
  PARENTHESIS_RIGHT(")", ")", ")", Type.PARENTHESIS_RIGHT),
  MODULO("%", " <tt><small>mod</small></tt> ", "%", Type.OPERATOR),
  ADDITION("➕", " + ", "+", Type.OPERATOR),
  SUBTRACTION("—", " – ", "-", Type.OPERATOR),
  MULTIPLICATION("×", " × ", "*", Type.OPERATOR),
  DIVISION("÷", " ÷ ", "/", Type.OPERATOR),
  NEGATION("±", " -", " -", Type.NEGATION),
  POINT(".", ".", ".", Type.POINT),
  ZERO("0", "0", "0", Type.DIGIT),
  ONE("1", "1", "1", Type.DIGIT),
  TWO("2", "2", "2", Type.DIGIT),
  THREE("3", "3", "3", Type.DIGIT),
  FOUR("4", "4", "4", Type.DIGIT),
  FIVE("5", "5", "5", Type.DIGIT),
  SIX("6", "6", "6", Type.DIGIT),
  SEVEN("7", "7", "7", Type.DIGIT),
  EIGHT("8", "8", "8", Type.DIGIT),
  NINE("9", "9", "9", Type.DIGIT);

  /** Single unicode character to enable consistent representation of token during construction. */
  private final String build;
  /** Display string of token. */
  private final String display;
  /** Token string as recognized by exp4j. */
  private final String execute;
  /** Token type for grouping based on common behaviour. */
  private final Type   type;

  public String build() {
    return this.build;
  }

  public String display() {
    if (this.type == Type.FUNCTION) {
      return "<tt><small>" + this.display + "</small></tt>(";
    }
    return this.display;
  }

  public String execute() {
    return this.execute;
  }

  /** String for defining function definition */
  public String define() {
    if (this.type == Type.FUNCTION) {
      return this.execute.substring(0, this.execute.length() - 1);
    }
    return "";
  }

  public String validate() {
    switch (this.type) {
      case DIGIT:
        return DIGIT_VALIDATION;
      case FUNCTION:
        return FUNCTION_VALIDATION;
      case NEGATION:
        return NEGATION_VALIDATION;
      case OPERATOR:
        return OPERATOR_VALIDATION;
      case PARENTHESIS_LEFT:
        return FUNCTION_VALIDATION;
      case PARENTHESIS_RIGHT:
        return PARENTHESIS_RIGHT_VALIDATION;
      case POINT:
        return POINT_VALIDATION;
      default:
        return "";
    }
  }

  Tokens(String build, String display, String execute, Type type) {
    this.build = build;
    this.display = display;
    this.execute = execute;
    this.type = type;
  }

  /**
   * String constant of operator build tokens for use in regular expressions.
   */
  static final String OPERATORS           = ADDITION.build()
                                            + DIVISION.build()
                                            + MODULO.build()
                                            + MULTIPLICATION.build()
                                            + SUBTRACTION.build();
  /**
   * String constant of function build tokens for use in regular expressions.
   */
  static final String FUNCTIONS           = EXPONENT_10.build()
                                            + EXPONENT_NATURAL.build()
                                            + LOGARITHM_10.build()
                                            + SQUARE_ROOT.build()
                                            + SINE.build();
  /** String constant of regular expression for validation of digits. */
  static final String DIGIT_VALIDATION    = "(^$)|(.*\\d$)|(.*[\\." + OPERATORS
                                            + "\\(" + FUNCTIONS + "]$)";
  /** String constant of regular expression for validation of function tokens. */
  static final String FUNCTION_VALIDATION = "(^$)|(.*[" + OPERATORS
                                            + "\\(" + FUNCTIONS + "]$)";
  /** String constant of regular expression for validation of operator tokens. */
  static final String OPERATOR_VALIDATION = "(^$)|(.*\\d$)|(.*\\)$)";

  static final String PARENTHESIS_RIGHT_VALIDATION = "(.*[\\d\\)]$)";
  static final String NEGATION_VALIDATION          = "(.*?)(\\d+[\\.]?\\d*$)";
  static final String POINT_VALIDATION             = ".*(?<![\\.\\d])\\d+$";
}
