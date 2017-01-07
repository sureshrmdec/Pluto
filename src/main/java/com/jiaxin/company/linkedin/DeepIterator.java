package com.jiaxin.company.linkedin;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 
 * http://blog.baozitraining.org/2014/08/linkedin-twitter-and-hulu-onsite-how-to.html
 * 
 * "Program an iterator for a List which may include nodes or List  i.e.  
 * {0, {1,2}, 3 ,{4,{5, 6}}} Iterator returns 0 - 1 - 2 - 3 - 4 - 5 - 6"
 * 
 */

public class DeepIterator implements Iterator<Integer>{
	private Stack<Iterator> stack;
	private Integer top = null;
	
	public DeepIterator(Iterable iterable) {
		stack = new Stack<Iterator>();
		stack.push(iterable.iterator());
	}
	
	@Override
	public boolean hasNext() {
		if (this.top != null) {
			return true;
		}
		
		while (!stack.isEmpty()) {
			Iterator iterator = stack.peek();
			
			if (iterator.hasNext()) {
				Object temp = iterator.next();
				if (temp instanceof Integer) {
					this.top = (Integer) temp;
					return true;
					
				} else if (temp instanceof Iterable) {
					stack.push(((Iterable)temp).iterator());
					
				} else {
					throw new RuntimeException("type is not supported");
				}
				
			} else {
				stack.pop();
			}
		}
		
		return false;
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			Integer temp = this.top;
			this.top = null;
			
			return temp;	
		}
		
		throw new NoSuchElementException();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not supported");
	}

}
