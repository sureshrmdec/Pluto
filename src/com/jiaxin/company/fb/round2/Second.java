package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * Initial Onsite: 
 * 1. Xml parse 
 * 2. Print tree by level 
 * 3. Regex
 * 
 * 
 * Onsite: 
 * 1. Find 3 ints that sum to 0 in an array (Jedi)  - Sum
 * 2. Given a list of a parties, can I attend all parties? (Ninja) -- check if they have intervals ? 
 * 3. Max non-adjacent subset sum (Ninja)
 * 4. Youtube typeahead (Pirate)
 * 5. Football scores (Ninja)
 */
public class Second {
	// 1. xml parse  - stack, queue? 
	// 2. print tree by levels 
	// 3. regex
	
	
	
	// 1. Find 3 ints that sum to 0 in an array (Jedi)  - Sum
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (num == null || num.length == 0) {
			return result;
		}
		
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			
			int left = i + 1;
			int right = num.length - 1;
			
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[left]);
					list.add(num[right]);
					
					result.add(list);

					left++;
					right--;
					
					while (left < right && num[left] == num[left - 1]) {
						left++;
					}
					
					while (left < right && num[right] == num[right + 1]) {
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		return result;
    }
	
	// 2. 
	
	
	// 3. Max non-adjacent subset sum (Ninja) - DP
	
	// 5. Football Score
	public static List<List<Integer>> football(int score) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] A = {1, 2, 3, 6}; // 1 <= 6
		int[] list = new int[4];
		
		footBallHelper(result, list, A, score, 0);
		
		return result;
	}

	private static void footBallHelper(List<List<Integer>> result, int[] list, int[] A, int score, int position) {
		for (int i = position; i < list.length; i++) {
			int sum = getSum(list, A);
			
			if (sum == score && list[0] <= list[3]) {
				result.add(convertToList(list));
				return;
			}
			
			if (sum > score) {
				continue;
			}
			
			list[i]++;
			footBallHelper(result, list, A, score, i);
			list[i]--;
		}
		
	}
	
	private static List<Integer> convertToList(int[] list) {
		List<Integer> temp = new ArrayList<Integer>();
		for (int i : list) {
			temp.add(i);
		}
		
		return temp;
	}

	private static int getSum(int[] list, int[] A) {
		int score = 0;
		
		for (int i = 0; i < list.length; i++) {
			score += list[i] * A[i];
		}
		
		return score;
	}

	public static void main(String[] args) {
		System.out.println(football(7));
	}
	
	
	
}
