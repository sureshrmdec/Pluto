package com.jiaxin.company.linkedin;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author jiashan
 * Two words are called isomorphic if the letters in one word can be remapped to get the second word.
 * 
 * given "foo", "app"; returns true we can map f -> a and o->p
 * given "bar", "foo"; returns false we can't map both 'a' and 'r' to 'o'
 * given "ab", "ca"; returns true we can map 'a' -> 'b' and 'c' -> 'a'
 *
 */

public class Isomorphic {
	public boolean isomorphic(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		
		if (s.length() != t.length()) {
			return false;
		}
		
		Map<Character, Character> sTot = new HashMap<Character, Character>(); 
		Map<Character, Character> tTos = new HashMap<Character, Character>(); 
		
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			if (sTot.containsKey(c1)) {
				if (sTot.get(c1) != c2) {
					return false;
				}
			}
			
			if (tTos.containsKey(c2)) {
				if (tTos.get(c2) != c1) {
					return false;
				}
			}
			
			sTot.put(c1, c2);
			tTos.put(c2, c1);
		}
		
		return true;
	}
	
	@Test
	public void test() {
		Assert.assertTrue(isomorphic("axx", "bow"));
	}
}
