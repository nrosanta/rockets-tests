package com.testingfly.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3};
		System.out.println(permute(arr1));

	}

	/*
	 * - !factorial of the total distinct numbers = possible combinations - recurive
	 * calls to break down problem into small swappable parts. - if nth call is !
	 * the distinct numbers, return list;
	 */
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		return permute(nums, list, 0, nums.length-1);

	}
	
	/*
	 * 123
	 */
	public static List<List<Integer>> permute(int[] nums, List<List<Integer>> res, int left, int right) {
		//System.out.println("Temp: "+Arrays.toString(nums));
		if(left==right) { 
			res.add(addList(nums));
			
		} else {
			for(int i=left;i<=right;i++) {
//				int[]arr = Arrays.copyOf(nums, nums.length);
//				int temp = arr[left];
//				arr[left]=arr[i];
//				arr[i] = temp;
				swap(nums, left, i);
				//System.out.println("Temp->i: "+i+"->"+Arrays.toString(arr));
				permute(nums,res,left+1, right);
				swap(nums, left, i); //backtrack
			}
		}
		return res;
		
	}
	
	public static List<Integer> addList(int[] nums){
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<nums.length;i++)
			list.add(nums[i]);
		
		return list;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j] = temp;
	}
	
	
	
	
	
	

}
