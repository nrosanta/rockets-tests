package com.testinfly.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KMostFrequent {

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3,3,3};
		int k=2;
		System.out.println(Arrays.toString(kMostFrequent(arr,k)));

	}
	/*
	 * sort the array
	 * load it to a hash table
	 * build a priority queue based on frequency
	 * loop through the priority queue and dequeue when size greater than k
	 * 
	 * Runtime will be O(NlogN)
	 */
	static int[] kMostFrequent(int[] arr, int k) {
		Arrays.sort(arr);
		Map<Integer, Integer> count = new HashMap<>();
		for(int i : arr) {
			count.put(i, count.getOrDefault(i, 0)+1);
		}
		
		Queue<Integer> pq = new PriorityQueue<>((n1,n2)->(count.get(n1)-count.get(n2)));
		for(int key : count.keySet()) {
			pq.add(key);
			if(pq.size()>k)
				pq.poll();
		}
		
		List<Integer> res = new ArrayList<>();
		while(!pq.isEmpty())
			res.add(pq.poll());
		
		Collections.reverse(res);
		return res.stream().mapToInt(i->i).toArray();
	}

}
