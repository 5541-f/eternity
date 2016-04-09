package comp5541.teamf.eternity;

/**
 * Enum of mathematical tokens depending on use. Display strings are displayed in the UI; build
 * strings are used to build the strings before execution and prevent usage conflicts; execute
 * strings are those which are recognized by the exp4j library.
 */
enum Tokens {

  EXPONENT_10
      ("⑽", "<tt><small>10ˣ</small></tt>(", "fExpTen("),//"10^("),//rename later
  EXPONENT_NATURAL
      ("ℯ", "<tt><small>ℯˣ</small></tt>(", "fExpNat("),//"exp("),//rename later
  LOGARITHM_10
      ("㏒", "<tt><small>log₁₀</small></tt>(", "fLogTen("),//"log10("), //rename later
  SINE
      ("∿", "<tt><small>sin</small></tt>(", "fSine("),//"sin("),//rename later
  SQUARE_ROOT
      ("√", "<tt><small>√</small></tt>(", "fSqrt("),//"sqrt("), //rename later
  MODULO
      ("%", " <tt><small>mod</small></tt> ", "%"),
  ADDITION
      ("➕", " + ", "+"),
  SUBTRACTION
      ("—", " – ", "-"),
  MULTIPLICATION
      ("×", " × ", "*"),
  DIVISION
      ("÷", " ÷ ", "/"),
  NEGATION
      ("±", " -", " -");

  private final String build;
  private final String display;
  private final String execute;

  Tokens(String build, String display, String execute) {
    this.build = build;
    this.display = display;
    this.execute = execute;
  }

  public String build() {
    return build;
  }

  public String display() {
    return display;
  }

  public String execute() {
    return execute;
  }
}
