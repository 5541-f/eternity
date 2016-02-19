package comp5541.team_f.eternity;

/**
 * Created by richard.smith on 2016-02-18.
 */
enum Symbol {

    SINE("<tt><small>sin</small></tt>",                 "∿", "<tt><small>sin</small></tt>(",                 "f_sine("),
    EXPONENT_NATURAL ("<tt><small><i>e</i>ˣ</small></tt>","ℯ", "<tt><small><i>e</i>ˣ</small></tt>(","f_expE("),
    SQUARE_ROOT("<tt>√</tt>",                   "√", "<tt>√</tt>(",                  "f_sqrt("),
    EXPONENT_10("<tt><small>10ˣ</small></tt>",      "⑽", "<tt><small>10ˣ</small></tt>(",      "f_exp10("),
    LOGARITHM_10("<tt><small>log₁₀</small></tt>","㏒","<tt><small>log₁₀</small></tt>(",    "f_log("),
    MODULUS          ("<tt><small>mod</small></tt>","%"," <tt><small>mod<small></tt> ","%"),
    ADDITION         ("<tt>+</tt>",                   "+", " + ",                           "+"),
    SUBTRACTION      ("<tt>—</tt>",                   "—", " — ",                         "-"),
    MULTIPLICATION   ("<tt>×</tt>",                   "×", " × ",                           "*"),
    DIVISION         ("<tt>÷</tt>",                   "÷", " ÷ ",                           "/"),
    NEGATION         ("<tt>±</tt>",                   "±", " –",                            " -");

    private final String label;
    private final String build;
    private final String display;
    private final String execute;

    Symbol(String label, String build, String display, String execute) {
        this.label = label;
        this.build = build;
        this.display = display;
        this.execute = execute;
    }

    public String label() {
        return label;
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
