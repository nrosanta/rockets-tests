package com.testingfly.lc;

public class BestTimeBuySellStock {
	public static void main(String[] args) {
		int[] data = { 7, 1, 5, 3, 6, 4 };
		int[] data1 = { 1, 2, 3, 4, 5 };

		System.out.println(maxProfit(data));
		System.out.println(maxProfit(data1));// Expected 4
	}

	public static int maxProfit(int[] prices) {
		int max_profit = 0;
		int index = 0;

		while (index < prices.length - 1) {

			if (prices[index] > prices[index + 1]) {
				index++;
				continue;
			} else

				max_profit = max_profit + (prices[index + 1] - prices[index]);

			index++;

		}
		return max_profit;
	}
}
