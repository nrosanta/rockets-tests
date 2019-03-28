package com.testingfly.lc;

/**
 * 
 * On an 8 x 8 chessboard, there is one white rook. There also may be empty
 * squares, white bishops, and black pawns. These are given as characters 'R',
 * '.', 'B', and 'p' respectively. Uppercase characters represent white pieces,
 * and lowercase characters represent black pieces.
 * 
 * The rook moves as in the rules of Chess: it chooses one of four cardinal
 * directions (north, east, west, and south), then moves in that direction until
 * it chooses to stop, reaches the edge of the board, or captures an opposite
 * colored pawn by moving to the same square it occupies. Also, rooks cannot
 * move into the same square as other friendly bishops.
 * 
 * Return the number of pawns the rook can capture in one move.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input:
 * {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}
 * Output: 3 Explanation: In this example the rook is able to capture all the
 * pawns. Example 2:
 * 
 * 
 * 
 * Input:
 * {{'.','.','.','.','.','.','.','.'},{'.','p','p','p','p','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','B','R','B','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','p','p','p','p','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}
 * Output: 0 Explanation: Bishops are blocking the rook to capture any pawn.
 * Example 3:
 * 
 * 
 * 
 * Input:
 * {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}}
 * Output: 3 Explanation: The rook can capture the pawns at positions b5, d6 and
 * f5.
 * 
 * 
 * Note:
 * 
 * board.length == board{i}.length == 8 board{i}{j} is either 'R', '.', 'B', or
 * 'p' There is exactly one cell with board{i}{j} == 'R'
 *
 */

public class AvailableCapturesForRook {

	public static void main(String[] args)

	{
		char[][] ip1 = { { '.', '.', '.', '.', '.', '.', '.', '.' }, 
						 { '.', '.', '.', 'p', '.', '.', '.', '.' },
						 { '.', '.', '.', 'p', '.', '.', '.', '.' }, 
						 { 'p', 'p', '.', 'R', '.', 'p', 'B', '.' },
						 { '.', '.', '.', '.', '.', '.', '.', '.' }, 
						 { '.', '.', '.', 'B', '.', '.', '.', '.' },
						 { '.', '.', '.', 'p', '.', '.', '.', '.' }, 
						 { '.', '.', '.', '.', '.', '.', '.', '.' } };

		char[][] ip2 = { { '.', '.', '.', '.', '.', '.', '.', '.' }, 
						 { '.', '.', '.', '.', 'p', '.', 'p', '.' },
						 { '.', 'p', '.', '.', '.', '.', '.', '.' }, 
						 { '.', 'p', 'B', '.', 'R', '.', 'B', 'p' },
						 { '.', 'p', '.', '.', '.', 'B', '.', '.' }, 
						 { '.', '.', 'p', '.', '.', 'p', '.', '.' },
						 { '.', '.', '.', '.', '.', '.', '.', '.' }, 
						 { '.', '.', '.', '.', '.', '.', '.', '.' } };

		char[][] ip3 = { {'.','.','.','.','.','.','.','.'},
				 		 {'.','.','.','p','.','.','.','.'},
				 		 {'.','.','.','B','.','.','.','.'},
				 		 {'.','p','B','R','p','B','p','.'},
				 		 {'.','.','.','p','p','.','.','.'},
				 		 {'.','.','.','B','.','.','.','.'},
				 		 {'.','.','.','p','.','.','.','.'},
				 		 {'.','.','.','.','.','.','.','.'}};
		
		System.out.println(numRookCaptures(ip1));
		System.out.println(numRookCaptures(ip2));
		System.out.println(numRookCaptures(ip3));

	}

	public static int numRookCaptures(char[][] board) {
		int i = 0, j = 0;
		int count = 0;

		for (i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++)
				if (board[i][j] == 'R')
					break;
			if (j != 8)
				break;
		}
		
		

		int temp = i+1;
		// down
		while (temp < 8) {
			if (board[temp][j] == 'B')
				break;
			if (board[temp][j] == 'p') {
				count++;
				break;
			}
			temp++;
		}
		System.out.println("down: "+count);
		// up
		temp = i-1;
		while (temp >= 0) {
			if (board[temp][j] == 'B')
				break;
			if (board[temp][j] == 'p') {
				count++;
				break;
			}
			
			temp--;
		}
		System.out.println("up: "+count);
		// right
		temp = j+1;
		while (temp < 8) {
			if (board[i][temp] == 'B')
				break;
			if (board[i][temp] == 'p') {
				count++;
				break;
			}
			temp++;
		}
		
		System.out.println("right: "+count);

		// left
		temp = j-1;
		while (temp >= 0) {
			if (board[i][temp] == 'B')
				break;
			if (board[i][temp] == 'p') {
				count++;
				break;
			}
			temp--;
		}
		System.out.println("left: "+count);

		return count;
	}

}
