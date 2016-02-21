package comp5541.team_f.eternity;

enum Symbol {

  EXPONENT_10
      ("⑽", "<tt><small>10ˣ</small></tt>(", "f_exp10("),//"10^("),//rename later
  EXPONENT_NATURAL
      ("ℯ", "<tt><small>ℯˣ</small></tt>(", "f_expE("),//"exp("),//rename later
  LOGARITHM_10
      ("㏒", "<tt><small>log₁₀</small></tt>(", "f_log10("),//"log10("), //rename later
  SINE
      ("∿", "<tt><small>sin</small></tt>(", "f_sine("),//"sin("),//rename later
  SQUARE_ROOT
      ("√", "<tt><small>√</small></tt>(", "f_sqrt("),//"sqrt("), //rename later
  MODULUS
      ("%", " <tt><small>mod</small></tt> ", "%"),
  ADDITION
      ("+", " + ", "+"),
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
