package comp5541.teamf.eternity;

/**
 * Provides mathematical functions. Abstraction provided to set only those method used by the
 * calculator app to be public; shared private methods so that algorithms requiring other
 * mathematical functions do not directly reference one another; and private method implementations
 * of the various mathematical functions, which can be replaced or overloaded, depending on context
 */
public class Math {

  // Calculated constant for PI
  private static final double PI = pi_1();
  // Calculated constant for E
  private static final double E  = natural_1();

  /**
   * Power of 10
   *
   * @param exponent Accepts all real numbers
   * @return
   */
  public static double exponent10(double exponent) {
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
    if (exponent == ((int) exponent) && exponent >= 1) {
      return exponentiation(base, (int) exponent);
    } else {
      return exponentiation_2(base, exponent);
    }
  }

  // Private method for use by functions that require factorials, such as E or sine
  private static long factorial(int limit) {
    return factorial_2(limit);
  }

  private static double logarithmNatural(double number) {
    return logarithmNatural_1(number);
  }

  public static double exponentNatural(double exponent) {
    return exponentiation(E, exponent);
  }

  public static double logarithm10(double number) {
    return logarithm10_1(number);
  }

  public static double sine(double number) {
    return sine_1(number);
  }

  public static double squareRoot(double number) {
    return squareRoot_2(number);
  }

  // Recursive factorial function
  private static long factorial_1(int limit) {
    if (limit == 0) {
      return 1;
    }
    return (limit * factorial_1(limit - 1));
  }

  // Non-recursive factorial function
  private static long factorial_2(int limit) {
    if (limit < 0) {
      throw new ArithmeticException(limit + " is not a natural number.");
    }
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
    if (exponent == 0) {
      return 1;
    }
    for (int i = 0; i < exponent; i++) {
      result *= base;
    }
    return result;
  }

  // Taylor Series; for real number exponents
  private static double exponentiation_2(double base, double exponent) {
    double result       = 1;
    double elementary   = 1;
    double intermediate = exponent;
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    if (exponent < 0) {
      intermediate = -exponent;
    }
    double log = intermediate * logarithmNatural(base);
    for (int j = 1; elementary > 1e-12; j++) {
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
    if (number < 0) {
      return Double.NaN;
    }
    if (number == 0) {
      return Double.NEGATIVE_INFINITY;
    }
    double result = 0;
    for (int i = 0; i < 70; i++) {
      result += (1.0 / (2 * i + 1)) * exponentiation((number - 1) / (number + 1), (2 * i + 1));
    }
    return 2 * result;
  }

  // Approximation correct to 11 decimal places using 21 terms
  private static double pi_1() {
    double term = 0;
    for (int i = 0; i < 40; i++) {
      term += (exponentiation(-1.0 / 3.0, i)) / (2 * i + 1);
    }
    return squareRoot_1(12) * term;
  }

  // First 32 terms of the Taylor Series Expansion
  private static double sine_1(double x) {
    double result = 0;
    double term;
    for (int i = 1; i < 65; i += 2) {
      term = exponentiation(PI / 180, i) * exponentiation(x, i) / factorial(i);
      if (i % 4 == 1) {
        result += term;
      } else {
        result -= term;
      }
    }
    return result;
  }

  private static double squareRoot_1(double x) {
    double sqr = x / 2;
    double temp;
    do {
      temp = sqr;
      sqr = (temp + x / temp) / 2;
    } while ((temp - sqr) != 0);
    return temp;
  }

  private static double squareRoot_2(double number) {
    if (number < 0) {
      return Double.NaN;
    }
    if (number == 0) {
      return 0;
    }
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
}
