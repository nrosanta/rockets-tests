package com.testingfly.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	Note: Given n will be a positive integer.
	
	Example 1:
	
	Input: 2
	Output: 2
	Explanation: There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps
	Example 2:
	
	Input: 3
	Output: 3
	Explanation: There are three ways to climb to the top.
	1. 1 step + 1 step + 1 step
	2. 1 step + 2 steps
	3. 2 steps + 1 step
 *
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(climbStairs1(n));
		System.out.println(climbStairs(n));

	}
	
	/*
	 * 2 = 11 2
	 * 3 = 111 12 21
	 * 4 = 1111 112 211 22 
	 * 5 = 11111 1112 2111 1121 1211 122 221 212
	 */
    public static int climbStairs1(int x) {
    	if(x==2) return 2;
    	if(x==1) return 1;    		
    	if(x==0) return 0;
    	return climbStairs1(x-1) + climbStairs1(x-2);
    	
    }
    
    /*
     * non-recursive approach
     */
    public static int climbStairs(int n) {
    
    	Map<Integer, Integer> data = new HashMap<>();
    	data.put(1, 1);
    	data.put(2, 2);
    	
    	for(int i=3;i<=n;i++) 
    		data.put(i, data.get(i-1) + data.get(i-2));
    	
    	return data.get(n);
    }
    
    
    /*
     * recursive solution with memoization
     */
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) { //check if its already calculated
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

}
