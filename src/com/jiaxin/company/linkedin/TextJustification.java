package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * "This    is    an",
   "example  of text",
   "justification.  "
   
    words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.
   
 * @author jiashan
 *
 */

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		List<String> result = new ArrayList<String>();
		
		if (words == null || words.length == 0) {
			return result;
		}
		
		int curLength = 0;
		int lastI = 0;
		
		for (int i = 0; i <= words.length; i++) {
			if (i == words.length || curLength + words[i].length() + i - lastI > L) { // i- lastI space between words
				StringBuffer sb = new StringBuffer();
				int spaceCount = L - curLength;
				int spaceSlots = i - 1 - lastI;
				
				if (spaceSlots == 0 || i == words.length) { // last line or just one word in a line. too long
					for (int j = lastI; j < i; j++) {
						sb.append(words[j]);
						if (j != i - 1) {
							appendSpace(sb, 1);
						}
					}
					
					appendSpace(sb, L - sb.length());
				} else {
					int spaceEach = spaceCount/spaceSlots;
					int spaceExtra = spaceCount % spaceSlots;
					
					for (int j = lastI; j < i; j++) {
						sb.append(words[j]);
						
						if (j != i - 1) {
							appendSpace(sb, spaceEach + (j - lastI < spaceExtra? 1:0)); // j - lastI means 1st char
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
		String[] words = {"aaa", "bb", "cc", "ddddd"};
		System.out.println(fullJustify(words, 5));
	}
}
