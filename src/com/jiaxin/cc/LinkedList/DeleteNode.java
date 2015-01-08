package com.jiaxin.cc.LinkedList;

/**
 * 2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 * 
 * We need the previous node if we'd like to delete the current node. The problem is we can't get it.
 * 
 * Solution: copy current.next node date to current, and then remove current.
 * We don't n.next.next, it could be null.
 *  
 * @author jeffwan
 * @date Feb 15, 2014
 */
public class DeleteNode {
	public boolean deleteNode(ListNode node) {
	    if (node == null || node.next == null) {
	        return false;
	    }

	    node.val = node.next.val;
	    node.next = node.next.next;
	    return true;
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
