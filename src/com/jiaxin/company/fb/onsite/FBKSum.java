package com.jiaxin.company.fb.onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 1. 2Sum
 * 2. 3Sum
 * 3. KSum Iterative
 * 4. KSum DP?
 * 
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * 
 * http://tech-wonderland.net/blog/summary-of-ksum-problems.html
 * http://agooglehacker.blogspot.com/2013/10/2sum-3sum-4sum-ksum.html
 * http://www.cnblogs.com/yuzhangcmu/p/4279676.html
 * 
 * 
 * 
 * @author jiashan
 *
 */

public class FBKSum {
	// 2Sum - Two Pointer - Already sorted, don't know to care record original index
	public int[] twoSumTwoPointer(int[] numbers, int target) {
		int[] result = {-1, -1};
		if (numbers == null || numbers.length == 0) {
			return result;
		}
		
		int start = 0; 
		int end = numbers.length - 1;
		
		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				result[0] = start;
				result[1] = end;
				break;
			}
			
			if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		
		return result;
	}
	
	
	// 2Sum - HashMap
	public int[] twoSum(int[] numbers, int target) {
		int[] result = {-1, -1};
		if (numbers == null || numbers.length == 0) {
			return result;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				result[0] = map.get(numbers[i]) + 1;
				result[1] = i + 1;
				break;
				
			} else {
				map.put(target - numbers[i], i);
			}
		}
		
		return result;
	}
	
	
	/**********************************************************************************************/
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // remove duplicates
			}
			
			int start = i + 1;
			int end = num.length - 1;
			
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[start]);
					list.add(num[end]);
					result.add(list);
					start++;
					end--;
					
					// remove duplicates
					while (start < end && num[start] == num[start - 1]) {
						start++;
					}

					while (start < end && num[end] == num[end + 1]) {
						end--;
					}
					
				} else if (sum < 0) {
					start++;
				} else {
					end--;
				}
			}
		}

		return result;
	}
	
	/**********************************************************************************************/
	
	/**********************************************************************************************/
    public int kSumDP(int A[], int k, int target) {
    	if (A == null || target < 0) {
    		return 0;
    	}
		
    	int length = A.length;
    	
    	int[][][] num = new int[length + 1][k + 1][target + 1];
    	
    	for (int i = 0; i <= length; i++) {
    		for (int j = 0; j <= k; j++) {
    			for (int t = 0; t <= target; t++) {
    				if (j == 0 && t == 0) {
    					num[i][j][t] = 1; 
    				} else if (!(i == 0 || j == 0 || t == 0)) {
    					num[i][j][t] = num[i - 1][j][t];
    					if (t - A[i - 1] >= 0) {
    						num[i][j][t] += num[i - 1][j - 1][t - A[i - 1]];
    					}
    				}
    				
    			}
    		}
    	}
    	
    	return num[length][k][target];
    }
	
    @Test
    public void test() {
    	int[] A = {1,2,3,4,5,6};
    	System.out.println(kSumDP(A, 2, 10));
    }
}
