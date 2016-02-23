package comp5541.teamf.eternity;

public class Math {

  private static final double PI = pi_2();
  private static final double E = natural_1();

  private static double exponentiation(double base, int exponent) {
    return exponentiation_1(base, exponent);
  }

  /*
  Overloaded function to provide algorithms which are more efficient for integers and more accurate
  for real numbers.
   */
  private static double exponentiation(double base, double exponent) {
    if (exponent == ((int) exponent)) {
      return exponentiation(base, (int) exponent);
    } else {
      return exponentiation_2(base, exponent);
    }
  }

  private static long factorial(int limit) {
    return factorial_2(limit);
  }

  private static double logarithmNatural(double number) {
    return logarithmNatural_1(number);
  }

  public static double exponent10(double exponent) {
    return exponentiation(10, exponent);
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
    assert limit >= 0 : limit + " is not a natural number.";
    long result = 1;
    for (int i = 1; i <= limit; i++){
      result *= i;
    }
    return result;
  }

  // Function to calculate E; 18 iterations produced maximum accuracy for a double
  private static double natural_1() {
    double result = 1;
    for (int i = 1; i < 18; i++){
      result += (1D / (factorial(i)));
    }
    return result;
  }

  //Computes x^y when y is an integer
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

  // E method
  private static double exponent10_1(double exponent) {
    double result     = 1.0;
    int    largestNum = 999999999;
    if (exponent == 0) {
      result = 1.0;
    }
    if (exponent == 1) {
      result = 10.0;
    } else {
      for (int i = 0; i < largestNum; i++) {
        double part = exponent * logarithmNatural(10);
        result *= (1 + part / largestNum);
      }
    }
    return result;
  }

  // Taylor Series
  private static double exponentiation_2(double base, double exponent) {
    double sum          = 1;
    double elem         = 1;
    double exponentTemp = exponent;
    double log;
    int    i            = 1;
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    if (exponent < 0) {
      exponentTemp = -exponent;
    }
    log = exponentTemp * logarithmNatural(10);
    while (elem > 1e-12) {
      elem *= log / i;
      sum += elem;
      i++;
    }
    if (exponent < 0) {
      sum = 1 / sum;
    }
    return sum;
  }

  private static double logarithm10_1(double x) {
    return logarithmNatural(x) / (logarithmNatural(10));
  }

  private static double logarithmNatural_1(double x) {
    double result = 0;
    //Assumed 500 terms was a reasonable enough of an approximation
    for (int i = 0; i < 1000; i++) {
      result += (1.0 / (2 * i + 1)) * exponentiation((x - 1) / (x + 1), (2 * i + 1));
    }
    return 2 * result;
  }

  //Approximation correct to 11 decimal places using 21 terms
  private static double pi_1() {
    double term = 0;
    for (int i = 0; i < 40; i++) {
      term += (exponentiation(-1.0 / 3.0, i)) / (2 * i + 1);
    }
    return squareRoot_1(12) * term;
  }

  // PI using Leibniz Formula
  private static double pi_2() {
    int    count       = 999999999;
    double pi          = 0;
    double denominator = 1;
    for (int x = 0; x < count; x++) {
      if (x % 2 == 0) {
        pi = pi + (1 / denominator);
      } else {
        pi = pi - (1 / denominator);
      }
      denominator = denominator + 2;
    }
    pi = pi * 4;
    return pi;
  }

  //First 32 terms of the Taylor Series Expansion
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
    double num    = number;
    double result = 0;
    double sqr;
    double temp   = 0;
    if (num == 0) {
      sqr = 0;
      result = sqr;
    } else if (num < 0) {
      result = -99999999;
    } else {
      sqr = num / 2;
      do {
        temp = sqr;
        sqr = (temp + num / temp) / 2;
      } while ((temp - sqr) != 0);
      result = temp;
    }
    return result;
  }

}
