package com.jiaxin.lc.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		Arrays.sort(candidates);
		combinationSumHelper(result, list, candidates, target, 0);
		
 		return result;
	}

	private void combinationSumHelper(List<List<Integer>> result,
			List<Integer> list, int[] candidates, int target, int position) {
		if (getSum(list) == target) {
			result.add(new ArrayList<Integer>(list));
		}
		
		if (getSum(list) > target) {
			return;
		}
		
		for (int i = position; i < candidates.length; i++) {
			list.add(candidates[i]);
			combinationSumHelper(result, list, candidates, target, i);
			list.remove(list.size() - 1);
		}
	}

	private int getSum(List<Integer> list) {
		int total = 0;
		for (int number: list) {
			total += number;
		}
		
		return total;
	}
}
