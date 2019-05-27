package com.testingfly.lc;

public class UniquePathwithObstacles {

	public static void main(String[] args) {

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
		for (int i = 0; i < obstacleGrid.length; i++)
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (i == 0 && j == 0 && obstacleGrid[i][j] == 0)
					obstacleGrid[i][j] = 1;
				else if (i > 0 && j > 0 && obstacleGrid[i][j] == 0)
					obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
				else if (i > 0 && obstacleGrid[i][j] == 0)
					obstacleGrid[i][j] = obstacleGrid[i - 1][j];
				else if (j > 0 && obstacleGrid[i][j] == 0)
					obstacleGrid[i][j] = obstacleGrid[i][j - 1];
				else
					obstacleGrid[i][j] = 0;
			}

		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}