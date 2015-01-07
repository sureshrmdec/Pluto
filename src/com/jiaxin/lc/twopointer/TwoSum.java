package com.jiaxin.lc.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] sorted = new int[numbers.length];
		System.arraycopy(numbers, 0, sorted, 0, numbers.length);
		Arrays.sort(sorted);
		
		int left = 0;
		int right = numbers.length - 1;
		
		while (left < right) {
			int sum = sorted[left] + sorted[right];
			if (sum == target) {
				break;
			} 
			
			if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		
		int[] result = {-1, -1};
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == sorted[left] || numbers[i] == sorted[right]) {
				if (result[0] == -1) {
					result[0] = i + 1;
				} else {
					result[1] = i + 1;
				}
			}
		}
		
		Arrays.sort(result);
		return result;
    }
	
	public int[] twoSumHashMap(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = {-1, -1};
		
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[0] = map.get(target - numbers[i]) + 1;
				result[1] = i + 1;
				break;
			} else {
				map.put(numbers[i], i);
			}
		}
	
		return result;
	}
	
}
