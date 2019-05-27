package com.testingfly.lc;

import java.util.Arrays;

/**
 * 
 * We have discussed Overlapping Subproblems and Optimal Substructure properties
 * in Set 1 and Set 2 respectively. We also discussed one example problem in Set
 * 3. Let us discuss Longest Common Subsequence (LCS) problem as one more
 * example problem that can be solved using Dynamic Programming.
 * 
 * LCS Problem Statement: Given two sequences, find the length of longest
 * subsequence present in both of them. A subsequence is a sequence that appears
 * in the same relative order, but not necessarily contiguous. For example,
 * “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * 
 * It is a classic computer science problem, the basis of diff (a file
 * comparison program that outputs the differences between two files), and has
 * applications in bioinformatics.
 * 
 * Examples: LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 *
 */
public class LongetestCommonSubSequence {
	static int counter = 0;
	static int[][] arr;
	static String str="";

	public static void main(String[] args) {

		String s1 = "ABCBBC"; // ABBC
		String s2 = "ABBCC";
		
		String s3 = "AGGTAB";
		String s4 = "GXTXAYB"; // GTAB
		String s5 = "BCBAC";
		String s6 = "BCADCA"; // BCAC
		String s7 = "BACAC";
		String s8 = "BCCAC"; // BCAC
		String s9 = "ABCDGH";
		String s10 = "AEDFHR"; // ADH
		String s11 = "BBDBACAAACA";
		String s12 = "BADABCBBCAC"; // BCAC

		arr = new int[s1.length() + 1][s2.length() + 1];
		initArr(arr);
		
		System.out.println("LCS: " + longestCS(s1, s2, s1.length(), s2.length()) + " Stacked Calls: " + counter);
		//System.out.println("LCS: "+str);
		printLCSArr(arr);
//		counter = 0;
		arr = new int[s3.length()+1][s4.length()+1];
		initArr(arr);
		System.out.println("LCS: " + longestCS(s3, s4, s3.length(), s4.length()) + " Stacked Calls: " + counter);
		printLCSArr(arr);
//		// System.out.println("Array_After: " + Arrays.deepToString(arr));
//
//		counter = 0;
//		arr = new int[s5.length()][s6.length()];
//		initArr(arr);
//		System.out.println("LCS: " + longestCS(s5, s6, s5.length(), s6.length()) + " Stacked Calls: " + counter);
//		// System.out.println("Array_After: " + Arrays.deepToString(arr));
//		counter = 0;
//		arr = new int[s7.length()][s8.length()];
//		initArr(arr);
//		System.out.println("LCS: " + longestCS(s7, s8, s7.length(), s8.length()) + " Stacked Calls: " + counter);
//		// System.out.println("Array_After: " + Arrays.deepToString(arr));
//		counter = 0;
//		arr = new int[s9.length()][s10.length()];
//		initArr(arr);
//		System.out.println("LCS: " + longestCS(s9, s10, s9.length(), s10.length()) + " Stacked Calls: " + counter);
//		// System.out.println("Array_After: " + Arrays.deepToString(arr));
//		counter = 0;
//		arr = new int[s11.length()][s12.length()];
//		initArr(arr);
//		System.out.println("LCS: " + longestCS(s11, s12, s11.length(), s12.length()) + " Stacked Calls: " + counter);
//		// System.out.println("Array_After: " + Arrays.deepToString(arr));
//
//		lcsStr(s11, s12);
//		LCS(s11, s12);

	}

	public static void lcsStr(String s1, String s2) {

		int len1 = s1.length();
		int len2 = s2.length();

		int[][] arr = new int[len1 + 1][len2 + 1];

		for (int i = 0; i < len1; i++)
			for (int j = 0; j < len2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i + 1][j + 1] = 1 + arr[i][j];
				} else {
					arr[i + 1][j + 1] = getMax(arr[i + 1][j], arr[i][j + 1]);
				}
			}

		System.out.println("\n\nLCS: " + arr[len1][len2]);

		showArr(arr);
		printLCS(arr, s1, s2);

	}

	public static void showArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				System.out.print(" " + arr[i][j]);
			System.out.println();
		}

	}

	public static void printLCS(int[][] arr, String s1, String s2) {

		int i = arr.length - 1;
		int j = arr[0].length - 1;
		int[] temp = new int[arr[i][j]];
		int index = temp.length - 1;

		while (i > 0 && j > 0) {
			// System.out.println("i:j->"+i+":"+j);
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				// System.out.print(s1.charAt(i - 1));
				temp[index--] = i;
				i--;
				j--;
			} else if (arr[i][j - 1] > arr[i - 1][j]) {
				j--;
			} else
				i--;
		}

		// System.out.println("\nTemp: " + Arrays.toString(temp));
		for (i = 0; i < temp.length; i++) {
			System.out.print(s1.charAt(temp[i] - 1));
		}

	}

	public static void initArr(int[][] arr) {
		for (int i = 1; i < arr.length; i++)
			for (int j = 1; j < arr[0].length; j++)
				arr[i][j] = -1;

		// System.out.println("Array_Before: " + Arrays.deepToString(arr));
	}

	// recursive solution
	public static int longestCS(String s1, String s2, int n1, int n2) {
		counter++;
		
		if (n1 == 0 || n2 == 0)
			return 0;
		
		if(arr[n1][n2]!=-1)
			return arr[n1][n2];
		
		if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
			arr[n1][n2]= longestCS(s1,s2,n1-1,n2-1)+1;
			return arr[n1][n2]; 
	
		} else {
			arr[n1] [n2] = Math.max(longestCS(s1, s2, n1 - 1, n2), longestCS(s1, s2, n1, n2 - 1)); 
			return arr[n1][n2];
		}

	}

	public static int getMax(int x, int y) {
		return (x > y) ? x : y;
	}

	public static void LCS(String s1, String s2) {
		int x = s1.length();
		int y = s2.length();
		int[][] L = new int[x + 1][y + 1];
		
		

		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					L[i + 1][j + 1] = 1 + L[i][j];
				} else {
					L[i + 1][j + 1] = getMax(L[i][j + 1], L[i + 1][j]);
				}
			}
		
		System.out.println("\n\nLCS: " + L[x][y]);

		showArr(L);
		printLCS(L, s1, s2);

	}
	
	static void printLCSArr(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++)
				System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
	}

}
