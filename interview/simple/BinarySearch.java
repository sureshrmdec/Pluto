package interview.simple;

public class BinarySearch {
	public static void main(String[] args) {
		int[] A = new int[1024];
		for (int i = 0; i < A.length; i++) {
			A[i] = i + 1;
		}
		System.out.println(search(A, 1));
	}
	
	public static int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		
		int count = 0;
		while(start + 1 < end) {
			count++;
			System.out.println("run time: " + count);
			int mid = start + (end - start) / 2;
			if (target == A[mid]) {
				return mid;
			}
			
			if (target < A[mid]) {
				end = mid;
			}
			
			if (target > A[mid]) {
				start = mid;
			}
		}
		
		if (A[start] == target) {
			count++;
			System.out.println("run time: " + count);
			return start;
		}
		
		if (A[end] == target) {
			count++;
			System.out.println("run time: " + count);
			return end;
		}
		
		return -1;
	}
}
