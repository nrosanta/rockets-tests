package com.testingfly.lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupsSpecialEquivalentStrings {

	
	/*
	 * Integer based char map approach using a 0 based index
	 */
	public int numSpecialEquivGroups(String[] A) {
		Set<String> seen = new HashSet<>();
		for (String S : A) {
			int[] count = new int[52];
			for (int i = 0; i < S.length(); ++i) {
				count[S.charAt(i) - 'a' + 26 * (i % 2)]++; // 1st 26 or 2nd 26 depending on remainder
				
			}
			seen.add(Arrays.toString(count));

		}

		return seen.size();
	}
	
	/*
	 * split even odds, sort and add them and append to set to get group counts. 
	 */
    public int numSpecialEquivGroups1(String[] A) {
        Set<String> set = new HashSet<>();
        for(String s : A){
            set.add(getEvenOdds(s));
        }
        return set.size();
    }
    
    String getEvenOdds(String str){
        StringBuffer even = new StringBuffer();
        StringBuffer odd = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(i%2==0)
                even.append(str.charAt(i));
            else
                odd.append(str.charAt(i));
        }
        char[] caEven = even.toString().toCharArray();
        char[] caOdd = odd.toString().toCharArray();
        Arrays.sort(caEven);
        Arrays.sort(caOdd);
        return String.valueOf(caEven) + String.valueOf(caOdd);
        
    }
}