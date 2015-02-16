package com.jiaxin.company.linkedin;

import org.junit.Test;

import junit.framework.Assert;

public class BinarySearchRotatedAndRange {

	/** 
	* Return the smallest character that is strictly larger than the search character, 
	* If no such character exists, return the smallest character in the array 
	* @param sortedStr : sorted list of letters, sorted in ascending order. 
	* @param c : character for which we are searching. 
	* Given the following inputs we expect the corresponding output: 
	* ['c', 'f', 'j', 'p', 'v'], 'a' => 'c' 
	* ['c', 'f', 'j', 'p', 'v'], 'c' => 'f' 
	* ['c', 'f', 'j', 'p', 'v'], 'k' => 'p' 
	* ['c', 'f', 'j', 'p', 'v'], 'z' => 'c' // The wrap around case 
	* ['c', 'f', 'k'], 'f' => 'k' 
	* ['c', 'f', 'k'], 'c' => 'f' 
	* ['c', 'f', 'k'], 'd' => 'f' 
	* 
	* http://www.careercup.com/question?id=5726366532108288
	*/
	
	public char nextChar(char[] array, char c) {
		int start = 0;
		int end = array.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (array[mid] == c) {
				return array[(mid + 1) % array.length];
			}
			
			if (array[mid] < c) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		
		if (array[start] > c) {
			return array[start];
		}
		
		if (array[end] <= c) {
			return array[(end + 1) % array.length];
		}
		
		return array[(start + 1) % array.length];
	}
	
	/**
	 * 
	 * Find a given element in sorted array. 
	 * array = [1, 2, 3, 4, 5, 6] 
	 * 
	 * follow up: If the sorted array is shifted left by unknown number, modify existing binary search to find a element in modified array 
	 * array = [4, 5, 6, 1, 2, 3]
	 * 
	 */
	public int findPivot(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (A[start] <= A[mid]) {
				
			} else {
				
			}
			
		}
		
		
		
		
		return -1;
	}
	
	
	
	
	@Test
	public void test() {
		char[] array = {'c', 'f', 'j', 'p', 'v'};
		Assert.assertEquals('c', nextChar(array, 'a'));
		Assert.assertEquals('f', nextChar(array, 'c'));
		Assert.assertEquals('p', nextChar(array, 'k'));
		Assert.assertEquals('c', nextChar(array, 'z'));
		
		char[] array2 = {'c', 'f', 'k'};
		Assert.assertEquals('k', nextChar(array2, 'f'));
		Assert.assertEquals('f', nextChar(array2, 'd'));
		Assert.assertEquals('f', nextChar(array2, 'c'));
		
		char[] array3 = {'a', 'c'};
		Assert.assertEquals('c', nextChar(array3, 'b'));
	}
	
}
