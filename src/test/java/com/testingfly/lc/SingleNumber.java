package com.testingfly.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1] Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,1,2,1,2] Output: 4
 *
 */

public class SingleNumber {

	public static void main(String[] args) {
		int[] arr1 = { 4, 1, 2, 1, 2 };
		int[] arr2 = { 2, 2, 1 };

		System.out.println(singleNumber(arr1));
		System.out.println(singleNumber(arr2));
	}

	public static int singleNumber1(int[] nums) {
		if (nums.length == 1)
			return nums[0];

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1; i = i + 2)
			if (nums[i] != nums[i + 1])
				return nums[i];
		if (nums[nums.length - 1] != nums[nums.length - 2])
			return nums[nums.length - 1];
		return 0;

	}

	public static int singleNumber2(int[] nums) {
		int i = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (i < nums.length) {
			if (map.containsKey(nums[i]))
				map.remove(nums[i]);
			else
				map.put(nums[i], i);

			i++;
		}
		for (int num : map.keySet())
			return nums[map.get(num)];
		return nums[0];
	}

	public static int singleNumber3(int[] nums) {

		int i = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (i < nums.length) {
			if (map.get(nums[i]) == null)
				map.put(nums[i], nums[i]);
			else
				map.remove(nums[i]);

			i++;
		}
		
		
		for (int key : map.keySet())
			return map.get(key);
		
		return nums[0];
	}
	
	public static int singleNumber(int[] nums) {
		int res = 0;
		for(int i: nums) 
			res = res^i;
		return res;
	}
}
