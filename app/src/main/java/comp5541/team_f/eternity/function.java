package comp5541.team_f.eternity;

import java.util.Scanner;

public class function {
	
	public static double findSqr(){
		Scanner sc = new Scanner(System.in);
		System.out.print("please enter number: " );
	    double num = sc.nextDouble();
	    sc.close();
		double result = 0;
    	double sqr;
    	double temp = 0;
    	if(num == 0){
    		sqr = 0;
    		result = sqr;
    	}
        else if (num < 0){		
    		result = -99999999;
    	}
    	else{
    		sqr = num/2;
    	  do{
    		temp = sqr;
    		sqr = (temp+num/temp)/2;
        	}while((temp-sqr)!=0);	
		result = temp;
    	}
		return result;		
}
    public static void main(String[] args){
		double result = findSqr();
		System.out.println("   the square root is +" + result);
		System.out.println("or the square root is -" + result);
   	    }	
}