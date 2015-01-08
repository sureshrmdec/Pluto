package com.jiaxin.cc.LinkedList;

/**
 * 2.6 Given a circular linkedList, implement an algorithm which returns the node at the beginning of the loop.
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class FindBeginning {

	public ListNode findBeginning(ListNode head) {
	    if (head == null) {
	        return null;
	    }

	    ListNode slow = head;
	    ListNode fast = head;
	    
	    do {
	        if (fast.next == null || fast.next.next == null) {
	            return null; //no loop
	        }
	    
	        slow = slow.next;
	        fast = fast.next.next;
	    
	    } while (slow != fast);
	    
	   
	    while (slow != head) {
	        head = head.next;
	        slow = slow.next;
	    }
	    
	    return head;
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
