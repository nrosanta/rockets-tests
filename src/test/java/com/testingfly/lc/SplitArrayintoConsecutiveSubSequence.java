package com.testingfly.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Counter {
	Map<Integer, Integer> map = new HashMap<>();
	public void add(int k, int v) {
		map.put(k, get(k)+v);
	}
	public int get(int k) {
		return map.containsKey(k)?map.get(k):0;
	}
	
	public void print() {
		System.out.println(map);
	}
}

public class SplitArrayintoConsecutiveSubSequence {
	public static void main(String[] args) {
		int[] nums = { 1,2,3,3,4,4,5,5};
		System.out.println(isPossible(nums));
	}

	public static boolean isPossible(int[] nums) {
		Counter count = new Counter();
		Counter tails = new Counter();
		for (int x : nums)
			count.add(x, 1);
		
		//count.print();
		
		
		for (int x : nums) {
			if (count.get(x) == 0) {
				continue;
			} else if (tails.get(x) > 0) {
				tails.add(x, -1);
				tails.add(x + 1, 1);
			} else if (count.get(x + 1) > 0 && count.get(x + 2) > 0) {
				count.add(x + 1, -1);
				count.add(x + 2, -1);
				tails.add(x + 3, 1);
			} else {
				return false;
			}
			count.add(x, -1);
			count.print();
			tails.print();
		}
		return true;
	}
	


	public static boolean isPossible1(int[] nums) {

		Integer prev = null;
		int prevCount = 0;
		Queue<Integer> starts = new LinkedList<>();
		int last_index = 0; // index of the first occurrence of t
		for (int i = 0; i < nums.length; ++i) {
			int t = nums[i];
			if (i == nums.length - 1 || nums[i + 1] != t) {
				int count = i == 0 ? 1 : i - last_index; // current index - last_index to get the current count
				System.out.println("count: " + count);

				// If prev != t - 1, the consecutive sequence is broken, so we should try to
				// close any valid sequences at prev
				if (prev != null && t - prev != 1) {
					while (prevCount-- > 0)
						if (prev < starts.poll() + 2) // if subset is <3, return false
							return false;
					// we are building a consecutive sequence with at least three integers,
					// so if prev < starts.poll() + 2, it is impossible to build the sequence.

					prev = null;
					// consecutive sequence is broken, so we start over again.
				}

				// Current integer is either the first number of a new sequence,
				// or the next valid integer in a consecutive sequence.
				if (prev == null || t - prev == 1) {
					// sequences end at 'prev'
					while (prevCount > count) {
						prevCount--;
						if (t - 1 < starts.poll() + 2) // if subset is <3, return false
							return false;
					}
					// sequences start at 't'
					while (prevCount++ < count)
						starts.add(t);
				}
				prev = t;
				prevCount = count;
				last_index = i;
			}
			// else, nums[i+1] == t
			// do nothing but increasing i by 1
		}

		// The consecutive sequences continue till the end of the array
		// so close all of them if possible.
		while (prevCount-- > 0)
			if (nums[nums.length - 1] < starts.poll() + 2)
				return false;
		return true;
	}
}

class InitialAttempt {
	/*
	 * - Capture count in a hashmap - Load data to a min heap - Generate sequence
	 * based on the heap - if sequence not consecutive, return false - Decrease
	 * count with each pop - After each pop, do a peek and check count - if count is
	 * >1 proceed, otherwise, reset sequence
	 */
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int i : nums)
			count.put(i, count.getOrDefault(i, 0) + 1);

		// Queue<Map.Entry<Integer, Integer>> heap = new
		// PriorityQueue<>((n1,n2)->n1.getValue()-n2.getValue());
		Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			q.offer(entry);
		}

		List<Integer> list = new ArrayList<>();
		while (!q.isEmpty()) {
			Map.Entry<Integer, Integer> entry = q.poll();
			int num = entry.getKey();
			int x = entry.getValue();

			if (x > 0) {
				list.add(num);
				x = x - 1;
				entry.setValue(x);
				if (x > 0)
					q.add(entry);
				// System.out.println("x: "+x);
				System.out.println("q: " + q);
			}

			if (q.size() > 0 && num + 1 != q.peek().getKey() && q.peek().getValue() < 2) {
				System.out.println(list);
				if (list.size() < 3)
					return false;
				list = new ArrayList<>();
			}
		}

		return true;
	}
}