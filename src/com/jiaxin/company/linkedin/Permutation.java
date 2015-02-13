package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
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
	* 
	* 
	* Next Permutation -- iterator?
	* 一面两个题很简单，找距离最近的n个点和一个排好序的数组找比给定数大的第一个数，水过了
二面面完就感觉没戏了。第一题出了个2sum，我说做过，第二题是个permutation，写完了我以为下边follow up应该是考虑重复数字吧，但扯了半天next permutation，说如果要找next permutation的话用什么signature,后来搞了半天直到他写出了next(), hasnext(), 才知道他的意思是用iterator。。。
后来出了个textfile implement iterator的题之前在版上见过这题，想先把file 读一遍放list里然后用iterator，但说不行，必须一行一行的读，对iterator也不熟，写的code跟屎一样，当攒人品了吧。
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
	
	@Test
	public void test() {
		List<Integer> items = new ArrayList<Integer>();
		items.add(1);items.add(2);items.add(3);
		
		System.out.println(permutation(items));
	}
	
}
