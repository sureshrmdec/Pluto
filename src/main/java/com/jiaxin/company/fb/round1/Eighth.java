package com.jiaxin.company.fb.round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;


/*
 * Phone:
 * 1. Powerset -- same as combination, 2^n
 * 2. Phone number words
 * 3. Roman numebrs to int 
 * 
 * 
 * Onsite: 
 * 1. What would be main design considerations in designing backend for movies . com website (as in
https://www.facebook.com/notes/facebook-engineering/the-full-stack-part-i/461505383919), and how would you estimate #
machines needed. (Pirate)
 * 2. Give an array with unique doubles, find all quadruples that match the condition a+b+c+d = 0 (Ninja)
 * 3. Given a rotated sorted array in one specified direction, return if a number exists or not. e.g 7 8 1 3 6 x=1  (Ninja)
 * 4. Palindrome Detector (Jedi)
 * 5. Read 4k  (Ninja)
 * 6. Given a DAG(Directed Acyclic Graph), find the longest path in it. (Ninja)
 * 7. Design newsfeed backend. (Pirate) 
 */
public class Eighth {
	
	/**************************************************************************/
	// 1.Powerset -- same as combination, 2^n  -- Recursive
	// for every node, exist or not exist.  n number. 2^n. 0000 - 1111. 
	public List<List<Integer>> subset(int[] A) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		if (A == null || A.length == 0) {
			return result;
		}
		
		Arrays.sort(A);
		subsetHelper(result, list, A, 0);
		
