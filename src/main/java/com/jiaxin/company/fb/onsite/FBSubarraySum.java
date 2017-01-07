package com.jiaxin.company.fb.onsite;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * Same to Lint code?
 * 
 *  
 * 1. find a contiguous subarray which has the largest sum
 * 2. find two  [1, 3, -1, 2, -1, 2], 7 => [1,3] [2,-1,2] or [1,3,-1,2][2]
 * 3. find k subarray sum to target (KSum)
 * 4. maximum subarray difference 
 * 5. product array
 * 6. continuous subarray sum to target
 *  
 * @author jiashan
 *
 */
public class FBSubarraySum {
	
   public int maxSubArray(int[] nums) {
	   return 0;
   }

   
   public int minSubArray(int[] nums) {
	   return 0;
   }
   
   
   // 1. Product array
	public int[] productArray(int[] nums) {
		if (nums == null || nums.length == 0) {
	        return new int[0];
	    }
	    
	    int[] result = new int[nums.length];
	    int[] left = new int[nums.length];
	    int[] right = new int[nums.length];
	    
	    left[0] = 1;
	    for (int i = 1; i < nums.length; i++) {
	        left[i] = left[i - 1] * nums[i - 1]; 
	    }
	    
	    right[nums.length - 1] = 1;
	    result[nums.length - 1] = right[nums.length - 1] * left[nums.length - 1];
	    for (int i = nums.length - 2; i >= 0; i--) {
	        right[i] = right[i + 1] * nums[i + 1];
	        result[i] = left[i] * right[i];
	    }
	    
	    return result;
	}
	
	// FB classic - continious array sum to target
	public boolean findTarget(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false; 
		}
		
		int leftBound = 0;
		int i = 0;
		int sum = 0;
		
		while (i < A.length) {
			if (sum < target) {
				sum += A[i++];
			}
			
			while (leftBound < i && sum > target) {
				sum -= A[leftBound];
				leftBound++;
			}
			
			if (sum == target && i > leftBound) {
				return true;
			}
		}
		
		return false;
	}
	
	
	@Test
	public void test() {
		int[] nums = {10, 3, 5, 6, 2};
		int[] result = productArray(nums);
		List<Integer> list = new ArrayList<Integer>();
		for (int number : result) {
			list.add(number);
		}
		System.out.println(list);
		
		int[] A = {1,2,7,9, 11};
		System.out.println(findTarget(A, 0));
	}
}
