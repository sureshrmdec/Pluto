package CC150.Moderate;

/**
 * Problem 17.2: Design an algorithm to figure out if someone has won a game of tic-tac-toe
 * 
 * Solution:
 * 1. 这里题目需要考虑表盘是不是都是X,O 还是有""的没填入的元素. 也就是说三种可能, 我应该动点脑子，自然是考虑三种，因为没填满就可以赢了！
 * 2. 看是否需要多次调用，因为这个board不大，所以可以pre-processging, 变成一个HashTable 每次直接查结果
 * 3. 最好直接写扩展.不用3*3的，用n*n 的
 * 
 * TestCase:
 * 
 * @author jeffwan
 * @date Feb 26, 2014
 */
public class HasWon {
	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'O'}, {'O', 'X', ' '}, {' ', 'O', 'X'}};
		System.out.println(hasWon(board));
	}
	
	public static boolean hasWon(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
			return false;
		}
		
		int n = board.length;
		int i, j;
		// check each line
		for (i = 0; i < n; i++) {
			if (board[i][0] == 'X' || board[i][0] == 'O') {
				for (j = 1; j < n; j++) {
					if (board[i][j] != board[i][j - 1]) {
						break;
					}
				}
				if (j == n) {
					return true;
				}
			}
		}
		
		// check each column
		for (i = 0; i < n; i++) {
			if (board[0][i] == 'X' || board[0][i] == 'O') {
				for (j = 1; j < n; j++) {
					if (board[j][i] != board[j - 1][i]) {
						break;
					}
				}
				if (j == n) {
					return true;
				}
			}
		}
		
		// check diagonal
		if (board[0][0] == 'X' || board[0][0] == 'O') {
			for (i = 1; i < n; i++) {
				if (board[i][i] != board[i - 1][i - 1]) {
					break;
				}
			}
			
			if (i == n) {
				return true;
			}
		}
		
		// check reverse diagonal
		if (board[0][n - 1] == 'X' || board[0][n - 1] == 'O') {
			for (i = 1; i < n; i++) {
				if (board[i][n - i - 1] != board[i - 1][n - i]) {
					break;
				}
			}
			
			if (i == n) {
				return true;
			}
		}
		
		return false;
	}
	
	// HashTable pre-processging 方法， Each board is represented as 3^0 *v0 + 3^1*v1 + 3^2*v2
	public static int convertBoardToInt(char[][] board) {
		int factor = 1;
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int v = 0;
				if (board[i][j] == 'X') {
					v = 1;
				} else if (board[i][j] == 'O') {
					v = 2;
				}
				sum += v * factor;
				factor *= 3;
			}
		}
		
		return sum;
	}

}
