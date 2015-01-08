package interview.simple;

import java.util.ArrayList;

/**
 * Reference: http://leetcode.com/2011/01/sliding-window-maximum.html
 * 
 * @author jeffwan
 * @date Apr 5, 2014
 */
public class FindWindowMax {
	public static void main(String[] args) {
		int[] A = {2,3,5,4,2,-1,2,3};
		System.out.println(findWindowMax(A, 3));
		
	}
	
	public static ArrayList<Integer> findWindowMax(int[] A, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (A == null || A.length == 0) {
			return result;
		}

		for (int i = 0; i < A.length - k + 1; i++) {
			int max = findMax(A, i, i + k - 1);
			result.add(max);
		}
		return result;
	}

	public static int findMax(int[] A, int start, int end) {
		int max = A[start];
		for (int i = start + 1; i <= end; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}

		return max;
	}
}
