package com.jiaxin.company.fb.online;

import org.junit.Test;

/**
 * 
 * 
 * O(n^2) -> general 
 * O(n) -> KMP
 * O(n) -> Rolling Hash  -> hash will be easily overflow
 * O(n) -> Boyer - Moore
 * 
 * call many ties -> Trie
 * 
 * http://blog.csdn.net/linhuanmars/article/details/20276833
 * http://www.matrix67.com/blog/archives/115
 * https://weblogs.java.net/blog/potty/archive/2012/05/21/string-searching-algorithms-part-iii
 * 
 * 
 * A[i-j+ 1..i] --- match --- B[1..j]
 * 
 * @author jiashan
 *
 */
public class StrStrTrieKMP {

	// KMP
	public int[] prekmp(String pattern) {
		int[] next = new int[pattern.length()];
		int i = 0, j = -1;
		next[0] = -1;
		while (i < pattern.length() - 1) {
			while (j >= 0 && pattern.charAt(i) != pattern.charAt(j))
				j = next[j];
			i++;
			j++;
			next[i] = j;
		}
		return next;
	}

	public int kmp(String text, String pattern) {
		int[] next = prekmp(pattern);
		int i = 0, j = 0;
		while (i < text.length()) {
			while (j >= 0 && text.charAt(i) != pattern.charAt(j)) {
				j = next[j];
			}
				
			i++;
			j++;
			if (j == pattern.length()) {
				return i - pattern.length();
			}
		}
		
		return -1;
	}

	
	// BM
	public int search(String text, String pattern) {
		int[] occurrence = new int[256];
		for (int i = 0; i < pattern.length(); i++) {
			occurrence[pattern.charAt(i)] = i;
		}
		
		int n = text.length();
		int m = pattern.length();
		
		int skip;
		
		for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i+j)) {
                    skip = Math.max(1, j - occurrence[text.charAt(i+j)]);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return n;
	}
	
	@Test
	public void test() {
		String text = "Lorem ipsum dolor sit amet";
		String pattern = "do";
		
		System.out.println(search(text, pattern));
		System.out.println(kmp(text, pattern));
	}
	
}
