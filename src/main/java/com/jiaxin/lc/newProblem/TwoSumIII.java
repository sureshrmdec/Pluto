package com.jiaxin.lc.newProblem;

import java.util.HashMap;
import java.util.Map;

// case: add(0) -> find(0) -> should be false
public class TwoSumIII {
	Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
	
	public void add(int number) {
		if (dict.containsKey(number)) {
			dict.put(number, dict.get(number) + 1);
		} else {
			dict.put(number, 1);
		}
	}

	public boolean find(int value) {
		for (Integer key : dict.keySet()) {
			if (value - key == key) {
				if (dict.get(key) >= 2) {
					return true;
				}
			} else if (dict.containsKey(value - key)) {
				return true;
			}
		}
	
		return false;
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