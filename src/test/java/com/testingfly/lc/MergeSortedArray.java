package com.testingfly.lc;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int[] temp = Arrays.copyOfRange(nums1, 0, m);
		int j = 0, k = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (j < temp.length && k < nums2.length)
				if (temp[j] < nums2[k]) {
					nums1[i] = temp[j++];
				} else
					nums1[i] = nums2[k++];
			else if (j < temp.length)
				nums1[i] = temp[j++];
			else if (k < nums2.length)
				nums1[i] = nums2[k++];
		}
	}
}
