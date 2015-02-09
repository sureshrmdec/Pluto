package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Triangle {
	
	/**
     * Three segments of lengths A, B, C form a triangle iff
     * 
     *      A + B > C
     *      B + C > A
     *      A + C > B
     *
     * e.g.
     *  6, 4, 5 can form a triangle
     * 10, 2, 7 can't
     *
     * Given a list of segments lengths algorithm should find at least one triplet of segments that form a triangle (if any).
     * 
     * Method should return an array of either:
     * - 3 elements: segments that form a triangle (i.e. satisfy the condition above)
     * - empty array if there are no such segments
     * 
     * https://gist.github.com/gaoyike/40df1e0ec5a6c95e0014
     * 
     * http://www.geeksforgeeks.org/find-number-of-triangles-possible/
     */
	
	// find all triples -- consider deng bian triangle
	public List<List<Integer>> triangle(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		for (int i = 0; i < nums.length; i++) {
			int k = i;
			for (int j = i; j < nums.length; j++) {
				// k would be the largest number make triangle words
				while (k < nums.length && nums[i] + nums[j] > nums[k]) {
					k++;
				}
				
				for (int l = j; l < k; l++) {
					List<Integer> triple = new ArrayList<Integer>();
					triple.add(nums[i]);
					triple.add(nums[j]);
					triple.add(nums[l]);
					result.add(triple);
				}
			}
		}
		
		return result;
	}
	
	// no duplicate
	public List<List<Integer>> triangleDiffSide(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1; j++) {
				// k would be the largest number make triangle words
				while (k < nums.length && nums[i] + nums[j] > nums[k]) {
					k++;
				}
				
				for (int l = j + 1; l < k; l++) {
					List<Integer> triple = new ArrayList<Integer>();
					triple.add(nums[i]);
					triple.add(nums[j]);
					triple.add(nums[l]);
					result.add(triple);
				}
			}
		}
		
		return result;
	}
	
	// find total number -- no duplicates
	public int trianglePossibile(int[] nums) {
		int result = 0;
		Arrays.sort(nums);
		
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2; // initialize the right most element;
			for (int j = i + 1; j < nums.length - 1; j++) {
				// k would be the largest number make triangle words
				while (k < nums.length && nums[i] + nums[j] > nums[k]) {
					k++;
				}
				
				result += k - j - 1;
			}
		}
		return result;
	}
	
	@Test
	public void test() {
		int[] nums = {4,6,3, 7};
		System.out.println(triangle(nums));
		System.out.println(triangleDiffSide(nums));
		System.out.println(trianglePossibile(nums));
	}
	
}
