package com.testingfly.lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class ThirdLargestNumber {

	public static void main(String[] args) {
		Set<Integer> nums = new HashSet<>();
		nums.add(5);
		nums.add(2);
		nums.add(3);
		nums.add(7);
		
		System.out.println(thirdLargest1(nums));

	}
	
	public static int thirdLargest1(Set<Integer> set) {
		Object[] list = set.toArray();
		Arrays.sort(list);
		return (int)list[(int)list.length-3];
	}
	
	/*
	 * Using anonymous class, arrayutils, etc.
	 */
	public static int thirdLargest2(Set<Integer> set) {
		//Integer[] list = (Integer[])set.toArray();
		//Integer[] list = set.toArray(new Integer[] {});
		int[] list = (int[]) ArrayUtils.toPrimitive(set.toArray()) ;
		
		Arrays.sort(list);
		return (int)list[(int)list.length-3];
	}
	
	public static int thirdLargest(Set<Integer> set) {
		
		int largest=Integer.MIN_VALUE;
		int s_largest=Integer.MIN_VALUE;
		int t_largest=Integer.MIN_VALUE;
		
		System.out.println(set);
		for(int i : set) {
			
			if(i>largest){
				t_largest = s_largest;
				s_largest = largest;
				largest=i;
			}
			else if(i>s_largest) 
				s_largest=i;
			else if(i>t_largest)
				t_largest = i;
			
		}
		return t_largest;
	}

}
