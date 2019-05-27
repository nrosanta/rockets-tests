package com.testinfly.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class CountCandy {
	
	public static void main(String[] args) {
		int[] arr1 = {2,2,2,3,3,3,4,4,4,5,5,5};//4
		int[] arr2 = {2,2,3,3,5,5,5,5};//3
		int[] arr3 = {1,2,3,4,5,5,5,2};//4
		int[] arr4 = {1,1,1,1};//1
		int[] arr5 = {1,1,1,2,2,2,3,3,3,4,4,4};//4
		int[] arr6 = {3, 4, 7, 7, 6, 6};  //3
		int[] arr7 = {80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789}; //3
		
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
		System.out.println(solution(arr3));
		System.out.println(solution(arr4));
		System.out.println(solution(arr5));
		System.out.println(solution(arr6));
		System.out.println(solution(arr7));
	}

	public static int solution1(int[] T) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int i : T) 
			count.put(i, count.getOrDefault(i, 0) + 1);
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return count.get(o2)-count.get(o1);
			}
			
		};
		
		//Queue<Integer> queue = new PriorityQueue<>((a, b) -> (count.get(b) - count.get(a)));
		Queue<Integer> queue = new PriorityQueue<>(comp);
		for (int key : count.keySet()) {
			queue.add(key);
		}
		
		int sum=0;
		int res = 0;
		
		while (!queue.isEmpty()) {
			int key = queue.poll();
			sum = sum + count.get(key);
			if(count.get(key)>1) {
				sum=sum-1;
				res++;
			}
			if (sum >= T.length / 2)
				break;
		}

		return queue.size()+res;
	}
	
	
	public static int solution2(int[] T) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int i : T) 
			count.put(i, count.getOrDefault(i, 0) + 1);

		Queue<Integer> pk = new PriorityQueue<>(Collections.reverseOrder());
		for (Entry<Integer, Integer> entry : count.entrySet()) {
			pk.add(entry.getValue());
		}
		
		int k = T.length/2;
		while (k>0) {
			int val = pk.poll();
			val--;
			if(val>0)
				pk.add(val);
			k--;
		}

		return pk.size();
	}
	
	
	public static int solution(int[] T) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int i : T) 
			count.put(i, count.getOrDefault(i, 0) + 1);

		Queue<Integer> pk = new PriorityQueue<>(Collections.reverseOrder());
		for (int key : count.keySet()) {
			pk.add(count.get(key));
		}
		
		int k = T.length/2;
		while (k>0) {
			int val = pk.poll();
			val--;
			if(val>0) pk.add(val);
			k--;
		}

		return pk.size();
	}
	

}