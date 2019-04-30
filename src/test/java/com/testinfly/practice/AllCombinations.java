package com.testinfly.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombinations {

	public static void main(String[] args) {
		System.out.println(getCombinations(2));

	}
	
	public static List<String> getCombinations(int n){
		List<String> list = new ArrayList<>();
		char[] str = {'a','b','c'};
		return getCombinations(list, str, 0, str.length);
	}
	
	public static List<String> getCombinations(List<String> list, char[] str, int left, int right){
		if(left==right)
			list.add(Arrays.toString(str));
		else
			for(int i=left;i<right;i++) {
				swap(str, left, i);
				getCombinations(list, str, left+1, right);
				swap(str, left, i); //backtrack
			}
		return list;
	}
	
	public static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

}
