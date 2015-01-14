package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

public class TwoSumIII {
	List<Integer> list;
	Map<Integer, Boolean> dict;
	
	public TwoSumIII() {
		this.list = new ArrayList<Integer>();
		this.dict = new HashMap<Integer, Boolean>();
	}
	
	
	public void add(int number) {
		int i = 0;
		for (i = 0; i < list.size(); i++) {
			if (list.get(i) > number) {
				break;
			}
		}
		
		list.add(i, number);
	}

	public boolean find(int value) {
		if (dict.containsKey(value)) {
			return dict.get(value);
		}
		
		boolean result = false;
		int start = 0;
		int end = list.size() - 1;
		
		while (start < end) {
			int sum = list.get(start) + list.get(end);
			
			if (sum == value) {
				result = true;
				break;
			} else if (sum < value) {
				start++;
			} else {
				end--;
			}
		}
		
		dict.put(value, result);
		return result;
	}
	
	public static void main(String[] args) {
		TwoSumIII util = new TwoSumIII();
		util.add(1);
		util.add(3);
		util.add(5);
		
		System.out.println(util.find(4));
		System.out.println(util.find(7));
	}
	
}