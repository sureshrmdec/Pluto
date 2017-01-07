package com.jiaxin.company.ebay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.jiaxin.company.ebay.Part2.ListNode;
import com.jiaxin.company.ebay.Part2.TreeNode;

/**
 * 3.1 Given an integer array, determine whether there exists an element such that the number of occurrences of 
 * the element strictly exceeds the number of occurrences of any other element.
 * [1, 2, 3] => false
 * [1, 2, 3, 2] => true
 * [1, 2, 3, 2, 3] => false
 * [1, 2, 3, 4, 4, 4, 5, 5, 5] => false
 * 
 * 3.2 Two Attribute of Heap
 * 
 * 3.3 pow(x, y)
 * 
 * 3.4 Given a string with missing spaces "FindaString", divide into words i.e. "Find", "a", "String"
 * boolean isDictionaryWord(String word);
 * 
 * 3.5 Wordladder 2
 * 
 * 3.6 设计题： facebook 查找好友功能
 * 
 * @author jeffwan
 * @date May 3, 2014
 */
public class Part3 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,4,4,5,5,5,5};
		String s = "catsanddog";
		Set<String> set = new HashSet<String>();
		set.add("cat"); set.add("cats"); set.add("and"); set.add("sand"); set.add("dog");
		System.out.println(wordBreak(s, set));
				
//		System.out.println(findHighOccurrence(nums));
	}
	
	// 3.1 find highest occurrences. 统计int 频率的变种题目, 最高频率的是1个就是true，1个以上false.
	public boolean findHighOccurrence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i: nums) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		
		// find highest occurrences
		int max = 0;
		for (int i : map.values()) {
			if (i > max) {
				max = i;
			}
		}
		
		// find result
		int count = 0;
		for (int key: map.keySet()) {
			if (map.get(key) == max) {
				count++;
			}
		}
		
		return count == 1; 
	}
	
	/*
	 * 3.2 Heap Attribute
	 * 1. Logically is a complete tree, Physically is a array
	 * 2. root is the largest/least element.
	 * 3. index --- parent i, children 2i+ 1, 2i + 2, child i, parent (i - 1) / 2 
	 */
	
	// 3.3 pow(x, y)
	public int pow(int x, int y) {
		if (y == 0) {
			return 1;
		}
		
		if (y == 1) {
			return x;
		}
		
		if (y < 0) {
			if (y == Integer.MIN_VALUE) {
				return 1 / (pow(x, Integer.MAX_VALUE) * x);
			} else {
				return 1 / pow(x, -y);
			}
		}
		
		if (y % 2 == 0) {
			return pow(x, y / 2) * pow(x, y / 2);
		} else {
			return pow(x, y / 2) * pow(x, y / 2) * x;
		}
	}
	
	// 3.4 Given a string with missing spaces "FindaString", divide into words i.e. "Find", "a", "String" 
	// boolean isDictionaryWord(String word); 
	// 这题算是word break.. 跟大写字符啥的没关系，当成word break II. 直接给了方法很方便
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return result;
		}
			
		helper(s, dict, 0, "", result);
		return result;
    }

	private static void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res) {
		if (start >= s.length()) {
			res.add(item);
			return;
		}
		StringBuilder str = new StringBuilder();
		
		for (int i = start; i < s.length(); i++) {
			str.append(s.charAt(i));
			if (dict.contains(str.toString())) {
				String newItem = item.length() > 0 ? (item + " " + str.toString()) : str.toString();
				helper(s, dict, i + 1, newItem, res);
			}
		}
	}
	
	
	// 3.5 Word ladder 2
	
	
	
	/*
	 * 3.6
	 * 假设在一个服务器高峰时间，来的查询量很大，你怎么handle （注意，已经具体是 一个服务器了） -- frome me: 我觉得LZ的面经写的有问题，不一定是一个服务器吧。。一个时段 
	 * 我说的是
	 * 1. 根据user active 程度，划分priority， 然后delay low priority user request 
	 * 2. 根据request cost， 决定priority
	 *   
	 *   
	 */
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
}
