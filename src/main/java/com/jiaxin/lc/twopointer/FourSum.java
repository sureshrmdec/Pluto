package com.jiaxin.lc.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author jiashan
 *
 * K-Sum (Recursive + split 2 groups way)
 * 
 * http://tech-wonderland.net/blog/k-sum-problem-analysis-recursive-implementation-lower-bound.html
 * http://cs.stackexchange.com/questions/2973/generalised-3sum-k-sum-problem
 * 
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			 
			for (int j = i + 1; j < num.length - 2; j++) {
				if (j != i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				
				int left = j + 1;
				int right = num.length - 1;
				
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
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
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		
		return result;
    }
}
