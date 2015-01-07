package com.jiaxin.lc.binarysearch;

public class Pow {
	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		
		if (n == 1) {
			return x;
		}
		
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				return 1/ (pow(x, Integer.MAX_VALUE) * x);
			}
			
			return 1 / pow(x, -n);
		}
		
		double half = pow(x, n /2); 
		
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}
}
