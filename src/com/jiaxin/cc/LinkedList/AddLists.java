package com.jiaxin.cc.LinkedList;

/**
 * 2.5 add List 
 * 1 -> 2 -> 3
 * 2 -> 3 -> 4 ->5
 * 这是逆序的，是 312 + 5432
 * CC150上的没用，直接加就行了，给的参数carry也没用. LeetCode add two numbers
 * 
 * Follow Up: 因为这个题目是逆序的，最大位是尾巴. 如果是顺序的，就不一样了， 就是 123 + 2345，尾巴要对齐，所以需要
 * 1.getLength, 对短的补齐0.
 * 2. 我觉得可以Reverse LinkList
 * 3. 按照逆序的，也就是这道题的方法计算
 * 4. 最后reverse还原回来
 * 
 * @author jeffwan
 * @date May 5, 2014
 */

public class AddLists {
	public ListNode addList(ListNode l1, ListNode l2, int carry) {
	    if (l1 == null && l2 == null) {
	        return null;
	    }
	    
	    ListNode dummy = new ListNode(0);
	    ListNode head = dummy;

	    while (l1 != null && l2 != null) {
	        int sum = l1.val + l2.val;
	        carry = sum / 10;
	        head.next = new ListNode (sum % 10);
	        head = head.next;
	        l1 = l1.next;
	        l2 = l2.next;
	    }
	    
	   while (l1 != null) {
	       int sum = l1.val + carry;
	       carry = sum / 10;
	       head.next = new ListNode(sum % 10);
	       head = head.next;
	       l1 = l1.next;
	   } 
	   
	   while (l2 != null) {
	       int sum = l2.val + carry;
	       carry = sum / 10;
	       head.next = new ListNode(sum % 10);
	       head = head.next;
	       l2 = l2.next;
	   }
	   
	   if (carry != 0) {
	       head.next = new ListNode(carry);
	   }
	   
	   return dummy.next;
	}
	
	
	// Node 
	class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			this.val = x;
		}
	}
}
