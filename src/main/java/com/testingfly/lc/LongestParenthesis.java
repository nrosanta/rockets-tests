package com.testingfly.lc;

import java.util.Stack;

public class LongestParenthesis {

	public static void main(String[] args) {
		String s1 = "((()";
		String s2 = "(()()";
		String s3 = "()(()))))";
		
		//System.out.println("Longest Valid Parenthesis for "+s1+":"+ longestValidParentheses(s1));
		//System.out.println("Longest Valid Parenthesis for "+s2+":"+ longestValidParentheses(s2));
		System.out.println("Longest Valid Parenthesis for "+s3+":"+ longestValidParentheses(s3));

	}
	
	 public static int longestValidParentheses(String s) {
	    	if(s.length()==0) return 0;
	        Stack<Integer> s1 = new Stack<Integer>();
	        //System.out.println("Input: "+s);
	        s1.push(-1);
	        int length = 0;
	        for(int i=0;i<s.length();i++) {
	        	//System.out.println("i: "+i+" stack: "+s1);
	        	if(s.charAt(i)=='(') {
	        		s1.push(i);
	        	}else {
	        		s1.pop();
	        		if(!s1.empty()) {
	        			length = Math.max(length, i-s1.peek());
	        		}else {
	        			s1.push(i);
	        		}
	        	}

	        }
	        
	        
	        return length;
	        
	    }

}
