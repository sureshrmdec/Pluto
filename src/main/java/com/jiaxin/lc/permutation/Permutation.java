package com.jiaxin.lc.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		permuteHelper(result, list, num);
		
		return result;
	}

	private void permuteHelper(List<List<Integer>> result, List<Integer> list, int[] num) {
		if (list.size() == num.length) {
			result.add(new ArrayList<Integer>(list));
		}
				
		for (int i = 0; i < num.length; i++) {
			if (list.contains(num[i])) {
				continue;
			}
			
			list.add(num[i]);
			permuteHelper(result, list, num);
			list.remove(list.size() - 1);
		}
	}
}
