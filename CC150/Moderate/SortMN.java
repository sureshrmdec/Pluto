package CC150.Moderate;
/**
 * 17.6 Given an array of integers, write a method to find indices m and n such that if you sorted
 * elementss m through n, the entire array would be sorted. 
 * 
 * input : {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}
 * output: (3, 9)
 * 思路: 找到升序序列
 * left: 1, 2, 4, 7, 10, 11
 * middle: 7, 12
 * right: 6, 7, 16, 18, 19
 *  
 * min(middle) > left End
 * max(midlle) < right Start
 * 然后shift左边，右边，调整一下就好
 * 
 * 但是我感觉书上是有问题的，max的index 随时更新的，或者min max 同时一步步的走，因为shift到middle的值的如果是 < > 原来的max min，需要参与下一步的计算，
 * 比如11换成19，那最后结果就应该是尾巴了，而不是9
 * 
 * @author jeffwan
 * @date May 24, 2014
 */
public class SortMN {
	public static void main(String[] args) {
		int[] A = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		findUnSortedSequence(A);
	}
	
	public static void findUnSortedSequence(int[] A) {
		int startRight = findStartRight(A);
		int endLeft = findEndLeft(A);
		
		int min = endLeft + 1;
		int max = startRight - 1;
		// already sorted check
		if (min >= A.length || max < 0) {
			return;
		}
		
		// find min max index in middle part
		for (int i = min; i <= max; i++) {
			if (A[i] < min) {
				min = i;
			}
			
			if(A[i] > max) {
				max = i;
			}
		}
		
		int left = shiftLeft(A, endLeft, min);
		int right = shiftRight(A, startRight, max);
		
		System.out.println(left + " " + right);
	}

	private static int shiftLeft(int[] A, int endLeft, int min) {
		int value = A[min];
		for (int i = endLeft; i >= 0; i--) {
			if (A[i] < value) {
				return i + 1;
			}
		}
		return 0;
	}
	
	private static int shiftRight(int[] A, int startRight, int max) {
		int value = A[max];
		for (int i = startRight; i < A.length; i++) {
			if (A[i] > value) {
				return i - 1;
			}
		}
		return A.length - 1;
	}

	private static int findEndLeft(int[] A) {
		int i = 1;
		for (i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				break;
			}
		}
		return i - 1;
	}

	private static int findStartRight(int[] A) {
		int i = A.length - 1;
		for (i = A.length - 2; i >= 0; i--) {
			if (A[i] > A[i + 1]) {
				break;
			}
		}
		return i + 1;
	}
}
