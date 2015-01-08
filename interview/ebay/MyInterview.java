package interview.ebay;

public class MyInterview {
	public static void main(String[] args) {
		int[][] board = {{1, 1, 0}, {1, 0, 0}, {1, 0, 0}};
		System.out.println(maxCount(board));
	}

	static boolean[][] visited;
	public static int maxCount(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return -1;
		}
		
		visited = new boolean[board.length][board[0].length];
		
		int max = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int count = 0;
				helper(board, count, i, j);
				max = Math.max(max, count);
			}
		}

		return max;
	}

	public static void helper(int[][] board, int count, int i, int j) {
		if (board[i][j] == 0) {
			return;
		}

		count++;
		visited[i][j] = true;

		for (int x = i - 1; x <= i + 1; x++) {
			for (int y = j - 1; y <= j + 1; y++) {
				if (!(x == i && y == j) && x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
					helper(board, count, x, y);
				}
			}
		}

		System.out.println(count);
//		count--;
//		 visited[i][j] = false;
//		return count;
	}
}
