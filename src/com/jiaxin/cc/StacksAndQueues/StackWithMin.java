package com.jiaxin.cc.StacksAndQueues;

import java.util.Stack;

@SuppressWarnings("serial")
public class StackWithMin extends Stack<Integer>{
	Stack<Integer> minStack;
	
	public StackWithMin() {
		minStack = new Stack<Integer>();
	}
	
	public void push(int value) {
		if (value < getMin()) {
			minStack.push(value);
		}
		
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == getMin()) {
			minStack.pop();
		}
		return value;
	}
	
	

	private int getMin() {
		if (!minStack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
		
	}
	
	
}
