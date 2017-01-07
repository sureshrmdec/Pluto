package com.jiaxin.lc.newProblem;

public class Practice {

	public int spreasheet(int nRows, int nCols, String... exprArray) {
		String s = exprArray[0];
		
		return nRows;
	}
	
	//http://www.geeksforgeeks.org/find-subarray-with-given-sum/
	public static ListNode insertionSortList(ListNode head) {
	    if (head == null) {
	        return null;
	    }
	    
	    ListNode dummy = new ListNode(0);
	    
	    while (head != null) {
	        ListNode target = dummy; 
	        while (target.next != null && target.next.val < head.val) {
	            target = target.next;
	        }
	        
	        ListNode temp = head.next;
	        head.next = target.next;
	        target.next = head;
	        head = temp;
	        
	        if (head != null) {
	        	System.out.println(head.val);	
	        }
	        
	    }
	    
	    return dummy.next;
	}
	
	
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5); 
		ListNode node2 = new ListNode(2); 
		ListNode node4 = new ListNode(4); 
		ListNode node6 = new ListNode(6); 
		ListNode node1 = new ListNode(1); 
		ListNode node3 = new ListNode(3);
		
		node5.next = node2; node2.next = node4; node4.next = node6; node6.next = node1; node1.next = node3;
		
		ListNode result = insertionSortList(node5);
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}

	public void reverse(ListNode head) {
	    if (head == null) {
	    	return;
	    }
	
	    reverse(head.next);
	    System.out.print(head.val + "->");
	}
	
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}

