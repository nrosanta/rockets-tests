package com.testingfly.lc;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique_numbers = new HashSet<>();
        for(int i=0;i<nums.length;i++)
            unique_numbers.add(nums[i]);
        
        if(unique_numbers.size()==nums.length)
            return false;
            
        return true;
        
    }

}
