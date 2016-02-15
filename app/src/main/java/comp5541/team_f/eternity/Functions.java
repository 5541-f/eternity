package comp5541.team_f.eternity;


public class Functions {

    public static int factorial(int x){ //Recursive function to compute the factorial of x
        if( x == 0)
            return 1;
        return(x*factorial(x-1));
    }

    public static double toThePower(double x, int y){ //Computes x^y
        double result = 1;
        if(y==0)
            return 1;

        for(int i = 1; i <y; i++){
            result*=x;
        }
        return result;
    }

    public static double pi(){ //the number pi
        return 3.14159265358979323846264338327950288419716939937510582;
    }

    public static double sin(double x) { //Computes sin(x)
        double result = 0;
        double term;

        for (int i = 1; i<1000; i += 2) { //First 500 terms of Taylor series expansion
            term = toThePower(pi()/180,i)*toThePower(x,i)/factorial(i);
            if(i%4==1)
                result+=term;
            else
                result-=term;
        }
        return result;
    }
}
