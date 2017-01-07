package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Intersection {
	/**
	 * Intersection of two arrays. List -> same thing
	 * 
	 * 1. sorting. all sorted, two pointer to get == ones
	 * 
	 * 2. sorting one, for each of num2, do binary search
	 * 
	 * 3. hashMap.
	 * 
	 * 
	 * arr1[] = {1, 3, 4, 5, 7}
	 * arr2[] = {2, 3, 5, 6}
	 * 
	 * Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}.
	 * 
	 * 
	 */
	public List<Integer> union(int[] A, int[] B) {
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		
		Arrays.sort(A); Arrays.sort(B);
		
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				list.add(A[i++]);
			} else if (A[i] > B[j]) {
				list.add(B[j++]);
			} else {
				list.add(A[i]); i++;j++;
			}
		}
		
		while (i < A.length) {
			list.add(A[i++]);
		}
		
		while (j < B.length) {
			list.add(B[j++]);
		}
		
		return list;
		
	}
	
	public List<Integer> intersection(int[] A, int[] B) {
		List<Integer> list = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		
		Arrays.sort(A); Arrays.sort(B);
		
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				i++;
			} else if (A[i] > B[j]) {
				j++;
			} else {
				list.add(A[i]); i++;j++;
			}
		}
		
		return list;
	}

	@Test
	public void test() {
		int[] A = {1, 3, 4, 5, 7};
		int[] B = {2, 3, 5, 6};
		
		System.out.println(union(A, B));
		System.out.println(intersection(A, B));
	}
	
	
}
