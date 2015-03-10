package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * str dictionary. if stores. face, book, facebook. output facebook since face and book can construct facebook. 
 * 
 * same to word break 
 * 
 * 
 * @author jiashan
 *
 */
public class LongestStrConstruction {
	public String wordBreak(Set<String> dict) {
		if (dict == null || dict.size() == 0) {
			return null;
		}

		Set<String> list = new TreeSet<String>(lengthComparator);
		list.addAll(dict);
		
		for (String word : list) {
			if (canSegment(dict, word)) {
				return word;
			}
		}
		
		return null;
	}

	private boolean canSegment(Set<String> dict, String word) {
		dict.remove(word);
		
		boolean[] canSegment = new boolean[word.length() + 1];
		canSegment[0] = true;
		
		for (int i = 1; i <= word.length(); i++) {
			for (int j = 1; j <= i; j++) {
				String suffix = word.substring(i - j, i);
				if (canSegment[i - j] = true && dict.contains(suffix)) {
					canSegment[i] = true;
					break;
				}
			}
		}
		
		return canSegment[word.length()];
	}

	public Comparator<String> lengthComparator = new Comparator<String>() {
		
		@Override
		public int compare(String o1, String o2) {
			int diff = o2.length() - o1.length();
			if (diff == 0) {
				return o1.compareTo(o2);
			}
			
			return diff;
		}
	};
	
	@Test
	public void test() {
		Set<String> dict = new HashSet<String>();
		dict.add("face");
		dict.add("book");
		dict.add("facebook");
		
		System.out.println(wordBreak(dict));
	}
}
