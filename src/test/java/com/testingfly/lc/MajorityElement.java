package com.testingfly.lc;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3


Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	/*
	 * Using sort
	 */
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {

			if (nums[i] == nums[i + 1])
				count++;
			else
				count = 0;
			if (count == nums.length / 2)
				return nums[i];
		}
		return nums[0];
	}

	/*
	 * Using hashMap
	 */
	public int majorityElementHM(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		System.out.println(map);
		for (int i = 0; i < nums.length; i++)
			if (map.get(nums[i]) > nums.length / 2)
				return nums[i];
		return nums[0];
	}
}