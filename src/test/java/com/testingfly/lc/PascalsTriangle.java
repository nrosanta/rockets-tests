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
        for(int i=0;i<numRows;i++) {
        	List<Integer> list = new ArrayList<>();
        	for(int j=0;j<i;j++) {
        		list.add(k);
        	}
        	
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
