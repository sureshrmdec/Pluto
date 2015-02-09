package com.jiaxin.dataStructure;

import java.util.Stack;

public class MaxStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> maxStack = new Stack<Integer>();
	
	public void push(int value) {
		if (value > peekMax()) {
			maxStack.push(value);
		}
		
		stack.push(value);
	}

	public Integer pop() {
		int value = stack.pop();
		if (value == peekMax()) {
			maxStack.pop();
		}
		
		return value;
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int peekMax() {
		if (maxStack.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return maxStack.peek();
		}
	}
	
	public int popMax() {
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty() && stack.peek() != peekMax()) {
			temp.push(stack.pop());
		}
		
		int max = maxStack.pop();
		
		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}
		
		return max;
	}
	
}
