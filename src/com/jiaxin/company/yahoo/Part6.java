package com.jiaxin.company.yahoo;

import java.util.ArrayList;
import java.util.Arrays;

import com.jiaxin.company.yahoo.Part2.ListNode;
import com.jiaxin.company.yahoo.Part2.TreeNode;

/**
 * 1. subsets
 * 2. 3sum 
 * 3. 4sum
 * 
 * 4. subsets sum
 * 5. search for a range
 * 6. fabonacci
 * 
 * 7. linkedlist swap node 一对一对交换
 * 8. 找到BST小于一个value的最大元素
 * 9. Implement Producer-consumer  --- 这是个多线程的经典问题，交通灯？
 * 10. 地铁售票机 
 * 
 * 11. 有2 billion个URL，每个URL都有一个size, 对于所有的size, 怎么找出95th percentile -- 不会
 * 12. strStr
 * 13. 怎么判断一个数是否是2的整数次方
 * 14. String matching，一个String里有字母和＊， 怎么判断是否能够match一个dictionary中的任意单词
 * 
 * 15. Implement equal method for generic objects.
 * 16. Implement string reversion
 * 17. 怎么保证一个method是thread safe的。什么是deadlock？
 * 
 * 18. remove listNode just use itself
 * 19. 有一个过山车，从高空往下看是个圆形，并且只有一层。是不是存在两个点，他们的连线经过圆心，并且高度相等。若存在，如何找到它们？
 * 20. String replacement, 如何把一个string中所有的substr1更改成substr2？

 * 
 * 
 * @author jeffwan
 * @date May 13, 2014
 */
public class Part6 {
	public static void main(String[] args) {
		System.out.println(Math.pow(2, 32));
	}
	
	
	// 1. subsets -- 只写iterative了这里， 
	// 理解int， 2^32 - 1. 4bytes, 不是说一半表示正，一般负数，java 不管. 所以是2^32. 这种做法最多支持32个树的array
	public ArrayList<ArrayList<Integer>> subset(int[] A) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    
	    int maxSize = 1 << A.length;
	    
	    for (int i = 0; i < maxSize; i++) {
	        ArrayList<Integer> list = convertArray(i, A);
	        result.add(list);
	    }
	    
	    return result;
	}

	public ArrayList<Integer> convertArray(int k, int[] A) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    int index = 0;
	    for (int i = k; i > 0; i >>= 1) {
	        if ((i & 1) == 1) {
	            list.add(A[index]);
	        }
	        index++;
	    }
	    return list;
	}
	
	// 2. 3sum . 
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    Arrays.sort(num);
	    if (num == null || num.length == 0) {
	       return result;        
	    }
	    
	    for (int i = 0; i < num.length; i++) {
	        if (i != 0 && num[i] == num[i - 1]) {
	            continue;
	        }
	        
	        int start = i + 1;
	        int end = num.length - 1;
	        
	        while (start < end) {
	            int sum = num[i] + num[start] + num[end];
	            if (sum == 0) {
	                ArrayList<Integer> tripple = new ArrayList<Integer>();
	                tripple.add(num[i]);
	                tripple.add(num[start]);
	                tripple.add(num[end]);
	                result.add(tripple);
	                start++;
	                end--;
	                
	                while (start < end && num[start] == num[start - 1]) {
	                    start++;
	                }
	                
	                while (start < end && num[end] == num[end + 1]) {
	                    end--;
	                }
	            } else if (sum < 0) {
	                start++;
	            } else {
	                end--;
	            }
	        }
	    }
	    
	    return result;
	}
	
	//  3. 4sum 多一层循环，不写了，没必要，写一下3sum closet
	public int threeSumClosest(int[] num, int target) {
	    if (num == null || num.length == 0) {
	        return -1;
	    }
	    Arrays.sort(num);
	    int closet = Integer.MAX_VALUE / 2;    

	    for (int i = 0 ; i < num.length; i++) {
	        int start = i + 1;
	        int end = num.length - 1;

	        
	        while (start < end) {
	            int sum = num[i] + num[start] + num[end]; 
	            if (sum == target) {
	                return sum;    
	            } else if (sum < target) {
	                start++;
	            } else {
	                end--;
	            }
	            
	            closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum : closet;
	        }
	    }
	    
	    return closet;
	}
	
	// 4. subsets sum 不写了，就每次subset 求一次和，然后判断下，是的加进去
	
	// 5. search for a range(sorted array)
	public int[] searchRange(int[] A, int target) {
	    int[] bound = new int[2];
	    if (A == null || A.length == 0) {
	        bound[0] = bound[1] = -1;
	    }
	    
	    // search for left
	    int start = 0;
	    int end = A.length - 1;
	    
	    while (start + 1 < end) {
	        int mid = start + (end - start) / 2;
	        if (target == A[mid]) {
	            end = mid;
	        } else if (target < A[mid]) {
	            end = mid;
	        } else {
	            start = mid;
	        }
	    }
	    
	    if (A[start] == target) {
	        bound[0] = start;
	    } else if (A[end] == target) {
	        bound[1] = end;
	    } else {
	        bound[0] = bound[1] = -1;
	        return bound;
	    }
	      
	      
	    // search for right
	    start = 0;
	    end = A.length - 1;
	    while (start + 1 < end) {
	        int mid = start + (end - start) / 2;
	        if (target == A[mid]) {
	            start = mid;
	        } else if (target < A[mid]) {
	            end = mid;
	        } else {
	            start = mid;
	        }
	    }
	    
	    if (A[end] == target) {
	        bound[1] = end;
	    } else if (A[start] == target) {
	        bound[1] = start;
	    } 
	    
	    return bound;
	}
	
	// 6. fabonacci 不写了，太熟悉了，注意DP写法，优化递归次数就可以了

	// 7/ swap pairs
	public ListNode swapPairs(ListNode head) {
	    if (head == null || head.next == null) {
	        return null;
	    }

	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode lastNode = head;

	    while (head != null && head.next != null) {
	        //swap nodes
	        ListNode temp = head.next.next;
	        head.next.next = lastNode.next;
	        lastNode.next = head.next;
	        head.next = temp;
	       
	        // move forward 
	        lastNode = head;
	        head = head.next;
	    }

	    return head;
	}
	
	// 8.找到BST小于一个value的最大元素
	public TreeNode prevNode(TreeNode node) {
	    if (node == null) {
	        return null;
	    }

	    if (node.parent == null || node.left != null) {
	        return leftMostRight(node.left);
	    }
	    
	    while (node.parent != null || node.parent.right != node) {
	        node = node.parent;
	    }
	    
	    return node.parent;
	}    

	public TreeNode leftMostRight(TreeNode root) {
	    if (root.right != null) {
	        root = root.right;
	    }
	    
	    return root;
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
