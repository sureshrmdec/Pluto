package com.jiaxin.company.yelp;

import java.util.Arrays;

/**
 * http://www.1point3acres.com/bbs/thread-75421-1-1.html
 * 1. longest common prefix
 * 2. 然后出了一个题，给一个int[]数组，给一个number，问用数组里面的数字通过加，减，乘，除能否得到那个number 
 * 返回boolean. 数组里的数每个只能用一次，可以都用，也可以只用部分。 用DFS解的
 * 3. skype interview isPalindrome（不算标点符号）
 * 4. 有道fibonacci非递归，有个post request的处理
 * 5. coding是anagram
 * 
 * http://www.1point3acres.com/bbs/thread-53649-1-1.html
 * 6.猜一个数在1-N之间，怎么猜？还现场玩了一回，如果不知道N怎么猜？
 * @author jeffwan
 * @date May 10, 2014
 */
public class Part4 {
	public static void main(String[] args) {
		String[] strs = {"abcd", "abcde", "ddsadsa", "abc"};
		String s = "race a car";
//		System.out.println(isPalindrome(-2147447412));
		System.out.println(longestCommonPrefix2(strs));
//		System.out.println(fabonacci2(10));
//		System.out.println(isAnagram("aabdas", "adbssa"));
//		System.out.println(isAnagramNormal("aabdas", "adbssa"));
//		System.out.println(binarySearch(100, 0));
	}
	
	// 1.longest common prefix -- solution1. compare one by one
	// 不能用 prefix.charAt(j) != strs[i].charAt(j) 判断，因为可能走完最后一个字符还是相等，要取最小的，或者把截取放外面
	public static String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0) {
	        return "";
	    }

	    String prefix = strs[0];
	    for (int i = 0; i < strs.length; i++) {
	        int j = 0;
	        while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
	                j++;
	        }    
	        
	        if (j == 0) {
	                return "";
	        }
	        
	        prefix = prefix.substring(0, j);
	    }
	    
	    return prefix;
	}
	
	// 1. longest common prefix -- solution 2: compare all strs array char by char
	// 注意这里break只是内层，外层还是要多运行一次，所以要 i - 1.
	public static String longestCommonPrefix2(String[] strs) {
	    if (strs == null || strs.length == 0) {
	        return "";
	    }

	    int size = getSize(strs);
	    int i;
	    boolean flag = true;
	    
	    for (i = 0; i < size & flag; i++) {
	        char temp = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j++) {
	            if (strs[j].charAt(i) != temp) {
	                flag = false;
	                break;
	            }
	        }
	    }
	    return strs[0].substring(0, i - 1);
	}

	public static int getSize(String[] strs) {
	    int minSize = Integer.MAX_VALUE;
	    for (String str : strs) {
	        if (minSize > str.length()) {
	            minSize = str.length();
	        }
	    }
	    
	    return minSize;
	}

	
	
	// 2. input- int[], target. 是否可以通过array中加减乘除 得到那个数字，求结果. 组合??
	public boolean getNumber(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		
		
		return false;
	}
	
	
	// 3. string isPalindrome, 
	// 如果是int， reverse int, 直接判断是否相等, 要问面试官负数问题. 
	public boolean isPalindrome(String s) {
	    if (s == null || s.length() == 0) {
	        return false;
	    }

	    int start = 0;
	    int end = s.length() - 1;
	    
	    while (start < end) {
	        char startChar = Character.toLowerCase(s.charAt(start));
	        char endChar = Character.toLowerCase(s.charAt(end));
	        
	        if (startChar < 'a' || startChar > 'z') {
	            start++;
	            continue;
	        }
	        
	        if (endChar < 'a' || endChar > 'z') {
	            end--;
	            continue;
	        }
	        
	        if (startChar != endChar) {
	            return false;
	        }
	        
	        start++;
	        end--;
	    }

	    return true;
	}
	
	// 4. fabonacci 0 1 1 2. 有第0项，是0, 这样肯定就是n + 1项了，index这块终于很清楚了....比较爽.
	int[] values;
	public int fabonacci(int n) {
	    values = new int[n + 1];
	    for (int i = 0; i < values.length; i++) {
	        values[i] = Integer.MAX_VALUE;
	    }
	    
	    return search(n);
	}

	public int search(int n) {
	    if (n == 0) {
	        return 0;
	    }        
	        
	    if (n == 1) {
	        return 1;
	    }

	    if (values[n] != Integer.MAX_VALUE) {
	        return values[n];
	    } 
	    
	    values[n] = search(n - 1) + search(n -2);
	    return values[n];
	}
	
	public int fabonacci2(int n) {
	    if (n == 0) {
	        return 0;
	    }
	    
	    if (n == 1) {
	        return 1;
	    }

	    int[] values = new int[n + 1];
	    values[0] = 0; values[1] = 1; 
	   
	    for (int i = 2; i < values.length; i++) {
	        values[i] = values[i - 1] + values[i - 2];
	    }
	    
	    return values[n];
	} 
	
	// 5. Anagram. sort way -- O(nlog(n)). statistic -- O(n)
	public boolean isAnagram(String s1, String s2) {
	    if (s1 == null || s2 == null || s1.length() != s2.length()) {
	        return false;
	    }
	    
	    return sort(s1).equals(sort(s2));
	}

	public String sort(String s) {
	    char[] chars = s.toCharArray();    
	    Arrays.sort(chars);
	    
	    return new String(chars);
	}

	// AscII has 256 char, first 128 is common, like numeric, digits, operation. last 128 is special (not on keyboard)
	public boolean isAnagramNormal(String s1, String s2) {
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
	
	// 6. 猜数字 1-N. 就是BinarySearch log(n) 次就搞定，按理说就是100个数字, 最多7次因为 2^7 = 128. 这里100，得用8次..0还是7次
	public int findNumber(int n, int target) {
		if (n < target) {
			return Integer.MAX_VALUE;
		}
		
		int start = 0;
		int end = n;
		int count = 0;
		
		while (start + 1 < end) {
			count++;
			int mid = start + (end - start) / 2;
			if (target == mid) {
				return count;
			}
			
			if (target < mid) {
				end = mid;
			} else if (target > mid) {
				start = mid;
			}
		}
		
		if (start == target || end == target) {
			return ++count;
		}
		
		return Integer.MAX_VALUE;
	}
	
	
}
