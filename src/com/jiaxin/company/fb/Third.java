package com.jiaxin.company.fb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/*
 * Phone: 
 * 1. Find 2 elements with a given sum
 * 2. Longest increasing subsequence
 * 
 * 
 * Onsite:
 * 1. Darkest submatrix (Ninja)
 * 2. Number permutations greater than the given number  (Ninja)  -> Next Permutation
 * 3. Merge K Lists (Ninja)
 * 4. Strstr (Ninja)
 * 5. Find all substring that are palindromes. (Ninja)
 * 6. balance parans (Ninja)
 * 7. Phone book, number matching with wildcards (Ninja)
 * 8. Git Bisect 
 * 9. Given an array of numbers, you can jump ahead by a[i] or go one step ahead. Minimum steps from start of array to end. 
 */
public class Third {
	// 1. two Sum
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = {-1, -1};
		
		if (numbers == null || numbers.length == 0) {
			return result;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[0] = map.get(target - numbers[i]) + 1;
				result[1] = i + 1;
				break;
			} else {
				map.put(numbers[i], i);
			}
		}
		
		return result;
	}
	
	// 2. Longest increasing subsequence -lintcode Defination: f[i] lis length end up with i, but not the longest. 
	//Different case: [3,4,10,2]  [1,2,10,4,5,6,7]
	public int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] f = new int[nums.length];
		int max = 0;
		
		for (int i = 0; i < nums.length; i++) {
			f[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i]) {
					f[i] = f[i] < f[j] + 1 ? f[i] : f[j] + 1;
				}
			}
			
			max = Math.max(f[i], max);
		}
		
		return max;
	}
		
	// 1. Darkest submatrix
	
	// 2. Number permutations greater than the given number  (Ninja)  -> Next Permutation
	public void nextPermutation(int[] num) {
		if (num == null || num.length == 0) {
			return;
		}
		
		int i = num.length - 2;
		while (i >= 0 && num[i] >= num[i + 1]) {
			i--;
		}
		
		if (i >= 0) {
			int j = i + 1;
			
			while (j < num.length && num[j] > num[i]) {
				j++;
			}
			j--;
			
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
		
		reverse(num, i + 1);
	}

	private void reverse(int[] num, int start) {
		int end = num.length - 1;
		
		while (start < end) {
			int temp = num[start];
			num[start] = num[end];
			num[end] = temp;
			start++;
			end--;
		}
	}
		
	// 3. Merge K Lists (Ninja)
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
		
		for (ListNode node: lists) {
			if (node != null) {
				heap.add(node);
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		while (!heap.isEmpty()) {
			ListNode node = heap.poll();
			head.next = node;
			head = head.next;
			
			if (node.next != null) {
				heap.add(node.next);
			}
		}
		
		return dummy.next;
    }
	
	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode o1, ListNode o2) {
			return o1.val - o2.val;
		}
	};
	
	// 4. Strstr (Ninja)
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() == 0 || needle.length() == 0) {
			return -1;
		}
		
		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			int j = 0;
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			
			if (j == needle.length()) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	// 5. Find all substring that are palindromes. (Ninja)
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		
		if (s == null || s.length() == 0) {
			return result;
		}
		
		helper(result, list, s, 0);
		
		return result;
	}
	
	private void helper(List<List<String>> result, List<String> list, String s, int position) {
		if (position == s.length()) {
			result.add(new ArrayList<String>(list));
			return;
		}
		
		for (int i = position; i < s.length(); i++) {
			String str = s.substring(position, i);
			if (!isPalindrome(str)) {
				continue;
			}
			
			list.add(str);
			helper(result, list, str, i + 1);
			list.remove(list.size() - 1);
		}
	}

	private boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
	
	// 9. Given an array of numbers, you can jump ahead by a[i] or go one step ahead. Minimum steps from start of array to end.
	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int[] step = new int[A.length];
		step[0] = 0;
		
		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j < i; j++) {
				if (j + A[j] >= i) {
					step[i] = step[j] + 1;
					break;
				}
			}
		}
		
		return step[A.length - 1];
	}
	

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
