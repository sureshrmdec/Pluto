package com.jiaxin.company.twosigma;

//http://www.1point3acres.com/bbs/thread-136729-1-1.html
//http://www.1point3acres.com/bbs/thread-135020-1-1.html

// multi processor. manay machines.

//https://leetcode.com/problems/game-of-life/

//http://www.cnblogs.com/grandyang/p/4854466.html
// http://blog.csdn.net/xudli/article/details/48896549 clean code
// https://segmentfault.com/a/1190000003819277  optimization.

public class GameOfLife {

	// l
	public void gameOfLife(int[][] board) {
		// check input
		if (board == null || board.length == 0 || board[0] == null
				|| board[0].length == 0)
			return;

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int x = getLiveNum(board, i, j);
				if (board[i][j] == 0) {
					if (x == 3)
						board[i][j] += 10;  // dead -> live  10  dead -> dead = 0
				} else {
					if (x == 2 || x == 3)
						board[i][j] += 10;  // live -> live  11  live -> dead = 1  
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] /= 10;
			}
		}

	}

	private int getLiveNum(int[][] board, int x, int y) {
		int c = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i < 0 || j < 0 || i > board.length - 1
						|| j > board[0].length - 1 || (i == x && j == y))
					continue;
				if (board[i][j] % 10 == 1)
					c++;
			}
		}
		return c;
	}
}
