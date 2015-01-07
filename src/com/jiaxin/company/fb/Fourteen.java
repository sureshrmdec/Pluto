package com.jiaxin.company.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * Phone:
 * 1. Implement function which returns true or false if two words are anagrams
 * 2. Given a binary tree, implement serialize and deserialize functions, such that deserialize(serialize(root)) 
 * 	returns equivalent tree. You can choose the serialization format. 
 * 3. Give a needle and haystack, tell if an anagram of the needle can be found as a substring in the haystack. 
 * 
 * 
 * Onsite:
 * 1. Print tree by levels. (Ninja) 
 * 2. Determine if 2 Strings are 1 edit distance apart.(Ninja) 
 * 3. Determine the edit distance between 2 strings (Ninja)
 * 4. Binary Search (Jedi)
 * 5. Let's say you have a very scalable storage system that contains 10^12 English text documents gathered from the web. They
are small in size, say averaging 10KB of data. You want to build a large scale distributed system that scans the documents
and produces a dataset that contains the frequency of all the ordered word pairs on the documents. For example, the
ordered pair ("they", "are") might map to 40,000,000 but the ordered pair ("purple", "submarine") would probably map to
something lower like 2, since it's very unlikely in English. (Pirate)
 *  
 */

public class Fourteen {
	// Anagram 
	// Test case: ["",""]  single one. mainly on temp.size() > 1
	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
		Map<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
		
		if (strs == null || strs.length == 0) {
			return result;
		}
		
		for (String str: strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String key = new String(charArray);
			
			if (!dict.containsKey(key)) {
				dict.put(key, new ArrayList<String>());
			}
			
			dict.get(key).add(str);
		}
		
		for (ArrayList<String> temp : dict.values()) {
			if (temp.size() > 1) {
				result.addAll(temp);
			}
		}
		
		return result;
    }
	
	public String serialization(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				sb.append(root.val);
				stack.push(root);
				root = root.left;
			}
			
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			}
		}
		
		return sb.toString();
	}
	
	public TreeNode deserialization(String string) {
		
		
		return null;
	}
	

	
	public static void main(String[] args) {
		String[] input = new String[1];
		input[0] = "a";
//		System.out.println(anagrams(input));
	}
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
