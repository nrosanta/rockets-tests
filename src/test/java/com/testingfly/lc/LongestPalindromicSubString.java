package com.testingfly.lc;

/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromicSubString {

	public static void main(String[] args) {
		
	}
	
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return new String("");

		boolean[][] dp = new boolean[s.length()][s.length()];
		int left = 0, right = 0;
		int max = 0;
		for (int j = 0; j < s.length(); j++)
			for (int i = j; i >= 0; i--) {
				if (i == j)
					dp[i][j] = true;
				else if (s.charAt(i) == s.charAt(j)) {
					if (i < j - 1)
						dp[i][j] = dp[i + 1][j - 1];
					else
						dp[i][j] = true;
				} else
					dp[i][j] = false;

				if (dp[i][j] && max < (j - i + 1)) {
					left = i;
					right = j;
					max = j - i + 1;
				}
			}

		return s.substring(left, right + 1);
	}
}