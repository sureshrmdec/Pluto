package com.jiaxin.lc.permutation;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		combineHelper(result, list, n, k, 1);
		
		return result;
	}

	private void combineHelper(List<List<Integer>> result, List<Integer> list, int n, int k, int position) {
		if (list.size() == k) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = position; i <= n; i++) {
			list.add(i);
			combineHelper(result, list, n, k, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
