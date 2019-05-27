package com.testinfly.practice;

import java.util.Arrays;

public class ReverseWordsCharArray {

	public static void main(String[] args) {
		
		char[] words = {'t','e','s','t',' ','a',' ','i','s',' ','t','h','i','s'};
		System.out.println(words);
		System.out.println(reverseWords(words));
		//abc de fgh
		
		

	}

	static char[] reverseWords(char[] words) {
		words = strReverse(words, 0, words.length);
		//System.out.println("Reversed words: "+ Arrays.toString(words));
		int start = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i] == ' ' || i == words.length-1) {
				int end = i;
				if(i==words.length-1)
					end++;
				strReverse(words, start, end);
				start=end+1;
			}
		}
		return words;
	}

	
	static char[] reverseStr(char[] word, int start, int end) {
		
		while(start!=end){
			char temp = word[start];
			word[start] = word[end-1];
			word[end-1] = temp;
			start++;
			end--;
		}
		return word;
	}
	
	static char[] strReverse(char[] ca, int left, int right) {
		
		while(left<right) {
			char temp = ca[left];
			ca[left] = ca[right-1];
			ca[right-1]=temp;
			left++;
			right--;
		}
		
		return ca;
	}

}
