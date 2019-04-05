package com.testingfly.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOf2Arrays {

	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };

		int[] nums3 = { 1, 2, 2, 1 };
		int[] nums4 = { 2, 2 };

		int[] nums5 = { 1, 2 };
		int[] nums6 = { 1, 1 };

		System.out.println(Arrays.toString(intersect(nums1, nums2)));
		System.out.println(Arrays.toString(intersect(nums3, nums4)));
		System.out.println(Arrays.toString(intersect(nums5, nums6)));

	}

	public static int[] intersect(int[] nums1, int[] nums2) {

		int[] arr = new int[nums1.length<nums2.length?nums1.length:nums2.length];
		int k = 0;
		for (int i = 0; i < nums1.length; i++)
			for (int j = 0; j < nums2.length; j++) {
				if (nums2[j] == nums1[i]) {
					arr[k++] = nums1[i];
					nums2[j] = Integer.MAX_VALUE;
					break;
				}
			}
		return Arrays.copyOfRange(arr, 0, k);
	}

	/*
	 * [4,9,5], [9,4,9,8,4] solution when the intersection needs to be in sequence
	 * and consecutive
	 */
	public static int[] intersect1(int[] nums1, int[] nums2) {

		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++)
			for (int j = 0; j < nums2.length; j++) {
				if (i < nums1.length && nums2[j] == nums1[i]) {
					arr.add(nums2[j]);
					i++;
				}
			}

		int temp[] = new int[arr.size()];
		int j = 0;

		for (int num : arr)
			temp[j++] = num;

		System.out.println(Arrays.toString(temp));
		return temp;
	}

}
