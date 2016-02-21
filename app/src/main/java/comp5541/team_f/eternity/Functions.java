package comp5541.team_f.eternity;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

public class Functions {

  static double ln(double x){
    double num = 0;
    for(int i=0; i<500; i++){
     num += (1.0/(2*i+1))*toThePower((x-1)/(x+1),(2*i+1));
    }
    return 2*num;
  }

  static double log(double x){

    double num = ln(x)/(ln(10));
    return num;
  }


  static long factorial(int x) { //Recursive function to compute the factorial of x
    if (x == 0) {
      return 1;
    }
    return (x * factorial(x - 1));
  }

  static double toThePower(double x, int y) { //Computes x^y when y is an integer
    double result = 1;
    if (y == 0) {
      return 1;
    }
    for (int i = 0; i < y; i++) {
      result *= x;
    }
    return result;
  }

  //Approximation correct to 11 decimal places using 21 terms
  static double pi() {

    double term = 0;
    double sqrt12 = new ExpressionBuilder("sqrt(12)")
            .function(sqrt)
            .build()
            .evaluate();

    for (int i = 0; i < 40; i++) {
      term += (toThePower(-1.0 / 3.0, i)) / (2 * i + 1);
    }
    return sqrt12 * term;
  }


  static Function sin = new Function("sin") {
    @Override
    public double apply(double... args) {
      double result = 0;
      double term;

      for (int i = 1; i < 65; i += 2) { //First 32 terms of the Taylor Series Expansion
        term = toThePower(pi() / 180, i) * toThePower(args[0], i) / factorial(i); //
        if (i % 4 == 1) {
          result += term;
        } else {
          result -= term;
        }
      }
      return result;
    }
  };

  static Function sqrt = new Function("sqrt") {
    @Override
    public double apply(double... args) {
      double result;
      double sqr;
      double temp;
      if (args[0] == 0) {
        sqr = 0;
        result = sqr;
      } else if (args[0] < 0) {
        result = -99999999;
      } else {
        sqr = args[0] / 2;
        do {
          temp = sqr;
          sqr = (temp + args[0] / temp) / 2;
        } while ((temp - sqr) != 0);
        result = temp;
      }
      return result;
    }
  };


  public static void main(String[] args) throws IllegalArgumentException {
    //        //System.out.println(factorial(3));
    //        //System.out.println(toThePower(4,2));
    //        double result = new ExpressionBuilder("sin(45)")
    //                .function(sin)
    //                .build()
    //                .evaluate();
    System.out.println(ln(30));
    System.out.println(log(100));
    //        double sqrt9 = new ExpressionBuilder("sqrt(12)")
    //                .function(sqrt)
    //                .build()
    //                .evaluate();
    //        System.out.println(sqrt9);
  }
}
