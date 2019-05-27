package com.testingfly.lc;

public class ContainersWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


    //brute force solution
    public int maxArea(int[] height) {
        int maxarea = 0;
        for(int i=0;i<height.length;i++)
            for(int j=i+1;j<height.length;j++){
                int temp = (j-i) * Math.min(height[i], height[j]);
                maxarea = Math.max(maxarea, temp);
            }
        
        return maxarea;
    }

}