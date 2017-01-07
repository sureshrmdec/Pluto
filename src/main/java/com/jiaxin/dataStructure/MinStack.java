package com.jiaxin.dataStructure;

import java.util.Stack;

public class MinStack{
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int value) {
		if (!minStack.isEmpty() && value <= getMin()) {
			minStack.push(value);
		}
		
		stack.push(value);
	}

	public Integer pop() {
		int value = stack.pop();
		if (value == getMin()) {
			minStack.pop();
		}
		
		return value;
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
