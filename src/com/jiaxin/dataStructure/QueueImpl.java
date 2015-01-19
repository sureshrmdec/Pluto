package com.jiaxin.dataStructure;

import java.util.Stack;

public class QueueImpl<E> {
	Stack<E> inbox = new Stack<E>();
	Stack<E> outbox = new Stack<E>();
	
	public E poll() {
		shiftBox();
		return outbox.pop();
	}
	
	public void offer(E e) {
		inbox.push(e);
	}
	
	public int size() {
		return inbox.size() + outbox.size();
	}
	
	public E peek() {
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
