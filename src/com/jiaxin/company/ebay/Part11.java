package com.jiaxin.company.ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

/**
 * [面试经验] Ebay offer， 面试经验
 * Interview Time : 2014.1-3
 * Link:http://www.1point3acres.com/bbs/forum.php?mod=forumdisplay&fid=145&filter=sortid&sortid=311
 * 
 * Phone interview:
 * 1. subset recursive + iterative
 * 2. 统计string内部各个字符的出现次数并返回最高频的字符
 * 
 * Four round Skype:
 * 1. word ladder
 * 2. boggle game
 * 3. 节点通信（属于Distributed System问题）
 * 4. ZigZag Traversal Binary Tree，这个也是leetcode原题，可以用两个Stack解决.也可以 add.list(index, E);
 * 5. Merge Two Sorted Array 
 * 
 * 
 * Conlcusion: 
 * 1. 一般要记住subset这类题目要non-descending order, 所以要sort一下，iterative way思路一样，用111这样的二进制数组表示
 * 2. 牢记HashMap的遍历 用Map.Entry<>.http://stackoverflow.com/questions/1066589/java-iterate-through-hashmap
 * 
 * @author jeffwan
 * @date Apr 21, 2014
 */
public class Part11 {
	public static void main(String[] args) {
		int[] nums = {2,3,1};
//		System.out.println(subsetIterative(nums));
//		String s = "abecefghijksssseeseeqqqaaaaaa";
//		System.out.println(findChar(s));
		
		char[][] boggle = {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'},{'i', 'j', 'k', 'l'},{'m', 'n', 'o', 'p'}};
		String target = "abf";
//		System.out.println(searchResult(boggle, target));
	}
	
	// Phone Interview 1: subset
	public ArrayList<ArrayList<Integer>> subset(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		helper(result, list, nums, 0);
		return result;
	}
	
	private void helper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int[] nums, int position) {
		result.add(new ArrayList<Integer>(list));
		
		for (int i = position; i < nums.length; i++) {
			list.add(nums[i]);
			helper(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	// Phone Interview 1: subset - Iterative
	public ArrayList<ArrayList<Integer>> subsetIterative(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		
		int max = 1 << nums.length;
		for (int i = 0; i < max; i++) {
			ArrayList<Integer> list = convertIntToList(i, nums);
			result.add(list);
		}
		
		return result;
	}
	
	private static ArrayList<Integer> convertIntToList(int k, int[] nums) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index = 0;
		for (int i = k; i > 0; i >>= 1) {
			if ((i & 1) == 1) {
				list.add(nums[index]);
			}
			index++;
		}
		
		return list;
	}

	// Phone Interview 2: 统计string内部各个字符的出现次数并返回最高频的字符 - duplicates? O(n) + O(n) -> O(n)
	public char findMostChar(String s) {
		if (s == null || s.length() == 0) {
			return "".charAt(0);
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = s.toCharArray();
		
		for (char c: chars) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		int max = 0;
		char result = ' ';
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (max < entry.getValue()) {
				result = entry.getKey();
				max = entry.getValue();
			}
		}
		
		return result;
	}
	
	// Skype 1: Word Ladder	每个词, L*26 种替换方法，最差走遍所有 dict.O(n*26*L)   Test Case: start == end, 这个要问面试官了，看怎么返回，改动150-152
	public static int ladderLength(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || dict == null || dict.size() == 0) {
			return 0;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int length = 1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0 ; i < size; i++) {
				String current = queue.poll();
				
				for (int j = 0; j < current.length(); j++) {
					for (char c = 'a'; c <= 'z'; c++) {
						if (current.charAt(j) == c) {
							continue;
						}
						
						String temp = replaceChar(current, j, c);
						if (temp.equals(end)) {
							return length + 1;
						}
						if (dict.contains(temp)) {
							queue.offer(temp);
							dict.remove(temp);
						}
					}
				}
			}
			length++;
		}
		
		return 0;
	}

	private static String replaceChar(String current, int j, char c) {
		char[] temp = current.toCharArray();
		temp[j] = c;
		return new String(temp);
	}
	
