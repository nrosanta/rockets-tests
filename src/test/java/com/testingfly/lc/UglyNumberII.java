package com.testingfly.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UglyNumberII {
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
		System.out.println(nthUglyNumber2(10));
	}

	/*
	 * Heap approach
	 * O(nlogn)
	 */
    public static int nthUglyNumber(int n) {
        if(n==1) return 1;
        Queue<Long> pq = new PriorityQueue<>();
        pq.add((long)1);
        for(int i=1;i<n;i++){
            long num = pq.poll();
            while(!pq.isEmpty() && pq.peek()==num) 
                pq.poll();
            pq.add(num*2);
            pq.add(num*3);
            pq.add(num*5);
            //System.out.println(pq);
        }
        return pq.peek().intValue();
    }
    
    /*
     * Using array lists 
     * O(nlogn)
     */
    public static int nthUglyNumber1(int n) {
    	long[] res = new long[n];
    	List<Long> X = new ArrayList<>(), Y = new ArrayList<>(), Z = new ArrayList<>(); 
    	int iX = 0, iY = 0, iZ = 0;
    	res[0] = 1; X.add((long) 2); Y.add((long) 3); Z.add((long) 5);
    	for (int i = 1; i < n; i++) {
    		long min = Math.min(Math.min(X.get(iX), Y.get(iY)), Z.get(iZ));
    		res[i] = min;
    		if ( min == X.get(iX) ) iX++;
    		if ( min == Y.get(iY) ) iY++;
    		if ( min == Z.get(iZ) ) iZ++;
    		X.add(min * 2);
    		Y.add(min * 3);
    		Z.add(min * 5);
    	}
    	return (int)res[n-1];
    }
    
    /*
     * Using variables
     * O(nlogn)
     */
    public static int nthUglyNumber2(int n) {
        int[] res = new int[n];
        int X=2, Y=3, Z=5;
        res[0] = 1;
        
        int x=0,y=0,z=0;
        for(int i=1;i<n;i++){
            int min = Math.min(X, Math.min(Y,Z));
            res[i] = (int)min;
            if(min==X)
                X = res[++x]*2;
            if(min==Y)
                Y = res[++y]*3;
            if(min==Z)
                Z = res[++z]*5;
        }
        
        return res[n-1];	
        
    }
}