package com.testingfly.lc;

import java.util.Arrays;

public class ValidPalindrome {

	/*
	 * remove non-alpha numeric chars
	 */
	public static void main(String[] args) {
		
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "0P";
		String s3 = "`l;`` 1o1 ??;l`";
		System.out.println(isPalindrome(s1));
		System.out.println(isPalindrome(s2));
		System.out.println(isPalindrome(s3));
		
		System.out.println();
		
		System.out.println(isPalindrome2(s1));
		System.out.println(isPalindrome2(s2));
		System.out.println(isPalindrome2(s3));

	}
	
    public static boolean isPalindrome(String s) {
    	String str = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
    	for(int i=0;i<str.length()/2;i++) {
    		if(str.charAt(i)!=str.charAt(str.length()-i-1))
    			return false;
    	}
        return true;
    }
    
    
    /*
     * 0-9
     * 65-122
     */
    public static boolean isPalindrome1(String str) {
    	StringBuilder sb = new StringBuilder();
    	for(char c : str.toCharArray()) {
    		if(c>=48 && c<=57 || c>=65 && c<=90 || c>=97 && c<=122) {
    			if(c>=65 && c<97)
    				c=(char) (c+32);
    			sb.append(c);
    		}
    	}
    	str = (String)sb.toString();
    	for(int i=0;i<str.length()/2;i++) {
    		if(str.charAt(i)!=str.charAt(str.length()-i-1))
    			return false;
    	}
    	
    	return true;
    }
    
    
    public static boolean isPalindrome2(String str) {
       	int j=0,k=str.length()-1;
    	while(j!=k && j<str.length() && k>=0) {
    		char c1 = str.charAt(j);
    		char c2 = str.charAt(k);
    		if(isAlphaNumeric(c1)) {
    			if(isAlphaNumeric(c2)) {
    				if(toLowerCase(c1)!=toLowerCase(c2))
    	    			return false;
    				else {
    					j++;
    					k--;
    				}
    			}
    			else 
    				k--;
    	    }
    		else
    			j++;
    	}
    	return true;
    }
    
    public static boolean isAlphaNumeric(char ch){
    	
        if(ch>=48 && ch<=57 || ch>=65 && ch<=90 || ch>=97 && ch<=122) 
    			return true;
        return false;
    }
    
    public static char toLowerCase(char ch){
        if(ch>=65 && ch<97)
    		ch=(char) (ch+32);
        return ch;
    }

}
