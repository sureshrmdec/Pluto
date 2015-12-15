package com.jiaxin.company.twosigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerOfFour {

	public boolean powerOfTwo(int x) {
		// another solution is just left move 1. compare isEqulas(x, number);
		
		return (x != 0) && ((x & (x - 1)) == 0);
	}
	
	
	public boolean powerOfXYI(int x, int y) {
		while (x % y == 0) {
			x = x / y;
		}
		
		return x == 1;
	}
	

	// There is only one bit set in its binary representation (check for power of 2), and
	// Number of bits towards the right of set bit is even.
	
	public boolean powerOfFour(int x) {
		// another solution is just left move 1. compare isEqulas(x, number);
		if ((x != 0) && ((x & (x - 1)) == 0)) {
			int count = 0;
			
			while (x > 1) {
				x = x >> 1;
				count++;
			}
			
			return (count % 2 == 0);
//			 return  (x & 0x55555554) != 0;
		}
		
		return false;
	}
	
	@Test
	public void test() {
		assertEquals(true, powerOfFour(4));
		assertEquals(false, powerOfFour(3));
		assertEquals(false, powerOfFour(8));
		assertEquals(false, powerOfFour(32));
		assertEquals(true, powerOfFour(64));
		assertEquals(true, powerOfFour(256));
	}
	
}
