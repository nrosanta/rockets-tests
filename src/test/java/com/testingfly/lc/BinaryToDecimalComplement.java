package com.testingfly.lc;

public class BinaryToDecimalComplement {

	public static void main(String[] args) {

		int num = 5;
		System.out.println(bitwiseComplement(num));
		System.out.println(bitwiseComplement1(num));
		System.out.println(bitwiseComplement2(num));

	}

	public static int bitwiseComplement(int N) {
		int num = 0;
		String s = Integer.toBinaryString(N);
		int k = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '1')
				k++;
			else {
				num = (int) (num + Math.pow(2, k++));
			}
		}
		return num;
	}

	/*
	 * Given a binary number B and its complement C
	 * 
	 * B+C = results in all 1's
	 * 
	 * ALL 1's in decimal = 2^(num of 1's i.e. length of the binary number) -1 
	 * 11 = 2^2-1 = 3 
	 * 111=2^3-1 = 7
	 * 
	 * Now, subtract the original num N from the above. This will result in the complement.
	 */
	public static int bitwiseComplement1(int N) {
		return (int) Math.pow(2, Integer.toBinaryString(N).length()) - 1 - N;
	}

	public static int bitwiseComplement2(int N) {
		String s = Integer.toBinaryString(N).replace('0', 'Z').replace('1', '0').replace('Z', '1');
		return Integer.parseInt(s, 2);
	}

}
