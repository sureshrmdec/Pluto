package CC150.LinkedList;


/**
 * 2.4 Write code a partition a linkedList around a value x, such that all nodes less than x 
 * come before all nodes greater than or equal to x.  
 * 
 * CC150上的方法弱爆了，直接上dummyNode就OK了
 * 
 * 
 * @author jeffwan
 * @date Feb 15, 2014
 */
public class Partition {
	public ListNode partition(ListNode head, int x) {
	    if (head == null) {
	        return null;
	    }    

	    ListNode dummyLeft = new ListNode(0);
	    ListNode dummyRight = new ListNode(0);
	    ListNode left = dummyLeft, right = dummyRight;
	    
	    while (head != null) {
	        if (head.val <= x) {
	            left.next = head;
	            left = left.next;
	        } else {
	            right.next = head;
	            right = right.next;
	        }

	        head = head.next;
	    }
	    
	    right.next = null;
	    left.next = dummyRight.next;

	    return dummyLeft.next;    
	}
	
	
	
	
	public ListNode partition2 (ListNode node, int x) {
		ListNode beforeStart = null;
		ListNode afterStart = null;
		
		while (node != null) {
			ListNode next = node.next;
			node.next = null;
			
			if (node.val < x) {
				if (beforeStart == null) {
					beforeStart = node;
				} else {
					node.next = beforeStart;
					beforeStart = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
				} else {
					node.next = afterStart;
					afterStart = node;
				}
			}
			node = next;
		}

		if (beforeStart == null) {
			return afterStart;
		}
		
		ListNode head = beforeStart;
		while (beforeStart != null) {
			beforeStart = beforeStart.next;
		}
		
		beforeStart.next = afterStart;
		return head;
	}
	
	
	/**
	 * Solution 2: merge Two list (less than and more than), each has a head and end pointer. 
	 * We get every node and to see if node.val < x, then insert before list end.
	 * 
	 * Take care: I miss the following lines. --> cut the connection with the original following list.
	 * LinkedListNode next = node.next;
	 * node.next = null;  
	 * 
	 */
	public ListNode partition3 (ListNode node, int x) {
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;
	
		
		while(node != null) {
			// Terminte the current links
			ListNode next = node.next;
			node.next = null;
			if (node.val < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = node;
				} else {
					beforeEnd.next = node;
					beforeEnd = beforeEnd.next;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = node;
				} else {
					afterEnd.next = node;
					afterEnd = afterEnd.next;
				}
			}
			node = next;
		}
		
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		
		return beforeEnd;
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
