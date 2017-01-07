package com.jiaxin.lc.binarysearch;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0;
		int end = m * n - 1; 
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int midNumber = matrix[mid / n][mid % n]; 
			
			if (target == midNumber) {
				return true;
			}
			
			if (target < midNumber) {
				end = mid;
			} else if (target > midNumber) {
				start = mid;
			}
		}
		
		
		if (target == matrix[start / n][start % n]) {
			return true;
		}
		
		if (target == matrix[end / n][end % n]) {
			return true;
		}

		return false;
	}
}
