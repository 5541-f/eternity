package comp5541.teamf.eternity;

/**
 * Provides mathematical functions. Abstraction provided to set only those method used by the
 * calculator app to be public; shared private methods so that algorithms requiring other
 * mathematical functions do not directly reference one another; and private method implementations
 * of the various mathematical functions, which can be replaced or overloaded, depending on context
 */
public class Math {

  // Calculated constant for PI
  public static final double PI = pi_1();
  // Calculated constant for E
  public static final double E  = natural_1();

  /**
   * Power of 10
   *
   * @param exponent Accepts all real numbers
   * @return
   */
  public static double exponent10(double exponent) {
    if (((Double) exponent).isNaN()) {
      return Double.NaN;
    }
    if (exponent == Double.NEGATIVE_INFINITY) {
      return 0;
    }
    if (exponent == Double.POSITIVE_INFINITY) {
      return Double.POSITIVE_INFINITY;
    }
    if (exponent == 0) {
      return 1;
    }
    return exponentiation(10, exponent);
  }

  // Overloaded exponentiation method for use with int exponents
  private static double exponentiation(double base, int exponent) {
    return exponentiation_1(base, exponent);
  }

  /*
  Overloaded method to provide algorithms which are more efficient for integers and more accurate
  for real numbers.
   */
  private static double exponentiation(double base, double exponent) {
    if (((Double) exponent).isNaN()) {
      return Double.NaN;
    }
    if (exponent == Double.NEGATIVE_INFINITY) {
      return 0;
    }
    if (exponent == Double.POSITIVE_INFINITY) {
      return Double.POSITIVE_INFINITY;
    }
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    if (exponent == ((int) exponent)) {
      return exponentiation(base, (int) exponent);
    } else {
      return exponentiation_2(base, exponent);
    }
  }

  public static double exponentNatural(double exponent) {
    if (((Double) exponent).isNaN()) {
      return Double.NaN;
    }
    if (exponent == Double.NEGATIVE_INFINITY) {
      return 0;
    }
    if (exponent == Double.POSITIVE_INFINITY) {
      return Double.POSITIVE_INFINITY;
    }
    if (exponent == 0) {
      return 1;
    }
    return exponentiation(E, exponent);
  }

  // Private method for use by functions that require factorials, such as E or sine
  private static long factorial(int limit) {
    if (limit < 0) {
      throw new ArithmeticException(limit + " is not a natural number.");
    }
    if (limit == 0) {
      return 1;
    }
    if (limit == 1) {
      return 1;
    }
    return factorial_1(limit);
  }

  private static double logarithmNatural(double number) {
    if (((Double) number).isNaN()) {
      return Double.NaN;
    }
    if (number == Double.NEGATIVE_INFINITY) {
      return Double.NaN;
    }
    if (number == Double.POSITIVE_INFINITY) {
      return Double.POSITIVE_INFINITY;
    }
    if (number < 0) {
      return Double.NaN;
    }
    if (number == 0) {
      return Double.NEGATIVE_INFINITY;
    }
    return logarithmNatural_1(number);
  }

  public static double logarithm10(double number) {
    if (((Double) number).isNaN()) {
      return Double.NaN;
    }
    if (number == Double.NEGATIVE_INFINITY) {
      return Double.NaN;
    }
    if (number == Double.POSITIVE_INFINITY) {
      return Double.POSITIVE_INFINITY;
    }
    return logarithm10_1(number);
  }

  public static double sine(double number) {
    if (((Double) number).isNaN()) {
      return Double.NaN;
    }
    if (number == Double.NEGATIVE_INFINITY) {
      return Double.NaN;
    }
    if (number == Double.POSITIVE_INFINITY) {
      return Double.NaN;
    }
    if (number == 0) {
      return 0;
    }
    return sine_1(number);
  }

  public static double squareRoot(double number) {
    if (((Double) number).isNaN()) {
      return Double.NaN;
    }
    if (number == Double.NEGATIVE_INFINITY) {
      return Double.NaN;
    }
    if (number == Double.POSITIVE_INFINITY) {
      return Double.POSITIVE_INFINITY;
    }
    if (number < 0) {
      return Double.NaN;
    }
    if (number == 0) {
      return 0;
    }
    return squareRoot_1(number);
  }

  // Non-recursive factorial function
  private static long factorial_1(int limit) {
    long result = 1;
    for (int i = 1; i <= limit; i++) {
      result *= i;
    }
    return result;
  }

  // Function to calculate E; 18 iterations produced maximum accuracy for a double
  private static double natural_1() {
    double result = 1;
    for (int i = 1; i < 18; i++) {
      result += (1D / (factorial(i)));
    }
    return result;
  }

  // Computes x^y when y is an integer
  private static double exponentiation_1(double base, int exponent) {
    double result = 1;
    double temp = exponent;
    if (exponent < 0) {
      temp = -exponent;
    }
    for (int i = 0; i < temp; i++) {
      result *= base;
    }
    if (exponent < 0) {
      result = 1 / result;
    }
    return result;
  }

  // Taylor Series; for real number exponents
  private static double exponentiation_2(double base, double exponent) {
    double result       = 1;
    double elementary   = 1;
    double temp = exponent;
    if (exponent < 0) {
      temp = -exponent;
    }
    double log = temp * logarithmNatural(base);
    for (int j = 1; elementary > 0; j++) {
      elementary *= log / j;
      result += elementary;
    }
    if (exponent < 0) {
      result = 1 / result;
    }
    return result;
  }

  private static double logarithm10_1(double number) {
    return logarithmNatural(number) / (logarithmNatural(10));
  }

  // Assumed 500 terms was a reasonable enough of an approximation
  private static double logarithmNatural_1(double number) {
    double temp = 0;
    double result = 0;
    for (int i = 0; i < 500; i++) {
      temp = (1.0 / (2 * i + 1)) * exponentiation((number - 1) / (number + 1), (2 * i + 1));
      result += temp;
    }
    return 2 * result;
  }

  // Function to calculate PI; 30 iterations produced maximum accuracy for a double
  private static double pi_1() {
    double term = 0;
    for (int i = 0; i < 30; i++) {
      term += (exponentiation(-1.0 / 3.0, i)) / (2 * i + 1);
    }
    return squareRoot(12) * term;
  }

  // First 10 terms of the Taylor Series Expansion
  private static double sine_1(double number) {

    //algorithm not accurate with high negative values. Convert back to negative at the end if needed
    boolean isNegative = false;
    if(number<0) {
      isNegative = true;
      number = number*-1;
    }
    double result = 0;

    number = number%360; // Algorithm can only take angles between [0,180[
    if(number == 180)
      return 0;
    if(number>180){
      number = number-360; //Get the negative equivalent of the angle
    }
    Double term;

    //Taylor Series Terms
    for (int i = 1; i < 20; i += 2) {
      term = exponentiation(PI / 180, i) * exponentiation(number, i) / factorial(i);
      if (!term.isInfinite() && !term.isNaN()) {
        if (i % 4 == 1) {
          result += term;
        } else {
          result -= term;
        }
      }
    }
    if(isNegative == true)
      return result*-1;
    return result ;
  }

  private static double squareRoot_1(double number) {
    double result = 0;
    double temp   = 0;
    double sqr = number / 2;
    do {
      temp = sqr;
      sqr = (temp + number / temp) / 2;
    } while ((temp - sqr) != 0);
    result = temp;
    return result;
  }

  public static void main(String[] args){
    System.out.println(sine_1(-1000));
  }

}
