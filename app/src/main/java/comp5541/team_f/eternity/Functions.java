package comp5541.team_f.eternity;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

public class Functions {

    public static long factorial(int x){ //Recursive function to compute the factorial of x
        if( x == 0)
            return 1;
        return(x*factorial(x-1));
    }

    public static double toThePower(double x, int y){ //Computes x^y
        double result = 1;
        if(y==0)
            return 1;
        for(int i = 0; i <y; i++){
            result*=x;
        }
        return result;
    }

    public static double pi(){ // a reasonable approximation to the number pi
        return 3.14159265358979323846264338327950288419716939937510582;
    }

//    public static double sin(double x) { //Computes sin(x) using Taylor series expansion
//        double result = 0;
//        double term;
//
//        for (int i = 1; i<65; i += 2) { //First 32 terms of the series
//            term = toThePower(pi()/180,i)*toThePower(x,i)/factorial(i);
//            if(i%4==1)
//                result+=term;
//            else
//                result-=term;
//        }
//        return result;
//    }

    static Function sin = new Function("sin") {
        @Override
        public double apply(double... args) {
            double result = 0;
            double term;

            for (int i = 1; i<65; i += 2) { //First 32 terms of the Taylor Series Expansion
                term = toThePower(pi()/180,i)*toThePower(args[0],i)/factorial(i); //
                if(i%4==1)
                    result+=term;
                else
                    result-=term;
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
            if(args[0] == 0){
                sqr = 0;
                result = sqr;
            }
            else if (args[0] < 0){
                result = -99999999;
            }
            else{
                sqr = args[0]/2;
                do{
                    temp = sqr;
                    sqr = (temp+args[0]/temp)/2;
                }while((temp-sqr)!=0);
                result = temp;
            }
            return result;
        }};



//    public static void main(String[] args) throws IllegalArgumentException {
//        //System.out.println(factorial(3));
//        //System.out.println(toThePower(4,2));
//        double result = new ExpressionBuilder("sin(45)")
//                .function(sin)
//                .build()
//                .evaluate();
//        System.out.println(result);
//    }
}
