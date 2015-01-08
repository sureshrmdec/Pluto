package CC150.LinkedList;
import java.util.HashSet;
import java.util.Hashtable;


/**
 * 2.1 Write Code tos remove duplicates from an unsorted linked list.
 * FOLLOW UP quesiton
 * How would you sovle this problem if a temporary buffer is not allowed? 
 * 
 * @author jeffwan
 * @date Feb 15, 2014
 */
public class DeleteDups {
	
	/**
	 * Solution1: Extra Space
	 * We need to record the previous node to skip to current node. or use n.next like my way.
	 * Actually, n.next = n.next.next or n = n.next all points to same node, different is delete and skip one Node.
	 * @param n
	 */
	// O(n) space, O(n) time.
	public ListNode removeDuplicates(ListNode head) {
	    if (head == null) {
	        return null;
	    }

	    HashSet<Integer> set = new HashSet<Integer>();

	    ListNode current = head;
	    ListNode lastNode = null;
	    
	    while (current != null) {
	        if (set.contains(current.val)) {
	            lastNode.next = current.next;
	        } else {
	            set.add(current.val);
	            lastNode = current;
	        }
	        
	        current = current.next;
	    }
	    
	    return head;
	}
	
	/**
	 * Solution2: No Extra Space
	 * 
	 * Runner skip is same as n skip, they points to the same list.
	 * @param n
	 */
	
	// O(1) space, O(n^2) time
	public ListNode removeDuplicates2(ListNode head) {
	    if (head == null) {
	        return null;
	    }

	    ListNode current = head;
	    while (current != null) {
	        ListNode runner = current;
	        while (runner.next != null) {
	            if (runner.next.val == current.val) {
	                runner.next = runner.next.next;
	            } else {
	                runner = runner.next;
	            }
	        }
	        
	        current = current.next;
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
