package com.jiaxin.cc.SortingAndSearching;
/**
 * LeetCode 上变种题，这个是每行严格递增，但是上面一行的最后一个，不一定大于第二行的第一个. 每一列也是严格递增的
 * 每次可以扔掉一列或者一行
 * 
 * 有重复，如果有，直接跳到对角线(因为上边，右边都肯定不是，严格递增递减的)
 * 
 * @author jeffwan
 * @date May 18, 2014
 */
public class SortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,4}, {1,2,6,9}, {3,5,6,10}, {7,8,9,11}};
		System.out.println(findMatrix(matrix, 7));
	}
	
	public static boolean findMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0|| matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length - 1;
		
		int i = m - 1;
		int j = 0; 
		while (i >= 0 && j < n) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				i = i-1;
			} else {
				j = j + 1;
			}
		}
			
		return false;
	}
	
}
