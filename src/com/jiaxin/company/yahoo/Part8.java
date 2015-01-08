package com.jiaxin.company.yahoo;


/**
 * 1 .longest common ancester
 * 2. how much memory to store a MxN sized picture, bad word filter using hash/trie. -- 不会
 * 
 * 3. Copy List with Random Pointer
 * 4. linux command du how to design it. -- 不会
 * 
 * 5. Level order binary tree
 * 6.  给一个数字，转化成字符串，有多少种可能比如123，1=>a, 2=>b, 3=>c; 12=>l, 3=>c;  1=>a, 23=>w
 * 
 * 7. Buy Stock I
 * 8. LRU Cache 
 * 
 * 9. reverse linkedlist 
 * 10. how to sovle deack lock
 *   
 * 
 * @author jeffwan
 * @date May 13, 2014
 */


public class Part8 {
	// 1. longest common ancester
	public TreeNode longestCommonAncester(TreeNode root, TreeNode t1, TreeNode t2) {
	    if (root == null || root == t1 || root == t2) {
	        return root;
	    }
	    
	    TreeNode left = longestCommonAncester(root.left, t1, t2);
	    TreeNode right = longestCommonAncester(root.right, t1, t2);
	    
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
	
	
	// 2. 不会
	
	// 3. Copy List with Random Pointer
	public ListNode copyRandomList(ListNode head) {
	    if (head == null) {
	        return null;    
	    }
	    
	    copyNode(head);
	    copyRandom(head);
	    return split(head);
	}

	public void copyNode(ListNode head) {
	    while (head != null) {
	        ListNode newNode = new ListNode(head.val);
	        newNode.next = head.next;
	        head.next = newNode;
	        head = head.next.next;
	    }
	}

	public void copyRandom(ListNode head) {
	    while (head != null && head.next != null) {
	        if (head.random != null) {
	           head.next.random = head.random.next; 
	        }    
	        head = head.next.next;
	    }
	}

	public ListNode split(ListNode head) {
	    ListNode newHead = head.next;
	    while (head != null) {
	        ListNode temp = head.next;
	        head.next = head.next.next;
	        head = head.next;
	        
	        if (temp.next != null) {
	            temp.next = temp.next.next;
	        }
	    }
	    return newHead;
	}
	
	// 4. du command -- 不会
	
	// 5. level order 太简单不写了
	
	// 6. number decoding
	public int numDecoding(int x) {
	    if (x < 0) {
	        return -1;
	    }

	    String s = String.valueOf(x);
	    int[] nums = new int[s.length() + 1];
	    nums[0] = 1;
	    nums[1] = s.charAt(0) != '0'? 1: 0;
	    
	    for (int i = 2; i < nums.length; i++) {
	        if (s.charAt(i) != '0') {
	            nums[i] = nums[i - 1];
	        }
	    
	        int twoDigit = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
	        if (twoDigit >= 10 && twoDigit <= 26) {
	            nums[i] += nums[i - 2];
	        }
	    }
	    
	    return nums[s.length()];
	}
	
	// 7. Buy Stock I
	public int maxProfits(int[] prices) {
	    if (prices == null || prices.length == 0) {
	        return 0;   
	    }
	    
	    int lowestPrice = Integer.MAX_VALUE;
	    int profit = 0;
	    
	    for (int price : prices) {
	        lowestPrice = Math.min(lowestPrice, price);
	        profit = Math.max(profit, price - lowestPrice);
	    }
	    
	    return profit;
	}
	
	// 8. LRU Cache -- 太长了，没写这了，
	// 注意每次都要同时 考虑, map的变化 和 双链表的变化. 用双链表主要是删除节点爽. 否则可以用linkedlist了，每次删除traversal 太麻烦
	
	// 9. Reverse LinkedList - 太简单不写了
	// 10. How to solve dead lock. -- notes
	
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode random;
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
