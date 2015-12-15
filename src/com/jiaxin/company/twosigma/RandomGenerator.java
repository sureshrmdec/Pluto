package com.jiaxin.company.twosigma;

import java.util.Iterator;

//http://www.1point3acres.com/bbs/thread-136729-1-1.html
// Generator 5. 
public class RandomGenerator implements Iterator<Long> {

	Iterator<Long> random;
	Long number = null;
	public RandomGenerator(Iterator<Long> random) {
		this.random = random;
	}
	
	@Override
	public boolean hasNext() {
		while (random.hasNext()) {
			long number = random.next();
			if (number % 5 == 0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Long next() {
		return number;
	}

	@Override
	public void remove() {
		
		
	}

	
	
}
