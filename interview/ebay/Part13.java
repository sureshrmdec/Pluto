package interview.ebay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * [面试经验] 今天刚面的ebay，来报一下 
 * Interview Time : 2013 1-3
 * Link: http://www.1point3acres.com/bbs/thread-52893-1-1.html 
 * 
 * Interview:
 * 1. Reverse singly linkedlist
 * 2. 写个函数  int mostFrequentCharacter（String str)， 返回出现最多次数的字符
 * 3. 还有一些java细节的问题， 比如string pool， hashmap等  
 * 
 * Comment: 我之前还真不知道string pool 是指什么的...
 * ------------------------------------------------------------------------
 * 
 * [面试经验] 昨天刚面完ebay intern phone interview, 发个面经攒RP，求offer 
 * Interview Time: 2013 4-6
 * Link: http://www.1point3acres.com/bbs/thread-60875-1-1.html 
 * 
 * Phone Interview:
 * 1. 写一个递归的fib
 * 2. binary search tree的insert算法
 * 3. Given a circular linked list, implement an algorithm which returns node at beginning of the loop
 * ------------------------------------------------------------------------
 * 
 * [面试经验] 发点面经，为明天ebay求RP，也为等待着的amazon求RP- Intern
 * Interview Time: 2013 1-3
 * Link: http://www.1point3acres.com/bbs/thread-49492-1-1.html
 * 
 * Phone Interview:
 * 1. Coding Problem: See if two strings are Anagrams.
 * 2. When will you use quicksort?
 * 3. Implement a Queue using two stacks 
 * 4. Find the kth largest number in a set of numbers ***
 * 
 * @author jeffwan
 * @date Apr 21, 2014
 */
public class Part13 {
	public static void main(String[] args) {
		String str = "aaaavbbbbb";
//		System.out.println(mostFrequentCharacter(str));
		String s1 = "aabc";
		String s2 = "abc";
		int[] nums = {5,2,9,3,8,4,0,1,6,7};
//		System.out.println(findKthLargest(nums, 3));
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
	}
	
