package com.diorsding.advance.followup;

import java.util.PriorityQueue;



public class KthSmallestInSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean flag[][] = new boolean[m][n];
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		heap.offer(matrix[0][0]);
		flag[m][n] = true;
		
		while (heap.isEmpty() && k != 0) {
			
		}
		
		return k;
        
    }
	
}
