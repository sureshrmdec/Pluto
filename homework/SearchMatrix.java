package homework;

public class SearchMatrix {
	
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
	
		int m = matrix.length;
		int n = matrix[0].length;
		
		int start, end, mid;
		start = 0;
		end = m * n - 1;
		
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (target == matrix[mid / n][mid % n]) {
				return true;
			}
			
			if (target < matrix[mid / n][mid % n]) {
				end = mid;
			} else {
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
