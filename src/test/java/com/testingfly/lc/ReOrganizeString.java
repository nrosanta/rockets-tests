package com.testingfly.lc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReOrganizeString {
	public static void main(String[] args) {
		String str = "abaab";
		System.out.println(reorganizeString(str));
	}

	public static String reorganizeString(String S) {
		Map<Character, Integer> count = new HashMap<>();
		for (char c : S.toCharArray())
			count.put(c, count.getOrDefault(c, 0) + 1);
		// System.out.println(count);
		Queue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>((n1,
				n2) -> (n2.getValue() == n1.getValue()) ? n1.getKey() - n2.getKey() : n2.getValue() - n1.getValue());

		StringBuilder res = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : count.entrySet()) {
			heap.add(entry);
			if (entry.getValue() > (S.length() + 1) / 2)
				return "";
		}

		// System.out.println(heap);

		while (!heap.isEmpty()) {
			Map.Entry<Character, Integer> s1 = heap.poll();
			Map.Entry<Character, Integer> s2 = heap.poll();
			if (s1 != null)
				res.append(s1.getKey());

			if (s2 != null)
				res.append(s2.getKey());

			if (s1 != null && s1.getValue() - 1 > 0) {
				s1.setValue(s1.getValue() - 1);
				heap.add(s1);
			}
			if (s2 != null && s2.getValue() - 1 > 0) {
				s2.setValue(s2.getValue() - 1);
				heap.add(s2);
			}
		}
		return res.toString();

	}
}