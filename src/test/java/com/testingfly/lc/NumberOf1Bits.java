package com.testingfly.lc;

public class NumberOf1Bits {

	public static void main(String[] args) {
		
		System.out.println(hammingWeight(11));
		System.out.println(hammingWeight(7));

	}
	
	/*
	 * this solution only works for integer range
	 */
    public static int hammingWeight1(int n) {
    	int count=0;
    	while(n>0) {
    		if(n%2==1)count++;
    		n=n/2;
    	}
        return count;
    }
    
    /*
     * alternate implementation using bit operation
     */
    public static int hammingWeight2(int n) {
    	int count=0;
    	int mask =1;
    	for(int i=0;i<32;i++) {
    		if((n & mask)!=0)
    			count++;
    		mask<<=1;
    	}
    	return count;
    }
    
    /*
     * alternate solution using manipulation of least significant bits
     * 
     */
    public static int hammingWeight(int n) {
    	int count=0;
    	while(n!=0) {
    		count++;
    		n = n & (n-1);
    	}
    	
    	return count;
    }
    
}
