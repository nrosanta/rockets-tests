package com.testinfly.practice;

import java.util.Arrays;

public class MissingInteger {

	/*
	 * - random order - negative and postives - sort array - if last element is <0,
	 * return 1 - if arr length =1, return A[0] - start with s = A[0] - if s!=A[0],
	 * increment s else break; - return s;
	 */

	public int solution(int[] A) {

		Arrays.sort(A);
		int index = 0;

		// capture index of 1st occurence of non-zero val
		for (int i = 0; i < A.length; i++) {
			index = i;
			if (A[i] > 0)
				break;
		}

		// if non-zero val >1 OR largest val<0, return 1
		if (index <= A.length - 1 && A[index] > 1 || A[A.length - 1] < 1)
			return 1;

		int s = A[index];
		for (int i = index; i < A.length; i++) {
			if (s != A[i])// increment only when there's no duplicate
				s++;
			if (s < A[i])// return missing element
				return s;
		}

		return A[A.length - 1] + 1;// return next element if no misisng elements in between

	}
}