package comp5541.team_f.eternity;

enum Symbol {

    SINE             ("∿",  "<tt><small>sin</small></tt>(",         "f_sine("),
    EXPONENT_NATURAL ("ℯ",  "<tt><small><i>ℯ</i>ˣ</small></tt>(",   "f_expE("),
    SQUARE_ROOT      ("√",  "<tt>√</tt>(",                          "f_sqrt("),
    EXPONENT_10      ("⑽",  "<tt><small>10ˣ</small></tt>(",         "f_exp10("),
    LOGARITHM_10     ("㏒",  "<tt><small>log₁₀</small></tt>(",       "f_log("),
    MODULUS          ("%",  "<tt><small>mod</small></tt>",           "%"),
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
