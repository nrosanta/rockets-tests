package com.testingfly.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrConcat {

	public static void main(String[] args) {
		String s = "barfoothefoobarman"; //18chars
		String words[] = {"foo","bar"}; //4chars
		String s1 = "catbatatecatatebat"; //18chars
	    String words1[] = {"cat", "ate", "bat"};//9chars
	    String s2 = "abcdababcd";
	    String words2[] = {"ab", "ab", "cd"};
	    String s3 = "abcdababcd"; 
	    String words3[] = {"ab", "ab"};
	    String s4 = "lingmindraboofooowingdingbarrwingmonkeypoundcake"; 
	    String words4[] = {"fooo","barr","wing","ding","wing"};
	    
	    int[] num1 = {1,2,3};
	    int[] num2 = {1,2};
	    
	    
		//System.out.println(findSubstring(s,words));
		//System.out.println(findSubstring(s1,words1));
		//System.out.println(findSubstring(s2,words2));
		//System.out.println(findSubstring(s3,words3));
		//System.out.println(findSubstring(s4,words4));
	    //nextPermutation(num1);
	    //nextPermutation(num2);

	}
	
    public static List<Integer> findSubstring(String s, String[] words) {
        int wLength=words[0].length();
        int numWords=words.length;
        Map<String, Integer> wMap = new HashMap<>();
        List<Integer> index = new ArrayList<>();
        
        //load words to map
        for(int i=0;i<numWords;i++){
            wMap.put(words[i], wMap.getOrDefault(words[i], 0)+1);
        }
        
        System.out.println("s: "+s);
        System.out.println("wMap: "+wMap);
        int count=0;
        
        	
        	for(int j=0;j<(s.length());j++) {
        		Map<String, Integer> tMap = new HashMap<>();
        		System.out.println("  j: "+j);
        		if(((j*1)+wLength*numWords)>s.length())
        			break;
        		System.out.println("Debug: "+j+"->"+((j*1)+wLength*numWords));
        		//String temp = s.substring(j*wLength, j*wLength+numWords*wLength);
        		String temp = s.substring(j, ((j*1)+wLength*numWords));
        		System.out.println("temp: "+temp);
        		tMap.clear();
        		for(int k=0;k<temp.length();k=k+wLength) {
        			System.out.println("   k: "+k);
        			String substring = temp.substring(k, k+wLength);
        			System.out.println("substring: "+substring+" count: "+count);
        			//fooowingdingbarrwing
        			count = wMap.getOrDefault(substring, 0);
        			if(count==0)break;
        			else {count++;tMap.put(substring, tMap.getOrDefault(substring,0)+1);}
        		}
        		System.out.println("	tMap: "+tMap+" count: "+count);
        		System.out.println("count: "+count+" tMapSize: "+tMap.size());
        		
            	if(tMap.equals(wMap)) {
            		index.add((j*wLength)/wLength);
            	}
        	}

        	
      //  }
        
		return index;
        
    }
    
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> index = new ArrayList<>();
        if(s==null||words==null) return index;
        if(s==""||words.length==0) return index;
        int wLength=words[0].length();
        int numWords=words.length;
        Map<String, Integer> wMap = new HashMap<>();
        
        
        //load words to map
        for(int i=0;i<numWords;i++){
            wMap.put(words[i], wMap.getOrDefault(words[i], 0)+1);
        }
        int count=0;
        	for(int j=0;j<(s.length());j++) {
        		Map<String, Integer> tMap = new HashMap<>();
        		if(((j*1)+wLength*numWords)>s.length())
        			break;
        		String temp = s.substring(j, ((j*1)+wLength*numWords));
        		tMap.clear();
        		for(int k=0;k<temp.length();k=k+wLength) {
        			String substring = temp.substring(k, k+wLength);
        			count = wMap.getOrDefault(substring, 0);
        			if(count==0)break;
        			else {count++;tMap.put(substring, tMap.getOrDefault(substring,0)+1);}
        		}
        		
            	if(tMap.equals(wMap)) {
            		index.add((j*wLength)/wLength);
            	}
        	}
		return index;
        
    }
    
  
	

}
