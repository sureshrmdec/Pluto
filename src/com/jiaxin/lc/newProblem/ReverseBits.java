package com.jiaxin.lc.newProblem;

import org.junit.Test;


/**
 * For example, 
 * given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Optimization: call many times
 * Store 0X0 - OXF reverse result in a int[16] array, next time, do 4 by 4. check reverse directly. for every int, need 8 step.
 * 
 * 
 * @author jiashan
 *
 */
public class ReverseBits {
	public int reverseBits(int n) {
		int result = 0;
		
		for (int i = 0; i < 32; i++) {
			int bit = (n >> i) & 1; 
			result += bit << (31 - i);
		}
		
		return result;
	}
	
	int[] cache = new int[16];
	public int reverseBitsCache(int n) {
		
		
		return n;
	}
	
	@Test
	public void test() {
		System.out.println(reverseBits(43261596));
	}
}
