//@ Author: Team F, Yiguo Sun
// 5461 Project
//for Calculator function of power of 10
// method1: using e
// named base10PowerCal2

import java.util.Scanner;

public class base10PowerCal2 {
	   
	
	public static void main (String[] args){
	 	   
	 	   double result = power10();
	 	   System.out.print(result);
	 	   
	    }
	
	
	public static double power10(){
		   
		   System.out.println("please type one number to calculater the power of " + "10^");
	 	   Scanner input = new Scanner (System.in);
	 	   double exponent = input.nextDouble();
	 	   input.close();

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
  	  System.out.println("Java.Math = " + Math.pow(10.0, exponent));
  	    System.out.print("10^ " + exponent + " = ");
  	    return result;
	}
}
