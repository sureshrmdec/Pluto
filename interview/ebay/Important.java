package interview.ebay;

import interview.ebay.Part4.ListNode;
import interview.yahoo.Part2.TreeNode;

import java.util.Arrays;
import java.util.Stack;


/**
 * 1. // Input  -> "I have  36 books, 40 pens2, and 1 notebook."
 *    // Output -> "I evah  36 skoob, 40 2snep, dna 1 koobeton."
 * 2. LRU Cache --- LinkedList + HashMap
 * 常用的放在tail, capacity 满了的时候，remove 头，
 * 3. 实现O(1)时间取最小值的stack，cc150原题问我有没有做过，我当然说没有 ?? ---- another stack only push value < min();
 * 4. You are given with a singly linked list, swap nth node with head node. -- solve swap nodes
 * 5. 用+,-操作实现divide   -- Solved. LeetCode. need bit 
 * 6. inorder successor  -- Solved 
 * 
Design online system, user can find all anagrams in the file of a given word.
 * @author jeffwan
 * @date May 6, 2014
 */
public class Important {
	
	public static void main(String[] args) {
		String input = "I have 36 books, 40 3pens2, and 1 notebook.";
		System.out.println(reverseWords(input));
		System.out.println(divide(100,3));
	}
	
	// 1. reverse words
	public static String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return null;
		}
		
		Stack<Character> stack = new Stack<Character>();
		String result = "";
		
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9' && stack.isEmpty()) {
				result += c;
			} else if (c == ' ' || c == ',' || c == '.') {
				while (!stack.isEmpty()) {
					result += stack.pop();
				}
				
				result += c;
			} else {
				stack.push(c);
			}
		}
		
		return result;
	}
	
	// 2. LRU Cache

	// 4.  交换value 和交换节点都OK
	
	public static boolean swap(ListNode head, int n) {
		if (head == null || n <= 0) {
			return false;
		}
		
		ListNode runner = head;
		ListNode last = null;
		// find nth node
		for (int i = 0 ; i < n - 1; i++) {
			if (runner!= null) {
				last = runner;
				runner = runner.next;
			} else {
				return false;
			}
		}
		
		if (runner == null) {
			return false;
		}
		
		// swap the value but not listNode.
//		int temp = runner.val;
//		runner.val = head.val;
//		head.val = temp;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		// swap
		ListNode runnerNext = runner.next;
		ListNode headerNext = head.next;
		last.next = head;
		head.next = runnerNext;
		runner.next = headerNext;
		dummy.next = runner;
		
//		ListNode tempNode = head.next;
//		head.next = runner.next;
//		last.next = head;
//		runner.next = tempNode;
//		dummy.next = runner;

		
		while (dummy.next != null) {
			System.out.print(dummy.next.val + " -> ");
			dummy.next = dummy.next.next;
		}
		return true;
	}

	
	// 5. +- implements divide
	public static int divide(int divident, int divisor) {
		int result = 0;
		boolean negative = (divident < 0 && divisor > 0) || (divident > 0 && divisor < 0);
		
		long a = Math.abs((long)divident);
		long b = Math.abs((long)divisor);
		// only use +,- ,really slow, we need to use bit operation to fasten process.
//		while (a >= b) {
//			a -= b;
//			result++;
//		}
		
		while (a >= b) {
			int shift = 0;
			while ((b << shift) <= a) {
				shift++;
			}
			
			result += 1 << (shift - 1);
			a -= b << (shift - 1); 
		}
		
		return negative ? -result: result;
	}
	
	// 6. successor
	// 思路上好明确，这么3中情况！
	public static TreeNode inorderSuccessor(TreeNode current) {
	    if (current == null) {
	        return null;
	    }
	    
	    if (current.right != null) {
	        return leftMost(current.right);
	    } else {
	        while (current.parent != null && current.parent.left != current) {
	            current = current.parent;
	        }
	        return current.parent;
	    }
	}

	public static TreeNode leftMost(TreeNode root) {
	    while (root.left != null) {
	        root = root.left;
	    }
	    
	    return root;
	}
	
	
	// 2. common largetst ancester -- no parent pointer
	
		public TreeNode latestCommonAncester(TreeNode root, TreeNode t1, TreeNode t2) {
		    if (root == null || root == t1 || root == t2) {
		        return root;
		    }
		    
		    TreeNode left = latestCommonAncester(root.left, t1, t2);
		    TreeNode right = latestCommonAncester(root.right, t1, t2);

		    if (left != null && right != null) {
		        return root;
		    }

		    if (left != null) {
		        return left;
		    }
		    
		    if (right != null) {
		        return right;
		    }
		    
		    return null;
		}
	
	
	// TreeNode
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode (int x) {
			val = x;
		}
	}
	
}
