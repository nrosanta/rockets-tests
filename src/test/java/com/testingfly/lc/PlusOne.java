package com.testingfly.lc;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		int[] arr1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] arr2 = { 9, 9 };
		int[] arr3 = { 9 };
		int[] arr4 = { 2 };

		System.out.println(Arrays.toString(plusOne(arr1)));
		System.out.println(Arrays.toString(plusOne(arr2)));
		System.out.println(Arrays.toString(plusOne(arr3)));
		System.out.println(Arrays.toString(plusOne(arr4)));

	}

	public static int[] plusOne1(int[] digits) {
		int carry = 1;
		int[] res = new int[digits.length + 1];
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			if (sum > 9 && i == 0) {
				res[0] = 1;
			} else {
				if (sum > 9) {
					sum = sum % 10;
					carry = 1;
				} else
					carry = 0;
				res[i + 1] = sum;
			}

		}
		return res[0] != 0 ? res : Arrays.copyOfRange(res, 1, res.length);

	}

	/*
	 * recursive approach [2,2,1]
	 */
	public static int[] plusOne(int[] digits) {
		return plusOne(digits, digits.length - 1);
	}

	public static int[] plusOne(int[] digits, int len) {
		if (digits[len] != 9) {
			digits[len] += 1;
			return digits;
		}
		digits[len] = 0;

		if (len == 0) {
			int[] new_digits = new int[digits.length + 1];
			new_digits[0] = 1;
			return new_digits;
		}

		return plusOne(digits, len - 1);
	}
}