package com.testingfly.lc;

public class Add2Numbers {

	public static void main(String[] args) {
		
		System.out.println(getSum(2, 3));

	}
	
    public static int getSum(int a, int b) {
        int sum=a;
        int carry=0;
        
        while(b!=0){
            carry = sum & b;
            sum = sum ^ b;
            b = carry << 1;
        }
        
        return sum;
    }

}
