package com.jiaxin.company.yelp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * 1. min stack问题，拓展stack实现min（）这个函数的功能
 * 2. 问一个小问题： T(n) = 4*T(n/2) + (n^2) * lg(n) 这个递归式能否用master method求解，如果可以，如何求解？
 * 3. 一道题 leetcode的word ladder II。 
 * 
 * @author jeffwan
 * @date May 10, 2014
 */
public class Part3 {
	// 1. minStack
	public class StackWithMin extends Stack<Integer>{
	    Stack<Integer> minStack;
	    
	    public StackWithMin() {
	        minStack = new Stack<Integer>();
	    }
	    
	    public int minValue() {
	        if (minStack.isEmpty()) {
	            return Integer.MAX_VALUE;
	        } else {
	            return minStack.peek();
	        }
	    }

	    public void push(int value) {
	        if (value == minValue()) {
	            minStack.push(value);
	        }
	    
	        super.push(value);
	    }


	    public Integer pop() {
	        int value = super.pop();
	        if (value == minValue()) {
	            minStack.pop();
	        }
	        
	        return value;
	    }
	}
	
	
	// 2. leave it here
	
	// 3. word ladder 2
	// http://www.1point3acres.com/bbs/thread-51646-1-1.html
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		
		
		return null;
    }
	
	private class Node {
        public Node prev;
        public String str;
        public int level;
        public Node(Node prev, String s, int l){
            prev = prev;
            str = s;
            level = l;
        }
    }
	
}
