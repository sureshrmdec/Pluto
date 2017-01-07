package com.jiaxin.company.linkedin;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CommonChar {
	
	/**
	 * Write a program that gives count of common characters presented in an array of strings..(or array of character arrays) 

	For eg.. for the following input strings.. 

	aghkafgklt 
	dfghako 
	qwemnaarkf 

	The output should be 3. because the characters a, f and k are present in all 3 strings. 

	Note: The input strings contains only lower case alphabets
	 */
		
	// can't use map. may have duplicates in one string. makes count(c) > 3.
	// same to longest common prefix. Use first one as compare object, compare with other strings
	public int getNumOfCommonChars(String[] inputs) {
		if (inputs == null || inputs.length == 0) {
			return 0;
		}
		
		char[] array = inputs[0].toCharArray();
		Set<Character> set = new HashSet<Character>(); 
		
		for (int i = 0; i < array.length; i++) {
			int j = 2;
			for (j = 2; j < inputs.length; j++) {
				if (inputs[j].indexOf(array[i]) == -1) {
					break;
				}
			}
			
			if (j == inputs.length) {
				set.add(array[i]);
			}
		}
		
		System.out.println(set);
		return set.size();
	}
	
	@Test
	public void test() {
		String[] inputs = {"aghkafgklt", "dfghako", "qwemnaarkf"};
		System.out.println(getNumOfCommonChars(inputs));
	}
}
