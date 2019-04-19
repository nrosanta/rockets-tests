package com.testingfly.lc;

public class SqrtCompute {

	public static void main(String[] args) {

		System.out.println(mySqrt(8));

	}

	public static int mySqrt(int x) {

		double i = x / 2;
		double j = -1;
		if (x > 1)
			while (i != j) {
				j = (i + x / i) / 2;
				i = (j + x / j) / 2;
				if (i == j)
					return (int) i;
			}
		return x;
	}

}
