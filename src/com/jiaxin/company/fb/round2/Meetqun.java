package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to 
 * the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).
 * Example:  arr[] = {10, 3, 5, 6, 2}  prod[] = {180, 600, 360, 300, 900}
 * 
 */


import org.junit.Test;



public class Meetqun {
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
	    for (int i = nums.length - 2; i >= 0; i--) {
	        right[i] = right[i + 1] * nums[i + 1];
	    }
	    
	    for (int i = 0; i < nums.length; i++) {
	        result[i] = left[i] * right[i];
	    }
	    
	    return result;
	}
	
	// 2. Combination Sum
	public List<List<Integer>> combinationSum(int[] num, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> list = new ArrayList<Integer>();
	    Arrays.sort(num);

	    if (num == null || num.length == 0) {
	        return result;
	    }
	    
	    helper(result, list, num, target, 0);
	    
	    return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> list, int[] num, int target, int position) {
	    int sum = getSum(list);
	    
	    if (sum == target) {
	        result.add(new ArrayList<Integer>(list));
	        return;
	    }
	    
	    if (sum > target) {
	        return;
	    }
	    
	    for (int i = position; i < num.length; i++) {
	        list.add(num[i]);
	        helper(result, list, num, target, i);
	        list.remove(list.size() - 1);
	    }
	}

	public int getSum(List<Integer> list) {
	    int sum = 0;
	    for (int i = 0; i < list.size(); i++) {
	        sum += list.get(i);
	    }
	    return sum;
	}
	
	@Test
	public void test() {
//		int[] nums = {10, 3, 5, 6, 2};
//		int[] result = productArray(nums);
//		List<Integer> list = new ArrayList<Integer>();
//		
//		for (int number : result) {
//			list.add(number);
//		}
//		
//		System.out.println(list);
		
		int[] num = {2,3,7};
		System.out.println(combinationSum(num, 10));
	}
}
