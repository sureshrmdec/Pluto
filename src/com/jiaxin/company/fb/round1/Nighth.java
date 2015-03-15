package com.jiaxin.company.fb.round1;

import java.util.Set;

import com.jiaxin.company.fb.round1.Twelfth.ListNode;
import com.jiaxin.company.fb.round1.Twelfth.TreeNode;

/*
 * Phone:
 * 1. Implement big/littke endianess check function
 * 2. Implement insert for circular queue. 
 * 
 * Onsite: 
 * 1. String Regexp Mather Simple (Ninja)
 * 2. List flatten (Ninja)
 * 3. Design FB chat (pirate)
 * 4. Given a BST'S root and a key, find the predecessor node before the key (Jedi)
 * 5. Swap pairs of nodes in a singly linked list, e.g. 1->2->3->4->5 becomes 2->1->4->3->5 (Ninja)
 * 6. Word breaking: given a string and a dictionary, determine whether the string can be broken into words (Ninja)
 * 7.  
 */
public class Nighth {

	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode lastNode = dummy;
		
		while (head != null && head.next != null) {
			ListNode temp = head.next.next;
			head.next.next = lastNode.next;
			lastNode.next = head.next;
			head.next = temp;
			
			lastNode = head;
			head = head.next;
		}
		
		return dummy.next;
	}
	
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || dict == null) {
			return false;
		}
		
		int maxLength = getMaxLength(dict);
		boolean[] canSegment = new boolean[s.length()];
		canSegment[0] = true; 
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= i && j < maxLength; j++) {
				String word = s.substring(i - j, i);
				if (canSegment[j] && dict.contains(word)) {
					canSegment[i] = true;
					break;
				}
			}
		}
		
		return false;
	}
	
	
	private int getMaxLength(Set<String> dict) {
		int length = 0;
		for (String s: dict) {
			length = Math.max(length, s.length());
		}
		
		return length;
	}


	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
