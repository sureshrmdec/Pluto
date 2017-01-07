package com.jiaxin.company.fb.careercup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Input: 
 * 1. list of Ranges that don't overlap(not sorted).
 * 2. newRange that might overlap.
 * 
 * Output: 
 * 1. List of Merged ranges
 * 
 * Solution:
 * use position to control insert position
 * 
 * @author jiashan
 *
 */
public class IntervalMerging {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();
		
		Collections.sort(intervals, IntervalComparator);
		int position = 0;
		
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
				position++;
			} else if (interval.start > newInterval.end) {
				result.add(interval);
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		
		result.add(position, newInterval);
		return result;
    }
    
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> result = new ArrayList<Interval>();
    	
    	if (intervals == null || intervals.size() == 0) {
    		return result;
    	}
    	
    	Collections.sort(intervals, IntervalComparator);
    	Interval last = intervals.get(0);
    	
    	for (int i = 1; i < intervals.size(); i++) {
    		Interval current = intervals.get(i);
    		
    		if (last.end < current.start) {
    			result.add(last);
    			last = current;
    		} else {
    			last.end = Math.max(last.end, current.end);
    		}
    	}
    	
    	result.add(last);
    	return result;
    }
    
    
    public Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	};
    
    public class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    		Interval(int s, int e) { start = s; end = e; }
    }
}
