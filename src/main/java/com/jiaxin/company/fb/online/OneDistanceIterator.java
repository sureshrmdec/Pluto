package com.jiaxin.company.fb.online;

import org.junit.Test;

/**
 * 1. Conbination Product
 * 2. 1234 -> One Thousand Two Hundred Thirty Four"
 * 3. One edit distance iterator version
 * 
 * return if the distance between a and b is at most 1
 * Distance: minimum number of modifications to make a=b
 * 
 * Modification:
 * 1. change an int in a
 * 2. insert an int to a
 * 3. remove an int from a
 * 
 * tasks: http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=121925&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26sortid%3D311
 * 
 * 
 * 
 * @author jiashan
 *
 */
public class OneDistanceIterator {
	interface IntFileIterator {
		boolean hasNext();
		int next();
	}

	interface FileCompare {
		public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b);

	}
	// return if the distance between a and b is at most 1..1point3acres缃�
	// Distance: minimum number of modifications to make a=b
	// Modification:
	// 1. change an int in a
	// 2. insert an int to a
	// 3. remove an int from a
	
	// 12321  12321
	// 2321    2321
	int lastA = Integer.MAX_VALUE;
	int lastB = Integer.MAX_VALUE;
	boolean flag = false;
	
	public boolean isDistanceZeroOrOne(IntFileIterator a, IntFileIterator b) {
		while (a.hasNext() && b.hasNext()) {
			int curA = a.next();
			int curB = b.next();
			
			if (curA == curB) {
				lastA = a.next();
				lastB = b.next();
				continue;
			} else {
				
				if (lastA != Integer.MAX_VALUE && lastB != Integer.MAX_VALUE) {
					if (!flag){
						flag = true;
					} else if (flag) {
						return false;
					} 
					
					if (curB == lastA) {
						b.next();
					} else if (curA == lastB) {
						a.next();
					}
					
				} else {
					flag = true;
				}
				
				lastA = curA;
				lastB = curB;
			}
			
		}
	
		if (flag) {
			if (!a.hasNext() && !b.hasNext()) {
				return true;
			} 
			
			return false;
		}
		
		return true;
	}
	
	//  not equal -> change? or insert?
	@Test
	public void test() {
		// same size
		// [13 12]   [31 21]   [32 23]     
		
		// not same size 
		// [123, 23]  [123, 13]  [123, 23].
	}
	
	
}
