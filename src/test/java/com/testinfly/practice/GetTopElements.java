package com.testinfly.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class GetTopElements {

	public static void main(String[] args) {
		
		int[] nums1 = {1,1,1,2,3,2,2,4,2,5,6,5,5,8,9,2};
		System.out.println(topElements(nums1, 3));

	}
	
	public static List<Integer> topElements(int[] nums, int k){
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> count = new HashMap<>();
		for(int i=0;i<nums.length;i++) 
			count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
			
		Comparator<Integer> compareCount = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return count.get(o1) - count.get(o2);
			}
			
		};
		
		//PriorityQueue<Integer> pq = new PriorityQueue<>(compareCount);
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->count.get(n1)-count.get(n2));
		
		
		for(int key : count.keySet()) {
			pq.add(key);
			if(pq.size()>k)
				pq.poll();
		}
		
		for(int i : pq) {
			list.add(i);
		}
		
		Collections.reverse(list);
		return list;
	}
	
	
	


}
