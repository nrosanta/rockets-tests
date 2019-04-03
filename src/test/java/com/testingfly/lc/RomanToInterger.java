package com.testingfly.lc;

public class RomanToInterger {

	public static void main(String[] args) {

		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));

	}

	public static int romanToInt(String s) {
		
		int num = 0;

		for (int i = 0; i < s.length(); i++) {

			if (i + 1 < s.length() && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
				num = num + 4;
				i++;
			} else if (i + 1 < s.length() && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
				num = num + 9;
				i++;
			} else if (i + 1 < s.length() && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
				num = num + 40;
				i++;
			} else if (i + 1 < s.length() && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
				num = num + 90;
				i++;
			} else if (i + 1 < s.length() && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
				num = num + 400;
				i++;
			} else if (i + 1 < s.length() && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
				num = num + 900;
				i++;
			}

			else

				switch (s.charAt(i)) {

				case 'I':
					num = num + 1;
					break;
				case 'V':
					num = num + 5;
					break;
				case 'X':
					num = num + 10;
					break;
				case 'L':
					num = num + 50;
					break;
				case 'C':
					num = num + 100;
					break;
				case 'D':
					num = num + 500;
					break;
				case 'M':
					num = num + 1000;

				}
		}

		return num;

	}
}