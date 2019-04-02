package com.testingfly.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		
		System.out.println(isAnagram3("aa","bb")); //false
		System.out.println(isAnagram3("cat","atc")); //true
		System.out.println(isAnagram3("aabbbb","aaaabb")); //false
		
	}

	public static boolean isAnagram1(String s, String t) {

		Map<Character, Integer> mapS = new HashMap<>();
		Map<Character, Integer> mapT = new HashMap<>();

		for (char ch : s.toCharArray())
			mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);

		for (char ch : t.toCharArray())
			mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);

		if (mapT.equals(mapS))
			return true;

		return false;
	}

	public static boolean isAnagram2(String s, String t) {

		char[] s1 = s.toCharArray();
		char[] s2 = t.toCharArray();

		Arrays.sort(s1);
		Arrays.sort(s2);

		if (Arrays.toString(s1).equals(Arrays.toString(s2)))
			return true;

		return false;
	}

	public static boolean isAnagram3(String s, String t) {
		if(s.length()==t.length()) {
			int count=0;
			int x=0,y=0;
			for(int i = 0; i<s.length();i++) {
				count = count ^ s.charAt(i)^t.charAt(i);
				x = x|s.charAt(i);
				y = y|t.charAt(i);
			}
			if(count==0 && x==y)
				return true;
		}
		
		return false;
	}

}
