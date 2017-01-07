package com.jiaxin.lc.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
	public List<List<Integer>> subsetWithDup(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		Arrays.sort(num);
		subsetWithDup(result, list, num, 0);
		
		return result;
	}

	private void subsetWithDup(List<List<Integer>> result, List<Integer> list, int[] num, int position) {
		result.add(new ArrayList<Integer>(list));
		
		for (int i = position; i < num.length; i++) {
			if (i != position && num[i] == num[i - 1]) {
				continue;
			}
			
			list.add(num[i]);
			subsetWithDup(result, list, num, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
