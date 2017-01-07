package com.jiaxin.lc.newProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStack  {
	// retrieving the minimum element in constant time.
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	public void push(int x) {
		if (x == getMin()) {
			cache.put(x, cache.get(x) + 1);
		}
		
		if (x < getMin()) {
			minStack.push(x);
			cache.put(x, 1);
		}
		
		stack.push(x);
	}

	public void pop() {
		int value = stack.pop();
		
		if (value == getMin()) {
			if (cache.get(value) == 1) {
				minStack.pop();
			}
			
			cache.put(value, cache.get(value) - 1);
		}
	}

    public int top() {
        return stack.peek();
    }

    public int getMin() {
    	if (minStack.isEmpty()) {
    		return Integer.MAX_VALUE;
    	} else {
    		return minStack.peek();
    	}
    }

}
