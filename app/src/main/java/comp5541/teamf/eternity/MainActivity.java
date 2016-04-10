package comp5541.teamf.eternity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

  private Calculator calculator = new Calculator();

  private TextView tvCurrent;
  private TextView tvPrevious;

  /**
   * Sets/resets <b>Previous Expression</b> display and values
   */
  private void setPrevious() {
    calculator.resetPrevious();
    tvPrevious = (TextView) findViewById(R.id.tvPrevious);
    tvPrevious.setMovementMethod(new ScrollingMovementMethod());
    setPrevious("");
  }

  private void setPrevious(String string) {
    tvPrevious.setText(Util.displayReplace(string));
    tvPrevious.bringPointIntoView(tvPrevious.length());
  }

  /**
   * Sets/resets <b>Current Expression</b> display and values
   */
  private void setCurrent() {
    calculator.resetCurrent();
    tvCurrent = (TextView) findViewById(R.id.tvCurrent);
    tvCurrent.setMovementMethod(new ScrollingMovementMethod());
    setCurrent("0");
  }

  private void setCurrent(String string) {
    tvCurrent.setText(Util.displayReplace(string));
    tvCurrent.bringPointIntoView(tvCurrent.length());
  }

  /**
   * A method for setting OnClickListeners for buttons with common attributes
   *
   * @param validation
   *     Regex that precedes this character
   * @param character
   *     Build character of the token
   * @param parentheses
   *     impact on parenthesis depth
   *
   * @return (View.OnClickListener)
   */
  private View.OnClickListener setKey(final String validation,
                                      final String character,
                                      final int parentheses) {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (Pattern.matches(validation, calculator.getCurrent())) {
          calculator.pressKey(validation, character, parentheses);
          setCurrent(calculator.getCurrent());
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

    ((Button) findViewById(R.id.btnPoint))
        .setOnClickListener(this.setKey(".*(?<![\\.\\d])\\d+$", ".", 0));

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
    ((Button) findViewById(R.id.btnBackspace)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (calculator.getCurrent().length() < 1) {
          setCurrent("0");
        } else {
          calculator.backspace();
          if (calculator.getCurrent().length() < 1) {
            setCurrent("0");
          } else {
            setCurrent(calculator.getCurrent());
          }
        }
      }
    });

    ((Button) findViewById(R.id.btnClearAll)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setPrevious();
        setCurrent();
      }
    });

    ((Button) findViewById(R.id.btnClearExpression)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setCurrent();
      }
    });

    // TODO: leave expression after error?
    // TODO: negation on return???; done?
    // TODO: infinity/NaN?
    ((Button) findViewById(R.id.btnExecute)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          calculator.evaluateExpression();
          setPrevious(calculator.getPrevious());
          setCurrent(calculator.getCurrent());
        } catch (Exception err) {
          setPrevious();
          setCurrent();
          setPrevious(err.getMessage());
          tvCurrent.setText(R.string.ERROR_LABEL);
          tvCurrent.bringPointIntoView(tvCurrent.length());
        }
      }
    });

    ((Button) findViewById(R.id.btnNegation)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.toggleNegation();
        setCurrent(calculator.getCurrent());
      }
    });

    ((Button) findViewById(R.id.btnParenthesisRight)).setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            calculator.pressParenthesisRight();
            setCurrent(calculator.getCurrent());
          }
        });
  }
}