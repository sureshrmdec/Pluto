package com.jiaxin.company.linkedin;

import org.junit.Test;

public class PowAndSqrt {

	public double pow(double a, int b) {
		if (b == 0) {
			return 1;
		}
		
		if (b == 1) {
			return a;
		}
		
		if (b < 0) {
			if (b == Integer.MIN_VALUE) {
				return 1 / (pow(a, Integer.MAX_VALUE) * a);
			}
			
			return 1 / pow(a, -b);
		}
		
		double half = pow(a, b/2);
		
		if (b % 2 == 1) {
			return half * half * a;
		} else {
			return half * half;
		}
	}
	
	
	/************************************************************************************/
	public int sqrtInt(int x) {
		if (x <= 0) {
			return 0;
		}
		
		int start = 1;
		int end = x/2 + 1; 
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (mid == x / mid) {
				return mid;
			}
			
			if (mid < x / mid) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (start == x / start) {
			return start;
		}
		
		if (end == x / end) {
			return end;
		}
		
		return -1;
	}
	
	
	/************************************************************************************/
	public double sqrtDouble(double x) {
		if (x <= 0) {
			return 0;
		}
		
		double start = 0; 
		double end = x / 2 + 1;
		double precision = 0.001;
		
		while (start < end) {
			double mid = start + (end - start) / 2;
			
			if (Math.abs(mid - x/mid) < precision) {
				return format(mid);
			}
			
			if (mid < x / mid) {
				start = mid;
			} else {
				end = mid;
			}
			
		}
		
		if (Math.abs(start - x/start) < precision) {
			return start;
		}

		if (Math.abs(end - x/end) < precision) {
			return end;
		}

		return -1;
	}
	
	
	private double format(double mid) {
		return Double.parseDouble(String.format("%.3f", mid));
	}


	@Test
	public void test() {
		System.out.println(sqrtDouble(2));
	}
	
}
