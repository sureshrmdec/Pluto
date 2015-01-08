package com.jiaxin.company.yahoo;
/**
 * 1.问了一道 给出一个list，里面存的是图里的所有有向边的信息，判断是否有环。 
去年面tripadvisor考过一道一样的题，只是当时给的是GraphNode*, Node里边存一个边的List。 太久没做手生了
 * 2. 
 * 
 * 1. isPalindrome
 * 2. fabonacci f(10) -> f(5) 如何优化--> DP思路
 * 
 * @author jeffwan
 * @date May 13, 2014
 */
public class Part4 {
	
	
	
	// 1. isPalindrome
	public boolean isPalindrome(String s) {
	    if (s == null) {
	        return false;
	    }

	    int start = 0;
	    int end = s.length() - 1;
	    
	    while (start < end) {
	        char startChar = Character.toLowerCase(s.charAt(start));
	        char endChar = Character.toLowerCase(s.charAt(end));
	        
	        if (startChar < 'a' || startChar > 'z') {
	            startChar++;
	        }
	 
	         
	        if (endChar < 'a' || endChar > 'z') {
	            endChar--;
	        }
	 
	                
	        if (startChar == endChar) {
	            start++;
	            end--;
	        } else {
	            return false;
	        }
	    }

	    return true;
	}
	
	// 2. fabonacii
	int[] result;
	public int fabonnaci(int n) {
	    result = new int[n + 1];
	    for (int i = 0; i < result.length; i++) {
	        result[i] = Integer.MAX_VALUE;
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

	    if (result[n] != Integer.MAX_VALUE) {
	        return result[n];
	    }

	    result[n] = search(n - 1) + search(n - 2);
	    return result[n];
	}

	// Iterative
	public int faboonacii(int n) {
	    if (n == 0) {
	        return 0;
	    }

	    if (n == 1) {
	        return 1;
	    }

	    int[] result = new int[n + 1];
	    result[0] = 0;
	    result[1] = 1;
	    
	    for (int i = 2; i < result.length; i++) {
	        result[i] = result[i - 1] + result[i - 2];
	    }
	    
	    return result[n];
	}
	
}

