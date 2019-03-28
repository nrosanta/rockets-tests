package com.testingfly.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * A self-dividing number is a number that is divisible by every digit it
 * contains.
 * 
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 ==
 * 0, and 128 % 8 == 0.
 * 
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * 
 * Given a lower and upper number bound, output a list of every possible self
 * dividing number, including the bounds if possible.
 * 
 * Example 1:
 * 
 * Input: left = 1, right = 22 Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15,
 * 22] Note:
 * 
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 *
 */
public class SelfDividingNumbers {

	public static void main(String[] args) {
		System.out.println(selfDividingNumbers1(1,22));
		System.out.println(selfDividingNumbers1(66,708));

	}
	
    public static List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> list = new ArrayList<>();
    	while(left<=right) {
    		int temp=left;
    		
    		while(temp>0) {
    			if(temp%10==0 || left%(temp%10)!=0)
    				break;
    			temp=temp/10;
    		}
    		if(temp==0)
    			list.add(left);
    		left++;
    	}
    	
		return list;
        
    }
    
    
    //Alternate approach - modularized
    public static List<Integer> selfDividingNumbers1(int left, int right) {
    	List<Integer> list = new ArrayList<>();
    	while(left<=right) {
    		
    		if(isDivisible(left))
    			list.add(left);
    		left++;
    	}
    	
		return list;
        
    }
    
    public static boolean isDivisible(int num) {
    	int left = num;
    	while(num>0) {
			if(num%10==0 || left%(num%10)!=0)
				return false;
			num=num/10;
		}
    	return true;
    }

}
