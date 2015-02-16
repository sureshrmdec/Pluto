package com.jiaxin.company.fb.online;

import java.util.List;

import org.junit.Test;

public class PhoneCombination {
	public List<List<String>> combination() {
		
		
		
		return null;
		
	}
	
	
	public int combination(int[] A) {
		
		int[] num = new int[A.length + 1];
		num[0] = 1;
		num[1] = 1;
		for (int i = 2; i <= A.length; i++) {
			if (A[i - 1] != 0) {
				num[i] = num[i - 1];	
			}
			
			
			int twoDigits = A[i - 2] * 10 + A[i - 1];
			if (twoDigits >= 10 && twoDigits <= 26) {
				num[i] += num[i - 2];
			}
		}
		
		return num[A.length];
	}
	
	@Test
	public void test() {
		int[] A = {1, 1, 0};
		
		System.out.println(combination(A));
	}
	
}
