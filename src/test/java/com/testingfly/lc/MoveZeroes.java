package com.testingfly.lc;

import java.util.Arrays;

/**
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 *
 */

public class MoveZeroes {

	public static void main(String[] args) {
		int[] arr1 = {0,1,0,3,12};
		
		moveZeroes(arr1);

	}
	
    public static void moveZeroes1(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]==0){
                    nums[j]=nums[j+1];
                    nums[j+1]=0;
                }
            }
        
        System.out.println(Arrays.toString(nums));
    }
    
    
    public static void moveZeroes(int[] nums) {
    
    	int j=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        
        System.out.println(Arrays.toString(nums)+" j:"+j);
        
        while(j<nums.length) {
        	nums[j++]=0;
        }
        
        System.out.println(Arrays.toString(nums));
    }
    

}
