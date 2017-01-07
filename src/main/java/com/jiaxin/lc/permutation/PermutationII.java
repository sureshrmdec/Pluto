package com.jiaxin.lc.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[num.length];
		
		Arrays.sort(num);
		permuteUniqueHelper(result, list, num, visited);
		
		return result;
	}

	private void permuteUniqueHelper(List<List<Integer>> result, List<Integer> list, int[] num, boolean[] visited) {
		if (list.size() == num.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < num.length; i++) {
			if ((visited[i] == true) || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == false)) {
				continue;
			}
			
			list.add(num[i]);
			visited[i] = true;
			permuteUniqueHelper(result, list, num, visited);
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}
}
