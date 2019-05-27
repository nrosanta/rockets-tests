package com.testingfly.lc;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInaStream {

	int k;
	Queue<Integer> heap;

	public static void main(String[] args) {

	}

	public KthLargestInaStream(int k, int[] nums) {
		this.k = k;
		heap = new PriorityQueue<>();
		for (int n : nums) {
			heap.add(n);
			if (heap.size() > k)
				heap.poll();
		}
	}

	public int add(int val) {
		heap.add(val);
		if (heap.size() > k)
			heap.poll();
		return heap.peek();
	}
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */