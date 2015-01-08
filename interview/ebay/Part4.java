package interview.ebay;

import java.util.ArrayList;
import java.util.Stack;

import interview.ebay.Part2.ListNode;
import interview.ebay.Part2.TreeNode;

/**
 * 4.1 Given a Node n from a BST, 找出nextLeast(n),也就是小于n.val的最大的val的node (有parent Node)
 * 4.2 
 * ABCDE
 * FGHIJ
 * KLMNO
 * PQRST
 * UVWYX
 * Z
 * 有以下操作：up(),down(),left(),right(),enter()
 * Assume 'M' is starting point.
 * 给一个字符串s，计算应该如何操作可以打印出s. e.g:	'HI' --> up(), enter(), right(), enter()
 * 
 * 4.3 You are given with a singly linked list, swap nth node with head node
 * 4.4 用+,-操作实现divide 
 *
 * @author jeffwan
 * @date May 3, 2014
 */
public class Part4 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6;
		swap(l1, 4);
		
//		System.out.println(1  2);  
		// (Integer.MIN_VALUE, 1), (2147483647,1), (-1010369383,-2147483648)
//		System.out.println(divide(-1010369383, Integer.MIN_VALUE));
		
		char[][] board = {
				{'a', 'b', 'c', 'd', 'e'},
				{'f', 'g', 'h', 'i', 'j'},
				{'k', 'l', 'm', 'n', 'o'},
				{'p', 'q', 'r', 's', 't'},
				{'u', 'v', 'w', 'x', 'y'}};
		System.out.println(findString(board, "hi"));
		
		
	}
	
	// 4.1 inorder traversal, current == n, return parent. 利用inorder的特性
	public TreeNode nextLeast(TreeNode root, TreeNode n) {
		if (n == null) {
			return null;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode last = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			
			if (!stack.isEmpty()) {
				root = stack.pop();
				last = root;
				root = root.right;
				if (root == n) {
					return last;
				}
			}
		}
		
		return null;
	}
	
	
	// 4.2 also same to boggle game
	static ArrayList<ArrayList<String>> realResult = new ArrayList<ArrayList<String>>();
	public static ArrayList<String> findString(char[][] board, String word) {
		
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		if (board == null || board.length == 0 || board[0].length == 0) {
			return result;
		}
		
		search(result, sb, board, 2, 2, word);
		return result;
	}
	
	private static void search(ArrayList<String> result, StringBuilder sb, char[][] board, int i, int j, String word) {
		if (word.length() == sb.length()) {
			realResult.add(new ArrayList<String>(result));
			return;
		}
		
		if ((sb.length() != 0) && (word.charAt(sb.length()) != board[i][j])) {
			return;
		}
		
		if (word.charAt(sb.length()) == board[i][j]) {
			result.add("enter");
			sb.append(board[i][j]);
		}
		
		
		if ( i - 1 >= 0 && i < board.length && j >= 0 && j < board[0].length) {
			result.add("up");
			search(result, sb, board, i - 1, j, word);
			result.remove(result.size() - 1);
		}
		if ( i >= 0 && i < board.length && j - 1>= 0 && j < board[0].length) {
			result.add("left");
			search(result, sb, board, i, j - 1, word);
			result.remove(result.size() - 1);
		}
		if ( i >= 0 && i + 1 < board.length && j >= 0 && j < board[0].length) {
			result.add("down");
			search(result, sb, board, i + 1, j, word);
			result.remove(result.size() - 1);
		}
		if ( i >= 0 && i < board.length && j >= 0 && j + 1< board[0].length) {
			result.add("right");
			search(result, sb, board, i, j + 1, word);
			result.remove(result.size() - 1);
		}
			
		
		result.remove(result.size() - 1);
		sb.deleteCharAt(sb.length() - 1);
	
	}

	// 4.3 swap nth node with head node. 是单纯的交换head和nth两个点，不是rotate，别被leetcode定式思维了
	// 交换value 和交换节点都OK
	
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
	
	// 4.4 +, - to implement divide. 用 long 把test case 过掉，比如Integer.MIN_VALUE/1	
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
