package comp5541.team_f.eternity;

public class Functions {

  static long factorial(int limit) { //Recursive function to compute the factorial of x
    if (limit == 0) {
      return 1;
    }
    return (limit * factorial(limit - 1));
  }

  static double exponentiation(double base, int exponent) { //Computes x^y when y is an integer
    double result = 1;
    if (exponent == 0) {
      return 1;
    }
    for (int i = 0; i < exponent; i++) {
      result *= base;
    }
    return result;
  }

  static double logrithm10(double x) {
    return logarithmNatural(x) / (logarithmNatural(10));
  }

  static double logarithmNatural(double x) {
    double result = 0;
    //Assumed 500 terms was a reasonable enough of an approximation
    for (int i = 0; i < 1000; i++) {
      result += (1.0 / (2 * i + 1)) * exponentiation((x - 1) / (x + 1), (2 * i + 1));
    }
    return 2 * result;
  }

  //Approximation correct to 11 decimal places using 21 terms
  static double pi() {
    double term = 0;
    for (int i = 0; i < 40; i++) {
      term += (exponentiation(-1.0 / 3.0, i)) / (2 * i + 1);
    }
    return squareRoot(12) * term;
  }


  static double sin(double x) {
    double result = 0;
    double term;

    for (int i = 1; i < 65; i += 2) { //First 32 terms of the Taylor Series Expansion
      term = exponentiation(pi() / 180, i) * exponentiation(x, i) / factorial(i); //
      if (i % 4 == 1) {
        result += term;
      } else {
        result -= term;
      }
    }
    return result;
  }

  static double squareRoot(double x) {
    double sqr = x / 2;
    double temp;

    do {
      temp = sqr;
      sqr = (temp + x / temp) / 2;
    } while ((temp - sqr) != 0);
    double result = temp;
    return result;
  }

  //////////////////////////////////////OTHER FUNCTIONS///////////////////////////////////////////////
  public static double findSqr(double number) {
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

  public static double piCal1(String[] args) {

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

  public class powCaculatorE {

    public static void main(String[] args) {


      System.out.println("please type one number to calculater the power of " + "10^");
      Scanner input = new Scanner(System.in);
      double  num   = input.nextDouble();
      input.close();

      double result = power10(num);
      System.out.println("10^ " + num + " = " + result);

      System.out.println("Calculating (10^PI and 10^-PI) ....");
      double resultPi = power10(pinum());
      System.out.println("By using Pi to test " + "10^PI = " + resultPi);
      System.out.println("By using Pi to test " + "10^-PI = " + 1 / resultPi);
    }


    public static double power10(double exponent) {
      double result     = 1.0;
      int    largestNum = 999999999;


      if (exponent == 0) {
        result = 1.0;
      }
      if (exponent == 1) {
        result = 10.0;
      } else {

        for (int i = 0; i < largestNum; i++) {
          // here using Math.log() method temporarily
          // considering Dana code log() function
          // finally will call Dana's log()
          double part = exponent * Math.log(10);
          result *= (1 + part / largestNum);
        }
      }
      return result;
    }

    public static double pinum() {
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

  }

  public class powCaculatorTaylor {

    public static void main(String[] args) {


      System.out.println("please type one number to calculater the power of " + "10^");
      Scanner input = new Scanner(System.in);
      double  num   = input.nextDouble();
      input.close();

      double result = power10(num);
      System.out.println("10^ " + num + " = " + result);

      System.out.println("Calculating (10^PI and 10^-PI) ....");
      double resultPi = power10(pinum());
      System.out.println("By using Pi to test " + "10^PI = " + resultPi);
      System.out.println("By using Pi to test " + "10^-PI = " + 1 / resultPi);
    }


    public static double power10(double exponent) {

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

      numLn10 = exponentTemp * Math.log(10);
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

    public static double pinum() {
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


  }
}
