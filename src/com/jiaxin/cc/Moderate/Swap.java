package com.jiaxin.cc.Moderate;

/**
 * Problem 17.1: Writtte a function to swap a number in place(that is, without temporary variables).
 * 
 * Solution:
 * 1. Add. Subtract 
 * 2. Bit Manipulation
 * 
 * @author jeffwan
 * @date Feb 26, 2014
 */
public class Swap {
	public static void main(String[] args) {
		
		swapByOperation(3, 4);
		
		swapByBit(1, 2);
	}
	
	
	public static void swapByOperation(int x, int y) {
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("x: " + x + " y: " + y);
		// x = x - y;   y = x + y;   x = y - x; is also a right solution. 
	}
	
	public static void swapByBit(int x, int y) {
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x: " + x + " y: " + y);
	}
}
