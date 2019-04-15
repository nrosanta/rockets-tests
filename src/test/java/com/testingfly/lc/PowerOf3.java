package com.testingfly.lc;

import java.util.Arrays;

public class PowerOf3 {

	public static void main(String[] args) {

		System.out.println(isPowerOfThree(27));

	}

	/*
	 * 3 9 27 81 243 729 2187 6561 19683 59049
	 */
	public static boolean isPowerOfThree1(int n) {
		if (n <= 0)
			return false;
		while (n > 1) {
			if (n % 3 != 0)
				return false;
			n = n / 3;
			
			int[] num = new int[]{1,2,3};
			Arrays.copyOfRange(num,0,2);

		}
		return true;
	}
	
	/*
	 * recursive approach
	 */
	public static boolean isPowerOfThree(int n) {
		if(n==1) return true;
		if(n<1 || n%3!=0) return false;
        return isPowerOfThree(n/3);
	}
}
