package com.jiaxin.lc.newProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> result = new ArrayList<Integer>();
    	if (S == null || L == null || L.length == 0) {
			return result;
		}
    	
    	Map<String, Integer> toFind = new HashMap<String, Integer>();
    	Map<String, Integer> dict = new HashMap<String, Integer>();
    	
    	for (String word : L) {
    		if (!toFind.containsKey(word)) {
    			toFind.put(word, 1);
    		} else {
    			toFind.put(word, toFind.get(word) + 1);
    		}
    	}
    	
    	int m = L[0].length();
    	int n = L.length;
    	
    	int j = 0;
    	for (int i = 0; i < S.length() - m * n + 1; i++) {
    		dict = new HashMap<String, Integer>(toFind);

    		for (j = 0; j < m * n; j += m) {
    			String word = S.substring(i + j, i + j + m);
    			if (dict.containsKey(word)) {
    				if (dict.get(word) == 0) {
    					break;
    				}
    				dict.put(word, dict.get(word) - 1);
    				
    			} else {
    				break;
    			}
    		}
    		
    		if (j == m * n) {
    			result.add(i);
    		}
    	}
    	
    	
    	return result;
    }
}
