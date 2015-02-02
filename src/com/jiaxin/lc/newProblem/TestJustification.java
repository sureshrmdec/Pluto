package com.jiaxin.lc.newProblem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestJustification {
    public List<String> fullJustify(String[] words, int L) {
		List<String> result = new ArrayList<String>();
    	if (words == null || words.length == 0 || L == 0) {
    		return result;
    	}
		
    	int curLength = 0;
    	int lastI = 0;
    	
    	for (int i = 0; i <= words.length; i++) {
    		if (i == words.length || curLength + words[i].length() + i - lastI > L) { // i - lastI at lease one space
    			StringBuffer sb = new StringBuffer();
    			int spaceCount = L - curLength;
    			int spaceSlots = i - lastI - 1; 
    			
    			if (spaceSlots == 0 || i == words.length) {
    				for (int j = lastI; j < i; j++) {
    					sb.append(words[j]);
    					if (j != i - 1) {
    						appendSpace(sb, 1);
    					}
    				}
    				appendSpace(sb, L - sb.length());
    			} else {
    				int spaceEach = spaceCount / spaceSlots;
    				int spaceExtra = spaceCount % spaceSlots;
    				
    				for (int j = lastI; j < i; j++) {
    					 sb.append(words[j]);
    					 if (j != i - 1) {
    						 appendSpace(sb, spaceEach + (j - lastI < spaceExtra? 1:0));
    					 }
    				}
    			}
    			
    			result.add(sb.toString());
    			lastI = i;
    			curLength = 0;
    		}
    		
    		if (i < words.length) {
    			curLength += words[i].length();
    		}
    	}
    	
    	return result;
    }

	private void appendSpace(StringBuffer sb, int count) {
		for (int i = 0; i < count; i++) {
			sb.append(" ");
		}
	}
	
	@Test
	public void test() {
		String[] words = {"This", "is", "an", "example", "of", "text", "justifition."};
		int L = 16;
		
		System.out.println(fullJustify(words, L));
	}
}
