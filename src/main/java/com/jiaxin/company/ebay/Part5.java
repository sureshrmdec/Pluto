package com.jiaxin.company.ebay;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 5.1 design pattern. factory method
 * 5.2 reverse linked list
 * 5.3 external sort
 * 5.4 两点之前最短路径
 * 5.5 3sum
 * @author jeffwan
 * @date May 3, 2014
 */

public class Part5 {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
//		System.out.println(threeSum(nums, 0));
	}
	
	// 5.1 Factory Design Pattern -- see Factory.java, following is the most simple one.
	/*
	public class CardGame {
		public static CardGame createCardGame(GameType type) {
			if (type == GameType.poker) {
				return new PokerGame();
			} else if (type == GameType.BlackJack) {
				return new BlackJackGame();
			}
			
			return null;
		}
	}
	*/
	
	// 5.2 Reverse linked list
	public ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		
		return newHead;
	}
	
	/*
	 * 5.3. External Sort 
	 * 1. Split big file into small ones. file size is not larger than memory, sort them.
	 * 2. Merge. every time load in part of the file, sort in memory and write into output buffer
	 * 3. When buffer is full. write to file, and load in new data from the file contribute to the buffer in the last step.
	 * 
	 * Answer from Mr.Duan: 
	 * 1.Divide the file into smaller chunks, sort each chunk, then merge them one by one;
	 * 2.Divide into chunks, sort each chunk, and then use a min heap get the complete file by extracting min elements.
	 * 
	 */
	
	// 5.4 Shortest Path 差这道题目
	
	
	// 5.5 3sum -- find all possible results
	public ArrayList<ArrayList<Integer>> threeSum(int[] nums, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(nums);
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		for (int i = 0 ; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int left = i + 1;
			int right = nums.length - 1;
			
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (target == sum) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					result.add(list);
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (sum < target) {
					left++;
				} else {
					right++;
				}
			}
		}
		
		return result;
	}
	
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
