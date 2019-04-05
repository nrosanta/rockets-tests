package com.testingfly.lc;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		printFib(10);

	}
	
	/*
	 * Computes fibonacci series upto Nth item
	 */
	public static void printFib(int n) {
		for(int i=1;i<=n;i++)
			System.out.print(fib(i)+" ");
	}
	
	/*
	 * recursive solution to compute Nth item of the fibonacci series
	 */
	public static int fib(int n) {
		
		if(n==1 || n ==2)
			return 1;
		
		return fib(n-1)+fib(n-2);
		
	}

}
