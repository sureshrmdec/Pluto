package CC150.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 4.6 Write an algorithm to find the 'next' node (in-order-successor) of a given node in a BST.
 * Assume that each node has a link to its parent;
 * 
 * 这题目老做，一直理解的有问题，传入的节点是当前的那个节点，而不是root. 
 * 给root就直接遍历，比较，用个prev node记录就可以了, 
 * 仔细想想我这么写是没有意义的，BST 无重复，直接遍历找到 target.val 的节点，然后return 不就行了么，何须这么搞，理解题意错了 
 * 
 * 给current 就麻烦一点
 * 1. 是否有右子树，有 --> 就是right subtree的 leftmost
 * 2. 没有
 * 		1. 自己是否是parent的right Tree，是就向上，循环这个步骤
 * 		2. return current.parent(包含了没有右子树的两种情况)
 * 
 * Follow up: 找比current节点小的最大的值，上面是比current大的最小的值，思路一样，全部反回来就可以了
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class InorderSuccesor {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		
		node8.left = node2; node8.right = node9;
		node2.left = node1; node2.right = node4; 
		node4.left = node3; node4.right = node6;
		node6.left = node5; node6.right = node7;
		
		
		node1.parent = node2; node2.parent = node8; node2.parent = node8;
		node3.parent = node4; node4.parent = node2;
		node5.parent = node6; node6.parent = node4;
		node7.parent = node6; node9.parent = node8;
		
		System.out.println(inorderDecessor(node3).val);
		
	}
	
	// 思路上好明确，这么3中情况！
	public static TreeNode inorderSuccessor(TreeNode current) {
	    if (current == null) {
	        return null;
	    }
	    
	    if (current.parent == null || current.right != null) {
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
	
	public static TreeNode inorderDecessor(TreeNode current) {
		if (current == null) {
			return null;
		}
		
		if (current.left != null) {
			return rightMost(current.left);
		} else {
			while (current.parent != null && current.parent.right != current) {
				current = current.parent;
			}
			return current.parent;
		}
	}
	

	private static TreeNode rightMost(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		
		return root;
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
