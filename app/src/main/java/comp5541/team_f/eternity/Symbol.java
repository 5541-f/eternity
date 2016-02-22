package comp5541.team_f.eternity;

enum Symbol {

  EXPONENT_10
      ("⑽", "<tt><small>10ˣ</small></tt>(", "a("),//"10^("),//rename later
  EXPONENT_NATURAL
      ("ℯ", "<tt><small>ℯˣ</small></tt>(", "b("),//"exp("),//rename later
  LOGARITHM_10
      ("㏒", "<tt><small>log₁₀</small></tt>(", "c("),//"log10("), //rename later
  SINE
      ("∿", "<tt><small>sin</small></tt>(", "d("),//"sin("),//rename later
  SQUARE_ROOT
      ("√", "<tt><small>√</small></tt>(", "e("),//"sqrt("), //rename later
  MODULUS
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

  Symbol(String build, String display, String execute) {
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
