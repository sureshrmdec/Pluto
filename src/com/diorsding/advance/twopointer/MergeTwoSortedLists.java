package com.diorsding.advance.twopointer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/merge-two-sorted-lists/
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 * 
 * Solution: Just Merge from two head. 
 * 
 * Follow Up:
 * http://www.lintcode.com/en/problem/merge-k-sorted-lists/
 * [
  2->4->null,
  null,
  -1->null
  ],   -----> result : -1->2->4->null.
 * 
 * Solution: Use Heap to find smallest node in K list. 
 * 
 * 
 * @author jiashan
 *
 */

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}

			head = head.next;
		}
		
		if (l1 != null) {
			head.next = l1; 
		}
		
		if (l2 != null) {
			head.next = l2;
		}
		
		return dummy.next;
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		for (ListNode node : lists) {
			if (node != null) {
				heap.offer(node);
			}
		}
		
		while (!heap.isEmpty()) {
			ListNode temp = heap.poll();
			head.next = temp; 
			head = head.next;
			
			if (temp.next != null) {
				heap.offer(temp.next);
			}
		}
		
		return dummy.next; 
    }
	
	@Test
	public void test() {
		ListNode node1 = new ListNode(1);
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(node1);
		System.out.println(mergeKLists(list));
	}
	
	
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
