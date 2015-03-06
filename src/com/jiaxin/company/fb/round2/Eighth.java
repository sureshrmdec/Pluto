package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.List;

/*
 * Return Offer:
 * 1. Football scores. Combination sum. 
 * 		-- How many possibilities. 
 * 		-- List all possibilities.  
 * 2. Compute x^n give a double x and an integer n. 
 */

public class Eighth {
	// 1. Football Scores  -- same to money change 1, 5, 10, 25. 2 sub question -- how many ways? how many combination?
	// 1 2 3 6 (touch down)
	static int[] A = {1, 2, 3, 6};
	public static List<List<Integer>> football(int score) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] list = new int[4];
		
		helper(result, list, score, 0);
		
		return result;
	}
		

	private static void helper(List<List<Integer>> result, int[] list, int score, int position) {
		for (int i = position; i < list.length; i++) {
			int sum = getSum(list);
			
			if (sum == score && list[0] <= list[3]) {
				result.add(convertToList(list));
				return;
			}
			
			if (sum < score) {
				list[i]++;
				helper(result, list, score, i);
				list[i]--;
			}
		}
	}


	private static List<Integer> convertToList(int[] list) {
		List<Integer> tempList = new ArrayList<Integer>();
		for (int i: list) {
			tempList.add(i);
		}
		
		return tempList;
	}


	private static int getSum(int[] list) {
		int score = 0;
		
		for (int i = 0; i < list.length; i++) {
			score += A[i] * list[i];
		}
		
		return score;
	}


	// 2. Compute x^n give a double x and an integer n.
	public double pow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		
		if (n == 1) {
			return x;
		}
		
		if (n < 0) {
			if (n == Integer.MIN_VALUE) {
				return 1 / (pow(x, Integer.MAX_VALUE) * x); 
			}
			
			return 1 / pow(x, -n);
		}
		
		if (n % 2 == 1) {
			return pow(x, n / 2) * pow(x, n / 2) * x;
		} else {
			return pow(x , n / 2) * pow(x, n / 2);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(football(7));
	}
	
}
