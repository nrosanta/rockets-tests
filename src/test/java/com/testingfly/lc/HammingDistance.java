package com.testingfly.lc;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 ≤ x, y < 231.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 *
 */
public class HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance2(1, 4));

	}

	public static int hammingDistance(int x, int y) {
		String str = Integer.toBinaryString(x ^ y);
		int count = 0;
		for (char c : str.toCharArray())
			if (c == '1')
				count++;
		return count;

	}

	public static int hammingDistance1(int x, int y) {
		int num = x ^ y;
		int count = 0;
		while (num > 0) {
			if (num % 2 == 1)
				count++;
			num = num / 2;
		}

		return count;

	}

	public static int hammingDistance2(int x, int y) {
		x = x ^ y;
		y = 0;
		while (x > 0) {
			y += x & 1;
			x = x>>1;
		}
		return y;
	}

}
