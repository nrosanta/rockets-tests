package com.testingfly.lc;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {

		print(generate(5));
		print(generate1(5));

	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> pascal = new ArrayList<>();
		
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			int x = 0, y = 1;
			for (int j = 0; j <= i; j++) {

				if (i < 2 || j == 0 || j == i)
					list.add(1);
				else
					list.add(pascal.get(i-1).get(x++) + pascal.get(i-1).get(y++));

			}
			
			pascal.add(list);

		}

		return pascal;

	}
	
	
	/*
	 * alternate recursive solution
	 */
	public static List<List<Integer>> generate1(int numRows) {

		List<List<Integer>> pascal = new ArrayList<>();
		
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j <= i; j++) {

				if (i < 2 || j == 0 || j == i)
					list.add(1);
				else
					list.add(getEle(i,j));

			}
			
			pascal.add(list);

		}

		return pascal;

	}
	
	
	public static int getEle(int row, int k) {
		if(row==0 || row ==1 || k==0 ||k>=row) 
			return 1;
		else
			return getEle(row-1, k-1) + getEle(row-1, k);
	}

	public static void print(List<List<Integer>> pascal) {

		for (List<Integer> list : pascal) {
			for (int i : list) {
				System.out.print(i);

			}
			System.out.println();
		}

	}

}
