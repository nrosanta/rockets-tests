package com.testingfly.lc;

import java.util.Arrays;

/**
 * 
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * Example 1:
 * 
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100]
 * 
 * Example 2:
 * 
 * Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000
 * 
 * -10000 <= A[i] <= 10000
 * 
 * A is sorted in non-decreasing order.
 *
 */
public class SquaresofSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { -4, -1, 0, 3, 10 };
		int[] arr2 = { -7, -3, 2, 3, 11 };

		System.out.println("Sorted Array: " + Arrays.toString(sortedSquares(arr1)));
		System.out.println("Sorted Array: " + Arrays.toString(sortedSquares(arr2)));

	}

	public static int[] sortedSquares(int[] A) {
		int[] sortedNum = new int[A.length];
		int i = 0;
		for (int num : A) {
			sortedNum[i++] = num * num;
		}
		Arrays.sort(sortedNum);
		return sortedNum;
	}

}
