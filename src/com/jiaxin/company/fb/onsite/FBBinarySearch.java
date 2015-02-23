package com.jiaxin.company.fb.onsite;

import org.junit.Test;

/**
 * 1. Git bitsect  Follow up -- try to call helper function as less as possible 
 * if boolean array gived, use follow up way. We don't need to care mid - 1, start - 1 outOfIndex
 * 
 * 2. Peak
 * 3. double sqrt
 * 4. Divide can only use + -.
 * 5. search 2D. only row and line increase
 * 
 * @author jiashan
 *
 */

public class FBBinarySearch {
	// Git Bitset
	public int gitBisect(int n) {
		int start = 1;
		int end = n;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
				return mid;
			} 

			if (isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (!isBadVersion(start - 1) && isBadVersion(start)) {
			return start;
		}
		
		if (!isBadVersion(end - 1) && isBadVersion(end)) {
			return end;
		}
		
		return -1;
	}
	
	// API function  --- when we pass in outOfIndex,it still works. but for array, not same
	public boolean isBadVersion(int k) {
		return k >= 6;
	}
	
	// just move window and judge result at last step
	public int gitBisectFollowUp(int n) {
		if (n < 1) {
			return -1;
		}
		
		int start = 1;
		int end = n;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (isBadVersion(start)) {
			return start;
		}
		
		if (isBadVersion(end)) {
			return end;
		}
		
		return -1;
	}
	

	@Test
	public void test1() {
		// test case 00, 10, 111, 000, 11100
		System.out.println(gitBisect(3));
		System.out.println(gitBisect(5));
	}
	
	/**********************************************************************************************/
	public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
			return -1;
		}

		int start = 0;
		int end = num.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
				return mid;
			}

			if (num[mid] > num[mid - 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}

		return num[start] > num[end] ? start : end;
    }
	
	@Test
	public void test2() {
		// treat left and right side -8. negative infinite.
		System.out.println(findPeakElement(new int[] {2, 3}));
		System.out.println(findPeakElement(new int[] {3, 2}));
		System.out.println(findPeakElement(new int[] {1, 2, 3}));
		System.out.println(findPeakElement(new int[] {3, 2, 1}));
		System.out.println(findPeakElement(new int[] {1, 2, 3, 1}));
		
	}
	
	/**********************************************************************************************/
	public double sqrtDouble(double x) {
		if (x <= 0) {
			return 0;
		}
		
		double start = 0; 
		double end = x / 2 + 1; // +1 is required. for example. 0.04 -> 0.2
		double precision = 0.001;
		
		while (start < end) {
			double mid = start + (end - start) / 2;
			
			if (Math.abs(mid - x/mid) < precision) {
				return format(mid);
			}
			
			if (x / mid > mid) {
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
	
	// avoid 9.0 2.999 case
	private double format(double mid) {
		return Double.parseDouble(String.format("%.3f", mid));
	}
	
	@Test
	public void test3() {
		System.out.println(sqrtDouble(9.0));
		System.out.println(sqrtDouble(4.0));
		System.out.println(sqrtDouble(0.04));
		System.out.println(sqrtDouble(2));
		System.out.println(sqrtDouble(1));
	}
	
	/**********************************************************************************************/
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		int m = 0;
		int n = matrix[0].length - 1;
		
		// start from up right. n(m + n) solution
		while (m < matrix.length && n >= 0) {
			int number = matrix[m][n];
			
			if (number == target) {
				return true;
			}
			
			if (target < number) { // left move
				n--;
			} else {  // under move
				m++;
			}
		}
		
		return false;
	}
	
	@Test
	public void test4() {
		int[][] matrix = {{1,3,5,7}, {2,6,8,9}, {4,10,11,13}};
		
		System.out.println(searchMatrix(matrix, 1)); //left up most
		System.out.println(searchMatrix(matrix, 4)); //left down most
		System.out.println(searchMatrix(matrix, 13)); // right down most
		System.out.println(searchMatrix(matrix, 11)); // any number
		System.out.println(searchMatrix(matrix, 20)); // invalid
	}
	
	/**********************************************************************************************/
	// Bit 
	public int divideBit(int dividend, int divisor) {
		return 0;
		
	}
	
	
	
	
	// + and -
	public int divide(int dividend, int divisor) {
		return 0;
		
	}
	
}
