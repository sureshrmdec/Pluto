package com.jiaxin.cc.ArraysAndString;

/**
 * 1.6 Given an image represented by an N*N matrix, where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees, Can you do in in place? 
 * 
 * 这题不用按书上的来，leetcode上的方法，中间线对折交换，再沿着对角线交换即可。
 * 
 * @author jeffwan
 * @date May 5, 2014
 */
public class RotateImage {
	//这个方法是不是稍微有点取巧，又补充了下面那一种纯编程型的
	public void rotate(int[][] matrix, int n) {
		if (matrix == null || n <= 0) {
			return;
		}
		
		// turn over along midline
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = temp;
			}
		}
		
		// swap along digonal
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	
	public void rotate1(int[][] matrix, int n) {
		
		
	}
	
}
