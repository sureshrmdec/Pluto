package interview.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Find maximum frequent numbers in an array. If there are more than one numbers with maximum frequency, 
 * they display all numbers in ascending order. Ascending order is important.
 */
public class TopFrequence {
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6,3,3,3,3,3,3,4,5,2,1,1,1,1,1,1,1,1};
		System.out.println(topFrequncy(num));
	}
	
	public static int topFrequncy(int[] num) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < num.length; i++) {
			if (hashMap.containsKey(num[i])) {
				hashMap.put(num[i], hashMap.get(num[i]) + 1);
			} else {
				hashMap.put(num[i], 1);
			}
		}
		
		int max = Integer.MIN_VALUE;
		// find the max value
		for (Integer value : hashMap.values()) {
			max = Math.max(max, value);
		}
		
		// find the max value's key if needed
		for (Integer key: hashMap.keySet()) {
			if (hashMap.get(key) == max) {
				return key;
			}
		}

		return max;
	}
}
