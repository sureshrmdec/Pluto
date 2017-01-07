package com.jiaxin.lc.newProblem;

import org.junit.Test;

public class ReverseWordsII {
    public void reverseWords(char[] s) {
    	if (s == null || s.length == 0) {
    		return;
    	}
    	
    	reversePart(s, 0, s.length - 1);
    	
    	int start = 0;
    	
    	for (int i = 0; i < s.length; i++) {
    		if ((i != 0 && s[i] == ' ')) {
    			reversePart(s, start, i - 1);
    			start = i + 1;
    		}
    	}
    	
    	// last word
    	reversePart(s, start, s.length - 1);
    }
    
    public void reversePart(char[] s, int left, int right) {
    	while (left < right) {
    		char temp = s[left];
    		s[left] = s[right];
    		s[right] = temp;
    		left++;
    		right--;
    	}
    }
    
    
    @Test
    public void test() {
    	char[] s = "the sky is blue".toCharArray();
    	reverseWords(s);
    	System.out.println(new String(s));
    }
}
