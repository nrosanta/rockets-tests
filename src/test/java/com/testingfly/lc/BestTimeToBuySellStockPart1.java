package com.testingfly.lc;

public class BestTimeToBuySellStockPart1 {

	public static void main(String[] args) {

		int[] arr1 = { 7, 1, 5, 3, 6, 4 };
		int[] arr2 = { 7, 6, 4, 3, 1 };
		int[] arr3 = { 3, 2, 6, 5, 0, 3 };

		System.out.println(maxProfit(arr1));
		System.out.println(maxProfit(arr2));
		System.out.println(maxProfit(arr3));

		System.out.println(maxProfit1(arr1));
		System.out.println(maxProfit1(arr2));
		System.out.println(maxProfit1(arr3));

	}

	/*
	 * brute force solution
	 */
	public static int maxProfit(int[] prices) {
		int max_profit = 0;
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] > prices[j])
					j++;
				else {
					int temp = prices[j] - prices[i];
					if (temp > profit)
						profit = temp;
				}
			}
			if (profit > max_profit)
				max_profit = profit;
		}
		return max_profit;
	}

	/*
	 * 1 pass solution tracking min_price and computing profit based on it.
	 * Subsequent larger profit is captured as the max_profit.
	 */
	public static int maxProfit1(int[] prices) {
		int max_profit = 0;
		int min_price = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min_price)
				min_price = prices[i];
			int profit = prices[i] - min_price;
			if (profit > max_profit)
				max_profit = profit;

		}

		return max_profit;
	}

}
