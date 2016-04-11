package comp5541.teamf.eternity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

/**
 * View controller.
 *
 * This class binds the UI to an instance of the Calculator model.
 */
public class MainActivity extends AppCompatActivity {

  private Calculator calculator = new Calculator();
  /** Displays current expression. */
  private TextView textViewCurrent;
  /** Displays previous expression. */
  private TextView textViewPrevious;

  /** Resets <b>previous expression</b> display and values. */
  private void setPrevious() {
    calculator.resetPreviousExpression();
    textViewPrevious = (TextView) findViewById(R.id.tvPrevious);
    textViewPrevious.setMovementMethod(new ScrollingMovementMethod());
    setPrevious("");
  }

  /** Sets <b>previous expression</b> display and values. */
  private void setPrevious(String string) {
    textViewPrevious.setText(displayReplace(string));
    textViewPrevious.bringPointIntoView(textViewPrevious.length());
  }

  /** Resets <b>Current Expression</b> display and values */
  private void setCurrent() {
    calculator.resetCurrentExpression();
    textViewCurrent = (TextView) findViewById(R.id.tvCurrent);
    textViewCurrent.setMovementMethod(new ScrollingMovementMethod());
    setCurrent("0");
  }

  /** Sets <b>Current Expression</b> display and values */
  private void setCurrent(String string) {
    textViewCurrent.setText(displayReplace(string));
    textViewCurrent.bringPointIntoView(textViewCurrent.length());
  }

  /**
   * Find and replace tokens for display.
   *
   * @param s
   *     (String)
   *
   * @return (Spanned)
   */
  private Spanned displayReplace(String s) {
    String displayString = s;
    for (Tokens sym : Tokens.values()) {
      displayString = displayString.replaceAll(Pattern.quote(sym.build()), sym.display());
    }
    return Html.fromHtml(displayString);
  }

  /**
   * Set OnClickListeners for buttons with common attributes.
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
        setCurrent(calculator.getCurrentExpression());
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
    // TODO: Reject superficial zeros.
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

    // Point
    // TODO: Add 0 if no digits are present
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

    // TODO: Handle exponents
    // TODO: Handle negation
    ((Button) findViewById(R.id.btnBackspace)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (calculator.getCurrentExpression().length() < 1) {
          setCurrent("0");
        } else {
          calculator.backspace();
          if (calculator.getCurrentExpression().length() < 1) {
            setCurrent("0");
          } else {
            setCurrent(calculator.getCurrentExpression());
          }
        }
      }
    });

    // Clear all
    ((Button) findViewById(R.id.btnClearAll)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setPrevious();
        setCurrent();
      }
    });

    // Clear current expression
    ((Button) findViewById(R.id.btnClearExpression)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setCurrent();
      }
    });

    // TODO: Leave expression after error?
    // TODO: Negation on return; done?
    // TODO: Handle infinity and NaN
    // TODO: Friendlier error messages
    ((Button) findViewById(R.id.btnExecute)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          calculator.evaluateExpression();
          setPrevious(calculator.getPreviousExpression());
          setCurrent(calculator.getCurrentExpression());
        } catch (Exception err) {
          setPrevious();
          setCurrent();
          setPrevious(err.getMessage());
          textViewCurrent.setText(R.string.ERROR_LABEL);
          textViewCurrent.bringPointIntoView(textViewCurrent.length());
        }
      }
    });

    // Toggle negation
    // TODO: Adding negation before digits
    ((Button) findViewById(R.id.btnNegation)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        calculator.toggleNegation();
        setCurrent(calculator.getCurrentExpression());
      }
    });
  }
}