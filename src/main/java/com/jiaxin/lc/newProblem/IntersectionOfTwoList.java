package com.jiaxin.lc.newProblem;


public class IntersectionOfTwoList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		int lengthA = getLength(headA);
		int lengthB = getLength(headB);
		
		if (lengthA > lengthB) {
			for (int i = 0; i < lengthA - lengthB; i++) {
				headA = headA.next;
			}
		} else {
			for (int i = 0; i < lengthB - lengthA; i++) {
				headB = headB.next;
			}
		}
		
		while (headA != null && headB != null) {
			if (headA.val == headB.val) {
				return headA;
			}
			
			headA = headA.next;
			headB = headB.next;
		}
		
		return null;
	}


	private int getLength(ListNode head) {
		int length = 0; 
		
		while (head != null) {
			head = head.next;
			length++;
		}
		
		return length;
	}


	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
