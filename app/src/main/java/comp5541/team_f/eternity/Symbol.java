package comp5541.team_f.eternity;

enum Symbol {

    SINE             ("∿",  "<tt><small>sin</small></tt>(",         "sin("),//rename later
    EXPONENT_NATURAL ("ℯ",  "<tt><small><i>ℯ</i>ˣ</small></tt>(",   "exp("),//rename later
    SQUARE_ROOT      ("√",  "<tt>√</tt>(",                         "sqrt("), //rename later
    EXPONENT_10      ("⑽",  "<tt><small>10ˣ</small></tt>(",        "10^("),//rename later
    LOGARITHM_10     ("㏒",  "<tt><small>log₁₀</small></tt>(",       "log10("), //rename later
    MODULUS          ("%",  "<tt><small>mod</small></tt>",          "%"),
    ADDITION         ("+",  " + ",                                  "+"),
    SUBTRACTION      ("—",  " – ",                                  "-"),
    MULTIPLICATION   ("×",  " × ",                                  "*"),
    DIVISION         ("÷",  " ÷ ",                                  "/"),
    NEGATION         ("±",  " –",                                   " -");

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
