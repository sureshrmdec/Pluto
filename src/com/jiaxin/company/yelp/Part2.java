package com.jiaxin.company.yelp;

import java.util.ArrayList;

/**
 * 
 * http://www.1point3acres.com/bbs/thread-94971-1-1.html
 * 1. 技术问题如下。
 * """
 * 1. Write a function to add the two binary number strings.
 * e.g.
 * add('100', '10') -> '110'
 * 
 * 2. Follow up, add two number strings with specific base
 * add('100', '10', 2) -> '110'
 * add('100', '9', 10) -> '109'
 * 
 * 3. Follow up, sum list number strings with specific base
 * add_strs(['9', '3', '2'], 10) -> '14'
 * """
 *
 * 4. Coding 最长公共前缀。
 *
 * @author jeffwan
 * @date May 10, 2014
 */

public class Part2 {
	public static void main(String[] args) {
		String[] strs = {"abc", "abc", "abcde","ab"};
//		System.out.println(longestCommonPrefix(strs));
		ArrayList<String> nums = new ArrayList<String>();
		nums.add("10");
		nums.add("1");
		nums.add("101");
		
		System.out.println(addArray(nums, 10));
		
	}
	
	// 1. Add Binary 
	public static String addBinary(String a, String b, int k) {
	    if (a.length() < b.length()) {
	        String temp = a;
	        a = b;
	        b = temp;
	    }

	    int aIndex = a.length() - 1;
	    int bIndex = b.length() - 1;
	    int carry = 0;
	    String result = "";
	    
	    while (bIndex >= 0) {
	        int sum = carry + Character.getNumericValue(a.charAt(aIndex)) +
	            Character.getNumericValue(b.charAt(bIndex));
	        result = String.valueOf(sum % k) + result;
	        carry = sum / k;
	        aIndex--;
	        bIndex--;
	    }
	    
	    while (aIndex >= 0) {
	        int sum = carry + Character.getNumericValue(a.charAt(aIndex));
	        result = String.valueOf(sum % k) + result;
	        carry = sum / k;
	        aIndex--;
	    }
	    
	    if (carry != 0) {
	        result = String.valueOf(carry) + result;
	    }
	    
	    return result;
	}
	// 2. Add Binary follow-up 1 和 Add Binary 做法一样，参数 k 代替2 就可以了
	
	// 3. Add Binary follow-up 2 充分利用已有的函数，不要对list中每位加，这样很难控制 index， 还是2个2个加好
	public static String addArray(ArrayList<String> nums, int k) {
	    String a = nums.get(0);
	    for (int i = 1; i < nums.size(); i++) {
	        a = addBinary(a, nums.get(i), k);
	    }
	    
	    return a;
	}

	// 4. longest common prefix
	public String longestCommonPrefix(String[] strs) {
	    if (strs == null || strs.length == 0) {
	        return "";
	    }

	    String prefix = strs[0];
	    
	    for (int i = 1; i < strs.length; i++) {
	        int index = 0;
	        while (index < prefix.length() && index < strs[i].length()) {
	            if (prefix.charAt(index) == strs[i].charAt(index)) {
	                index++;
	            }
	        }
	        
	        if (index == 0) {
	            return "";
	        }
	        
	        prefix = prefix.substring(0, index);
	    }    
	   
	   return prefix;
	}	
	
	
}
