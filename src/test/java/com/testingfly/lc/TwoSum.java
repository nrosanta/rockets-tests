package com.testingfly.lc;

import java.util.*;

public class TwoSum {

	public static void main(String[] args) {
		int nums1[] = {2, 7, 11, 15};
		int target1 = 9;
		int nums2[] = {-1,-2,-3,-4,-5};
		int target2 = -8;
		int nums3[] = {3, 2, 4};
		int target3 = 6;
		
		//System.out.println("TwoSum: "+Arrays.toString(twoSum(nums1, target1)));
		//System.out.println("TwoSum: "+Arrays.toString(twoSum(nums2, target2)));
		System.out.println("TwoSum: "+Arrays.toString(twoSumHash(nums3, target3)));

	}
	
    public static int[] twoSum(int[] nums, int target) {
        if(nums.length==0) return nums;
        int temp[] = {0,1};
        //Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));

        for(int i=0;i<nums.length;i++) {
        	int ele = target-nums[i];        	
        	//System.out.println("j: "+ele);
        	int j = searchEle(nums, ele);
        	
        	if(j>-1 && j<nums.length && nums[i]+nums[j]==target && i!=j && j!=-1 ) {
        		//System.out.println("j: "+i+","+j);
        		temp[0]=i;
        		temp[1]=j;
        		break;
        	}
        		
        }
        

        return temp;
        
    }
    
    public static int searchEle(int nums[], int ele ) {
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]==ele)
    			return i;
    	}
    	
		return -1;
    }
    
    //Binary Search
    public static int binSearch(int nums[], int left, int right, int ele ) {
    	if(right>0) {
	    	int pivot = (left+right)/2;
	    	//System.out.println("pivot: "+pivot+" left: "+left+" right: "+right);
	    	if(nums[pivot]==ele)
	    		return pivot;
	    	if(nums[pivot]>ele) 
				return binSearch(nums, left, pivot-1, ele);
			else
				return binSearch(nums, pivot+1, right, ele);
    	}
    	String s1="12"; s1.charAt(1);
    	
		return -1;
    }
    
    
    
    public static int[] twoSumHash(int[] nums, int target) {
    	if(nums.length==0) return nums;
    	Map<Integer, Integer> hMap = new HashMap<>();
    	for(int i=0;i<nums.length;i++) {
    		int ele = target-nums[i];
    		if(hMap.containsKey(ele))
    			return new int[] {i, hMap.get(ele)};
    		else {
    			hMap.put(nums[i], i);
    		}
    			
    	}
        return new int[] {};
        
    }

}
