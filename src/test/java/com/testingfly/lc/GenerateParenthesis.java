package com.testingfly.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GenerateParenthesis {

    /*
        - load ()() to list
        - opening & closing braces should match
        - recursive calls to generate possible combinations and check validity
        - if valid add to list
    */
	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
		System.out.println(generateParenthesis1(1));
	}
	
	/*
	 * brute force approach with all combinations
	 */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> tempSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append("()");

        //System.out.println(sb);
        set =  generateParenthesis(set,tempSet, sb, 0, sb.length()-1);
        for(String str : set)
            list.add(str);
        
        return list;
    }
    
    public static Set<String> generateParenthesis(Set<String> set, Set<String> tempSet, StringBuilder s, int l, int r){
        
        if(l==r && isValid(s))
            set.add(s.toString());
        else
        for(int i=l;i<=r;i++){
            StringBuilder temp = s;
            char c = temp.charAt(l);
            temp.setCharAt(l,temp.charAt(i));
            temp.setCharAt(i,c);
            if(!tempSet.contains(temp.toString()))
            {
                
                generateParenthesis(set,tempSet, temp, l+1, r);
                tempSet.add(temp.toString());
                
            }
        }
            
        return set;
        
    }
    
    public static boolean isValid(StringBuilder s){
        Stack<Character> stk = new Stack<>();
        for(char c: s.toString().toCharArray()){
            if(c=='(')
                stk.push(c);
            else
                if(stk.isEmpty())
                    return false;
                else
                    stk.pop();
        }
        return true;
    }
    
    
    /*
     * LeetCode brute force approach
     */
    public static List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
    	System.out.println(current);
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
