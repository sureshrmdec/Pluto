package com.jiaxin.company.fb;

import java.util.ArrayList;
import java.util.List;


/*
 * Phone:
 * 1. Sqrt
 * 2. Count number of unique characters 
 * 
 * Onsite:
 * 1. March madness brackets (Ninja)
 * 2. Count palindrome  (Ninja)
 * 3. Count binary tree to linked list (Ninja)
 * 4. Interval intersection (Phd Jedi)
 * 5. Design Facebook post search (Pirate)
 * 6. 
 */
public class Fifth {
	
	 // 1. Sqrt
	public int sqrt(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("Can't be negative");
		}
		
		if (x == 0) {
			return 0;
		}
		
		int start = 1;
		int end = x / 2 + 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (x / mid == mid) {
				return mid;
			}
			
			if (x / mid < mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (x / start == start) {
			return start;
		}
		
		if (x / end == end) {
			return end;
		}
		
		return -1;
	}
	
	 // 2. Count number of unique characters 
	
	 // 4. Interval insertion
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null) {
			return result;
		}
		
		int position = 0;
		for (Interval interval : intervals) {
			if (interval.end > newInterval.start) {
				result.add(interval);
				position++;
			} else if (interval.start > newInterval.end) {
				result.add(interval);
			} else {
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end = Math.max(interval.end, interval.end);
			}
		}
		
		result.add(position, newInterval);
		return result;
    }
	
	class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	 }
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
