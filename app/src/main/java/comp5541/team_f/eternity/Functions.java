package comp5541.team_f.eternity;


public class Functions {


  static double logarithmNatural(double x){
    double num = 0;
    //Assumed 500 terms was a reasonable enough of an approximation
    for(int i=0; i<1000; i++){
     num += (1.0/(2*i+1))*toThePower((x-1)/(x+1),(2*i+1));
    }
    return 2*num;
  }

  static double log(double x){
    return logarithmNatural(x)/(logarithmNatural(10));
  }


  static long factorial(int x) { //Recursive function to compute the factorial of x
    if (x == 0) {
      return 1;
    }
    return (x * factorial(x - 1));
  }

  static double toThePower(double base, int exponent) { //Computes x^y when y is an integer
    double result = 1;
    if (exponent == 0) {
      return 1;
    }
    for (int i = 0; i < exponent; i++) {
      result *= base;
    }
    return result;
  }

  //Approximation correct to 11 decimal places using 21 terms
  static double pi() {
    double term = 0;
    for (int i = 0; i < 40; i++) {
      term += (toThePower(-1.0 / 3.0, i)) / (2 * i + 1);
    }
    return squareRoot(12) * term;
  }


  static double sin(double x){
      double result = 0;
      double term;

      for (int i = 1; i < 65; i += 2) { //First 32 terms of the Taylor Series Expansion
        term = toThePower(pi() / 180, i) * toThePower(x, i) / factorial(i); //
        if (i % 4 == 1) {
          result += term;
        } else {
          result -= term;
        }
      }
      return result;
    }


  static double squareRoot(double x){
      double result;
      double sqr;
      double temp;

        sqr = x / 2;
        do {
          temp = sqr;
          sqr = (temp + x / temp) / 2;
        } while ((temp - sqr) != 0);
        result = temp;
      return result;
    }
//////////////////////////////////////OTHER FUNCTIONS///////////////////////////////////////////////

//  public class function {
//
//    public static double findSqr(){
//      Scanner sc = new Scanner(System.in);
//      System.out.print("please enter number: " );
//      double num = sc.nextDouble();
//      sc.close();
//      double result = 0;
//      double sqr;
//      double temp = 0;
//      if(num == 0){
//        sqr = 0;
//        result = sqr;
//      }
//      else if (num < 0){
//        result = -99999999;
//      }
//      else{
//        sqr = num/2;
//        do{
//          temp = sqr;
//          sqr = (temp+num/temp)/2;
//        }while((temp-sqr)!=0);
//        result = temp;
//      }
//      return result;
//    }
//    public static void main(String[] args){
//      double result = findSqr();
//      System.out.println("   the square root is +" + result);
//      System.out.println("or the square root is -" + result);
//    }

// Calculating pi with Leibniz
// public class piCal1 {
//    public static void main(String[] args) {
//
//      int count = 999999999;
//      double pi = 0;
//      double denominator = 1;
//
//      for (int x = 0; x < count; x++) {
//
//        if (x % 2 == 0) {
//          pi = pi + (1 / denominator);
//        } else {
//          pi = pi - (1 / denominator);
//        }
//        denominator = denominator + 2;
//      }
//      pi = pi * 4;
//      System.out.println(pi);
//    }
//
//  }

//  public class powCaculatorE {
//
//    public static void main (String[] args){
//
//
//      System.out.println("please type one number to calculater the power of " + "10^");
//      Scanner input = new Scanner (System.in);
//      double num = input.nextDouble();
//      input.close();
//
//      double result = power10(num);
//      System.out.println("10^ " + num + " = "+ result);
//
//      System.out.println("Calculating (10^PI and 10^-PI) ...." );
//      double resultPi = power10(pinum());
//      System.out.println("By using Pi to test " + "10^PI = " + resultPi);
//      System.out.println("By using Pi to test " + "10^-PI = " + 1/resultPi);
//    }
//
//
//    public static double power10(double exponent){
//      double result = 1.0;
//      int largestNum = 999999999;
//
//
//      if (exponent == 0){
//        result = 1.0;
//      }
//      if (exponent ==1){
//        result = 10.0;
//      }else{
//
//        for(int i = 0; i<largestNum; i++){
//          // here using Math.log() method temporarily
//          // considering Dana code log() function
//          // finally will call Dana's log()
//          double part = exponent * Math.log(10);
//          result *= (1+part/largestNum);
//        }
//      }
//      return result;
//    }
//
//    public static double pinum(){
//      //LeibnizFormula
//      int count = 999999999;
//      double pi = 0;
//      double denominator = 1;
//
//      for (int x = 0; x < count; x++) {
//
//        if (x % 2 == 0) {
//          pi = pi + (1 / denominator);
//        } else {
//          pi = pi - (1 / denominator);
//        }
//        denominator = denominator + 2;
//      }
//      pi = pi * 4;
//      return pi;
//    }
//
//  }
//public class powCaculatorTaylor {
//
//  public static void main (String[] args){
//
//
//    System.out.println("please type one number to calculater the power of " + "10^");
//    Scanner input = new Scanner (System.in);
//    double num = input.nextDouble();
//    input.close();
//
//    double result = power10(num);
//    System.out.println("10^ " + num + " = "+ result);
//
//    System.out.println("Calculating (10^PI and 10^-PI) ...." );
//    double resultPi = power10(pinum());
//    System.out.println("By using Pi to test " + "10^PI = " + resultPi);
//    System.out.println("By using Pi to test " + "10^-PI = " + 1/resultPi);
//  }
//
//
//  public static double power10(double exponent){
//
//    double sum =1;
//    double elem =1;
//    double exponentTemp = exponent;
//    double numLn10;
//    int i=1;
//
//    if (exponent == 0){
//      return 1.0;
//    }
//
//    if (exponent ==1){
//      return 10.0;
//    }
//
//    if (exponent < 0){
//      exponentTemp = -exponent;
//    }
//
//    numLn10= exponentTemp * Math.log(10);
//    while(elem>1e-12){
//      elem *= numLn10/i;
//      sum += elem;
//      i++;
//    }
//
//    if  (exponent < 0){
//      sum = 1/sum;
//    }
//
//    return sum;
//  }
//
//  public static double pinum(){
//    //LeibnizFormula
//    int count = 999999999;
//    double pi = 0;
//    double denominator = 1;
//
//    for (int x = 0; x < count; x++) {
//
//      if (x % 2 == 0) {
//        pi = pi + (1 / denominator);
//      } else {
//        pi = pi - (1 / denominator);
//      }
//      denominator = denominator + 2;
//    }
//    pi = pi * 4;
//    return pi;
//  }
//
//
//}


  public static void main(String[] args) throws IllegalArgumentException {
    //        //System.out.println(factorial(3));
    //        //System.out.println(toThePower(4,2));
    //        double result = new ExpressionBuilder("sin(45)")
    //                .function(sin)
    //                .build()
    //                .evaluate();
    System.out.println(logarithmNatural(30));
    System.out.println(log(100));
    System.out.println(squareRoot(49));
    System.out.println(sin(45));
    System.out.println();
    //        double sqrt9 = new ExpressionBuilder("sqrt(12)")
    //                .function(sqrt)
    //                .build()
    //                .evaluate();
    //        System.out.println(sqrt9);
  }
}