	/**
	 * Skype2: Boggle Gamge 这个跟真实游戏不同，不允许对角线方向，只能上下左右.
	 * 
	 * 给定一个string，再给定一个二维的字符数组，每次只允许在二维数组中上下左右移动，禁止访问曾经访问过的字符，
     * 问该string是否可以在这个二维字符数组中被发现，返回true or false, dict是
		a b c d
		e f g h
		i j k l
		m n o p
		那么string：“abf”，返回true
		string：”efi“，返回false , 这只是一个简单的DFS,用一个StringBuffer记录当前节点，然后expand再循环进入。
		--------
		对每一个点遍历DFS, 只要有一个值 return true，result return true. DFS 典型找解的题目
		首先要遍历boggle.length^2 个点，每个点，需要4个方向, 每个方向长度是target.length()m. O(n^2 * 4*m ) -> O(mn^2)
		
	 */
	// 这题做了简化版，只有四个方向，完整方向的看BoggleGame.java -- 用sb 代替start 也行
	// 别用if () { return hasResult(boggle, target, i, j - 1, start + 1) } 这种，有错，把他放条件中去
	boolean[][] visited = new boolean[4][4];
	public boolean searchResult(char[][] boggle, String target) {
		if (boggle == null || boggle.length == 0 || boggle[0].length == 0) {
			return false;
		}
	
		for (int i = 0; i < boggle.length; i++) {
			for (int j = 0; j < boggle[i].length; j++) {
				if (hasResult(boggle, target, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasResult(char[][] boggle, String target, int i, int j, int start) {
		if (target.charAt(start) != boggle[i][j]) {
			return false;
		}
		
		if (start == target.length() - 1) {
			return true;
		}
		
		visited[i][j] = true;
		
		// Then Go Up --> Left --> Down --> Right 
		if (i - 1 >= 0 && !visited[i - 1][j] && hasResult(boggle, target, i - 1, j, start + 1)) {
			return true;
		}
		if (j - 1 >= 0 && !visited[i][j - 1] && hasResult(boggle, target, i, j - 1, start + 1)) {
			return true;
		}
		if (i + 1 < boggle.length && !visited[i + 1][j] && hasResult(boggle, target, i + 1, j, start + 1)) {
			return true;
		}
		if (j + 1 < boggle.length && !visited[i][j + 1] && hasResult(boggle, target, i, j + 1, start + 1)) {
			return true;
		}
	
		// BackTrack
		visited[i][j] = false;
		return false;
	}
	
	/**
	 * Skype3: 节点通信
	 * 
	 * 节点通信（属于Distributed System问题）。给定N个节点，节点通过某种safe的总线相连接，每个节点都拥有两个函数:
		一个是void send(int id, int value): 意思是把一个value传送给那个编号为id的节点；
		一个int receive(int id)：意思是从编号为id的节点接收其传输的value并返回这个value。
		现在的任务是，N个节点，每一个节点拥有自己的int id，和int value，现在要求每个节点都run相同的一个函数，
		在所有节点完成run之后，每一个节点都知道了所有N个节点value的总和。
	 * 
	 */
	
	
	// Skype4: ZigZag Traversal Binary Tree，这个也是leetcode原题，可以用两个Stack解决.也可以 queue + list.add(index, E);
	// 因为queue的太熟悉了，这里写一下两个stack的防止面试问，另外list.add(idnex, E) 有点取巧，不好 O(n)
	public ArrayList<ArrayList<Integer>> zigzagTraversal(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		
		Stack<TreeNode> currLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		currLevel.push(root);
		boolean normalOrder = true;
		
		while (!currLevel.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			while (!currLevel.isEmpty()) {
				TreeNode current = currLevel.pop();
				list.add(current.val);
				
				if (normalOrder) {
					if (current.left != null) {
						nextLevel.push(current.left);
					}
					if (current.right != null) {
						nextLevel.push(current.right);
					}
				} else {
					if (current.right != null) {
						nextLevel.push(current.right);
					}
					
					if (current.left != null) {
						nextLevel.push(current.left);
					}
				}
			}
			
			result.add(list);
			currLevel = nextLevel;
			nextLevel = new Stack<TreeNode>();
			normalOrder = !normalOrder;
		}
		return result;
	}
	
	// Skype5: Merge Two Sorted Array  用index 代替m + n - 1更简明 O(m+n)
	public void merge(int[] A, int m, int[] B, int n) {
		if (A == null || B == null) {
			return;
		}
		
		int index = m + n;
		while (m > 0 && n > 0) {
			if (A[m - 1] > B[n - 1]) {
				A[--index] = A[--m];
			} else {
				A[--index] = B[--n];
			}
		}
		
		while (n > 0) {
			A[--index] = B[--n];
		}
	}
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
