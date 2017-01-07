package com.jiaxin.lc.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		Arrays.sort(S);
		subsetHelper(result, list, S, 0);
		
		return result;
	}

	private void subsetHelper(List<List<Integer>> result, List<Integer> list, int[] s, int position) {
		result.add(new ArrayList<Integer>(list));
		
		for (int i = position; i < s.length; i++) {
			list.add(s[i]);
			subsetHelper(result, list, s, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
