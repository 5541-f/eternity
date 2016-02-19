package comp5541.team_f.eternity;

/**
 * Created by richard.smith on 2016-02-18.
 */
enum Symbol {

    SINE             ("<tt>sin</tt>",                 "q", "<tt>sin</tt>(",                 "f_sine("),
    EXPONENT_NATURAL ("<tt><i>e</i></tt><sup>x</sup>","w", "<tt><i>e</i></tt><sup>^</sup>(","f_expE("),
    SQUARE_ROOT      ("<tt>√</tt>",                   "√", "<tt>√</tt>(",                  "f_sqrt("),
    EXPONENT_10      ("<tt>10</tt><sup>x</sup>",      "y", "<tt>10</tt><sup>^</sup>(",      "f_exp10("),
    LOGRITHM_10      ("<tt>log</tt><sub>10</sub>",    "_", "<tt>log</tt><sub>10</sub>(",    "f_log("),
    MODULUS          ("<tt>mod</tt>",                 "%", " <tt>mod</tt> ",                "%"),
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
