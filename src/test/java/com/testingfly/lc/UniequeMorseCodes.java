package com.testingfly.lc;

import java.util.HashSet;
import java.util.Set;

public class UniequeMorseCodes {

	public static void main(String[] args) {
		String[] words = { "gin", "zen", "gig", "msg" };
		System.out.println("Count: " + uniqueMorseRepresentations(words));

	}

	public static int uniqueMorseRepresentations(String[] words) {

		if (words.length == 0)
			return 0;
		
		String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
				"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

		Set<String> count = new HashSet<>();

		for (int i = 0; i < words.length; i++) {
			String trans = "";
			for (int j = 0; j < words[i].length(); j++) {
				trans = trans + morseCodes[Integer.valueOf(words[i].charAt(j)) - 97];
			}
			count.add(trans);
		}

		return count.size();

	}
	
	public static int uniqueMorseRepresentations1(String[] words) {

		if (words.length == 0)
			return 0;
		
		String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
				"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

		Set<String> count = new HashSet<>();

		for (String word: words) {
			StringBuilder trans = new StringBuilder();
			for (char c: word.toCharArray()) {
				trans.append(morseCodes[c-'a']);
			}
			count.add(trans.toString());
		}

		return count.size();

	}

}
