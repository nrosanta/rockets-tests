package com.testingfly.lc;

/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach 
the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */
public class UniquePathMatrix2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniquePaths(int m, int n) {
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++)
			matrix[i][0] = 1;
		for (int i = 0; i < n; i++)
			matrix[0][i] = 1;

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
			}

		// System.out.println(Arrays.deepToString(matrix));
		return matrix[m - 1][n - 1];
	}
	
	
	/*
	 * recursive approach using memoization
	 */
	
    public int uniquePaths1(int m, int n) {
        return helperGetPaths(m - 1, n - 1, new int[m][n]);
    }
    
    private int helperGetPaths(int m, int n, int[][] memo){
        if(n==0||m==0) return 1;
        if(memo[m][n]!=0) return memo[m][n];
        return memo[m][n] = helperGetPaths(m-1,n,memo)+helperGetPaths(m,n-1,memo);
    }
}