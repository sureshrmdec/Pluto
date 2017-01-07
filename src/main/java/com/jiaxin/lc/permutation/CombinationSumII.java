package com.jiaxin.lc.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	
    	Arrays.sort(num);
    	combinationSum2(result, list, num, target, 0);
    	return result;
    }

	private void combinationSum2(List<List<Integer>> result,
			List<Integer> list, int[] num, int target, int position) {
		if (getSum(list) == target) {
			result.add(new ArrayList<Integer>(list));
		}
		
		if (getSum(list) > target) {
			return;
		}
		
		for (int i = position; i < num.length; i++) {
			if (i != position && num[i] == num[i - 1]) {
				continue;
			}
			
			list.add(num[i]);
			combinationSum2(result, list, num, target, i + 1);
			list.remove(list.size() - 1);
		}
	
	}

	private int getSum(List<Integer> list) {
		int total = 0;
		for (int number : list) {
			total += number;
		}
		
		return total;
	}
}
