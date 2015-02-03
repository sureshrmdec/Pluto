package com.jiaxin.company.linkedin;

import java.util.List;

import org.junit.Test;

public class SumOfNestedInteger {
	public int depthSum (List<NestedInteger> input) {
		return 0;
	     //Implement this function
	}
	
	

	/**
	 * This is the interface that allows for creating nested lists. You should not implement it, 
	 * or speculate about its implementation
	 */
	public interface NestedInteger {
	    // Returns true if this NestedInteger holds a single integer, rather than a nested list
	    public boolean isInteger();

	    // Returns the single integer that this NestedInteger holds, if it holds a single integer
	    // Returns null if this NestedInteger holds a nested list
	    public Integer getInteger();

	    // Returns the nested list that this NestedInteger holds, if it holds a nested list
	    // Returns null if this NestedInteger holds a single integer
	    public List<NestedInteger> getList();
	}  
	
	
	// Recursive
	
	
	
	// Iterative 
	public int getSum(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int level = 0;
		int result = 0;
	
		for (char c : s.toCharArray()) {
			if (c == '{') {
				level++; 
			} else if (c == '}') {
				level--;
			} else if (c >= '0' && c<= '9'){
				result += level * (c - '0');
			}
		}
		
		return result;
	}
	
	@Test
	public void test() {
		String s = "{3, 5, {2,{1,4}}}";
		
		System.out.println(getSum(s));
	}
}
