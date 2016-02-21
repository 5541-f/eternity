
import java.util.Scanner;

public class base10PowerCal1 {
	
	public static void main (String[] args){
 	   
 	   double result = power10();
 	   System.out.println(result);
 	   
    }
    
    
    public static double power10(){
 	   
 	   System.out.println("please type one number to calculater the power of " + "10^");
 	   Scanner input = new Scanner (System.in);
 	   double exponent1 = input.nextDouble();
 	   double exponent = exponent1;
 	   input.close();
 	   
 	   
 	
 	   double sum =1;
 	   double elem =1.0;
 	   double numLn10= exponent * Math.log(10);
 	   int i=1;
 	   double results=0;
 	   
 	   if (exponent == 0){
 		   results = 1.0;
 	   }
 	   if (exponent ==1){
 		   results = 10.0;
 	   }
 	   else if(exponent >0){
 	  
 		   
 		   while(elem>1e-12){
	            elem *= numLn10/i;
	            sum += elem;
	            i++;
	        }
 		   
 		   results = sum;
 	   }
             
    
 	   if (exponent <0){
 		   exponent = - exponent;
 		   numLn10= exponent * Math.log(10);
 		   while(elem>1e-12){
   	            elem *= numLn10/i;
   	            sum += elem;
   	            i++;
 		   }
 		   results = 1/sum;
 	   }
 	   System.out.println("Java.Math = " + Math.pow(10.0, exponent1));
 	   System.out.print("10^ " + exponent1 + " = ");
 	   return results;
 	       
    }     
}