		return result;
	}
	
	private void subsetHelper(List<List<Integer>> result, List<Integer> list, int[] A, int position) {
		result.add(new ArrayList<Integer>(list));
		
		for (int i = position; i < A.length; i++) {
			list.add(A[i]);
			subsetHelper(result, list, A, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	// Iteration
	public List<List<Integer>> subSetIteration(int[] A) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (A == null || A.length == 0) {
			return result;
		}
		
		result.add(new ArrayList<Integer>());
		
		for (int i = 0; i < A.length; i++) {
			int size = result.size(); 
			
			for (int j = 0; j < size; j++) {
				List<Integer> list = new ArrayList<Integer>(result.get(j)); 
				list.add(A[i]);
				result.add(list);
			}
		}
		
		return result;
	}
	
	public List<List<Integer>> subsetIIRemoveDup(int[] A) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    
	    result.add(new ArrayList<Integer>());
	    
	    Arrays.sort(A);
	    int lastSize = 0;
	    
	    for (int i = 0; i < A.length; i++) {
	        int size = result.size();

	        int j = (i != 0) && (A[i] == A[i - 1]) ? size - lastSize : 0; 
	        lastSize = 0;
	        
	        for (; j < size; j++) {
	            List<Integer> list = new ArrayList<Integer>(result.get(j));
	            list.add(A[i]);
	            result.add(list);
	            lastSize++;
	        }
	    }
	    
	    return result;
	}
	

	/**************************************************************************/
	// 2. Phone number words-- Test case [""] -> [""] but not [], digits.length == 0 can't add into first parameter validation
	char[][] map = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, 
			{'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		if (digits == null) {
			return result;
		}
		
		phoneNumberhelper(result, sb, digits);
		
		return result;
	}

	private void phoneNumberhelper(List<String> result, StringBuilder sb, String digits) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}
		
		int index = Character.getNumericValue(digits.charAt(sb.length()));
		
		for (int i = 0; i < map[index].length; i++) {
			sb.append(map[index][i]);
			phoneNumberhelper(result, sb, digits);
			sb.deleteCharAt(sb.length() - 1);
		}

	}

	/**************************************************************************/
	// 3. Roman numebrs to int
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int result = charToInt(s.charAt(0));
		
		for (int i = 1; i < s.length(); i++) {
			int last = charToInt(s.charAt(i - 1));
			int current = charToInt(s.charAt(i));
			
			if (last < current) {
				result += current - 2 * last;
			} else {
				result += current;
			}
		}
		
		return result;
	}
	
	public int charToInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	
	/**************************************************************************/
	// 2. Give an array with unique doubles, find all quadruples that match the condition a+b+c+d = 0 (Ninja)
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	 
    	if (num == null || num.length == 0) {
    		return result;
    	}
    	
    	Arrays.sort(num);
   
    	for (int i = 0; i < num.length - 3; i++) {
    		if (i != 0 && num[i] == num[i - 1]) {
    			continue;
    		}
    		
    		for (int j = i + 1; j < num.length - 2; j++) {
    			if (j != i + 1 && num[j] == num[j - 1]) {
    				continue;
    			}
    			
    			int left = j + 1;
    			int right = num.length - 1;
    			
    			while (left < right) {
    				int sum = num[i] + num[j] + num[left] + num[right];
    				if (sum == target) {
    					List<Integer> list = new ArrayList<Integer>();
    					list.add(num[i]);
    					list.add(num[j]);
    					list.add(num[left]);
    					list.add(num[right]);
    					
    					result.add(list);
    					left++;
    					right--;
    					
    					while (left < right && num[left] == num[left - 1]) {
    						left++;
    					}
    					
    					while (left < right && num[right] == num[right + 1]) {
    						right--;
    					}
    				} else if (sum < target) {
    					left++;
    				} else {
    					right--;
    				}
    			}
    		}
    	}
    	
    	return result;
    }
	
    public List<List<Integer>> fourSumHashMap(int[] num, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();

    	Arrays.sort(num);
    	if (num == null || num.length == 0) {
    		return result;
    	}

    	for (int i = 0; i < num.length - 3; i++) {
    		if (i != 0 && num[i] == num[i - 1]) {
    			i++;
    		}

    		for (int j = i + 1; j < num.length - 2; j++) {
    			if (j != i + 1 && num[j] == num[j - 1]) {
    				j++;
    			}

    			Set<Integer> dict = new HashSet<Integer>();

    			for (int k = j + 1; k < num.length; k++) {
    				int rest = target - num[i] - num[j] - num[k];
    				if (rest < 0) {
    					break;
    				}
    				
    				if (dict.contains(rest)) {
    					List<Integer> list = new ArrayList<Integer>();
    					list.add(num[i]);
    					list.add(num[j]);
    					list.add(rest);
    					list.add(num[k]);
    					
    					result.add(list);

    				} else {
    					dict.add(num[k]);
    				}
    			}
    		}
    	}

    	return result;
    }

    
    
	/**************************************************************************/
	// 3. Given a rotated sorted array in one specified direction, return if a number exists or not. e.g 7 8 1 3 6 x=1  (Ninja)
    public int search(int[] A, int target) {
    	if (A == null || A.length == 0) {
    		return -1;
    	}
		
    	int start = 0;
    	int end = A.length - 1;
    	
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		
    		if (A[mid] == target) {
    			return mid;
    		}
    		
    		if (A[start] < A[mid]) {
    			if (target >= A[start] && target < A[mid]) {
    				end = mid;
    			} else {
    				start = mid;
    			}
    		} else {
    			if (target < A[mid] && target <= A[end]) {
    				start = mid;
    			} else {
    				end = mid;
    			}
    		}
    	}
    	
    	if (A[start] == target) {
    		return start;
    	}
    	
    	if (A[end] == target) {
    		return end;
    	}
    	
    	return -1;
    }
	
	
	/**************************************************************************/
	// 4. Palindrome Detector (Jedi) -> Valid Palindrome
    // could also use stack(half, half)
    public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			char head = Character.toLowerCase(s.charAt(left));
			char rear = Character.toLowerCase(s.charAt(right));
			
			if (!Character.isLetterOrDigit(head)) {
				left++;
				continue;
			}
			
			if (!Character.isLetterOrDigit(rear)) {
				right--;
				continue;
			}
			
			if (head != rear) {
				return false;
			}
			
			left++;
			right--;
		}
    	
    	return true;
    }
    
	
	
	/**************************************************************************/
	// 5. Read 4k  (Ninja)
    public int readOnce(char[] buf, int n) {
		char[] buffer = new char[4];
		boolean eof = true;
		int total = 0;
		
		while (eof && total < n) {
			int temp = read4(buffer);
			if (temp < 4) {
				eof = false;
			}
			
			int bytes = Math.min(n - total, temp);
			System.arraycopy(buffer, 0, buf, total, bytes);
			total += bytes;
			
			/*
			if (temp < 4) {
				break;
			}
			*/
		}
		
		return total;
	}
    
    // Multiple call version
    private char[] buffer = new char[4];
	private int bufsize = 0;
	private int offset = 0;
	
	public int read(char[] buf, int n) {
		int total = 0;
		boolean eof = true;
		
		while (eof && total < n) {
			if (bufsize == 0) {
				bufsize = read4(buffer);
				
				if (bufsize < 4) {
					eof = false;
				}
			}
			
			int bytes = Math.min(n - total, bufsize);
			System.arraycopy(buffer, offset, buf, total, bytes);
			
			offset = (offset + bytes) % 4;
			bufsize -= bytes;
			total += bytes;
		}
		
		return total;
	}
    
    
	// API funciton
	public int read4(char[] buf) {
		return 0;
	}
	
	/**************************************************************************/
	// 6. Given a DAG(Directed Acyclic Graph), find the longest path in it. (Ninja) - Graph Longest Path
	
	
	
	/**************************************************************************/
	// 7. Design newsfeed backend. (Pirate) 
	
	


    @Test
	public void test() {
		int[] A = {-3,-2,-1,0,0,1,2,3};	
		System.out.println(fourSum(A, 0));
		System.out.println(fourSumHashMap(A, 0));
		
		int[] B = {1, 2, 3};
		System.out.println(subset(B));
		System.out.println(subSetIteration(B));
		
		int[] C = {1,2,2};
		System.out.println(subsetIIRemoveDup(C));
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
}
