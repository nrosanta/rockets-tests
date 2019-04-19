package com.testingfly.lc;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,5,6,7};
		rotate(arr1,3);

	}
	
    public static void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length+k];
        int j=0;
        for(int i=k;i>0;i--)
            arr[j++]=nums[nums.length-i];
        
        j=k;
        for(int i=0;i<arr.length-k;i++)
            arr[j++]=nums[i];
        
        System.out.println(Arrays.toString(arr));
        
        nums = Arrays.copyOfRange(arr,0,arr.length-k);
        System.out.println(Arrays.toString(nums));
    }
	
	

}
