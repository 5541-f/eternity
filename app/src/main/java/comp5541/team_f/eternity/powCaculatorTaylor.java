//@ Author: Team F, Yiguo Sun
// 5461 Project
//for Calculator function of power of 10
// method1: using Taylor Series
// named base10PowerCal1

import java.util.Scanner;

public class powCaculatorTaylor {

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

		double sum =1;
		double elem =1;
		double exponentTemp = exponent;
		double numLn10;
		int i=1;

		if (exponent == 0){
			return 1.0;
		}
		
		if (exponent ==1){
			return 10.0;
		}
		
		if (exponent < 0){
			exponentTemp = -exponent;
		}
		
		numLn10= exponentTemp * Math.log(10);
		while(elem>1e-12){
			elem *= numLn10/i;
			sum += elem;
			i++;
		}
		
		if  (exponent < 0){
			sum = 1/sum;
		}
		
		return sum;
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

