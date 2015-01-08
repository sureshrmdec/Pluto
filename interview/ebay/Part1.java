package interview.ebay;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 1.1 Given a sorted integer array and a number, find the start and end indexes of n in the array.
 *  e.g. {0,0,1,1,1,5,5,6,6,6,6,7,11}, n = 5 -> output {5,6}  Follow up: Can you get it to be < O (n)
 *  
 * 1.2 Given a file that contains many strings, how would you sort all strings in the file?  
 * What is the time and space complexity?  How would you improve on the algorithm?  What about finding a string in the file?
 * 
 * 1.3 How do you reverse-traverse a linked list? -- this is not reverse linkedlist...
 * 
 * 1.4  When would you use a hashmap over an array?  Why?
 * 
 * @author jeffwan
 * @date May 3, 2014
 */
public class Part1 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2; l2.next = l3; l3.next = l4;
//		System.out.println(reverseTraversal(l1));
//		System.out.println(reveseTraversal(l1));
		
		
	}
	
	// 1.1 search for a range
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		if (nums == null || nums.length == 0) {
			result[1] = result[2] = -1;
			return result;
		}
		
		int start, end, mid;
		start = 0;
		end = nums.length - 1;

		// left bound
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (target <= nums[mid]) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (nums[start] == target) {
			result[0] = start;
		} else if (nums[end] == target) {
			result[0] = end;
		} else {
			result[0] = result[1] = -1;
			return result;
		}
		
		// right bound
		start = 0;
		end = nums.length - 1;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (target >= nums[mid]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (nums[end] == target) {
			result[1] = end;
		} else if (nums[start] == target){
			result[1] = start;
		}
		
		return result;
	}
	
	/*
	 *  1.2 sort strings
	 *  
	 *  根据字母顺序排序？ 
	 */
	
	/*
	 *  1.3 reverse traversal a linked list 不是reverse linkedList
	 * 方法1: reverse以后，traversal一遍, 这样破坏List结构了
	 * 方法2: forward traversal, 然后把每个值放到Stack里，最后stack中在走一遍
	 * 方法3: recursive. 有概念，stack和recursive 原理一样，所以stack可以解决, recursive也可以
	 *  
	 */
	// Iterative 
	public ArrayList<Integer> reveseTraversal(ListNode head) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		
		while(!stack.isEmpty()) {
			result.add(stack.pop().val);
		}
		
		return result;
	}
	
	
	// Recursive
	public ArrayList<Integer> reverseTraversal(ListNode head) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		traversal(result, head);
		return result;
	}

	private void traversal(ArrayList<Integer> result, ListNode head) {
		if (head == null) {
			return;
		}
		
		traversal(result, head.next);
		result.add(head.val);
	}

	/*
	 * 1.4 这题目其实就是为HashMap 和 类似ArrayList这种数据结构的区别，还有什么时候用什么结构
	 * 
	 * Under two situations:
	 * 1. need to store <key,value> mappings, while key is not integer
	 * 2. key is integer, but not continuous
	 * 
	 * Hashmap provide random access by O(1), but contain more overheads than an array.
	 * 
	 * HashMap is a dictionary and ArrayList is an ordered sequence(a list). They can both store objects.
	 * HashMap need a key-value pair.  ArrayList is based on index.
	 * 
	 */
		 
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
}
