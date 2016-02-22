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


  private StringBuilder current;
  private StringBuilder previous;

  private TextView tvCurrent;
  private TextView tvPrevious;

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

  //displaydepth somewhere?
  private void setParenthesesDepth(int flag) {
    switch (flag) {
      case 1:
        parenthesesDepth++;
        break;
      case -1:
        parenthesesDepth--;
        break;
      default:
    }
  }

  private View.OnClickListener setKey(final String validation,
                                      final String character,
                                      final int parentheses) {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (Pattern.matches(validation, current.toString())) {
          setParenthesesDepth(parentheses);
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

    Button btn0                = (Button) findViewById(R.id.btn0);
    Button btn1                = (Button) findViewById(R.id.btn1);
    Button btn2                = (Button) findViewById(R.id.btn2);
    Button btn3                = (Button) findViewById(R.id.btn3);
    Button btn4                = (Button) findViewById(R.id.btn4);
    Button btn5                = (Button) findViewById(R.id.btn5);
    Button btn6                = (Button) findViewById(R.id.btn6);
    Button btn7                = (Button) findViewById(R.id.btn7);
    Button btn8                = (Button) findViewById(R.id.btn8);
    Button btn9                = (Button) findViewById(R.id.btn9);
    Button btnAddition         = (Button) findViewById(R.id.btnAddition);
    Button btnBackspace        = (Button) findViewById(R.id.btnBackspace);
    Button btnClearAll         = (Button) findViewById(R.id.btnClearAll);
    Button btnClearExpression  = (Button) findViewById(R.id.btnClearExpression);
    Button btnDivision         = (Button) findViewById(R.id.btnDivision);
    Button btnPoint            = (Button) findViewById(R.id.btnPoint);
    Button btnExecute          = (Button) findViewById(R.id.btnExecute);
    Button btnExponent10       = (Button) findViewById(R.id.btnExponent10);
    Button btnExponentNatural  = (Button) findViewById(R.id.btnExponentNatural);
    Button btnLogarithm10      = (Button) findViewById(R.id.btnLogarithm10);
    Button btnModulo           = (Button) findViewById(R.id.btnModulo);
    Button btnMultiplication   = (Button) findViewById(R.id.btnMultiplication);
    Button btnNegation         = (Button) findViewById(R.id.btnNegation);
    Button btnParenthesisLeft  = (Button) findViewById(R.id.btnParenthesisLeft);
    Button btnParenthesisRight = (Button) findViewById(R.id.btnParenthesisRight);
    Button btnSine             = (Button) findViewById(R.id.btnSine);
    Button btnSquareRoot       = (Button) findViewById(R.id.btnSquareRoot);
    Button btnSubtraction      = (Button) findViewById(R.id.btnSubtraction);

    // redundant 0s
    btn0.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "0", 0));
    btn1.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "1", 0));
    btn2.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "2", 0));
    btn3.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "3", 0));
    btn4.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "4", 0));
    btn5.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "5", 0));
    btn6.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "6", 0));
    btn7.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "7", 0));
    btn8.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "8", 0));
    btn9.setOnClickListener(this.setKey(Util.DIGIT_VALIDATION, "9", 0));

    btnAddition.setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.ADDITION.build(), 0));
    btnDivision.setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.DIVISION.build(), 0));
    btnModulo.setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.MODULO.build(), 0));
    btnMultiplication.setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.MULTIPLICATION.build(), 0));
    btnSubtraction.setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.SUBTRACTION.build(), 0));

    btnExponent10.setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.EXPONENT_10.build(), 1));
    btnExponentNatural.setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.EXPONENT_NATURAL.build(), 1));
    btnLogarithm10.setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.LOGARITHM_10.build(), 1));
    btnParenthesisLeft.setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, "(", 1));
    btnSine.setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.SINE.build(), 1));
    btnSquareRoot.setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.SQUARE_ROOT.build(), 1));

    //what to do about 0/empty
    //erasing negation
    btnBackspace.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (current.length() < 1) {
          tvCurrent.setText("0");
        } else {
          if (Pattern.matches(".*[\\)]", current.toString())) {
            parenthesesDepth++;
          }
          if (Pattern.matches(".*[\\(" + Util.FUNCTION_REGEX + "]$", current.toString())) {
            parenthesesDepth--;
          }
          current.deleteCharAt(current.length() - 1);
          if (current.length() > 0 &&
              current.charAt(current.length() - 1) == Tokens.NEGATION.build().charAt(0)) {
            if (current.length() < 1) {
              tvCurrent.setText("0");
            } else {
              tvCurrent.setText(Util.displayReplace(current));
            }
          }
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
    // negation on return???
    // infinity
    btnExecute.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (current.length() == 0) {
          current.append("0");
        }
        if (Pattern.matches("[\\(]",
            ((Character) current.charAt(current.length() - 1)).toString())) {
          parenthesesDepth--;
          current.deleteCharAt(current.length() - 1);
          if (current.length() == 0) {
            current.append("0");
          }
        }
        if (Pattern.matches("[\\.]" + Util.OPERATOR_REGEX,
            ((Character) current.charAt(current.length() - 1)).toString())) {
          current.deleteCharAt(current.length() - 1);
          if (current.length() == 0) {
            current.append("0");
          }
        }
        for (int i = 0; i < parenthesesDepth; parenthesesDepth--) {
          current.append(")");
        }
        if (Pattern.matches(Util.OPERATOR_REGEX, ((Character) current.charAt(0)).toString())) {
          if (previous.length() == 0) {
            previous.append("0");
          }
          previous.append(current);
        } else {
          previous = new StringBuilder(current);
        }
        try {
          Expression e = new ExpressionBuilder(Util.executeReplace(previous))
              .functions(Util.FUNCTIONS).build();
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

    btnNegation.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (Pattern.matches("(.*?)(\\d+[\\.]?\\d*$)", current.toString())) {
          if (Pattern.matches("(.*?)(±\\d+[\\.]?\\d*$)", current.toString())) {
            Pattern p = Pattern.compile("(.*?)(±\\d+[\\.]?\\d*$)");
            Matcher m = p.matcher(current.toString());
            m.find();
            int position = m.start(2);
            current.deleteCharAt(position);
          } else {
            Pattern p = Pattern.compile("(.*?)(\\d+[\\.]?\\d*$)");
            Matcher m = p.matcher(current.toString());
            m.find();
            int position = m.start(2);
            current.insert(position, Tokens.NEGATION.build());
          }
          tvCurrent.setText(Util.displayReplace(current));
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

    btnPoint.setOnClickListener(this.setKey(".*(?<![\\.\\d])\\d+$", ".", 0));
  }
}
