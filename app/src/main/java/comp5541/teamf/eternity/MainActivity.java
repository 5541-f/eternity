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
   * @param token
   *     Build string of the token
   * @param parentheses
   *     impact on parenthesis depth
   *
   * @return (View.OnClickListener)
   */
  private View.OnClickListener setKey(final Tokens token, final int parentheses) {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.insertToken(token, parentheses);
        setCurrent(calculator.getCurrent());
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
    ((Button) findViewById(R.id.btn0)).setOnClickListener(this.setKey(Tokens.ZERO, 0));
    ((Button) findViewById(R.id.btn1)).setOnClickListener(this.setKey(Tokens.ONE, 0));
    ((Button) findViewById(R.id.btn2)).setOnClickListener(this.setKey(Tokens.TWO, 0));
    ((Button) findViewById(R.id.btn3)).setOnClickListener(this.setKey(Tokens.THREE, 0));
    ((Button) findViewById(R.id.btn4)).setOnClickListener(this.setKey(Tokens.FOUR, 0));
    ((Button) findViewById(R.id.btn5)).setOnClickListener(this.setKey(Tokens.FIVE, 0));
    ((Button) findViewById(R.id.btn6)).setOnClickListener(this.setKey(Tokens.SIX, 0));
    ((Button) findViewById(R.id.btn7)).setOnClickListener(this.setKey(Tokens.SEVEN, 0));
    ((Button) findViewById(R.id.btn8)).setOnClickListener(this.setKey(Tokens.EIGHT, 0));
    ((Button) findViewById(R.id.btn9)).setOnClickListener(this.setKey(Tokens.NINE, 0));

    ((Button) findViewById(R.id.btnPoint)).setOnClickListener(this.setKey(Tokens.POINT, 0));

    // Operators
    ((Button) findViewById(R.id.btnAddition))
        .setOnClickListener(this.setKey(Tokens.ADDITION, 0));
    ((Button) findViewById(R.id.btnDivision))
        .setOnClickListener(this.setKey(Tokens.DIVISION, 0));
    ((Button) findViewById(R.id.btnModulo))
        .setOnClickListener(this.setKey(Tokens.MODULO, 0));
    ((Button) findViewById(R.id.btnMultiplication))
        .setOnClickListener(this.setKey(Tokens.MULTIPLICATION, 0));
    ((Button) findViewById(R.id.btnSubtraction))
        .setOnClickListener(this.setKey(Tokens.SUBTRACTION, 0));

    // Functions
    ((Button) findViewById(R.id.btnExponent10)).setOnClickListener(
        this.setKey(Tokens.EXPONENT_10, 1));
    ((Button) findViewById(R.id.btnExponentNatural)).setOnClickListener(
        this.setKey(Tokens.EXPONENT_NATURAL, 1));
    ((Button) findViewById(R.id.btnLogarithm10)).setOnClickListener(
        this.setKey(Tokens.LOGARITHM_10, 1));
    ((Button) findViewById(R.id.btnParenthesisLeft)).setOnClickListener(
        this.setKey(Tokens.PARENTHESIS_LEFT, 1));
    ((Button) findViewById(R.id.btnSine)).setOnClickListener(
        this.setKey(Tokens.SINE, 1));
    ((Button) findViewById(R.id.btnSquareRoot)).setOnClickListener(
        this.setKey(Tokens.SQUARE_ROOT, 1));

    ((Button) findViewById(R.id.btnParenthesisRight)).setOnClickListener(
        this.setKey(Tokens.PARENTHESIS_RIGHT, -1));

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
  }
}