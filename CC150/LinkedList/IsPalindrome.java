package CC150.LinkedList;

import java.util.Stack;

/**
 * 2.7 Implement a function to check if a linked list is a palindrome. 
 * 
 * 这个题目用stack来做，先拿到list长度，然后stack push进去一般的长度. 
 * 然后对比head和stack.pop的值，最后应该是stack.isEmpty() head == null.  
 * 注意length 奇数偶数的情况，奇数的话，需要head = head.next 跳过一个值
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class IsPalindrome {
	public boolean isPalindrome(ListNode head) {
	    if (head == null) {
	        return false;
	    }
	    
	    Stack<ListNode> stack = new Stack<ListNode>();    
	    int length = getLength(head);
	    
	    for (int i = 0; i < length / 2; i++) {
	        stack.push(head);
	        head = head.next;
	    }    
	    
	    if (length % 2 == 1) {
	        head = head.next;
	    }
	    
	    while (!stack.isEmpty() && head != null) {
	        ListNode temp = stack.pop();
	        if (temp.val != head.val) {
	            return false;
	        }    
	        head = head.next;
	    }
	    
	    return true;
	}

	private int getLength(ListNode head) {
	    int length = 0;
	    while (head != null) {
	        head = head.next;
	        length++;
	    }
	    
	    return length;
	}
	
	// Node 
	static class ListNode{
		ListNode next = null;
		int val;
		
		ListNode(int data) {
			this.val = data;
		}
	}
}
