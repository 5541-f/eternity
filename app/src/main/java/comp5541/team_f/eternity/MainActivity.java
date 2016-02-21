package comp5541.team_f.eternity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    private void setPrevious() {
        previous = new StringBuilder("0");
        tvPrevious = (TextView) findViewById(R.id.tvPrevious);
        tvPrevious.setText("");
        tvPrevious.setMovementMethod(new ScrollingMovementMethod());
    }

    private void setCurrent() {
        current = new StringBuilder();
        tvCurrent = (TextView) findViewById(R.id.tvCurrent);
        tvCurrent.setText("0");
        tvCurrent.setMovementMethod(new ScrollingMovementMethod());
        parenthesesDepth = 0;
    }

    private View.OnClickListener setKey(final String validation, final String character) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(validation, current.toString())) {
                    current.append(character);
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        };
    }

    private View.OnClickListener setKey(final String character) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(Util.FUNCTION_VALIDATION, current.toString())) {
                    parenthesesDepth++;
                    current.append(character);
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setPrevious();
        this.setCurrent();

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
        Button btnAddition = (Button) findViewById(R.id.btnAddition);
        Button btnBackspace = (Button) findViewById(R.id.btnBackspace);
        Button btnClearAll = (Button) findViewById(R.id.btnClearAll);
        Button btnClearExpression = (Button) findViewById(R.id.btnClearExpression);
        Button btnDivision = (Button) findViewById(R.id.btnDivision);
        Button btnPoint = (Button) findViewById(R.id.btnPoint);
        Button btnExecute = (Button) findViewById(R.id.btnExecute);
        Button btnExponent10 = (Button) findViewById(R.id.btnP10);
        Button btnExponentNatural = (Button) findViewById(R.id.btnPE);
        Button btnLogarithm10 = (Button) findViewById(R.id.btnLogarithm10);
        Button btnModulus = (Button) findViewById(R.id.btnModulus);
        Button btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        Button btnNegation = (Button) findViewById(R.id.btnNegation);
        Button btnParenthesisLeft = (Button) findViewById(R.id.btnParL);
        Button btnParenthesisRight = (Button) findViewById(R.id.btnParR);
        Button btnSine = (Button) findViewById(R.id.btnSin);
        Button btnSquareRoot = (Button) findViewById(R.id.btnSqrt);
        Button btnSubtraction = (Button) findViewById(R.id.btnSub);

        btn0.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "0"));
        btn1.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "1"));
        btn2.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "2"));
        btn3.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "3"));
        btn4.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "4"));
        btn5.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "5"));
        btn6.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "6"));
        btn7.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "7"));
        btn8.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "8"));
        btn9.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "9"));

        btnAddition.setOnClickListener(this.setKey(
                Util.OPERATOR_VALIDATION, Symbol.ADDITION.build()));
        btnDivision.setOnClickListener(this.setKey(
                Util.OPERATOR_VALIDATION, Symbol.DIVISION.build()));
        btnModulus.setOnClickListener(this.setKey(
                Util.OPERATOR_VALIDATION, Symbol.MODULUS.build()));
        btnMultiplication.setOnClickListener(this.setKey(
                Util.OPERATOR_VALIDATION, Symbol.MULTIPLICATION.build()));
        btnSubtraction.setOnClickListener(this.setKey(
                Util.OPERATOR_VALIDATION, Symbol.SUBTRACTION.build()));

        btnExponent10.setOnClickListener(this.setKey(Symbol.EXPONENT_10.build()));
        btnLogarithm10.setOnClickListener(this.setKey(Symbol.LOGARITHM_10.build()));
        btnParenthesisLeft.setOnClickListener(this.setKey("("));
        btnExponentNatural.setOnClickListener(this.setKey(Symbol.EXPONENT_NATURAL.build()));
        btnSine.setOnClickListener(this.setKey(Symbol.SINE.build()));
        btnSquareRoot.setOnClickListener(this.setKey(Symbol.SQUARE_ROOT.build()));

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current.length() < 1) tvCurrent.setText("0");
                else {
                    if (Pattern.matches(".*[\\)]", current.toString())) parenthesesDepth++;
                    if (Pattern.matches(".*[\\(∿ℯ⑽㏒√]$", current.toString())) parenthesesDepth--;
                    current.deleteCharAt(current.length() - 1);
                    if (current.length() < 1) tvCurrent.setText("0");
                    else tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrevious();
                setCurrent();
            }
        });

        btnClearExpression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCurrent();
            }
        });

        // Also cast to int if % 0 == 0;
        // move scroll on type??
        // leave expression after error?
        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current.length() == 0) current.append("0");
                if (Pattern.matches("[\\(]",
                        ((Character) current.charAt(current.length() - 1)).toString())) {
                    parenthesesDepth--;
                    current.deleteCharAt(current.length() - 1);
                    if (current.length() == 0) current.append("0");
                }
                if (Pattern.matches("[\\.\\+—×÷%]",
                        ((Character) current.charAt(current.length() - 1)).toString())) {
                    current.deleteCharAt(current.length() - 1);
                    if (current.length() == 0) current.append("0");
                }
                for (int i = 0; i < parenthesesDepth; parenthesesDepth--) current.append(")");
                if (Pattern.matches("[\\+—×÷%]", ((Character) current.charAt(0)).toString())) {
                    if (previous.length() == 0) previous.append("0");
                    previous.append(current);
                } else previous = new StringBuilder(current);
                try {
                    Expression e = new ExpressionBuilder(Util.executeReplace(previous)).build();
                    Double result = e.evaluate();
                    current = new StringBuilder(result.toString());
                    tvPrevious.setText(Util.displayReplace(previous));
                    tvCurrent.setText(Util.displayReplace(current));
                } catch (Exception err) {
                    setPrevious();
                    setCurrent();
                    tvPrevious.setText(err.getMessage());
                    tvCurrent.setText(R.string.ERROR_LABEL);
                }
            }
        });

        //Neg; roughed in
        btnNegation.setOnClickListener(new View.OnClickListener() {
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

        btnParenthesisRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(.*[\\d\\)]$)", current.toString()) && parenthesesDepth > 0) {
                    parenthesesDepth--;
                    current.append(")");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btnPoint.setOnClickListener(this.setKey(".*(?<![]\\.\\d])\\d+$", "."));
    }
}
