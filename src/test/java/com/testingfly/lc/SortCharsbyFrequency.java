package com.testingfly.lc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharsbyFrequency {
	public static void main(String[] args) {
		
		System.out.println(frequencySort("tree")); //eetr
		System.out.println(frequencySort("ete")); //eet
		System.out.println(frequencySort("cccaaa")); //aaaccc
	}
	
	 public static String frequencySort(String s) {
			Map<Character, Integer> count = new HashMap<>();
			for (char c : s.toCharArray()) {
				count.put(c, count.getOrDefault(c, 0) + 1);
			}
	        //System.out.println(count);
			Comparator<Character> comp = new Comparator<Character>() {
				@Override
				public int compare(Character n1, Character n2) {
					if(count.get(n2)!=count.get(n1))
						return count.get(n2)-count.get(n1);
					else 
						return n1-n2;

				}
				
			};
			
			//Queue<Character> pq = new PriorityQueue<>((n1, n2) -> count.get(n2) - count.get(n1));
			Queue<Character> pq = new PriorityQueue<>(comp);
			for (char c : s.toCharArray()) {
				pq.add(c);
			}
			
	        //System.out.println(pq.toString());
			String res="";
			while(!pq.isEmpty())
				res = res+pq.poll();
		    return res.toString().replace("[", "").replace("]", "").replace(", ", "");
	        
		}

	/*
	 * - Count frequency using hashtables - Load chars into a max heap - convert
	 * heap into string and return
	 */
	public static String frequencySort1(String s) {
		Map<Character, Integer> count = new HashMap<>();
		for (char c : s.toCharArray()) {
			count.put(c, count.getOrDefault(c, 0) + 1);
		}
		Comparator<Map.Entry<Character, Integer>> sortByFreq = new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> n1, Map.Entry<Character, Integer> n2) {
				return n2.getValue() - n1.getValue();
			}
		};
		//Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((n1, n2) -> n2.getValue()-n1.getValue());
		//Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(sortByFreq);
		Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> n1, Map.Entry<Character, Integer> n2) {
				return n2.getValue() - n1.getValue();
			}
		});
		
		for (Map.Entry<Character, Integer> entry : count.entrySet()) {
			pq.add(entry);
		}
		StringBuilder res = new StringBuilder();
		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			int x = entry.getValue();
			
			while(x>0) {
				res = res.append(entry.getKey());
				x--;
			}
		}
	    return res.toString();
        
	}
}

class SortCharsbyFrequency1 {
    public String frequencySort(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
		/*
		Here the anonymous class can be simplified to lambda expression:
		Queue<Map.Entry<Character, Integer>> heap = new new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
		*/
        Queue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                return Integer.compare(b.getValue(), a.getValue());
            }
        });
        for (char c : array) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            heap.offer(entry);
        }
        
        int count = 0;
        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> curr = heap.poll();
            for (int i = 0; i < curr.getValue(); i++) {
                array[count] = curr.getKey();
                count++;
            }
        }
        return new String(array);
    }
}