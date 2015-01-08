package com.jiaxin.cc.StacksAndQueues;

import java.util.Stack;

/**
 * 3.5 Implement a MyQueue class which implements a queue using two stacks.
 * 
 * @author jeffwan
 * @date May 6, 2014
 */

public class MyQueue<T> {
	Stack<T> inbox = new Stack<T>();
	Stack<T> outbox = new Stack<T>();
	public MyQueue() {
		inbox = new Stack<T>();
		outbox = new Stack<T>();
	}
	
	public void offer(T t) {
		inbox.push(t);
	}
	
	public T poll() {
		shiftBox();
		return outbox.pop();
	}
	
	public int size() {
		return inbox.size() + outbox.size();
	}
	
	public T peek() {
		shiftBox();
		return outbox.peek();
	}
	
	public void shiftBox() {
		if (outbox.isEmpty()) {
			while (!inbox.isEmpty()) {
				outbox.push(inbox.pop());
			}
		}
	}
}
