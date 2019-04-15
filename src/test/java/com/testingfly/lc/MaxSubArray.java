package com.testingfly.lc;

/**
 * 
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * 
 * Output: 6
 * 
 * Explanation: [4,-1,2,1] has the largest sum = 6. Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 *
 */

public class MaxSubArray {

	public static void main(String[] args) {
		int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4}; 
		int[] arr2 = {2,1,-3};
		
		System.out.println(maxSubArray(arr1));
		System.out.println(maxSubArray(arr2));

	}
	
	/*
	 * One pass approach.
	 * It scans through the array starting with the 1st element.
	 * Sums up each element and compare with current element.
	 * If sum is greater, maintain sum as largest
	 * Else current number is largest, hence, start new sum from there.
	 * 
	 * Compare 2 elements. If sum is greater than current element, continue sum.
	 * Else start new sum with current element.
	 */

	public static int maxSubArray(int[] nums) {

			int max_sum = nums[0];
			int max = nums[0];
			
			for (int i=1;i<nums.length;i++) {
				max = Math.max(nums[i], max+nums[i]);
				max_sum = Math.max(max, max_sum);
			}
	
			return max_sum;
		}

}
