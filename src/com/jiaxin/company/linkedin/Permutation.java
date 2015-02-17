package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Permutation {
	/** 
	* Generate all permutations of given sequence of elements. 
	* Return a list of all distinct permutations. 
	* 
	* E.g. 
	* generate([1, 2, 3]) -> [1, 2, 3], [1, 3, 2], [2, 3, 1], [2, 1, 3], [3, 1, 2], [3, 2, 1] 
	* 
	* vector<vector<int>> generate(vector<int> items); 
	* 
	* question:
	* 1. sorted? 
	* 2. duplicate ?
	* 3. next permutation? 
	*/ 	
	
	public List<List<Integer>> permutation(List<Integer> items) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		if (items == null || items.size() == 0) {
			return result;
		}
		
		Collections.sort(items);
		
		helper(result, list, items);
		
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> list,
			List<Integer> items) {
		if (list.size() == items.size()) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < items.size(); i++) {
			if (list.contains(items.get(i))) {
				continue;
			}
			
			list.add(items.get(i));
			helper(result, list, items);
			list.remove(list.size() - 1);
		}
	}
	
	/********************************************************************************/
	public List<String> permutation(String s) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		char[] array = s.toCharArray();
		boolean[] visited = new boolean[array.length];
		
		helper(result, sb, array, visited);
		
		return result;
	}

	private void helper(List<String> result, StringBuilder sb, char[] array, boolean[] visited) {
		if (sb.length() == array.length) {
			result.add(sb.toString());
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			if (visited[i] || (i != 0 && array[i] == array[i - 1] && !visited[i - 1])) {
				continue;
			}
			
			visited[i] = true;
			sb.append(array[i]);
			helper(result, sb, array, visited);
			sb.deleteCharAt(sb.length() - 1);
			visited[i] = false;
		}
	}
	
	
	//http://www.glassdoor.com/Interview/LinkedIn-Software-Engineer-Interview-Questions-EI_IE34865.0,8_KO9,26.htm#InterviewReview_5424743
	/**
	 * 2,3,6,5,4,1
	 * 1. right to left -> 3
	 * 2. right to left -> 4
	 * 3. swap 3, 4 -> 2 4 (6 5 3 1)
	 * 4. reverse part in brace -> 2 4 1 3 5 6
	 * 
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permutation(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (num == null || num.length == 0) {
			return result;
		}
		
		// don't change original array
		int[] last = new int[num.length];
		System.arraycopy(num, 0, last, 0, num.length);
		
		// calculate n!
		int length = 1;
		for (int i = 1; i < num.length; i++) {
			length *= num[i];
		}
		
		
		for (int k = 0; k < length; k++) {
			int i = last.length - 2;
			
			while (i >= 0 && last[i] >= last[i + 1]) {
				i--;
			}
			
			if (i >= 0) {
				int j = i + 1;
				
				while (j < last.length && last[j] > last[i]) {
					j++;
				}
				j--;
				
				int temp = last[i];
				last[i] = last[j];
				last[j]= temp;
			}
			
			List<Integer> list = reverse(last, i + 1);
			result.add(list);
		}
		
		return result;		
	}
	
	
	private List<Integer> reverse(int[] last, int start) {
		int end = last.length - 1;
		while (start < end) {
			int temp = last[start];
			last[start] = last[end];
			last[end] = temp;
			start++;
			end--;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (int number : last) {
			list.add(number);
		}
		
		return list;
	}

	@Test
	public void test() {
		List<Integer> items = new ArrayList<Integer>();
		items.add(1);items.add(2);items.add(3);
		
		System.out.println(permutation(items));
		System.out.println(permutation(new int[] {1,2,3}));
	}
	
}
