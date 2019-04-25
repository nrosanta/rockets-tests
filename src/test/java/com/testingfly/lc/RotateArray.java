package com.testingfly.lc;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,5,6,7};
		rotate(arr1,3);

	}
	
    public static void rotate1(int[] nums, int k) {
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
	
    public static void rotate2(int[] nums, int k) {
    	if(k>nums.length) k=k-nums.length;
        int[] arr = new int[nums.length];
        int j=0;
        arr = Arrays.copyOf(nums, nums.length);
        for(int i=nums.length-k;i<nums.length;i++)
            nums[j++]=arr[i];
        j = 0;
        for(int i=k;i<nums.length;i++)
        	nums[i]=arr[j++];
    }
    
    public static void rotate(int[] nums, int k) {
    	if(k>nums.length) k=k-nums.length;
    	System.out.println(Arrays.toString(nums));
       
        for(int i=0;i<k;i++) {
        	int temp = nums[i];
        	nums[i]=nums[nums.length-k+i];
        	nums[nums.length-k-i] = temp;
        }
        
        System.out.println(Arrays.toString(nums));
    }
	
	

}
