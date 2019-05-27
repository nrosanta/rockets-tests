package com.testingfly.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyBoardRow {

    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        
        String[] res = new String[words.length];
        int i=0;
        for(String s : words){
            if(rowContains(s, row1) || rowContains(s, row2) || rowContains(s, row3))
                res[i++] = s;
        }
        
        return Arrays.copyOfRange(res,0,i);
    }
    
    public boolean rowContains(String s, Set<Character> row){
        for(char c : s.toCharArray()){
            if(!row.contains(Character.toLowerCase(c)))
                return false;
        }
        return true;
    }
    
    
}

class KeyBoardRow1 {
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        List<String> res = new ArrayList<>();
        for(String s : words){
            if(rowContains(s, row1) || rowContains(s, row2) || rowContains(s, row3))
                res.add(s);
        }
        return res.toArray(new String[res.size()]);
    }
    
    public boolean rowContains(String s, Set<Character> row){
        for(char c : s.toCharArray()){
            if(!row.contains(Character.toLowerCase(c)))
                return false;
        }
        return true;
    }
    
    
}