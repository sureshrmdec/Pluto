package com.jiaxin.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;


/**
 * http://hxraid.iteye.com/blog/618962
 * http://www.douban.com/note/210673968/
 * https://richdalgo.wordpress.com/2015/01/27/lintcode-word-search-ii/
 * @author jiashan
 *
 * Compare to WordSearchII (the version seems like WordSearchI), we use an extra word loop. 
 * But for this, I can do it by only two loops (i & j). It's more likely my way, 
 * But my ways can not compare word.charAt(start) == board[i][j] since there's list of words, 
 * We can do it with Trie.
 *
 */
public class WordSearchIITrie {
	public ArrayList<String> wordSearchII(char[][] board, List<String> words) {
		Set<String> result = new HashSet<String>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		if (board == null || board.length == 0 || board[0].length == 0 || words == null) {
			return new ArrayList<String>(result);
		}
		
		Trie trie = new Trie();
		for (String word : words) {
			trie.add(word);
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				find(board, trie, visited, result, "", i, j); 
			}
		}
		
		return new ArrayList<String>(result);
    }
	
	private void find(char[][] board, Trie trie, boolean[][] visited,
			Set<String> result, String word , int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
			return;
		}
		
		if (trie.children[board[i][j]] == null) {
			return;
		}
		
		Trie next = trie.children[board[i][j]]; 
		word += board[i][j];
		
		if (next.isStr) {
			result.add(word); // we can not return here since there's might other words with this prefix. 
		}
		
		visited[i][j] = true;
		find(board, next, visited, result, word, i - 1, j);
		find(board, next, visited, result, word, i + 1, j);
		find(board, next, visited, result, word, i, j - 1);
		find(board, next, visited, result, word, i, j + 1);
		visited[i][j] = false;
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
	
	
	class Trie {
		boolean isStr = false;
		Trie[] children = new Trie[256];
		
		void add(String str) {
			Trie cursor = this;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if (cursor.children[c] == null) {
					cursor.children[c] = new Trie();
				}
				cursor = cursor.children[c];
			}
			
			cursor.isStr = true;
		}
		
		
		boolean contains(String str) {
			Trie cursor = this;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if (cursor.children[c] == null) {
					return false;
				}
				cursor = cursor.children[c];
			}
			
			return cursor.isStr;
		}
	}
}
