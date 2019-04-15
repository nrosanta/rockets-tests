package com.testingfly.lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy(7));
	}
	
	/*
	 * Input: 19
		Output: true
		Explanation: 
		12 + 92 = 82
		82 + 22 = 68
		62 + 82 = 100
		12 + 02 + 02 = 1
		
		123
		1 + 4 + 9 = 14
		1 + 16 = 17
		1 + 49 = 50
		25 + 0 = 25
		4 + 25 = 29
		4 + 81 = 85
		64 + 1 = 65
		36 + 25 = 61
		36 + 1 = 37
		9 + 49 = 58
		25 + 64 = 89
		64 + 81 = 145
		1 + 16 + 25 = 42
		16 + 4 = 20
		4 + 0 = 4
		16
		1 + 36 = 37
		
	 */
    public static boolean isHappy(int n) {
    	Set<Integer> set = new HashSet<>();
    	while(n!=1) {
    		n = getSum(n);
    		if(!set.add(n))
				return false;
		}
        return true;
    }
    
    public static int getSum1(int n) {
    	int sum=0;
    	while(n>0) {
    		sum += (n%10) * (n%10);
            n=n/10;
    	}
       	return sum;
    }
    
    /*
     * alternate solution using string array
     */
    public static int getSum(int n) {
    	String str = Integer.toString(n);
    	int sum=0;
    	for(char c : str.toCharArray())
    		sum += Math.pow(c-'0',2);
       	return sum;
    }

}
