package com.testingfly.lc;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.

	If there is no common prefix, return an empty string "".
	
	Example 1:
	
	Input: ["flower","flow","flight"]
	Output: "fl"
	Example 2:
	
	Input: ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] s1 = { "flower", "flow", "flight" };
		String[] s2 = { "dog", "racecar", "car" };
		String[] s3 = { "c", "c", };
		String[] s4 = { "aa", "a", };

		System.out.println(longestCommonPrefix(s1));
		System.out.println(longestCommonPrefix(s2));
		System.out.println(longestCommonPrefix(s3));
		System.out.println(longestCommonPrefix(s4));

	}

	/*
	 * vertical scanning approach
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length < 1)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i < strs[j].length() && (strs[0].charAt(i) == strs[j].charAt(i)))
					continue;
				else
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

}
