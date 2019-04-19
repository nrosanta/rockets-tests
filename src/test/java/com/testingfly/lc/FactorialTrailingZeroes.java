package com.testingfly.lc;

/*
 * Given an integer n, return the number of trailing zeroes in n!.

	Example 1:
	
	Input: 3
	Output: 0
	Explanation: 3! = 6, no trailing zero.
	Example 2:
	
	Input: 5
	Output: 1
	Explanation: 5! = 120, one trailing zero.
	Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	public static void main(String[] args) {

		System.out.println(trailingZeroes(5));
		System.out.println(trailingZeroes(13));

	}

	public static int trailingZeroes1(int n) {
		int count = 0;
		for (int i = 5; n / i >= 1; i *= 5) {
			count = count + (n / i);
		}
		return count;

	}
	
    public static int trailingZeroes2(int n) {
        int count = 0;
        for (int i = n/5; i > 0; i = i/5) {
            count = count + i;
        }
        return count;
    }
    
    /*
     * recursive approach
     */
    public static int trailingZeroes(int n) {
    	
    	if(n==0) return 0;
    	return  (n/5) + trailingZeroes(n/5);
        
    }

}
