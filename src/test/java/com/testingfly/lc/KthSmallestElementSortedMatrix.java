package com.testingfly.lc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementSortedMatrix {

	public static void main(String[] args) {
		int[][] arr1 = 
				{{1,5, 9},
				{10,11,13},
				{12,13,15}};
		System.out.println(kthSmallest1(arr1,8));

	}

	/*
	 * O(n*n)
	 * Using Sort
	 */
    public static int kthSmallest(int[][] matrix, int k) {
        int[] arr = new int[matrix.length*matrix[0].length];
        int index=0;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){

                arr[index++] = matrix[i][j];

            }
        
        Arrays.sort(arr);
        return arr[k-1];
    }
    
    /*
     * Using Priority Queue
     */
    public static int kthSmallest1(int[][] matrix, int k) {
        
    	Queue<int[]> pq = new PriorityQueue<>(matrix.length,(p1,p2)->matrix[p1[0]][p1[1]]-matrix[p2[0]][p2[1]]);
        for (int i = 0; i < matrix.length; i++) {
            pq.add(new int[]{i, 0});
        }
        
        System.out.println("Pq: "+Arrays.toString(pq.peek()));
        int[] s;
        for (int i = 1; i < k; i++) {
            s = pq.poll();
            s[1]++;
            if (s[1] < matrix[s[0]].length) {
                pq.add(s);
            }
        }
        s = pq.peek();
        return matrix[s[0]][s[1]];
    }
    
}
