package com.jiaxin.lc.newProblem;

import org.junit.Test;

public class HammingWeight {
	public int hammingWeight(int n) {
		
		int total = 0;
		
		for (int i = 0; i < 32; i++) {
			total += n & 1;
			n = n >> 1;
		}
		
		return total;
    }
	
	public int hammingWeight2(int n) { 
		int count = 0;
		for (int i = 0; i < 32; i++) {
			count += (n >>> i & 1);
		}
		
		return count;
	}
	
	
	@Test
	public void test() {
		System.out.println(hammingWeight(11));
		System.out.println(hammingWeight2(11));
		System.out.println(hammingWeight(15));
		System.out.println(hammingWeight2(15));
	}
}
