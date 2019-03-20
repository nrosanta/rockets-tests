package com.testingfly.lc;
public class BitShift {

	    public static void main(String args[])  {
	    	int dividend=-2147483648, divisor=1;
	    	System.out.println("Quotient: "+divide(dividend,divisor)+"\n\n");
	        
	        int result=0;
	        while(dividend>=divisor) {
	        	int i=0;
		        while(dividend>=(divisor<<i)) {
		    	   System.out.println(divisor<<i);
		    	   i++;
		        }
		        System.out.println("# of Shifts: "+(i-1));
		        result = result+(1<<(i-1));
		        //System.out.println("Result**: "+ (1<<(0)));
		        System.out.println("Result: "+result);
		        dividend = dividend-(divisor<<(i-1));
		        System.out.println("Dividend: "+dividend);
		        System.out.println("Quotient: "+result);
		    }     
	        
	        
	    }
	    
	    public static int divide(int dividend, int divisor) {
	        //handle special cases
	        if(divisor==0) return Integer.MAX_VALUE;
	        if(divisor==-1 && dividend == Integer.MIN_VALUE)
	            return Integer.MAX_VALUE;
	     
	        //get positive values
	        long pDividend = Math.abs((long)dividend);
	        long pDivisor = Math.abs((long)divisor);
	     
	        int result = 0;
	        while(pDividend>=pDivisor){
	            //calculate number of left shifts
	            int numShift = 0;    
	            while(pDividend>=(pDivisor<<numShift)){
	            	System.out.println(pDivisor<<numShift);
	                numShift++;
	            }
	     
	            //dividend minus the largest shifted divisor
	            result += 1<<(numShift-1);
	            System.out.println("# of Shifts: "+(numShift-1));
	            pDividend -= (pDivisor<<(numShift-1));
	        }
	     
	        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
	            return result;
	        }else{
	            return -result;
	        }
	    }
} 