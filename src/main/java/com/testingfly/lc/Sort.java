package com.testingfly.lc;

import java.util.*;

public class Sort {

	public static void main(String[] args) {
		int nums[] = {45, 34, 23, 89, 123, 1, 4, 18};
		System.out.println("Insertion Sort: "+Arrays.toString(insertionSort1(nums)));


	}
	
	public static int[] insertionSort(int nums[]) {
		for(int i=1;i<nums.length;i++) {
			int temp=nums[i];
			System.out.println("temp: "+temp);
			int j=i;
			while(j>0 && nums[j-1]>temp) {
					nums[j]=nums[j-1];
					j--;
				
			}
			nums[j] = temp;
		}
		return nums;
	}
	
	public static int[] insertionSort1(int nums[]) {
		for(int i=1;i<nums.length;i++) {
			int temp = nums[i];
			int j=i;
			while(j>0 && nums[j-1]>temp) {
				nums[j] = nums[j-1];
				j--;
			}
			nums[j]=temp;
		}
		
		return nums;
	}
	
	
   

}
