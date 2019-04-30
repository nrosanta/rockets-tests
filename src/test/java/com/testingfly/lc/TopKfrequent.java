package com.testingfly.lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;


public class TopKfrequent {

	public static void main(String[] args) {
		
		int[] arr1 = {1,1,2,2,2,3,4,1,5,8};
		System.out.println(topKFrequent(arr1,2));

	}
	
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        
        //System.out.println(count);
        
        Comparator<Integer> compareCount = new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				return count.get(n1)-count.get(n2);
			}
        };
        
        /*
         * Shortened lambda expression
         */
        //PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->count.get(n1)-count.get(n2));
        PriorityQueue<Integer> pq = new PriorityQueue<>(compareCount);
        
        for(int key: count.keySet()) {
        	pq.add(key);
        	if(pq.size()>k) {
        		pq.poll();
        	}
        }
        
        //System.out.println(pq);
        
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
        	list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
        	
    }
	
	

}
