package com.jiaxin.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * 1. My way is to find all paths, tracking every word to see if there's already a word in words.
 * 2. But for optimization, it's better to change to word searchI, for every word, find it. 
 * 3. Use Trie to solve this.
 * 
 */
public class WordSearchII {
	// my way -- slower but works. need bound check to return, 
	List<String> words = new ArrayList<String>();
	public List<String> wordSearchII(char[][] board, List<String> words) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		this.words.addAll(words);
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		if (board == null || board.length == 0 || board[0].length == 0 || words == null) {
			return result;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				find(board, visited, i, j, result, sb);
			}
		}
		
		return result;
    }

	private void find(char[][] board, boolean[][] visited, int i, int j,
			List<String> result, StringBuilder sb) {
		if (words.contains(sb.toString())) {
			result.add(sb.toString());
			words.remove(sb.toString());
		}
		
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
			return;
		}
		
		sb.append(board[i][j]);
		visited[i][j] = true;
		
		find(board, visited, i - 1, j, result, sb);
		find(board, visited, i + 1, j, result, sb);
		find(board, visited, i, j - 1, result, sb);
		find(board, visited, i, j + 1, result, sb);
		
		visited[i][j] = false;
		sb.deleteCharAt(sb.length() - 1);
	}
	
	@Test
	public void test() {
		char[][] board = {
				{'d', 'o', 'a', 'f'},
				{'a', 'g', 'a', 'i'},
				{'d', 'c', 'a', 'n'}
		};
		List<String> words = Arrays.asList("dog", "dad", "dgdg", "can", "again");
		
		System.out.println(wordSearchII(board, words));
	}
}
