package com.testinfly.practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HighestMaxProducts {

	public static void main(String[] args) {
		int[] arr1 ={-9,-2,1,5,5};
		
		System.out.println("Max Product: "+ maxProduct(arr1));
		System.out.println("Max Product: "+ maxProduct1(arr1));

	}

	// 3 highest value and 2 lowest -> max 3 products

	static int maxProduct(int[] arr) {
		int x = Integer.MIN_VALUE; // x - highest
		int y = x, z = y;
		int a = Integer.MAX_VALUE; // lowest
		int b = a;

		for (int i = 0; i < arr.length; i++) {
			if (x < arr[i]) {
				z = y;
				y = x;
				x = arr[i];
			} else if (y < arr[i]) {
				z = y;
				y = arr[i];
			} else if (z < arr[i])
				z = arr[i];

			if (a > arr[i]) {
				b = a;
				a = arr[i];
			} else if (b > arr[i])
				b = arr[i];
		}
		
		System.out.println("Max: x,y,z->"+x+","+y+","+z);
		System.out.println("Min: a,b->"+a+","+b);

		return Math.max((a * b * x), x * y * z);

	}
	
	static int maxProduct1(int[] arr) {
		int len = arr.length-1;
		Arrays.sort(arr);
		int max1 = arr[len]*arr[len-1]*arr[len-2];
		int max2 = arr[0] * arr[1] * arr[len];
		
		return Math.max(max1, max2);
	}

}
