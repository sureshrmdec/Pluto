package com.jiaxin.company.fb.online;

import org.junit.Test;

public class SwapZeros {
	// sort color way 
	public void moveZeros(int[] A) {
	    if (A == null || A.length == 0) {
	        return;
	    }
	    
	    int zeroIndex = A.length - 1; 
	    int i = 0;
	    
	    while (i < zeroIndex) {
	        if (A[i] == 0) {
	            int temp = A[i];
	            A[i] = A[zeroIndex];
	            A[zeroIndex] = temp;
	            zeroIndex--;
	        } else {
	            i++;
	        }
	    }
	}
	
	// sequence
	public void removeZero(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		
		int size = 0;
		for (int i = 0; i < A.length; i++) {
			if (A [i] != 0) {
				A[size++] = A[i];
			}
		}
		
		
		for (; size < A.length; size++) {
			A[size] = 0;
		}
	}
	
	
	@Test
	public void test() {
		int[] A = {4,0,5,0,8};
		
		moveZeros(A);
		
		for (int number : A) {
			System.out.print(number + " "); // 4 8 5 0 0
		}
		
		
		System.out.println();
		// if we want 4 5 8 0 0?
		int[] B = {4,0,5,0,8};
		removeZero(B);
		for (int number : B) {
			System.out.print(number + " "); // 4 8 5 0 0
		}
	}
}
