package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 1. For example, given the array [−2,1,−3,4,−1,2,1,−5,4], 
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6
 * 
 * 2. For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * 3. [1, 5, 2, 10] -> product besides itself [100, 20, 50, 10];
 * 
 * @author jiashan
 *
 */
public class SubarraySumAndProduct {
	
    public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			sum = Math.max(0, sum);
			max = Math.max(sum, max);
		}
		
    	return max;
    }
	
    /******************************************************************/
   /**
    * max_product = max{A[i]*min_product (when A[i]<0),  A[i]*max_product (when A[i]>0),  A[i] 
    * (when 0 occurs before A[i]) }.
	* 
	* min_product = min{A[i]*min_product,  A[i]*max_product,  A[i] }.
    * @param A
    * @return
    */
    public int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int max = A[0];
		int min = A[0];
		int product = A[0];
		
		
		for (int i = 1; i < A.length; i++) {
			int tempMax = max;
			int tempMin = min;
			
			max = Math.max(Math.max(tempMax * A[i], tempMin * A[i]), A[i]);
			min = Math.max(Math.min(tempMin * A[i], tempMin * A[i]), A[i]);
			product = Math.max(product, max);
		}
		
    	return product;
    }
    
    /******************************************************************/
    

/**
* Implement a method which takes an integer array and returns an integer array (of equal size) in
* which each element is the product of every number in the input array with the exception of the
* number at that index.
*. more info on 1point3acres.com
* Example:
*   [3, 1, 4, 2] => [8, 24, 6, 12]
*   
*   public int[] selfExcludingProduct(int[] input) {
    // implementation...
}
*/

    
    public int[] product(int[] A) {
    	int[] result = new int[A.length];
    	int[] left = new int[A.length];
    	int[] right = new int[A.length];
    	
    	left[0] = 1;
    	right[right.length - 1] = 1;
    	
    	for (int i = 1; i < A.length; i++) {
    		left[i] = left[i - 1] * A[i - 1];
    	}
    	
    	for (int i = A.length - 2; i >= 0 ; i--) {
    		right[i] = right[i + 1] * A[i + 1];
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		result[i] = left[i] * right[i];
    	}
    	
    	return result;
    }
    
    /**
     * Equilibrium index of an array is an index such that the sum of elements at lower indexes 
     * is equal to the sum of elements at higher indexes. For example, in an arrya A:
     * 
     * A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0
     * 
     * 3 is an equilibrium index, because:
     * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
     * 
     * 6 is also an equilibrium index, because sum of zero elements is zero, i.e., 
     * A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0
     */
    
    
    public List<Integer> equilibrium(int[] A) {
    	List<Integer> result = new ArrayList<Integer>();
    	
    	int[] left = new int[A.length];
    	int[] right = new int[A.length];
    	
    	left[0] = 0;
    	right[right.length - 1] = 0;
    	
    	for (int i = 1; i < A.length; i++) {
    		left[i] = left[i - 1] + A[i - 1];
    	}
    	
    	for (int i = A.length - 2; i >= 0 ; i--) {
    		right[i] = right[i + 1] + A[i + 1];
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		if (left[i] ==  right[i]) {
    			result.add(i);
    		}
    	}
    	
    	return result;
    }
    
    
    
    @Test
    public void test() {
    	int[] A = {-7, 1, 5, 2, -4, 3, 0};
    	System.out.println(equilibrium(A));
    }
}
