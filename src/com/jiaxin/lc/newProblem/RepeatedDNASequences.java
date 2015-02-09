package com.jiaxin.lc.newProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		int length = 10;
		
    	if (s == null || s.length() == 0) {
			return result; 
		}
    	
    	for (int i = 0; i < s.length() - length + 1; i++) {
    		String sequence = s.substring(i, i + length);
    		int count = map.get(sequence) != null? map.get(sequence) : 0;
     		map.put(sequence, count + 1);
    	}
    	
    	for (Map.Entry<String, Integer> entry : map.entrySet()) {
    		if (entry.getValue() > 1) {
    			result.add(entry.getKey());
    		}
    	}
    	
    	return result;
    }
    
    public List<String> findRepeatedDnaSequencesSet(String s) {
		HashSet<String> map = new HashSet<String>();
		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < s.length() - 9; i++) {
			String temp = s.substring(i, i + 10);
			if (!set.contains(temp)) {
				if (map.contains(temp)) {
					set.add(temp);
					map.remove(temp);
				} else {
					map.add(temp);
				}
			}
		}
		return new ArrayList<String>(set);
    }
    
    
    
    
    // translate string to integer to save memory
    /**
     * //A=0101, C=0103, G=0107, T=0124
     * last 3 is different, use mask "0111" &, could identiy ACGT
     * 
     * 0111->7
     * every time get first 9, concat next one, totally 30 char.
     * mask is 27 1's to filter, 7FFFFFF.
     * cur << 3. | means add
     * 
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        int mask = 0x7FFFFFF;
        List<String> result = new LinkedList<String>();
        if (s.length() <= 10) {
        	return result;
        }
        	
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int cur = 0;
        int i = 0;
        
        while (i < 9) {
        	cur = (cur << 3) | (s.charAt(i++) & 7);
        }
        
		while (i < s.length()) {
			cur = ((cur & mask) << 3) | (s.charAt(i++) & 7);
			if (map.containsKey(cur)) {
				int counts = map.get(cur);
				
				if (counts == 1) {
					result.add(s.substring(i - 10, i));
				}
					
				map.put(cur, ++counts);
			} else {
				map.put(cur, 1);
			}
		}
		
        return result;
    }	
    
    
    @Test
    public void test() {
    	String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    	System.out.println(findRepeatedDnaSequences2(s));
    }
}
