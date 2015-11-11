package com.diorsding.advance.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * http://www.lintcode.com/en/problem/sliding-window-maximum/
 * Challenge: O(n) time , O(k) memory
 * 
 * Solution:
 * We only move right bound. 
 * 
 * 1.while logic make sure we clear useless small numbers which can not be maximum. meaningless. 
 * 2.
 * i > k && deque.peekFirst() == nums[i - k - 1]   8 5 4 3. 
 * we need to pop first to get right maximum in the range
 * 
 * @author jiashan
 *
 */
public class SlidingWindowMaximum {

	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<>();
		
		int i = 0;
		
		for (int num : nums) {
			i++;
			
			while ((!deque.isEmpty() && num > deque.peekLast())) {
				deque.pollLast();
			}
			
			deque.offer(num);
			
			if (i > k && deque.peekFirst() == nums[i - k - 1]) {
				deque.pollFirst();
			}
			
			if (i >= k) {
				result.add(deque.peekFirst());
			}
		}
		
		return result;
    }
	
}
