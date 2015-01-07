package com.jiaxin.lc.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
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
						left--;
					}
					
					while (left < right && num[right] == num[right + 1]) {
						right++;
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
}
