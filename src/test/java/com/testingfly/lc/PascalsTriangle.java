package com.testingfly.lc;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		
		print(generate(5));
		

	}
	
	public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascal = new ArrayList<>();
        int k=1;
        List<Integer> temp = null;
        for(int i=0;i<numRows;i++) {
        	List<Integer> list = new ArrayList<>();
        	int x=0,y=1;
        	for(int j=0;j<=i;j++) {
        		if(i<2)
        			list.add(k);
        		else {
        			if(x<list.size() && y<list.size()) 
        				list.add(temp.get(x++)+temp.get(y++));
        			else if(x>=list.size()) 
        				list.add(temp.get(y++));
        			else if(y>=list.size()) 
        				list.add(temp.get(x++));
        			
        		}
        	}
        	temp = list;
        	
        	pascal.add(list);
        	
        	
        }
        
        return pascal;
        
    }
	
	public static void print(List<List<Integer>> pascal) {
	
		for(List<Integer> list : pascal) {
			for(int i : list) {
				System.out.print(i);
				
			}
			System.out.println();
		}
		
		
	}

}
