package com.testingfly.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return (new ArrayList<>());
        Map<String, List<String>> res = new HashMap<>();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);
            if(!res.containsKey(key))
                res.put(key,new ArrayList<>());
            res.get(key).add(str);
                
        }
        return new ArrayList<>(res.values());    
        
    }
}
