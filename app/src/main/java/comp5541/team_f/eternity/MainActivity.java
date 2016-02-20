package comp5541.team_f.eternity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private StringBuilder previous, current;

    private TextView tvPrevious, tvCurrent;

    private int parenthesesDepth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previous = new StringBuilder("0");
        tvPrevious = (TextView) findViewById(R.id.tvPrevious);
        tvPrevious.setMovementMethod(new ScrollingMovementMethod());

        current = new StringBuilder();
        tvCurrent = (TextView) findViewById(R.id.tvCurrent);
        tvCurrent.setText("0");
        tvCurrent.setMovementMethod(new ScrollingMovementMethod());

        parenthesesDepth = 0;

        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnBS = (Button) findViewById(R.id.btnBS);
        Button btnCA = (Button) findViewById(R.id.btnCA);
        Button btnCE = (Button) findViewById(R.id.btnCE);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnDot = (Button) findViewById(R.id.btnDot);
        Button btnEqu = (Button) findViewById(R.id.btnEqu);
        Button btnLog = (Button) findViewById(R.id.btnLog);
        Button btnMod = (Button) findViewById(R.id.btnMod);
        Button btnMul = (Button) findViewById(R.id.btnMul);
        Button btnNeg = (Button) findViewById(R.id.btnNeg);
        Button btnP10 = (Button) findViewById(R.id.btnP10);
        Button btnParL = (Button) findViewById(R.id.btnParL);
        Button btnParR = (Button) findViewById(R.id.btnParR);
        Button btnPE = (Button) findViewById(R.id.btnPE);
        Button btnSin = (Button) findViewById(R.id.btnSin);
        Button btnSqrt = (Button) findViewById(R.id.btnSqrt);
        Button btnSub = (Button) findViewById(R.id.btnSub);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("0");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("1");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("2");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("3");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("4");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("5");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("6");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("7");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("8");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.DIGIT_VALIDATION, current.toString())) {
                    current.append("9");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.OPERATOR_VALIDATION, current.toString())) {
                    current.append(Symbol.ADDITION.build());
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current.length() < 1) tvCurrent.setText("0");
                else {
                    if (Pattern.matches(".*[\\)]", current.toString())) parenthesesDepth++;
                    if (Pattern.matches(".*[\\(∿ℯ⑽㏒√]$", current.toString())) parenthesesDepth--;
                    current.deleteCharAt(current.length() - 1);
                    if (current.length() < 1) tvCurrent.setText("0");
                    else tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnCA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous = new StringBuilder("0");
                current = new StringBuilder();
                tvPrevious.setText("");
                tvCurrent.setText("0");
                parenthesesDepth = 0;
            }
        });

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = new StringBuilder();
                tvCurrent.setText("0");
                parenthesesDepth = 0;
            }
        });

        //This is shit; redo it.
        // Also cast to int if % 0 == 0; reset parentheses depth, C/CE too;
        // remove excess .0;, move scroll on type?? close parentheses and functions;
        // close operators with identity
        btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current.length() == 0) return;
                //probably invert this and make operators the exception
                if (Pattern.matches("[\\d\\s\\(∿ℯ⑽㏒√]", ((Character) current.charAt(0)).toString())) {
                    previous.delete(0, previous.length());
                    previous.append(current);
                } else {
                    if (previous.length() == 0) previous.append("0");
                    previous.append(current);
                }
                if (Pattern.matches("\\.", ((Character) current.charAt(current.length() - 1)).toString()))
                    current.append("0");
                try {
                    Expression e = new ExpressionBuilder(Util.executeReplace(previous)).build();
                    current = new StringBuilder(((Double) e.evaluate()).toString());
                    tvPrevious.setText(Html.fromHtml(Util.displayReplace(previous)));
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                } catch (Exception err) {
                    previous = new StringBuilder("0");
                    current = new StringBuilder("");
                    tvPrevious.setText(err.getMessage());
                    tvCurrent.setText(R.string.ERROR_LABEL);
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(".*(?<![]\\.\\d])\\d+$", current.toString())) {
                    current.append(".");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.OPERATOR_VALIDATION, current.toString())) {
                    current.append(Symbol.DIVISION.build());
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.OPERATOR_VALIDATION, current.toString())) {
                    current.append(Symbol.MODULUS.build());
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.OPERATOR_VALIDATION, current.toString())) {
                    current.append(Symbol.MULTIPLICATION.build());
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.FUNCTION_VALIDATION, current.toString())) {
                    current.append(Symbol.LOGARITHM_10.build());
                    parenthesesDepth++;
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        //Neg; roughed in
        btnNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("", current.toString())) {
                    if (Pattern.matches("", current.toString())) {
                        Pattern p = Pattern.compile("");
                        Matcher m = p.matcher(current.toString());
                        int position = m.regionStart();
                        current.insert(position + 1, " -");
                    } else if (Pattern.matches("", current.toString())) {
                        Pattern p = Pattern.compile("");
                        Matcher m = p.matcher(current.toString());
                        int position = m.regionStart();
                        current.delete(position + 1, position + 2);
                    }
                }
            }
        });

        btnP10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.FUNCTION_VALIDATION, current.toString())) {
                    current.append(Symbol.EXPONENT_10.build());
                    parenthesesDepth++;
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnParL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.FUNCTION_VALIDATION, current.toString())) {
                    parenthesesDepth++;
                    current.append("(");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnParR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(.*[\\d\\)]$)", current.toString()) && parenthesesDepth > 0) {
                    parenthesesDepth--;
                    current.append(")");
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnPE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.FUNCTION_VALIDATION, current.toString())) {
                    current.append(Symbol.EXPONENT_NATURAL.build());
                    parenthesesDepth++;
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.OPERATOR_VALIDATION, current.toString())) {
                    current.append(Symbol.SUBTRACTION.build());
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.FUNCTION_VALIDATION, current.toString())) {
                    current.append(Symbol.SINE.build());
                    parenthesesDepth++;
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Pattern.matches(Util.FUNCTION_VALIDATION, current.toString())) {
                    current.append(Symbol.SQUARE_ROOT.build());
                    parenthesesDepth++;
                    tvCurrent.setText(Html.fromHtml(Util.displayReplace(current)));
                }
            }
        });
    }
}
