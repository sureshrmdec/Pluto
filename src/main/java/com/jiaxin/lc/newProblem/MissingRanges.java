package com.jiaxin.lc.newProblem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author jiashan
 * handle the case: low, upper is between A. LeetCode does not have these test cases.
 *
 */
public class MissingRanges {
	
	public List<String> findMissingRanges(int[] A, int lower, int upper) {
		List<String> result = new ArrayList<String>();
		
		if (A == null || A.length == 0) {
			result.add(lower == upper? String.valueOf(lower) : 
				String.valueOf(lower) + "->" + String.valueOf(upper));
			return result;
		}
		
		int i = 0; 
		while (lower > A[i]) {
			i++;
		}
		
		findRange(result, lower - 1, A[i]);

		boolean flag = true;
		while (i < A.length - 1 && flag) {
			int current = A[i];
			int next = A[i + 1];
			if (next > upper) {
				next = upper + 1; 
				flag = false;
			}
			
			findRange(result, current, next);
			i++;
		}
		
		if (A[A.length - 1] < upper) {
			findRange(result, A[A.length - 1], upper + 1);
		}
		
		return result;        
    }
	
	private void findRange(List<String> result, int current, int next) {
		int diff = next - current;
		
		if (diff == 2) {
			result.add(String.valueOf(current + 1));
		} else if (diff > 2) {
			result.add(String.valueOf(current + 1) + "->" + String.valueOf(next - 1));
		}
	}

	@Test
	public void test() {
		int[] A = {0, 1, 3, 50, 75};
		System.out.println(findMissingRanges(A, 0, 99));
	}
}
