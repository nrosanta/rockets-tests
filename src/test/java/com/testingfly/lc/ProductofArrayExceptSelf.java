package com.testingfly.lc;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {

		int nums[] = { 2, 3, -1, 2 };
		System.out.println(Arrays.toString(productExceptSelf(nums)));
		System.out.println(Arrays.toString(productExceptSelf1(nums)));
		System.out.println(Arrays.toString(productExceptSelf3(nums)));

	}

	/*
	 * using brute force
	 */
	public static int[] productExceptSelf(int[] nums) {
		int[] arr = new int[nums.length];
		int p = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (j != i)
					p = p * nums[j];
			}
			arr[i] = p;
			p = 1;
		}
		return arr;
	}

	/*
	 * using division
	 */
	public static int[] productExceptSelf1(int[] nums) {
		int[] arr = new int[nums.length];
		int p = 1;
		int count_zeroes = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				p = p * 1;
				count_zeroes++;
			} else
				p = p * nums[i];
		}

		if (count_zeroes > 1)
			return arr;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0 && count_zeroes == 1)
				arr[i] = p / 1;
			else {
				if (count_zeroes > 0)
					arr[i] = 0;
				else
					arr[i] = p / nums[i];
			}
		}

		return arr;
	}

	/*
	 * using pointer
	 */
	public static int[] productExceptSelf2(int[] nums) {
		int[] ans = new int[nums.length];
		int N = ans.length;
		int left = 1;

		// ans[i] = left = product of nums[0 ... i-1]
		for (int i = 0; i < N; i++) {
			ans[i] = left;
			left *= nums[i];
		}

		System.out.println("left: " + Arrays.toString(ans));

		// right = product of nums[i+1 ... N-1]
		int right = 1;
		for (int i = N - 1; i >= 0; i--) {
			ans[i] = ans[i] * right;
			right *= nums[i];
		}
		return ans;
	}

	/*
	 * - scan input array left to right 
	 * - compute product to the left of the element	and save it to result array 
	 * - scan input array right to left 
	 * - compute final value -> left product(result array) * product to the right(input array) of
	 * the element
	 * 
	 */
	public static int[] productExceptSelf3(int[] nums) {
		int[] arr = new int[nums.length];
		int left = 1, right = 1;
		for (int i = 0; i < nums.length; i++) {
			arr[i] = left;
			left = left * nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			arr[i] = arr[i] * right;
			right = right * nums[i];
		}
		return arr;
	}

}
