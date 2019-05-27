package com.testinfly.practice;

public class StringtoNumber {

	public static void main(String[] args) {
		String num = "12345";
		System.out.println(toNumber1(num));
	}

	public static int toNumber(String str) {

		int n = 0;
		for (char c : str.toCharArray()) {
			n = n * 10 + Character.getNumericValue(c);
			
		}

		return n;
	}
	
	public static int toNumber1(String str) {

		int res = 0;
		int n = 1;
		for (int i=str.length()-1;i>=0;i--) {
			res = Character.getNumericValue(str.charAt(i))*n + res;
			n = n*10;
			
		}

		return res;
	}

}
