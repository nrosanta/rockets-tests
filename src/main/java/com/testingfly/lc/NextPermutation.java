package com.testingfly.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextPermutation {

	public static void main(String[] args) {
	    int[] num1 = {1,2,3};
	    int[] num2 = {1,2};
	    int[] num3 = {2,1,8,7,6,5};
	    int[] num4 = {3,2,1};
	    int[] num5 = {4,2,0,2,3,2,0}; //Expected: "[4,2,0,3,0,2,2]"
	    int[] num6 = {1,3,2};
	    int[] num7 = {4,5,6,3,2,1};
	    int[] num8 = {1,3,2};

	    nextPermutation(num1);
	    nextPermutation(num2);
	    nextPermutation(num3);
	    nextPermutation(num4);
	    nextPermutation(num5);
	    nextPermutation(num6);
	    nextPermutation(num7);
	    nextPermutation(num8);
	    
	    sort(num7,0,num7.length-1);
	    //System.out.println("Sorted: "+Arrays.toString(num7));

	}
	public static void nextPermutation(int[] nums) {
		//Input:  n = "[4,2,0,2,3,2,0]"
		//Expected: "[4,2,0,3,0,2,2]"
		//4,2,0,2,3,2,0
		//4,2,0,3,2,2,0
		
		System.out.println("Input:  "+Arrays.toString(nums));
		int left=-1;
		if(nums.length>1)
		for(int i=nums.length-1;i>0;i--) {
			
			if(nums[i]>nums[i-1]) {
				left=i-1;
				break;
			}
		}
		Arrays.sort(nums, left+1,nums.length);
		System.out.println("nums: "+Arrays.toString(nums));
		System.out.println("left: "+left);
		if(left>-1) {
			int pivot = findPivot(nums, nums[left], left+1);
			System.out.println("pivot: "+pivot);		
			swap(nums, left,pivot );
		}
		System.out.println("Output: "+Arrays.toString(nums)+"\n");
		
	}
	
	  public static int findPivot(int nums[], int pivot, int begin) {
		  for(int i=begin;i<nums.length;i++) {
			  if(nums[i]>pivot) {
				  return i;
			  }
		  }
		  return 0;
	  }
	  
	  public static void swap(int nums[], int i, int j) {
		  int temp = nums[i];
		  nums[i] = nums[j];
		  nums[j] = temp;
	  }
	
	  public static int[] sort(int nums[], int left, int right) {
		  int j=left;
		  while(j<right) {
			 for(int i=left;i<right;i++) {
			  if(nums[i]>nums[i+1]) {
				  int temp = nums[i];
				  nums[i]=nums[i+1];
				  nums[i+1]=temp;
			  }
			 }
			  j++;
			  
			  
			  
		  }
		  
		  return nums;
	  }
	
	/*
	  public static void nextPermutation_old(int[] nums) {
	    	
	        Map<Integer, String> data = new HashMap<>();
	    	data.put(0, "Zero");
	    	data.put(1, "One");
	    	data.put(2, "Two");
	    	data.put(3, "Three");
	    	data.put(4, "Four");
	    	data.put(5, "Five");
	    	data.put(6, "Six");
	    	data.put(7, "Seven");
	    	data.put(8, "Eight");
	    	data.put(9, "Nine");

	    	if(nums.length!=0)
	        for(int j=0;j<nums.length-1;j++) {
	        	String comp1 = "", comp2="";
	    		String tempStr = Integer.toString(nums[j]);
	    		for(int k=0;k<tempStr.length();k++) {
	    			comp1 = comp1+data.get(Integer.parseInt(tempStr.substring(k,k+1)));
	    		}
	    		
	    		tempStr = Integer.toString(nums[j+1]);
	    		for(int k=0;k<tempStr.length();k++) {
	    			comp2 = comp2+data.get(Integer.parseInt(tempStr.substring(k,k+1)));
	    		}
	    		System.out.println("comp1: "+comp1 +" comp2: "+comp2);
	        	
	        	if(comp1.compareTo(comp2)>0) {
	        		int temp = nums[j];
	        		nums[j]=nums[j+1];
	        		nums[j+1]=temp;
	        	}
	        }
	        
	        System.out.println(Arrays.toString(nums));
	        
	    }

*/
	  public static void nextPermutation1(int[] nums) {
		  //Input:  n = "[4,2,0,2,3,2,0]"
		  //Expected: "[4,2,0,3,0,2,2]"
		  int temp = 0;
		  boolean flg = false;
		  if(nums.length>1) {
			  for(int i=nums.length-1;i>0;i--) {
				  temp = nums[i];
				  System.out.println("num_i: "+nums[i]);
				  for(int j=i;j>-1;j--) {
					  System.out.println(" 	nums_j: "+nums[j]);
					  System.out.println(" 	j: "+j);
					  
					  if(temp>nums[j]) {
						 System.out.println("\tCondition: true");
						 temp=nums[j];
						 nums[j]=nums[i];
						 nums[i]=temp;
						 temp=j;
						 System.out.println("\tAfter swap: "+Arrays.toString(nums));
						 System.out.println("\ttemp: "+temp);
						 i=0;
						 flg = true;
						 break;
					  }
					  
				  }
				  System.out.println("\tnum: "+Arrays.toString(nums));
			  }

		  }
		  if(flg==false)
			  temp=0;
		  else
			  temp++;
		  System.out.println("Before Sort: "+Arrays.toString(nums));
		  
		  nums = sort(nums, temp);
		  
		  System.out.println("After Sort:  "+Arrays.toString(nums));
		  System.out.println("temp: "+temp);
	  }
	  
	  public static int[] sort(int nums[], int index) {
		  for(int j=index;j<nums.length;j++)
		  for(int i=index;i<nums.length;i++) {
			  int temp = nums[i];
			  if(nums[j]<nums[i]) {
				  nums[i]=nums[j];
				  nums[j]=temp;
				  
			  }
		  }
		  return nums;
	  }
	  
}
