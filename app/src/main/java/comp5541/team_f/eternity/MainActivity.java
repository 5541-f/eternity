package comp5541.team_f.eternity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    StringBuilder previous, current;

    TextView tvPrevious, tvCurrent;

    int parenthesesDepth;

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6,
            btn7, btn8, btn9, btnAdd, btnBS, btnCA, btnCE,
            btnDiv, btnDot, btnEqu, btnLog, btnMod, btnMul, btnNeg,
            btnP10, btnParL, btnParR, btnPE, btnSin, btnSqrt, btnSub;

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

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBS = (Button) findViewById(R.id.btnBS);
        btnCA = (Button) findViewById(R.id.btnCA);
        btnCE = (Button) findViewById(R.id.btnCE);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnEqu = (Button) findViewById(R.id.btnEqu);
        btnLog = (Button) findViewById(R.id.btnLog);
        btnMod = (Button) findViewById(R.id.btnMod);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnNeg = (Button) findViewById(R.id.btnNeg);
        btnP10 = (Button) findViewById(R.id.btnP10);
        btnParL = (Button) findViewById(R.id.btnParL);
        btnParR = (Button) findViewById(R.id.btnParR);
        btnPE = (Button) findViewById(R.id.btnPE);
        btnSin = (Button) findViewById(R.id.btnSin);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);
        btnSub = (Button) findViewById(R.id.btnSub);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("0");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("1");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("2");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("3");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("4");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("5");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("6");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("7");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("8");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    current.append("9");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*\\)$)", current.toString())) {
                    current.append(Symbol.ADDITION.build());
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        //BS
        btnBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current.length() < 1) tvCurrent.setText("0");
                else {
                    current.deleteCharAt(current.length() - 1);
                    if (current.length() < 1) tvCurrent.setText("0");
                    else tvCurrent.setText(Util.displayReplace(current));
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

        //This is shit; redo it
        btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current.length() == 0) return;
                if (Pattern.matches("\\d|\\s", ((Character) current.charAt(0)).toString())) {
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
                    tvPrevious.setText(Util.displayReplace(previous));
                    tvCurrent.setText(Util.displayReplace(current));
                } catch (Exception err) {
                    previous = new StringBuilder("0");
                    current = new StringBuilder("");
                    tvPrevious.setText(err.getMessage());
                    tvCurrent.setText("ERROR");
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches(".*(?<![]\\.\\d])\\d+$", current.toString())) {
                    current.append(".");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*\\)$)", current.toString())) {
                    current.append(Symbol.DIVISION.build());
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*\\)$)", current.toString())) {
                    current.append(Symbol.MODULUS.build());
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*\\)$)", current.toString())) {
                    current.append(Symbol.MULTIPLICATION.build());
                    tvCurrent.setText(Util.displayReplace(current));
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
                        current.insert(position +1, " -");
                    } else if (Pattern.matches("", current.toString())) {
                        Pattern p = Pattern.compile("");
                        Matcher m = p.matcher(current.toString());
                        int position = m.regionStart();
                        current.delete(position + 1, position + 2);
                    }
                }
            }
        });

        //P10

        btnParL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*[\\.\\+\\—×÷%\\(]$)", current.toString())) {
                    parenthesesDepth++;
                    current.append("(");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btnParR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(.*[\\d\\)]$)", current.toString()) && parenthesesDepth > 0) {
                    parenthesesDepth--;
                    current.append(")");
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        //PE

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.matches("(^$)|(.*\\d$)|(.*\\)$)", current.toString())) {
                    current.append(Symbol.SUBTRACTION.build());
                    tvCurrent.setText(Util.displayReplace(current));
                }
            }
        });

        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current.append(Symbol.SINE.build());
                parenthesesDepth++;
                tvCurrent.setText(Util.displayReplace(current));
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                current.append(Symbol.SQUARE_ROOT.build());
                parenthesesDepth++;
                tvCurrent.setText(Util.displayReplace(current));
            }
        });
    }
}
