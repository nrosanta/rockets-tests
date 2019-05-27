package com.testingfly.lc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SuperUglyNumber {
	
	public static void main(String[] args) {
		int n = 12;
		int[] primes = {3,5,7,11,19,23,29,41,43,47};
		System.out.println(nthSuperUglyNumber(n, primes));
		System.out.println(nthSuperUglyNumber1(n, primes));
	}

	/*
	 * Using priority queue
	 * Runtime is O(N+KlogK) or just O(KlogK)
	 */
	public static int nthSuperUglyNumber(int n, int[] primes) {
		Queue<Long> pq = new PriorityQueue<>();
		pq.add((long) 1); // add first

		for (int i = 0; i < primes.length; i++)
			pq.add((long) primes[i]);

		for (int i = 1; i < n; i++) {
			long num = pq.poll();
			while (!pq.isEmpty() && pq.peek() == num)
				pq.poll();
			pq = generateSequence(pq, primes, num);
			//System.out.println(pq);
		}

		return pq.peek().intValue();

	}

	public static Queue<Long> generateSequence(Queue<Long> pq, int[] primes, long k) {
		for (int i = 0; i < primes.length; i++) {
			pq.add((k * (long) primes[i]));
		}
		return pq;
	}
	
	public static int nthSuperUglyNumber1(int n, int[] primes) {
        int[] index = {0};
        int[] pnums = new int[primes.length];
        int[] indices = new int[primes.length];
        pnums = Arrays.copyOf(primes, primes.length);
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1;i<n;i++){
            int min = findSmallest(pnums, index);
            int j = index[0];
            indices[j] = indices[j]+1;
            int k = indices[j];
            if(res[i-1]==min)
            	i--;
            res[i] = min;
            //System.out.print(j+"->"+Arrays.toString(indices)+"->"+Arrays.toString(pnums));
            //System.out.print("->"+Arrays.toString(res)+"\n");
            
            pnums[j] = res[k]*primes[j];
            
        }
        
        return res[n-1];

    }
    
    public static int findSmallest(int[] pnums, int[] index){
        int x=Integer.MAX_VALUE;
        for(int i=0;i<pnums.length;i++){
            if(pnums[i]<x){
                x = pnums[i];
                index[0] = i;
            }
        }
            
        return x;
    }
}