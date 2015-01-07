package com.jiaxin.lc.dp.sequence;


public class PalindromePartitionII {
	// j from right to left.
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		boolean[][] isPalindrome = getPalindromeMatrix(s);
		int[] cut =  new int[s.length() + 1];
		cut[0] = 0;
		
		for (int i = 1; i <= s.length(); i++) {
			cut[i] = Integer.MAX_VALUE;
			for (int j = 1; j <= i; j++) {
				if (isPalindrome[i - j][i - 1] && cut[i - j] != Integer.MAX_VALUE) {
					cut[i] = Math.min(cut[i], cut[i - j] + 1);
				}
			}
		}
		
		return cut[s.length()] - 1;
	}

	private boolean[][] getPalindromeMatrix(String s) {
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			isPalindrome[i][i] = true;
		}
		
		for (int i = 0; i < s.length() - 1; i++) {
			isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
		}
		
		for (int length = 2; length < s.length(); length++) {
			for (int i = 0; i + length < s.length(); i++) {
				isPalindrome[i][i + length] = isPalindrome[i + 1][i + length - 1] && (s.charAt(i) == s.charAt(i + length)); 
			}
		}
		
		return isPalindrome;
	}
}
