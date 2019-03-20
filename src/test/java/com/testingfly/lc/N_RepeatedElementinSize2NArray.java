package com.testingfly.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of
 * these elements is repeated N times. Return the element repeated N times.
 * 
 * Example 1: Input: [1,2,3,3] Output: 3
 * 
 * Example 2: Input: [2,1,2,5,3,2] Output: 2
 * 
 * Example 3: Input: [5,1,5,2,5,3,5,4] Output: 5
 * 
 * Note:
 * 
 * 4 <= A.length <= 10000
 * 
 * 0 <= A[i] < 10000
 * 
 * A.length is even
 *
 */

public class N_RepeatedElementinSize2NArray {

	public static void main(String[] args) {
		int[] num1 = {5,1,5,2,5,3,5,4};
		int[] num2 = {1,2,3,3};
		int[] num3 = {2,1,2,5,3,2};
		
		System.out.println("Element: "+repeatedNTimes(num1));
		System.out.println("Element: "+repeatedNTimes(num2));
		System.out.println("Element: "+repeatedNTimes(num3));

	}

	public static int repeatedNTimes(int[] A) {
		Map<Integer, Integer> nMap = new HashMap<>();
		for(int i:A) {
			nMap.put(i, (nMap.getOrDefault(i, 0)+1));
			if(nMap.get(i)>1) return i;
			
		}
		
		return 0;
	}

}
