package com.diorsding.advance.dp;

/**
 * http://www.lintcode.com/en/problem/house-robber/
 * 
 * Use rolling array to save memory. Only Need O(1).  
 *  
 * Solution1:
 * 1.f[i] = most value in (0,i), global concept
 * 2.f[i] = max(f[i-1], f[i - 2] + A[i])
 * 3.f[0] = A[0], f[1] = Max(A[0], A[1])
 * 4.result = f[n - 1]
 * 
 * Solution2:
 * 1.f[i] = most value in (0, i), steel i. local concept
 * 2.f[i] = max(f[i-2], f[i-3]) + A[i]. We can not use f[i - 1] to update f[i], which already steel i-1, can not steel i
 * Don't mix global and local concept here. f[i] here means must steel i. 
 * 3.f[0] = A[0], f[1] = A[1], f[2] = max(A[0] + A[2], A[1]). 
 * Here, f[3] should be A[0] + A[2]. But, we need to consider edge case.A.length == 3. So we involve A[1].  
 * 4.result = max {f[i]}
 * 
 * @author jiashan
 *
 */
public class HouseRobber {

	// Solution 1
	public long houseRobber(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		if (A.length == 1) {
			return A[0];
		}
		
		long[] f = new long[A.length];
		f[0] = A[0];
		f[1] = Math.max(A[0], A[1]);
		
		for (int i = 2; i < A.length; i++) {
			f[i] = Math.max(f[i - 1], f[i - 2] + A[i]);
		}
	
		return f[A.length - 1];
	}
	
	public long houseRobberOptimization(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		if (A.length == 1) {
			return A[0];
		}
		
		long[] f = new long[2];
		f[0] = A[0];
		f[1] = Math.max(A[0], A[1]);
		
		for (int i = 2; i < A.length; i++) {
			f[i % 2] = Math.max(f[(i - 1) % 2], f[(i - 2) % 2] + A[i]);
		}
	
		return f[(A.length - 1) % 2];
	}
	
	
	// Solution 2
	public long houseRobberSolution2(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		if (A.length == 1) {
			return A[0];
		}
		
		if (A.length == 2) {
			return Math.max(A[0], A[1]);
		}
		
		if (A.length == 3) {
			return Math.max(A[0] + A[2], A[1]);
		}
		
		long[] f = new long[A.length];
		f[0] = A[0];
		f[1] = A[1];
		f[2] = A[0] + A[2];
		
		for (int i = 3; i < A.length; i++) {
			f[i % 3] = Math.max(f[(i - 2) % 3], f[(i - 3) % 3]) + A[i];
		}
		
		long max = 0;
		for (int i = 0; i < f.length; i++) {
			max = Math.max(max, f[i]);
		}
		
		return max;
	}
}
