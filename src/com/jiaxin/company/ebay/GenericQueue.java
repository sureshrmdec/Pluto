package com.jiaxin.company.ebay;

import java.util.Stack;

public class GenericQueue<E> {
	Stack<E> stack = new Stack<E>();
	Stack<E> queueStack = new Stack<E>();
	
	public void offer(E e) {
		while (!queueStack.isEmpty()) {
			stack.push(queueStack.pop());
		}
		queueStack.push(e);
		while (!stack.isEmpty()) {
			queueStack.push(stack.pop());
		}
	}
	
	public E poll() {
		return queueStack.pop();
	}
	
	public E peek() {
		return queueStack.peek();
	}
	
	public int size() {
		return queueStack.size();
	}
	
	public boolean empty() {
		return queueStack.isEmpty();
	}
	
	@Override
	public String toString() {
		return "Queue: " + queueStack.toString();
	}
}

