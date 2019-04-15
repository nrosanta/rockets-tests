package com.testingfly.lc;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {

	public static void main(String[] args) {
		
		System.out.println(countAndSay1(7));
		System.out.println(countAndSay(7));
		getCount();

	}
	/*
	 * 1
	 * 11
	 * 21
	 * 1211
	 * 111221
	 * 312211
	 * 13112221
	 */
	
	/*
	 * brute force approach
	 */
    public static String countAndSay1(int n) {
    	Map<Integer, String> lookup = new HashMap<>();
    	lookup.put(1, "1");
    	lookup.put(2, "11");
    	
    	for(int i=3;i<=n;i++) {
    		String str = lookup.get(i-1);
    		String temp="";
    		for(int j=0;j<str.length();j++) {
    			int count=1;
    			char ch = str.charAt(j);
    			while(j+1<str.length() && ch==str.charAt(j+1)) {
	    			count++;
	    			j++;
	    		}
	    		temp = temp+count+ch;
    		}
    		lookup.put(i, temp);
    	}
        return lookup.get(n);
    }
    
    /*
     * alternate approach using regular expression .. increases runtime
     */
    public static String countAndSay2(int n) {
    	Map<Integer, String> lookup = new HashMap<>();
    	lookup.put(1, "1");
    	lookup.put(2, "11");
    	
    	for(int i=3;i<=n;i++) {
    		String str = lookup.get(i-1);
    		String temp="";
    		String s = str;
    		int len = str.length();
    		//for(int j=0;j<str.length();j++) {
    		while(!s.equals("")) {
    			char ch = s.charAt(0);
    			s = s.replaceAll("^"+ch+"*"+ch+".*?","");
    			//System.out.println(s);
    			int count = len-s.length();
    			len = s.length();
	    		temp = temp+count+ch;
    		}
    		lookup.put(i, temp);
    	}
        return lookup.get(n);
    }
    
    /*
     * alternate approach using 2 loops and StringBuilder
     */
    public static String countAndSay(int n) {
    	if(n==1) return "1";
    	if(n==2) return "11";
    	StringBuilder sb = null;
    	String str = "11$";
    	for(int i=3;i<=n;i++) {
    		sb = new StringBuilder();
    		int count=1;
    		for(int j=1;j<str.length();j++) {
    			if(str.charAt(j-1)!=str.charAt(j)) {
    				sb.append(count);
    				sb.append(str.charAt(j-1));
    				count=1;
    				
    			}else
    				count++;
    			
    		}
    		str = sb.toString()+"$";
    		
    	}
        return sb.toString();
    }
    
    public static void getCount() {
    	String s = "34433344";  
    	int count = s.length()-s.replaceAll("^3*3.*?","").length();  
    	System.out.println(count);
    }

}
