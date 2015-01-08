package interview.amazon;


public class MergeTwoSortedList {

	/**
	 * 
	 */
	public ListNode mergeTwoSortedList (ListNode head1, ListNode head2) {
		ListNode dummyNode = new ListNode(0);
		ListNode newHead = dummyNode;
		
		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				newHead.next = head1;
				head1 = head1.next;
			} else {
				newHead.next = head2;
				head2 = head2.next;
			}
			newHead = newHead.next;
		}
		
		if (head1 != null) {
			newHead.next = head1;
		}
		
		if (head2 != null) {
			newHead.next = head2;
		}
		
		return dummyNode.next;
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode (int x) { this.val = x; }
	}
}
