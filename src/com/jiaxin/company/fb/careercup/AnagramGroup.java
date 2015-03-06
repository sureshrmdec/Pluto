package com.jiaxin.company.fb.careercup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of strings, return a list of lists of strings that groups all anagrams.
 * Ex. 	given {trees, bike, cars, steer, arcs}
 * return { {cars, arcs}, {bike}, {trees, steer} }
 * 
 * m = # of words
 * n = length of longest word
 * 
 * I solved this in O(m * n * log n) time.
 * 
 * @author jiashan
 *
 */
public class AnagramGroup {
	public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, List<String>> dict = new HashMap<String, List<String>>();
        
        if (strs == null || strs.length == 0) {
        	return result;
        }
		
		for (String str : strs) {
			char[] array = str.toCharArray();
			Arrays.sort(array);
			String key = new String(array);
			
			if (!dict.containsKey(key)) {
				dict.put(key, new ArrayList<String>());
			}
			
			dict.get(key).add(str);
		}
		
		for (List<String> entry : dict.values()) {
			if (entry.size() > 1) {
				result.addAll(entry);
			}
		}
		
    	return result;
    }
}
