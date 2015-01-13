package com.jiaxin.lc.newProblem;

import java.util.Stack;

public class MinStack  {
	// retrieving the minimum element in constant time.
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
		if (x <= getMin()) {
			minStack.push(x);
		}
		
		stack.push(x);
	}

	public void pop() {
		int value = stack.pop();
		
		if (value == minStack.peek()) {
			minStack.pop();
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
