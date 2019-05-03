package com.testingfly.lc;

import java.util.HashMap;
import java.util.Random;

public class FourSumII {

	public static void main(String[] args) {

		Random ran = new Random();
		ran.nextInt(10);
		
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		
		System.out.println("Count: "+ fourSumCount(A,B,C,D));

	}

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int res = 0, n = A.length;
		HashMap<Integer, Integer> sums = new HashMap<>();

		for (int a = 0; a < n; a++)
			for (int b = 0; b < n; b++) {
				sums.put(A[a] + B[b], sums.getOrDefault(A[a] + B[b], 0) + 1);
			}

		System.out.println(sums);

		for (int c = 0; c < n; c++)
			for (int d = 0; d < n; d++) {
				System.out.print(" " + (-C[c] - D[d]));
				res += sums.getOrDefault(-C[c] - D[d], 0);
			}

		return res;
	}

}