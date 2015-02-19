package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Android, skip
 * 
 * Phone: 
 * 1. in-place palindrome -- in-place doesn't make sense, standard way must be in-place
 * 2. 3sum 
 * 3. Add Binary
 * 
 * Onsite: 
 * 1. Design a smooth scrolling newsfeed / http downloader (Pirate)
 * 2. Serialize / Deserialize a binary tree (Ninja)
 * 3. Anagram bucket (Jedi)
 */
public class Fourth {

	// 1. in-place palindrome. LC: Valid Palindrome
	public static boolean isPalindrome(String s) {
		if ( s == null) {
			return false;
		}
		
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			char head = Character.toLowerCase(s.charAt(left));
			char rear = Character.toLowerCase(s.charAt(right));
			
			if (!Character.isLetterOrDigit(head)) {
				left++;
				continue;
			}
			
			if (!Character.isLetterOrDigit(rear)) {
				right--;
				continue;
			}
			
			if (head != rear) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	// 2. 3sum
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (num == null || num.length == 0) {
			return result;
		}
		
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			
			int start = i + 1;
			int end = num.length - 1;
			
			while (start < end) {
				int sum = num[start] + num[end] + num[i];
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[start]);
					list.add(num[end]);
					list.add(num[i]);
					
					result.add(list);
					
					start++;
					end--;
					
					while (start < end && num[start] == num[start - 1]) {
						start++;
					}
					
					while (start < end && num[end] == num[end + 1]) {
						end--;
					}
				} else if (sum < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		
		return result;
	}
	
	
	// 3. Serialize / Deserialize a binary tree
	public static String serializeRecursive(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		
		serializeHelper(sb, root);
		
		return sb.toString().substring(0, sb.length() - 1);
	}
	
	private static void serializeHelper(StringBuilder sb, TreeNode root) {
		if (root == null) {
			sb.append("#" + ",");
			return;
		}
		
		sb.append(root.val + ",");
		serializeHelper(sb, root.left);
		serializeHelper(sb, root.right);
	}

	static int i = 0;
	public static TreeNode deserializeRecursive(String str) {
		String[] strs = str.split(",");
		
		return deserializeHelper(strs);		
	}
	

	private static TreeNode deserializeHelper(String[] strs) {
		if (i > strs.length - 1) {
			return null;
		}
		
		if (strs[i].endsWith("#")) {
			i++;
			return null;
		}
		
		TreeNode node = new TreeNode(Integer.parseInt(strs[i++])); 
		node.left = deserializeHelper(strs);
		node.right = deserializeHelper(strs);
		
		return node;
	}

	// 4. Anagram bucket (Jedi) - has the thought of Bucket sort - same to LC. -- Test case: ["", ""]
    public static List<String> anagrams(String[] strs) {
    	List<String> result = new ArrayList<String>();
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
		
    	if (strs == null || strs.length == 0) {
    		return result;
    	}
    	
    	for (String str : strs) {
    		char[] charArray = str.toCharArray();
    		Arrays.sort(charArray);
    		String key = String.valueOf(charArray);
    		
    		if (!map.containsKey(key)) {
    			map.put(key, new ArrayList<String>());
    		}
    		
    		map.get(key).add(str);
    	}
    	
    	for (List<String> list : map.values()) {
    		if (list.size() > 1) {
    			result.addAll(list);
    		}
    	}
    	
    	return result;
    }
	
	
	public static void main(String[] args) {
		
		String[] strs = {"",""};
		System.out.println(anagrams(strs));
		
//		System.out.print(isPalindrome(s));
		/* 		30
		 * 	 10    20
		 * 50   45   35
		 *  
		 */
		
		TreeNode node30 = new TreeNode(30);
		TreeNode node10 = new TreeNode(10);
		TreeNode node20 = new TreeNode(20);
		TreeNode node50 = new TreeNode(50);
		TreeNode node45 = new TreeNode(45);
		TreeNode node35 = new TreeNode(35);
		
		node30.left = node10; node30.right = node20;
		node10.left = node50; 
		node20.left = node45; node20.right = node35;
		
		String result = serializeRecursive(node30);
		System.out.println("result " + result);
		
		TreeNode newRoot = deserializeRecursive(result);
		result = serializeRecursive(newRoot);
		System.out.println("result " + result);
		
	}
	
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
