
//@ Author: Team F, Yiguo Sun
//5461 Project
//for Calculator function of power of 10
//method1: using e methods
//named base10PowerCal2
import java.util.Scanner;

public class powCaculatorE {

	public static void main (String[] args){


		System.out.println("please type one number to calculater the power of " + "10^");
		Scanner input = new Scanner (System.in);
		double num = input.nextDouble();
		input.close();

		double result = power10(num);
		System.out.println("10^ " + num + " = "+ result);
		
		System.out.println("Calculating (10^PI and 10^-PI) ...." );
		double resultPi = power10(pinum());		
		System.out.println("By using Pi to test " + "10^PI = " + resultPi);
		System.out.println("By using Pi to test " + "10^-PI = " + 1/resultPi);
	}


	public static double power10(double exponent){
      double result = 1.0;
      int largestNum = 999999999;
     
    
      if (exponent == 0){
		   result = 1.0;
	    }
	    if (exponent ==1){
		   result = 10.0;
	    }else{
	    
       for(int i = 0; i<largestNum; i++){
         // here using Math.log() method temporarily 
     	// considering Dana code log() function
     	// finally will call Dana's log()
         double part = exponent * Math.log(10);
         result *= (1+part/largestNum);
         }
	    }
	    return result;
	 }
	
	 public static double pinum(){
		//LeibnizFormula
		 int count = 999999999;
	      double pi = 0;
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