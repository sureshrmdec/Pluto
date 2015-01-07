package com.jiaxin.lc.permutation.advance;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    char[][] map = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, 
				{'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
	
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder();
    	
    	letterCombinationsHelper(result, sb, digits);
    	
    	return result;
	}

	private void letterCombinationsHelper(List<String> result, StringBuilder sb, String digits) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}
		
		int index = Character.getNumericValue(digits.charAt(sb.length()));
		
		for (int i = 0; i < map[index].length; i++) {
			sb.append(map[index][i]);
			letterCombinationsHelper(result, sb, digits);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
