package com.testingfly.lc;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		
		String s1 = "loveleetcode";
		System.out.println(firstUniqChar(s1));
		
	}

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        
        for(int i=0;i<s.length();i++)
            if(map.get(s.charAt(i))==1)
                return i;
        return -1;
    }
    
    
    public int firstUniqChar1(String s) {
        
        int[] count = new int[26];
        
        for (char c : s.toCharArray()) {
            count[(int)c-97]++;
        }
        
        char[] sarray = s.toCharArray();
        
        for (int i=0; i<sarray.length; i++) {
            if (count[(int)sarray[i]-97]==1) {return i;}
        }
        return -1;
    }
    

}
