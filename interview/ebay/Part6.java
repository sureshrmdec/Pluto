package interview.ebay;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 6.1 Merge sorted linked lists;
 * 6.2 Iterative inorder traversal of binary tree
 * 6.3 Inorder successor of binary search tree; 
 * 6.4 infix expression evaluation of integers and + - * /; 
 * 6.5 implement a system to route packets based on their priority;  implement associative container Map;
 * 6.6 Given n nodes, each node has 2 blocking functions: send(int to_id, int msg); recv(int from_id); 
 * each node has a value; design a method to distribute the sum of all values on every node to all nodes; 节点通信那道题目
 * 6.7 power. design a Amazon product page chat service so that people browsing on the same product page can chat with each other.
 * @author jeffwan
 * @date May 4, 2014
 */
public class Part6 {
	public static void main(String[] args) {
		TreeNode node20 = new TreeNode(20);
		TreeNode node8 = new TreeNode(8);
		TreeNode node22 = new TreeNode(22);
		TreeNode node4 = new TreeNode(4);
		TreeNode node12 = new TreeNode(12);
		TreeNode node10 = new TreeNode(10);
		TreeNode node14 = new TreeNode(14);
		node20.left = node8; node20.right = node22; 
		node8.left = node4; node8.right = node12; node12.left = node10; node12.right = node14;
		
//		System.out.println(inorderPredecessor(node20, node20).val);
		
	}
	
	
	// 6.1 merge sorted list
	public ListNode merge(ListNode l1, ListNode l2) {
	    ListNode dummy = new ListNode(0);
	    ListNode head = dummy.next;
	    
	    while (l1 != null && l2 != null) {
	        if (l1.val < l2.val) {
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
	
	// 6.2 inorder traversal
	public ArrayList<Integer> inorder(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    
	    while (root != null || !stack.isEmpty()) {
	        while (root != null) {
	            stack.push(root);
	            root = root.left;
	        }

	        if (stack.isEmpty()) {
	            root = stack.pop();
	            result.add(root.val);
	            root = root.right;        
	        }
	    }
	   
	    return result;
	}
	
	public ArrayList<Integer> inorderRecursive(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    helper(result, root);   

	    return result;
	}

	public void helper(ArrayList<Integer> result, TreeNode root) {
	    if (root == null) {
	        return;
	    }

	    helper(result, root.left);
	    result.add(root.val);
	    helper(result, root.right);
	}

	/*
	 *  6.3 Inorder successor of binary search tree; 比较prev, 返回 root, 跟下面predecessor正好相反
	 *  
	 * if (root.val == target) { return root.right; } 这样不行！别掉坑了，因为还找这个点的向左子树，所以一定需要一个parent节点来判断。
	 * 关于比较的话，这题应该assume BST无重复元素, 还是用value比，直接比TreeNode是不可行的，
	 * 除非传入原来的TreeNode, 如果new TreeNode(), 即便value相同，对象不同，返回null了
	 *  
	 */
	
		// 6.4 infix expression evaluation of integers and + - * /;
	
	
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
