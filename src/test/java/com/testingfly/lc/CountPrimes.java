package com.testingfly.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountPrimes {

	public static void main(String[] args) {

		System.out.println(countPrimes4(10000));
		System.out.println(countPrimes5(10000));

	}

	public static int countPrimes(int n) {
		int count = 2;
		return countPrimes(n, count);
	}

	public static int countPrimes(int n, int count) {
		if (n <= 3)
			return count;
		if (n % 2 != 0 && n % 3 != 0)
			count++;
		count = countPrimes(n - 1, count);
		return count;
	}

	public static int countPrimes1(int n) {
		int count = 2;
		if (n <= 2)
			return 0;
		if (n == 3)
			return 1;
		for (int i = 5; i < n; i++)
			if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
				System.out.println(i);
				count++;
			}
		return count;
	}

	// Given n, return all primes up to and including n.
	public static int countPrimes2(int n) {
		if (n == 0 || n == 1)
			return 0;
		List<Integer> primes = new ArrayList<>();
		// isPrime.get(p) represents if p is prime or not. Initially , set each // to
		// true, excepting and 1. Then use sieving to eliminate nonprimes.
		List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n, true));
		isPrime.set(0, false);
		isPrime.set(1, false);
		for (int p = 2; p < n; ++p) {
			if (isPrime.get(p)) {
				primes.add(p);
				// Sieve p’s multiples.
				for (int j = p; j < n; j += p) {
					isPrime.set(j, false);
				}
			}
		}
		return primes.size();
	}

	public static int countPrimes3(int n) {
		if (n == 0 || n == 1)
			return 0;
		int count = 0;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int p = 2; p < n; p++) {
			if (isPrime[p]) {
				count++;
				for (int j = p; j < n; j += p) {
					isPrime[j] = false;
				}
			}
		}

		return count;
	}

	public static int countPrimes4(int n) {
		if (n == 0 || n == 1)
			return 0;
		int count = 0;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int p = 2; p < Math.sqrt(n); p++) {
			if (isPrime[p]) {
				for (int j = p * p; j < n; j += p) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 2; i < isPrime.length; i++)
			if (isPrime[i])
				count++;
		return count;
	}

	public static int countPrimes5(int n) {
		if (n == 0 || n == 1)
			return 0;
		int count = n - 2;
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int p = 2; p < Math.sqrt(n); p++) {
			if (isPrime[p]) {
				for (int j = p * p; j < n; j += p) {
					if (isPrime[j]) {
						isPrime[j] = false;
						count--;
					}
				}
			}
		}
		return count;
	}

	
}
