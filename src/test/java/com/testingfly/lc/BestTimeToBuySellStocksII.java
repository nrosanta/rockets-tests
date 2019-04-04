package com.testingfly.lc;

public class BestTimeToBuySellStocksII {

	public static void main(String[] args) {
		int[] data1 = { 7, 1, 5, 3, 6, 4 };
		int[] data2 = { 1, 2, 3, 4, 5 };

		System.out.println(maxProfit(data1));
		System.out.println(maxProfit(data2));

	}

	public static int maxProfit(int[] prices) {
		int max_profit = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] > prices[i + 1])
				continue;
			else
				max_profit = max_profit + (prices[i + 1] - prices[i]);
		}

		return max_profit;

	}

}
