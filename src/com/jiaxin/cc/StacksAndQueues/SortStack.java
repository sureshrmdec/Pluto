package com.jiaxin.cc.StacksAndQueues;

import java.util.Stack;

/**
 * 3.6 Sort Stack 
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class SortStack {
	
	public Stack<Integer> sortStack(Stack<Integer> unsorted) {
		Stack<Integer> sorted = new Stack<Integer>();
		if (unsorted == null || unsorted.isEmpty()) {
			return sorted;
		}
		
		while (!unsorted.isEmpty()) {
			int temp = unsorted.pop();
			while (!sorted.isEmpty() && sorted.peek() > temp) {
				unsorted.add(sorted.pop());
			}
			sorted.add(temp);
		}
		
		return sorted;
	}
	
}
