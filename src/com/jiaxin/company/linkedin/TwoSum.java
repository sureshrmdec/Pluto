package com.jiaxin.company.linkedin;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jiashan
 * Store use frequently: 
 * add – O(1) runtime, find – O(n) runtime, O(n) space – Store input in hash table:
 * 
 * 
 * Test use frequently:
 * add -O(n) find O(1) O(n^2) space. hashMap store sums pair, O(n) store list. 
 * 
 * -----------------
 * add – O(n) runtime, find – O(n) runtime, O(n) space – Binary search + Two pointers:
 * binary search to find out position, add need shift, find use two pointer
 * 
 * add – O(1) runtime, find – O(n log n) runtime, O(n) space – Sort + Two pointers:
 *  
 * 
 * 
 */
public class TwoSum {
	private Map<Integer, Integer> table = new HashMap<Integer, Integer>();
	
	void store(int value) {
		int count = table.get(value) != null ? table.get(value) : 0;
		table.put(value, count + 1);
	}
	
	boolean test(int sum) {
		for (Map.Entry<Integer, Integer> entry: table.entrySet()) {
			if (entry.getKey() == sum - entry.getKey()) {
				if (entry.getValue() >= 2) {
					return true;
				}
				// take care the logic here.
			} else if (table.containsKey(sum - entry.getKey())) {
				return true;
			}
		}
		
		return false;
	}
}
