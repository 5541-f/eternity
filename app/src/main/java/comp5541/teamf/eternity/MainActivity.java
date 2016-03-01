package comp5541.teamf.eternity;

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

  /**
   * Sets/resets <b>Previous Expression</b> display and values
   */
  private void setPrevious() {
    previous = new StringBuilder("0");
    tvPrevious = (TextView) findViewById(R.id.tvPrevious);
    tvPrevious.setText("");
    tvPrevious.setMovementMethod(new ScrollingMovementMethod());
  }

  /**
   * Sets/resets <b>Current Expression</b> display and values
   */
  private void setCurrent() {
    current = new StringBuilder();
    tvCurrent = (TextView) findViewById(R.id.tvCurrent);
    tvCurrent.setText("0");
    tvCurrent.setMovementMethod(new ScrollingMovementMethod());
    parenthesesDepth = 0;
  }

  /**
   * Increments or decrements <b>parenthesis depth</b> by 1. For use with <b>setKey</b> method.
   * @param flag <b>1</b> to increment by 1; <b>-1</b> to decrement by 1; default has no impact.
   */
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

  /**
   * A method for setting OnClickListeners for buttons with common attributes
   *
   * @param validation  Regex that precedes this character
   * @param character   Build character of the token
   * @param parentheses impact on parenthesis depth
   * @return (View.OnClickListener)
   */
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

    // Digits
    // TODO:redundant 0s
    ((Button) findViewById(R.id.btn0)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "0", 0));
    ((Button) findViewById(R.id.btn1)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "1", 0));
    ((Button) findViewById(R.id.btn2)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "2", 0));
    ((Button) findViewById(R.id.btn3)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "3", 0));
    ((Button) findViewById(R.id.btn4)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "4", 0));
    ((Button) findViewById(R.id.btn5)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "5", 0));
    ((Button) findViewById(R.id.btn6)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "6", 0));
    ((Button) findViewById(R.id.btn7)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "7", 0));
    ((Button) findViewById(R.id.btn8)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "8", 0));
    ((Button) findViewById(R.id.btn9)).setOnClickListener(
        this.setKey(Util.DIGIT_VALIDATION, "9", 0));

    // Operators
    ((Button) findViewById(R.id.btnAddition)).setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.ADDITION.build(), 0));
    ((Button) findViewById(R.id.btnDivision)).setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.DIVISION.build(), 0));
    ((Button) findViewById(R.id.btnModulo)).setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.MODULO.build(), 0));
    ((Button) findViewById(R.id.btnMultiplication)).setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.MULTIPLICATION.build(), 0));
    ((Button) findViewById(R.id.btnSubtraction)).setOnClickListener(
        this.setKey(Util.OPERATOR_VALIDATION, Tokens.SUBTRACTION.build(), 0));

    // Functions
    ((Button) findViewById(R.id.btnExponent10)).setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.EXPONENT_10.build(), 1));
    ((Button) findViewById(R.id.btnExponentNatural)).setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.EXPONENT_NATURAL.build(), 1));
    ((Button) findViewById(R.id.btnLogarithm10)).setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.LOGARITHM_10.build(), 1));
    ((Button) findViewById(R.id.btnParenthesisLeft)).setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, "(", 1));
    ((Button) findViewById(R.id.btnSine)).setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.SINE.build(), 1));
    ((Button) findViewById(R.id.btnSquareRoot)).setOnClickListener(
        this.setKey(Util.FUNCTION_VALIDATION, Tokens.SQUARE_ROOT.build(), 1));

    //what to do about 0/empty
    ((Button) findViewById(R.id.btnBackspace))
        .setOnClickListener(new View.OnClickListener() {
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
          if (current.length() > 0
              && current.charAt(current.length() - 1) == Tokens.NEGATION.build().charAt(0)) {
            current.deleteCharAt(current.length() - 1);
          }
          if (current.length() < 1) {
            tvCurrent.setText("0");
          } else {
            tvCurrent.setText(Util.displayReplace(current));
          }
        }
      }
    });

    ((Button) findViewById(R.id.btnClearAll))
        .setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setPrevious();
        setCurrent();
      }
    });

    ((Button) findViewById(R.id.btnClearExpression))
        .setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setCurrent();
      }
    });

    // TODO: Also cast to int if % 0 == 0; done?
    // TODO: move scroll on type??
    // TODO: leave expression after error?
    // TODO: negation on return???; done?
    // TODO: infinity/NaN?
    ((Button) findViewById(R.id.btnExecute))
        .setOnClickListener(new View.OnClickListener() {
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
        if (Pattern.matches("[\\." + Util.OPERATOR_REGEX + "]",
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
          if (result == result.intValue()) {
            current = new StringBuilder(((Integer) result.intValue()).toString().replace('-', '±'));
          } else {
            current = new StringBuilder(result.toString().replace('-', '±'));
          }
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

    ((Button) findViewById(R.id.btnNegation))
        .setOnClickListener(new View.OnClickListener() {
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

    ((Button) findViewById(R.id.btnParenthesisRight))
        .setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (Pattern.matches("(.*[\\d\\)]$)", current.toString()) && parenthesesDepth > 0) {
          parenthesesDepth--;
          current.append(")");
          tvCurrent.setText(Util.displayReplace(current));
        }
      }
    });

    ((Button) findViewById(R.id.btnPoint))
        .setOnClickListener(this.setKey(".*(?<![\\.\\d])\\d+$", ".", 0));
  }
}
