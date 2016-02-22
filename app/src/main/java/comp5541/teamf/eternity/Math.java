package comp5541.teamf.eternity;

public class Math {

  private final double PI = pi_2(); //fix
  private final double E = natural_1(); //fix

  private double exponentiation(double base, double exponent) {

    return 0; //fix
  }

  private long factorial(int limit) {

    return 0; //fix
  }

  private double logarithmNatural(double exponent) {

    return 0; //fix
  }

  public static double exponent10(double exponent) {

    return 0; //fix
  }

  public static double exponentNatural(double exponent) {

    return 0; //fix
  }

  public static double logrithm10(double exponent) {

    return 0; //fix
  }

  public static double sine(double exponent) {

    return 0; //fix
  }

  public static double squareRoot(double exponent) {

    return 0; //fix
  }

  private long factorial_1(int limit) { //Recursive function to compute the factorial of x
    if (limit == 0) {
      return 1;
    }
    return (limit * factorial_1(limit - 1));
  }

  private long factorial_2(int limit) {
    assert limit >= 0 : limit + " is not a natural number.";
    long result = 1;
    for (int i = 1; i <= limit; i++){
      result *= i;
    }
    return result;
  }

  private double natural_1() {
    double result = 1;
    for (int i = 1; i < 18; i++){
      result += (1D / (factorial(i)));
    }
    return result;
  }

  private double exponentiation_1(double base, int exponent) { //Computes x^y when y is an integer
    double result = 1;
    if (exponent == 0) {
      return 1;
    }
    for (int i = 0; i < exponent; i++) {
      result *= base;
    }
    return result;
  }

  private double exponent10_1(double exponent) {
    double result     = 1.0;
    int    largestNum = 999999999;
    if (exponent == 0) {
      result = 1.0;
    }
    if (exponent == 1) {
      result = 10.0;
    } else {
      for (int i = 0; i < largestNum; i++) {
        double part = exponent * logrithm10(10);
        result *= (1 + part / largestNum);
      }
    }
    return result;
  }

  private double exponent10_2(double exponent) {
    double sum          = 1;
    double elem         = 1;
    double exponentTemp = exponent;
    double numLn10;
    int    i            = 1;
    if (exponent == 0) {
      return 1.0;
    }
    if (exponent == 1) {
      return 10.0;
    }
    if (exponent < 0) {
      exponentTemp = -exponent;
    }
    numLn10 = exponentTemp * logrithm10(10);
    while (elem > 1e-12) {
      elem *= numLn10 / i;
      sum += elem;
      i++;
    }
    if (exponent < 0) {
      sum = 1 / sum;
    }
    return sum;
  }

  private double logrithm10_1(double x) {
    return logarithmNatural(x) / (logarithmNatural(10));
  }

  private double logarithmNatural_1(double x) {
    double result = 0;
    //Assumed 500 terms was a reasonable enough of an approximation
    for (int i = 0; i < 1000; i++) {
      result += (1.0 / (2 * i + 1)) * exponentiation((x - 1) / (x + 1), (2 * i + 1));
    }
    return 2 * result;
  }

  //Approximation correct to 11 decimal places using 21 terms
  private double pi_1() {
    double term = 0;
    for (int i = 0; i < 40; i++) {
      term += (exponentiation(-1.0 / 3.0, i)) / (2 * i + 1);
    }
    return squareRoot_1(12) * term;
  }

//  Math.PI: 3.141592653589793
//  Math.pi_1(): 3.141592653589794
//  Runtime in milliseconds: 4
//  Math.PI: 3.141592653589793
//  Math.pi_2(): 3.1415926545880506
//  Runtime in milliseconds: 18546
  private double pi_2() {
    //LeibnizFormula
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

  private double sin_1(double x) {
    double result = 0;
    double term;
    for (int i = 1; i < 65; i += 2) { //First 32 terms of the Taylor Series Expansion
      term = exponentiation(pi_1() / 180, i) * exponentiation(x, i) / factorial(i); //
      if (i % 4 == 1) {
        result += term;
      } else {
        result -= term;
      }
    }
    return result;
  }

  private double squareRoot_1(double x) {
    double sqr = x / 2;
    double temp;
    do {
      temp = sqr;
      sqr = (temp + x / temp) / 2;
    } while ((temp - sqr) != 0);
    return temp;
  }

  private double squareRoot_2(double number) {
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
