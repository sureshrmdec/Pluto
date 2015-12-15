package com.diorsding.advance.datastructure;

import java.util.ArrayList;


/**
 * http://www.lintcode.com/en/problem/sliding-window-median/
 * @author jiashan
 *
 */
public class SlidingWindowMedian {

	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		int median = nums[0];
		
		HashHeap minHeap = new HashHeap("min"); 
		HashHeap maxHeap = new HashHeap("max");
		
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				if (nums[i] > median) {
					minHeap.add(nums[i]);
				} else {
					maxHeap.add(nums[i]);
				}
			}
			
			if (i >= k) {
				if (median == nums[i - k]) {
					if (maxHeap.size() > 0) {
						median = maxHeap.poll();
					} else if (minHeap.size() > 0) {
						median = minHeap.poll();
					}
				} else if (median < nums[i - k]) {
					minHeap.delete(nums[i - k]);
				} else {
					maxHeap.delete(nums[i - k]);
				}
 			}
			
			while (maxHeap.size() > minHeap.size()) {
				minHeap.add(median);
				median = maxHeap.poll();
			}
			
			while (minHeap.size() > maxHeap.size() + 1) {
				maxHeap.add(median);
				median = minHeap.poll();
			}
			
			if (i + 1 >= k) {
				result.add(median);
			}
 		}
		
		return result;
    }
	
}
