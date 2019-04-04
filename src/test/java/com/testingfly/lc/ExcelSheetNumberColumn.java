package com.testingfly.lc;

public class ExcelSheetNumberColumn {

	public static void main(String[] args) {
		System.out.println(titleToNumber("XFD"));
		System.out.println(titleToNumber1("XFD"));

	}

	public static int titleToNumber(String s) {
		int num = 0, j=0;
		for(int i=s.length()-1;i>0;i--) {
			num = num + (s.charAt(j)-64)*(int)(Math.pow(26,i)) ;
			j++;
		}
		return num + s.charAt(j)-64;
	}
	
	/*
	 * alternate recursive solution
	 */
	public static int titleToNumber1(String s) {
		return getNumber(s, s.length());
	}
	
	public static int getNumber(String s, int n) {
		if(n==0)
			return 0;
		return getNumber(s, n-1);
	}


}
