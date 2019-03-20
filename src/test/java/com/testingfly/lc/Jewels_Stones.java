package com.testingfly.lc;

public class Jewels_Stones {

	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAbbbb";
		System.out.println(numJewelsInStones(J,S));
		
		String J1 = "z";
		String S1 = "ZZz";
		System.out.println(numJewelsInStones(J1,S1));
		
		
	}
	
    public static int numJewelsInStones(String J, String S) {
    	int count=0;
    	if(S.length()==0 || S==null) return count;
    	for(int i=0;i<S.length();i++) {
    		if(J.contains(String.valueOf((S.charAt(i))))) {
    			count++;
    		}
    	}
		return count;
        
    }

}
