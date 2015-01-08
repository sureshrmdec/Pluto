package interview.ebay;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 2.1 Singleton pattern
 * 2.2 String Matching(返回str2在str1中match的所有位置)
 * 2.3 电话号码string组合
 * 2.4 数字变英文（1023-》One thousand and twenty three）
 * 2.5 Sort LinkedList
 * 2.6 Check if string is valid () -- valid-parentheses
 * 2.7 merge K sorted array with limited memery,只讲思路
 * 2.8 fabonacci
 * 
 * @author jeffwan
 * @date May 3, 2014
 */
public class Part2 {
	/*
	 * 2.1 Singleton
	 * The singleton pattern ensures that a class has only one instance and ensures access to that instance 
	 * throughout the application. It can be useful where you have a "global" object exactly one instance
	 * 
	 * 方法和变量都是static的, 注意instance 是private 
	 * 困惑: getInstance 拿到实例，但是怎么防止大家new 一个出来呢？ 我向这里没有矛盾...知道用global的时候，就要用getInstance 来创建
	 * 还有线程安全的问题，多个线程可能同时 if (instance == null)
	 * 
	 * 
	 * http://www.cnblogs.com/rush/archive/2011/10/30/2229565.html
	 * 
	 */
	public static void main(String[] args) {
		
		ResoursePool re2= ResoursePool.getInstance();
		System.out.println(re2);
//		System.out.println(numToString(3987));
//		System.out.println(letterCombination("23")); 
//		System.out.println(validParenthese("}()[]{}"));
		

	}
	// 2.1 see Resource Pool class
	
	// 2.2 Strstr resurn all positions 
	public ArrayList<Integer> findMatch(String haystack, String needle) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (haystack == null || needle == null) {
			return result;
		}
		
		int j;
		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			for (j = 0; j < needle.length(); j++) {
				if(haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			
			if (j == needle.length()) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	// 2.3 Phone number
	char[][] map = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, 
			{'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
	public ArrayList<String> letterCombination(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		
		helper(result, sb, digits);
		return result;
	}

	private void helper(ArrayList<String> result, StringBuilder sb, String digits) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}
		
		int index = Character.getNumericValue(digits.charAt(sb.length()));
		for (int i = 0; i < map[index].length; i++) {
			sb.append(map[index][i]);
			helper(result, sb, digits);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	// 2.4 Num To String
	public String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	public String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Senventy", "Eighty", "Ninety"};
	public String[] bigs= {"", "Thousand", "Million"};
	
	public String numToString(int num) {
		if (num == 0) {
			return "ZERO";
		} else if (num < 0) {
			return "Negative" + numToString(-1 * num);
		}
		
		String result = "";
		int count = 0;
		while (num != 0) {
			if (num % 1000 != 0) {
				result = numToString100(num % 1000) + " " + bigs[count] + " " + result;  
			}
			
			num /= 1000;
			count++;
		}
		
		return result;
	}

	private String numToString100(int num) {
		String str = "";
		// hundreds
		if (num >= 100) {
			str += digits[num / 100 - 1] + " Hundreds ";
			num = num % 100;
		}

		// tens
		if (num >= 11 && num <= 19) {
			str += teens[num - 11];
			return str;
		} else if (num == 10 || num >= 20) {
			str += digits[num / 10 - 1] + " ";
			num = num % 10;
		}
		
		// ones
		if (num >= 1 && num <= 9) {
			str += digits[num - 1];
		}
		return str;
	}
	
	// 2.5 Sort LinkedList - MergeSort
	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode middle = findMiddle(head);
		ListNode right = sortList(middle.next);
		middle.next = null;
		ListNode left = sortList(head);
		
		return merge(left, right);
	}
	
	private ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head.next; // 这块不能定义为 head，否则有test case {1, 0} 总是指向后面
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (left != null || right != null) {
			if (left.val < right.val) {
				head.next = left;
				left = left.next;
			} else {
				head.next = right;
				right = right.next;
			}
			
			head = head.next;
		}
		
		if (left != null) {
			head.next = left;
		}
		
		if (right != null) {
			head.next = right;
		}
		
		return dummy.next;
	}

	// 2.6 valid-parentheses
	public boolean validParenthese(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (char c : str.toCharArray()) {
			if ("({[".contains(String.valueOf(c))) {
				stack.push(c);
			} else {
				if (!stack.isEmpty() && isVadlid(stack.peek(), c)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	
	private static boolean isVadlid(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
	}

	/*
	 * 2.7 merge K sorted array with limited memery,只讲思路
	 * Way 1: 
	 * Merge (A1, A2), (A3, A4),...
	 * Then there are k/2 sorted arrays now.Repeat the above procedure to get the full array sorted.
	 * This way wont work as the memory we can use is limited.
	 * 
	 * Way 2:
	 * Form a min heap from the first element of all the k arrays. Extract the min element. 
	 * It is the min element among all the arrays. Now take the next element from the array from 
	 * which the min element has come, and put it in the min heap. Repeat the procedure.
	 */
	
	
	// 2.8 fabonacci 0 - 1, 1 - 1
	// Recursive
	public int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	// Iterative
	public int fibonacciIterative(int n) {
		int[] result = new int[n + 1];
		result[0] = result[1] = 1;
		for (int i = 2; i < result.length; i++) {
			result[i] =  result[i - 1] + result[i - 2]; 
		}
		return result[n];
	}
	
	public class ListNode {
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
