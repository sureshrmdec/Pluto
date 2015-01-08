package homework;

/**
 * Solution: 
 * 1. if A[mid] < A[mid - 1]. There must be a top on the left side
 * 2. if A[mid] > A[mid + 1]. There must be a top on the right side 
 * @author jeffwan
 * @date Apr 25, 2014
 */
public class FindPeek {
	public int findPeek(int[] A) {
		if (A == null || A.length < 3) {
			return -1;
		}
		
		int start, end, mid;
		
		start = 1;
		end = A.length - 2;
		
		while(start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return A[mid];
			}
			
			if(A[mid] < A[mid - 1]) {
				end = mid;
			} else if(A[mid] < A[mid + 1]) {
				start = mid;
			}
		}
		
		if (A[start] > A[start - 1] && A[start] > A[start + 1]) {
			return A[start];
		}
		
		if (A[end] > A[end - 1] && A[end] > A[end + 1]) {
			return A[end];
		}
		
		return -1;
	}
}
