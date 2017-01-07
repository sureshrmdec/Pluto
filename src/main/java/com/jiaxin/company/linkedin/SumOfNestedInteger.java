package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/** 
* Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
* For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 
* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3) 
*/ 
public class SumOfNestedInteger {

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
	
	
	
	// NestedInteger could be integer or list only {1, {4,}}
	 
	public int depthSum (List<NestedInteger> input) {
		if (input == null || input.size() == 0) {
			return 0;
		}
		
		return getNestedSum(input, 1);
	}
	
	public int getNestedSum(List<NestedInteger> lists, int level) {
		int result = 0;
		
		for (int i = 0; i < lists.size(); i++) {
			NestedInteger number = lists.get(i);
			result += number.isInteger() ? number.getInteger() * level: 
				getNestedSum(number.getList(), level + 1);
		}
		
		return result;
	}
	
	@Test
	public void test() {
		List<NestedInteger> list1 = new ArrayList<NestedInteger>(); 
		List<NestedInteger> list2 = new ArrayList<NestedInteger>(); 

		NestedInteger nestedInteger1 = new MyNestedIneteger2(1, null); 
		NestedInteger nestedInteger2 = new MyNestedIneteger2(null, list1); 
		NestedInteger nestedInteger3 = new MyNestedIneteger2(4, null); 
		NestedInteger nestedInteger4 = new MyNestedIneteger2(null, list2); 
		NestedInteger nestedInteger5 = new MyNestedIneteger2(6, null); 

		list1.add(nestedInteger3);
		list1.add(nestedInteger4);
		list2.add(nestedInteger5);
		
		List<NestedInteger> input = new ArrayList<NestedInteger>(); 
		input.add(nestedInteger1); 
		input.add(nestedInteger2);

		System.out.println(input); 
		System.out.println(depthSum(input)); 
	}
	
	
	
	/* not correct
	// NestInteger could has integer and list at the same time.{1, list} should be one NestInteger,
	public int depthSum2 (List<NestedInteger> input) {
		int sum = 0;
			
		for (NestedInteger nestedInteger : input) {
			sum += getNestedSum2(nestedInteger , 1);
		}
		
		return sum;
	}
	
	private int getNestedSum2(NestedInteger nestedInteger, int level) {
		int sum = 0;
		if (!nestedInteger.isInteger()) {
			for (NestedInteger child: nestedInteger.getList()) {
				sum += getNestedSum2(child, level + 1); 
			}
		}
		
		sum += level * nestedInteger.getInteger();
		
		return sum;
	}

	
	@Test
	public void test2() {
		List<NestedInteger> list1 = new ArrayList<>(); 
		List<NestedInteger> list2 = new ArrayList<>(); 

		NestedInteger nestedInteger1 = new MyNestedIneteger2(1, list1); 
		NestedInteger nestedInteger2 = new MyNestedIneteger2(4, list2); 
		NestedInteger nestedInteger3 = new MyNestedIneteger2(6, null); 

		list1.add(nestedInteger2); 
		list2.add(nestedInteger3); 

		List<NestedInteger> input = new ArrayList<>(); 
		input.add(nestedInteger1); 

		System.out.println(input); 
		System.out.println(depthSum2(input)); 
	}
	*/
	
	/*************************************************************************/
	
	
	// iterator http://codereview.stackexchange.com/questions/32827/flatten-iterator-for-nested-list
	
}
