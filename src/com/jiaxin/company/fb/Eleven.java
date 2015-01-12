package com.jiaxin.company.fb;

import com.jiaxin.cc.Moderate.Swap;

/*
 * Phone: 
 * 1. 
 * 2. read using read64
 * 
 * Onsite:
 * 
 * 1. Design a system fro deep packet inspection on a distributed network? (Pirate) -- may be that guys
 * 2. Given a symbols, generate all permutation of length K. (Ninja)
 * 3. Given a symbols, generate all combinations of length K. (Ninja)
 * 4. find 1K closet points to origin point from 1M randomly sampled points from 3D space. (Ninja)
 * 5. Sqrt of double.(Ninja)
 * 6. Given	a linked list, modify it so that it looks like the one you get by taking head and tail in succession.
 * ABCDE becomes AEBDC (Phd Jedi)
 * 7. Dutch National Flag (Ninja) -- actually sort colors
 * 8. Find shortest number of jumps to the end of an array of integers (Ninja)
 * 
 */
public class Eleven {
	
	
	// 2. Given a symbols, generate all permutation of length K. (Ninja)
	
	
	
	// 3. Given a symbols, generate all combinations of length K. (Ninja)
	
	
	// 5. Newton's 
	double sqrt_newton(double v) {
		double x = 1, nx = 1;
		while (Math.abs(nx - x) > 1e-9) {
			x = nx;
			nx = (v / x + x) / 2;
		}
		return nx;
	}
	
	// Binary Search?? 
	public static double sqrt(double x) {
		double start = 0;
		double end = x / 2 + 1;
		
		while (start < end) {
			double mid = start + (end - start) / 2;
			if (Math.abs(x / mid - mid) < 0.0001) {
				return mid;
			}
			
			if (Math.abs(x / mid - mid) > 0.0001) {
				end = mid;
			} else {
				start = mid;
			}
			
			System.out.println(start + "   " + end + "   " + mid);
		}
		
		if (Math.abs(x / start - start) < 0.0001) {
			return start;
		}
		
		if (Math.abs(x / end - end) < 0.0001) {
			return end;
		}
		
		return -1;
	}
	
	
	// 7. Dutch National Flag --> sort colors
	public void sortColors(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		
		int redIndex = 0;
		int blueIndex = A.length - 1;
		int i = 0;
		
		while (i <= blueIndex) {
			if (i == 0) {
				swap(A, redIndex, i);
				redIndex++;
				i++;
			} else if (i == 2) {
				swap(A, blueIndex, i);
				blueIndex--;
			} else {
				i++;
			}
		}
	}
	
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// 8. Find shortest number of jumps to the end of an array of integers (Ninja)
	public static int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int[] step = new int[A.length];
		step[0] = 0;
		
		for (int i = 1; i < A.length; i++) {
			step[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (step[i] != Integer.MAX_VALUE && A[j] + j >= i ) {
					step[i] =  step[j] + 1;
					break;
				}
			}
		}
		
 		return step[A.length - 1];
	}
	
	public static void main(String[] args) {
		int[] A = {2, 1, 0, 8, 1};
		System.out.println(jump(A));
//		System.out.println(sqrt(2.0));
	}
	
}
