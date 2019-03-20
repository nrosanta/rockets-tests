package com.testingfly.lc;

import java.util.Arrays;

/**
 * 
 * Given a binary matrix A, we want to flip the image horizontally, then invert
 * it, and return the resulting image.
 * 
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * 
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced
 * by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * 
 * Example 1:
 * 
 * Input: [[1,1,0],[1,0,1],[0,0,0]] Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]]. Then, invert
 * the image: [[1,0,0],[0,1,0],[1,1,1]]
 * 
 * Example 2:
 * 
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]] Output:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] Explanation: First reverse each
 * row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]. Then invert the image:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] Notes:
 * 
 * 1 <= A.length = A[0].length <= 20
 * 
 * 0 <= A[i][j] <= 1
 *
 */
public class FlippingAnImage {

	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } };
		System.out.println("Arr: " + Arrays.deepToString(flipAndInvertImage(arr)));

		int arr1[][] = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
		System.out.println("Arr: " + Arrays.deepToString(flipAndInvertImage(arr1)));
	}

	public static int[][] flipAndInvertImage(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < (A[0].length+1) / 2; j++) {
				int temp = A[i][j];
				A[i][j] = A[i][A[0].length - j - 1] ^ 1;
				A[i][A[0].length - j - 1] = temp ^ 1;
			}

		}

//		for (int i = 0; i < A.length; i++) {
//			for (int j = 0; j < A[0].length; j++) {
//				if (A[i][j] == 1)
//					A[i][j] = 0;
//				else
//					A[i][j] = 1;
//			}
//
//		}
		// Arr: [[1, 1, 0, 0], [0, 1, 1, 0], [0, 0, 0, 1], [1, 0, 1, 0]]
		// [[1,0,0],[0,1,0],[1,1,1]]
		return A;
	}

}
