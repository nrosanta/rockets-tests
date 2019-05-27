package com.testinfly.practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

	public static void main(String[] args) {
		int[] arr1= {13,12,8,23,4,3,11,5};
		System.out.println(getKthElement(arr1, 4));
		

	}
	
	public static int getKthElement(int[] arr, int k) {
		//Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> pq = new PriorityQueue<>();
		
		for(int i : arr) {
			pq.add(i);
			if(pq.size()>k)
				pq.poll();
		}
		
		//System.out.println(pq);
		return pq.poll();
	}

}
