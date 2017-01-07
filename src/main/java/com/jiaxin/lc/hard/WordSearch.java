package com.jiaxin.lc.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
			return false;
		}
		
		if (word.length() == 0) {
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (find(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		
		return false;
	}

	private boolean find(char[][] board, String word, int i, int j, int start) {
		if (start == word.length()) {
			return true;
		}
		
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
				board[i][j] != word.charAt(start)) {
			return false;
		}
		
		board[i][j] = '#';
		boolean result = find(board, word, i - 1, j, start + 1)
				|| find(board, word, i + 1, j, start + 1)
				|| find(board, word, i, j - 1, start + 1)
				|| find(board, word, i, j + 1, start + 1);
		board[i][j] = word.charAt(start);
		return result;
	}
	
	/************************   Word Search II  *************************/
	public ArrayList<String> wordSearchIISameI(char[][] board, List<String> words) {
		ArrayList<String> result = new ArrayList<String>();
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		if (board == null || board.length == 0 || board[0].length == 0 || words == null) {
			return result;
		}
		
		for (String word : words) {  // only difference is
			boolean found = false;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					found = find(board, word, visited, i, j, 0);
					
					if (found) {
						break;
					}
				}
				
				if (found) {
					result.add(word);
					break;
				}
			}
		}
		
		return result;
    }

	private boolean find(char[][] board, String word, boolean[][] visited, int i,
			int j, int start) {
		if (word.length() == start) {
			return true;
		}
		
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
				|| visited[i][j] || word.charAt(start) != board[i][j]) {
			return false;
		}
		
//		visited[i][j] = true;
		board[i][j] = '#';
		boolean result = find(board, word, visited, i - 1, j, start + 1)
				|| find(board, word, visited, i + 1, j, start + 1)
				|| find(board, word, visited, i, j - 1, start + 1)
				|| find(board, word, visited, i, j + 1, start + 1);
		
//		visited[i][j] = false;
		board[i][j] = word.charAt(start);
		
		return result;
	}
	
	
	@Test
	public void test() {
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
				};
		
//		System.out.println(exist(board, "ABCCED"));
//		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
		
		
		char[][] board2 = {
				{'d', 'o', 'a', 'f'},
				{'a', 'g', 'a', 'i'},
				{'d', 'c', 'a', 'n'}
		};
		List<String> words = Arrays.asList("dog", "dad", "dgdg", "can", "again");
		System.out.println(wordSearchIISameI(board2, words));
		
	}
}
