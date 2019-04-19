package com.testingfly.lc;

public class MaxProfitBS {

	public static void main(String[] args) {
		
		int[] arr1 = {1,2,6,12,7,8};
		System.out.println(getMaxProfit(arr1));

	}
	
	public static int getMaxProfit(int[] arr) {
		if(arr==null || arr.length==1) return 0;
		int max_profit=0;
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<arr.length;i=i+2) {
			int temp = arr[i]-arr[i-1];
			min = Math.min(min, arr[i-1]);
			//System.out.println(temp+":"+ (arr[i]-min));
			temp = Math.max(temp, arr[i]-min);
			max_profit = Math.max(temp, max_profit); 
			
		}
				
		return max_profit;
	}

}
