package com.testingfly.lc;

public class GameOfLife {

	public void gameOfLife(int[][] board) {
		// corner case
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;
		boolean[][] updated = new boolean[m][n];

		countLivesNsetFlg(board, updated, m, n);
		generateNext(board, updated, m, n);

		return;

	}

	void generateNext(int[][] board, boolean[][] updated, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (updated[i][j]) {
					board[i][j] = 1 - board[i][j];
				}
			}
		}
	}

	void countLivesNsetFlg(int[][] board, boolean[][] updated, int m, int n) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int[] dir : dirs) {
					int x = i + dir[0];
					int y = j + dir[1];
					if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1) {
						count++;
					}
				}
				if (board[i][j] == 1 && (count < 2 || count > 3)) {
					updated[i][j] = true;
				}
				if (board[i][j] == 0 && count == 3) {
					updated[i][j] = true;
				}
			}
		}
	}
}

/*
 * Inline approach
 */
class GOL {
    public void gameOfLife(int[][] board) {
        //base cases
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        
        //count lives and set intermediate status
        setStatus(board, m, n);
        
        //set final status
        generateNext(board, m, n);


    }
    
    void generateNext(int[][] board, int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]==-1) {
                    board[i][j] = 0;
                }
                if (board[i][j]==-2) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    void setStatus(int[][] board, int m, int n){
    	//all possible surrounding cells relative positions
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0},{-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        for (int i = 0; i < m; i++) { //loop through each cell
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int[] dir : dirs) { //loop through all 8 surrounding cells
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) { //exclude out of index items
                       if (board[x][y] == 1 || board[x][y] == -1) //-1 included since it meant it original val was 1
                            count++;
                    }
                }
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = -1; //to be set to 0
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = -2; //to be set to 1
                }  
            }
        }
    }
}