package com.jiaxin.company.yahoo;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * 1. Remove Duplicates from array
 * 2. common ancestor of binary tree (有parent pointer).
 * 
 * 3. factory pattern, singleton pattern, observer pattern
 * 4. 只允许用加法实现乘法和除法 
 * 
 * 5. 两个LinkedList 找common node
 * 
 * @author jeffwan
 * @date May 13, 2014
 */
public class Part2 {
	// 1. Remove Duplicates from array. I think it's sorted
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int size = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[size] != A[i]) {
				A[++size] = A[i];
			}
		}
		
		return size + 1;
	}
	
	// 1. Remove Duplicates frome sorted array II. 能有2个相同的
	public int removeDuplicates2(int[] A) {
	    if (A == null || A.length == 0) {
	        return -1;
	    }

	    int size = 0;
	    
	    for (int i = 0; i < A.length; i++) {
	        if (A[i] == A[size] && size > 0 && A[size] == A[size - 1]) {
	            continue;
	        }    
	        
	        A[++size] = A[i];
	    }

	    return size + 1;
	}
	
	// 2. common ancestor of binary tree (有parent pointer). -- 一定考虑同一条线这个case
	public TreeNode lastestCommonAncester(TreeNode t1, TreeNode t2) {
	    if (t1 == null || t2 == null) {
	        return null;
	    }

	    ArrayList<TreeNode> t1Path = getPath(t1);
	    ArrayList<TreeNode> t2Path = getPath(t2);
	    
	    int i = t1Path.size() - 1;
	    int j = t2Path.size() - 1;

	    for (; i >= 0 && j >= 0; i--, j--) {
	        if (t1Path.get(i) != t2Path.get(j)) {
	            return t1Path.get(i).parent;
	        }    
	    }

	    return t1Path.get(i + 1);
	}

	public ArrayList<TreeNode> getPath(TreeNode root) {
	    ArrayList<TreeNode> path = new ArrayList<TreeNode>();
	    while (root != null) {
	        path.add(root);
	        root = root.parent;
	    }
	    
	    return path;
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
	
	
	// 3. Singlton - 见ResourcePool.java under ebay
	
	// 4. 只允许用加法实现乘法和除法 -- Divde 还得 bit operation, 有时间
	public int divide(int dividend, int divisor) {
	    int result = 0;
		boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
		
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		
		
		while (a >= b) {
			int shift = 0;
			while ((b << shift) <= a) {
				shift++;
			}
			
			result += 1 << (shift - 1);
			a -= (b << (shift - 1));
		}
		
		return negative? -result: result;
    }
	
	/*
	 *  5. LinkedList common node
	 *  Traverse each list once and find the global maximal value MAX
		Allocate a boolean array A with the size of MAX
		Traverse one list, for each value X in the list set A[X] = true
		Traverse the second list, for each value Y in the list if A[Y] = true then Y is a list intersection
		
	 * 其实直接用HashSet就行了，记录第一个，扫第二个	
	 */
	public ArrayList<Integer> commonNode(ListNode l1, ListNode l2) {
	    HashSet<Integer> set = new HashSet<Integer>();
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    while (l1 != null) {
	        set.add(l1.val);
	        l1 = l1.next;
	    }

	    while (l2 != null) {
	        if (set.contains(l2.val)) {
	            list.add(l2.val);    
	        }
	        
	        l2 = l2.next;
	    }
	    
	    return list;
	}
	
	
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) { val = x; }
	}
	
}
