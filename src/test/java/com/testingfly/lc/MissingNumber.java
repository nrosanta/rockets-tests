package com.testingfly.lc;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = {0,1,3,2,4,5,6};
		System.out.println(missingNumber(nums));
		System.out.println(missingNumber1(nums));
		System.out.println(missingNumber2(nums));

	}
	
	/*
	 * using math -> N = n(n+1)/2 i.e. sum of natural numbers.
	 */
    public static int missingNumber(int[] nums) {
    	
    	int n = nums.length;
    	int sumN = n*(n+1)/2;
    	
    	int sum=0;
    	for(int i=0;i<nums.length;i++)
    		sum+= nums[i];
    	
    	return sumN-sum;
    }
    
    /*
     * alternate solution using sort
     */
    public static int missingNumber1(int[] nums) {
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length;i++) {
    		if(i!=nums[i])
    			return i;
    	}
    	return nums[nums.length-1]+1;
    }
    	
    /*
     * alternate solution using XOR
     */
    public static int missingNumber2(int[] nums) {
    	int x = 0;
    	
    	for(int i=0;i<nums.length;i++)
    		x ^=   (i+1) ^ nums[i];
    	
    	return x;
    }

}
