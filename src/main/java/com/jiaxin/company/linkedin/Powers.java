package com.jiaxin.company.linkedin;

import java.util.Iterator;
//http://www.careercup.com/question?id=8591375
public interface Powers extends Iterator<Long> { 
	/* Returns the next integer a in the arithmetic sequence of integers where 
	* a = m^n, m > 1 n > 1, and m and n are both integers 
	* Thus, the first few outputs will be 4, 8, 9, 16, 25, 27, 32, 36, etc. 
	*/ 
	
	public Long next(); 
	
	/* Resets the sequence to the beginning, such that the next call to next() 
	* will return 4. 
	*/ 
	public void reset(); 
}