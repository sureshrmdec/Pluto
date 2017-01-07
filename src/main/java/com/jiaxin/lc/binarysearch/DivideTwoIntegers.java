package com.jiaxin.lc.binarysearch;

// bit 
public class DivideTwoIntegers {
	// Test case: -2147483648, -1
	public static int divide(int dividend, int divisor) {
		long result = 0;
		boolean positive = true;
		
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			positive = false;
		}
		
		long tempDividend = dividend;
		long tempDivisor = divisor;
		
		if (tempDividend < 0) {
			tempDividend = -tempDividend;
		}
		
		if (tempDivisor < 0) {
			tempDivisor = -tempDivisor;
		}
		
		while (tempDividend >= tempDivisor) {
			int multi = 1;
			long temp = tempDivisor;
			
			while (tempDividend >= temp) {
				tempDividend -= temp;
				result += multi;
				temp += temp;
				multi += multi;
			}
		}
		
		if (positive) {
			if (result == (long)Math.abs(Integer.MIN_VALUE)) {
				return Integer.MAX_VALUE;
			}
			
			return (int)result;
		} else {
			return (int)(-result);
		}	
	}
	
	public static void main(String[] args) {
		System.out.println(divide(-2147483648, -1));
	}
}
