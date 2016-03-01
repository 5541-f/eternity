package comp5541.teamf.eternity;

/**
 * Provides mathematical functions. Abstraction provided to set only those method used by the
 * calculator app to be public; shared private methods so that algorithms requiring other
 * mathematical functions do not directly reference one another; and private method implementations
 * of the various mathematical functions, which can be replaced or overloaded, depending on context.
 */
public class Math {

  /**
   * Calculated constant for <b>PI</b>.
   */
  static final double PI = piAlgorithmA();
  /**
   * Calculated constant for <b><i>E</i></b>.
   */
  static final double E  = naturalAlgorithmA();

  /**
   * Public method for <b>Power of 10</b>.
   *
   * @param exponent (double)
   * @return result (double)
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

  /**
   * Public method for Exponential Function
   *
   * @param exponent (double)
   * @return result (double)
   */
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
    if (number < 0) {
      return Double.NaN;
    }
    if (number == 0) {
      return Double.NEGATIVE_INFINITY;
    }
    if (number == 1) {
      return 0;
    }
//    double isTable10 = logTable10(number);
//    if (isTable10 != Double.NaN) {
//      return isTable10;
//    }
    return logarithm10AlgorithmA(number);
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
    return sineAlgorthmA(number);
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
    return squareRootAlgorthmA(number);
  }

  /**
   * Overloaded private exponentiation method for use with integer exponents
   *
   * @param base     (double)
   * @param exponent (int)
   * @return result (double)
   */
  private static double exponentiation(double base, int exponent) {
    return exponentiationAlgoritmA(base, exponent);
  }

  /**
   * Overloaded private exponentiation method to provide algorithms which are more accurate for
   * integers and more accurate for real numbers. Checks if (int) value of exponent is equal to
   * (double) value and selects appropriate method.
   * @param base (double)
   * @param exponent (double)
   * @return double
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
      return exponentiationAlgorithmB(base, exponent);
    }
  }

  /**
   * Private method for use by functions or calculated constants that require factorials, such as
   * sine or E.
   * @param limit (int)
   * @return (long)
   */
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
    return factorialAlgorithmA(limit);
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
    if (number == 1) {
      return 0;
    }
    return logarithmNaturalAlgorthmA(number);
  }

  // Non-recursive factorial function
  private static long factorialAlgorithmA(int limit) {
    long result = 1;
    for (int i = 1; i <= limit; i++) {
      result *= i;
    }
    return result;
  }

  // Function to calculate E; 18 iterations produced maximum accuracy for a double
  private static double naturalAlgorithmA() {
    double result = 1;
    for (int i = 1; i < 18; i++) {
      result += (1D / (factorial(i)));
    }
    return result;
  }

  // Computes x^y when y is an integer
  private static double exponentiationAlgoritmA(double base, int exponent) {
    double result = 1;
    double temp   = exponent;
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
  private static double exponentiationAlgorithmB(double base, double exponent) {
    double result     = 1;
    Double elementary = 1.0;
    double temp       = exponent;
    if (exponent < 0) {
      temp = -exponent;
    }
    double log = temp * logarithmNatural(base);
    for (int j = 1; elementary > 0; j++) {
      elementary *= log / j;
      if (elementary.isInfinite() && exponent < 0) {
        return 0;
      }
      if (elementary.isInfinite() && exponent > 0) {
        return Double.POSITIVE_INFINITY;
      }
      result += elementary;
    }
    if (exponent < 0) {
      result = 1 / result;
    }
    return result;
  }

  private static double logarithm10AlgorithmA(double number) {
    return logarithmNatural(number) / (logarithmNatural(10));
  }

//  private static double logTable10(double number) {
//    int result = -323;
//    double temp = 1e-323;
//    while (temp < 1e308) {
//      if (number == temp) {
//        return result;
//      } else {
//        temp *= 10;
//        result++;
//      }
//    }
//    return Double.NaN;
//  }

  // Assumed 500 terms was a reasonable enough of an approximation
  private static double logarithmNaturalAlgorthmA(double number) {
    double temp   = 0;
    double result = 0;
    for (int i = 0; i < 500; i++) {
      temp = (1.0 / (2 * i + 1)) * exponentiation((number - 1) / (number + 1), (2 * i + 1));
      result += temp;
    }
    return 2 * result;
  }

  // Function to calculate PI; 30 iterations produced maximum accuracy for a double
  private static double piAlgorithmA() {
    double term = 0;
    for (int i = 0; i < 30; i++) {
      term += (exponentiation(-1.0 / 3.0, i)) / (2 * i + 1);
    }
    return squareRoot(12) * term;
  }

  // First 10 terms of the Taylor Series Expansion
  private static double sineAlgorthmA(double number) {
    //algorithm not accurate with high negative values. Convert back to negative at the end if needed
    double temp = (number < 0) ?
        -number % 360 : number % 360; // can only take angles between [0,180]
    if (temp == 180 || temp == 0) {
      return 0;
    }
    double result = 0;
    if (temp > 180) {
      temp = temp - 360; // Get the negative equivalent of the angle
    }
    Double term;
    for (int i = 1; i < 20; i += 2) { // Taylor Series Terms
      term = exponentiation(PI / 180, i) * exponentiation(temp, i) / factorial(i);
      if (!term.isInfinite() && !term.isNaN()) {
        result += (i % 4 == 1) ? term : -term;
      }
    }
    return (number < 0) ? -result : result;
  }

  //TODO
  private static double squareRootAlgorthmA(double number) {
    double result;
    double temp;
    double sqr = number / 2;
    do {
      temp = sqr;
      sqr = (temp + number / temp) / 2;
    } while ((temp - sqr) != 0);
    result = temp;
    return result;
  }
}
