package com.testingfly.lc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {
	
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding", "love", "coding"};
		System.out.println(topKFrequent(words, 3));
				
	}

	public static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> count = new HashMap<>();
		for (String s : words)
			count.put(s, count.getOrDefault(s, 0) + 1);

		Queue<String> heap = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (count.get(s1) != count.get(s2))
					return count.get(s2) - count.get(s1);
				else
					return s1.compareTo(s2);
			}
		});

		for (String s : count.keySet())
			heap.add(s);

		List<String> list = new ArrayList<>();
		while (k > 0) {
			list.add(heap.poll());
			k--;
		}
		return list;
	}
}