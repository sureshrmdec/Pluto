package com.jiaxin.lc.newProblem;

import java.util.Stack;

public class MinStackNew {
	private Stack<Integer> stack = new Stack<Integer>();
	private int min = Integer.MAX_VALUE;
			
	public void push(int x) {
        stack.push(x - min);
        if (x < min) {
            min = x;
        }
    }
    
    public void pop() throws Exception {
        if (stack.size() == 0) {
            throw new Exception();
        }
        
        int currentMin = min;
        int diff = stack.pop();
        
        if (diff < 0) {
            min = currentMin - diff;
        }
    }
    
    public int peek() throws Exception {
		if (stack.peek() < 0) {
			return getMin();
		} else {
			return stack.peek() + min;
		}
    }
    
    public int getMin() throws Exception {
        if (stack.size() == 0) {
            throw new Exception();
        }
        return min;
    }
	
    
    public static void main(String[] args) throws Exception {
    	MinStackNew stack = new MinStackNew();

    }
}