	// Interview 1 : Reverse singly linkedlist
	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		 
		return newHead;
	}
	
	// Interview 2 : 写个函数  int mostFrequentCharacter（String str)， 返回出现最多次数的字符
	// 这个题目总感觉有坑啊，不能老出这种简单题目吧？这里我return一下最高的的字符是什么, 考虑重复, 先拿最高value，再去找key
	public ArrayList<Character> mostFrequentCharacter(String str) {
		ArrayList<Character> result = new ArrayList<Character>();
		if (str == null || str.length() == 0) {
			return result;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = str.toCharArray();

		for (char c : chars) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int max = 0;
		for (int i : map.values()) {
			if (i > max) {
				max = i;
			}
		}

		for (char c : map.keySet()) {
			if (max == map.get(c)) {
				result.add(c);
			}
		}
		return result;
	}
	

	/*
	 * Interview 3: 还有一些java细节的问题， 比如string pool， hashmap等
	 * 
	 * String str = new String("abc"); 
	   String str = "abc"; 
	   String 可以用上面两种的形式来创建，
	   第一种是用new()来新建对象的，它会在存放于堆中。每调用一次就会创建一个新的对象。 
	   第二种是先在栈中创建一个对String类的对象引用变量str，然后通过符号引用去字符串常量池里找有没有"abc",如果没有，
	   则将"abc"存放进字符串常量池，并令str指向”abc”，如果已经有”abc” 则直接令str指向“abc”。 
	 */
	
	/******************************************************/
	// Phone Interview 1: Fibonacci 注意是从 0 开始, F(0) = 0, F(1) = 1. 
	// 很多要求写Iterative的写法，我这里也补上, 平时练一下以防万一. recursive 要注意优化
	int[] result;
	public int fabonacci(int n) {
	    result = new int[n + 1];
	    
	    for (int i = 0; i < result.length; i++) {
	        result[i] = Integer.MAX_VALUE;
	    }        

	    return search(n);
	}

	public int search(int n ) {
	    if (n == 0) {
	        return 0;
	    }
	    
	    if (n == 1) {
	        return 1;
	    }

	    if (result[n] != Integer.MAX_VALUE) {
	        return result[n];
	    }
	    
	    result[n] = search(n - 1) + search(n - 2);
	    return result[n];
	}
	
	// Iterative
	public int fibonacciIterative(int n) {
		if (n == 0) {
			return 1;
		}
		
		if (n == 1) {
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = num[1] = 1;
		
		for (int i = 2; i < num.length; i++) {
			num[i] = num[i - 1] + num[i - 2];
		}
		
		return num[n];
	}

	// Phone Interview 2. binary search tree的insert算法. BST add 一定是到叶子上了，不可能中间的...别蒙
	// 一般都是return 一个 boolean类型的值表示是否插入成功, 注意考虑root == null也就是insert第一个节点的情况
	TreeNode root;
	public boolean bstAdd(int target) {
		if (root == null) {
			root = new TreeNode(target);
			return true;
		}
		
		TreeNode parent = null; // 这也可以不用, 用root.next != null (这个脑子傻了想的，哪TM有tree.next！)
		while (root != null) {
			parent = root;
			if (target < root.val) {
				root = root.left;
			} else if (target > root.val) {
				root = root.right;
			} else {
				return false;
			}
		}
		// 最后用parent node 赋值的时候还得判断一下
		if (target < parent.val) {
			parent.left = new TreeNode(target);
		} else {
			parent.right = new TreeNode(target);
		}
		
		return true;
	}
	
/* 注意泛型，还有compareTo， 我们不能假设就是存Integer了，然后直接 < > 这么来比较. 如果是我们一般做题的TreeNode. 那就是int val 可以直接比较！
	TreeNode root;
	public boolean insert(E e) {
	    if (root == null) {
	        root = new TreeNode<E>(e);
	        return true;
	    }
	    
	    TreeNode current = root;
	    TreeNode parent = current;
	    
	    while (current != null) {
	        parent = current;
	        if (e.compareTo(current.val) < 0) {
	            current = current.left;
	        } else if (e.compareTo(current.val) > 0) {
	            current = current.right;
	        } else {
	            return false;
	        }
	    }
	    
	    if (e.compareTo(parent.val) < 0) {
	        parent.left = new TreeNode<E>(e);
	    } else {
	        parent.right = new TreeNode<E>(e);
	    }
	
	    return true;
	}
*/	
	// Phone Interview 3. Given a circular linked list, implement an algorithm which returns node at beginning of the loop
	public ListNode circularEntry(ListNode head) {
		if (head == null) {
			return null; 
		}
		ListNode fast = head;
		ListNode slow = head;
		do {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			
		} while (fast != slow);
		
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		
		return head;
	}
	
	// Phone Interview 1: Coding Problem: See if two strings are Anagrams.
	// Solution1: sort and compare. Solution2: HashMap 遍历两遍, 也可以用int[]. Sort O(nlogn) + O(2n) -> O(nlogn)
	public boolean checkAnagrams(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		
		return sort(s1).equals(sort(s2));
	}
	// 直接比较new String() 比遍历 charArray爽很多
	public String sort(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	// 不用再查一遍 leeters是否有 > 0了，因为不可能！size必须相同才比较，如果有s1中多的，s2中必然有不一样的，所以letters[c] 已经 < 0. O(n)
	public boolean checkAnagrams2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		
		int[] letters = new int[256];
		for (char c: s1.toCharArray()) {
			letters[c]++;
		}
		
		for (char c: s2.toCharArray()) {
			if (--letters[c] < 0) {
				return false;
			}
		}
		return true;
 	}
	
	/*
	 * Phone Interview 2: When will you use quicksort?
	 * 
	 * http://blog.csdn.net/cinnamonjester7/article/details/11584899
	 * 1. 根据需求分Group, 比如身高<170 >170. 这时候只要选pivot为170就可以，分一次以后左边都是 <170. 右边都是 >170
	 * 2. 找kth largest number O(n) --> Phone Interview 4
	 * 3. 大数据场景: 文件分成大于1G，小于1G. pivot取文件size = 1G？
	 * 4. 数组中次数超过一半的数？？？啥意思？
	 * 
	 */
	
	// Phone Interview 3: Implement a Queue using two stacks 
	// 非常简单，就是offer的时候，stack导两次，这样顺序就正过来了. 还一种充分利用两个stack的方法, 更高效
	/*
	Stack<E> stack = new Stack<E>();
	Stack<E> queueStack = new Stack<E>();
	
	public void offer(E e) {
		while (!queueStack.isEmpty()) {
			stack.push(queueStack.pop());
		}
		queueStack.push(e);
		while (!stack.isEmpty()) {
			queueStack.push(stack.pop());
		}
	}
	
	public E poll() {
		return queueStack.pop();
	}
	
	 */
	
	/*
	Stack<E> inbox = new Stack<E>();
	Stack<E> outbox = new Stack<E>();
	
	public void offer(E e) {
		inbox.push(e);
	}
	
	public E poll() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
		return outbox.pop();
	}
	*/
	
	
	/*
	 * Phone Interview 4:  Find the kth largest number in a set of numbers
	 * 
	 * 这道题目So Good to practice quick sort!算是快排的一个应用，因为每次排完pivot后，
	 * 他的左边别他小，右边都比他大，所以 index + 1 就是整个array的 kth. 
	 * right 指向的就是pivot排序好的位置.所以都是跟他比，一定注意最后 swap(pivot, right);
	 * 另外优化的地方在于，我们直选 k 所在的区间进行排序！所以整个序列不是拍好的
	 * 每个数字排序都是O(n), two pointer 走一遍， 在log(n)词次内可以找到result, 即便优化应该也是O(nlog(n))。
	 * 最好可以O(n) 搞定
	 */

	private int findKthLargestHelper(int[] nums, int start, int end, int k) {
		int pivot = start;
		int left = start;
		int right = end;
		
		while (left <= right) {
			while (left <= right && nums[left] <= nums[pivot]) {
				left++;
			}
			
			while (left <= right && nums[right] >= nums[pivot]) {
				right--;
			}
			
			if (left < right) {
				swap(nums, left, right);
			}
		}
		
		swap(nums, pivot, right);
		
//		System.out.println(Arrays.toString(nums) + " "+ left + "  " + right);
		if (k == right + 1) {
			return nums[right];
		} else if (k > right + 1) {
			return findKthLargestHelper(nums, right + 1, end, k);
		} else {
			return findKthLargestHelper(nums, start, right - 1, k);
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	class E {
		
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
