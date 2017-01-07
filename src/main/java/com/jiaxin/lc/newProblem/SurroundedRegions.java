package com.jiaxin.lc.newProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	char[][] board;
	Queue<Integer> queue;
	int rows;
	int cols;

	public void solve(char[][] board) {
	    if (board == null || board.length == 0 || board[0].length == 0) {
	        return;
	    }

	    this.board = board;
	    this.queue = new LinkedList<Integer>();
	    this.rows = board.length;
	    this.cols = board[0].length;
	    
	    for (int i = 0; i < rows; i++) {
	        enqueue(i, 0);
	        enqueue(i, cols - 1);
	    }
	    
	    for (int j = 1; j < cols - 1; j++) {
	        enqueue(0, j);
	        enqueue(rows - 1, j);
	    }
	    
	    while (!queue.isEmpty()) {
	        int current = queue.poll();
	        
	        int x = current / cols;
	        int y = current % cols;
	        
	        board[current / cols][current % cols] = '#';
	        
	        enqueue(x - 1, y);
	        enqueue(x + 1, y);
	        enqueue(x, y - 1);
	        enqueue(x, y + 1);
	    }   
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            if (board[i][j] == '#') {
	                board[i][j] = 'O';
	            } else if (board[i][j] == 'O') {
	                board[i][j] = 'X';
	            }
	        }
	    }
	}

	public void enqueue(int i, int j) {
	    if (i >=0 && i < rows && j >= 0 && j < cols && board[i][j] == 'O') {
	        queue.offer(i * cols + j);
	    }
	}
}
