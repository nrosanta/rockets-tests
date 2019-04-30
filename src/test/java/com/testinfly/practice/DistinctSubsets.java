package com.testinfly.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Computes distinct subsets of 'n' unique elements.
 */
public class DistinctSubsets {

	public static void main(String[] args) {

		char[] arr1 = { 'a', 'b', 'c' };
		// printDistinctSubSets(arr1, arr1.length);
		System.out.println();
		// allCombinations(arr1,0,arr1.length);

		int[] arr2 = { 1, 2, 3 };
		getSubsets(arr2);

	}

	/*
	 * Iterative approach using bit operation 0 001 & 111 1 010 & 111 2 100 & 111
	 * Time Complexity -> O(n * 2^n)
	 */
	public static void printDistinctSubSets(char[] arr, int len) {

		int pow = (int) Math.pow(2, len);

		for (int i = 0; i < pow; i++) {
			for (int j = 0; j < len; j++) {
				if ((i & 1 << j) > 0)
					System.out.print(arr[j]);
			}

			System.out.println();

		}
	}

	/*
	 * Backtracking approach to get subsets of distinct elements
	 */

	public static void getSubsets(int[] arr) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		printSubsets(subSetHelper(arr, res, list, 0));

	}

	public static List<List<Integer>> subSetHelper(int[] arr, List<List<Integer>> res, List<Integer> list, int left) {

		for (int i = left; i < arr.length; i++) {

			list.add(arr[i]);
			System.out.println("trace: " + list);
			res.add(new ArrayList<Integer>(list));
			subSetHelper(arr, res, list, i + 1);
			list.remove((Object) arr[i]); // backtrack.. exclude arr[i] from subsets

		}

		return res;
	}

	public static void printSubsets(List<List<Integer>> res) {
		for (List<Integer> list : res)
			System.out.println(list);
	}

	/*
	 * - max possible combination is 2^n where n = length of unique elements - loop
	 * through max possible combinations - perform a AND operation within a nested
	 * loop - outside loop will be max possible combinations - inside loop will be
	 * length of elements
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int pow = (int) Math.pow(2, nums.length);
		for (int i = 0; i < pow; i++) {
			List<Integer> subList = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if ((i & 1 << j) > 0)
					subList.add(nums[j]);
			}
			res.add(subList);
		}

		return res;

	}

	/*
	 * all combinations using recursive backtrack approach Time Complexity ->
	 * O(2k+n*n) ->n^2
	 */

	public static void allCombinations(char[] arr, int left, int right) {

		if (left == right)
			System.out.println(arr);
		for (int i = left; i < right; i++) {
			swap(arr, left, i);
			allCombinations(arr, left + 1, right);
			swap(arr, left, i); // backtrack
		}
	}

	public static void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

}
