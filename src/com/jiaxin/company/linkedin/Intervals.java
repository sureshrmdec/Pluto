package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class Intervals {
	 /**
     * Adds an interval [from, to] into internal structure.
     */
	List<Interval> intervals = new ArrayList<Interval>();
    void addInterval(int from, int to) {
    	Interval interval = new Interval(from, to);
    	intervals.add(interval);
    }
    /**
     * Returns a total length covered by intervals.
     * If several intervals intersect, intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     *
     * getTotalCoveredLength() -> 6
     * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
     * [1,6] and [8,9] don't intersect so total covered length is a sum for both intervals, that is 6.
     *
     */
    int getTotalCoveredLength() {
    	int total = 0;
    	
    	if (intervals.size() == 0) {
    		return 0;
    	}
    	
    	Collections.sort(intervals, IntervalComparator);
    	Interval last = intervals.get(0);
    	
    	for (int i = 1; i < intervals.size(); i++) {
    		Interval current = intervals.get(i);
    		
    		if (last.end < current.start) {
    			total += last.end - last.start;
    			last = current; 
    		} else {
    			last.end = Math.max(last.end, current.end);
    		}
    	}
    	
    	total += last.end - last.start;
    	
    	return total;
    }
    
    
    
    
    
    //Given a list of tuples representing intervals, return the range these intervals covered
    // 1. merge 2. add to result when there's separate
    public int intervalSum(List<Interval> intervals) {
    	int result = 0;
    	// if we need return intervals, we will have a list here.
    	if (intervals == null || intervals.size() == 0) {
    		return result;
    	}
    	
    	Collections.sort(intervals, IntervalComparator);
    	
    	//[1,5] [3,6] [8,9]
    	
    	Interval last = intervals.get(0);
    	for (int i = 1; i < intervals.size(); i++) {
    		Interval current = intervals.get(i);
    		if (last.end < current.start) {
    			result += last.end - last.start;
    			// list.add(last)
    			last = current;
    		} else {
    			last.end = Math.max(last.end, current.end);
    		}
    	}
    	
    	result += last.end - last.start;
    	
    	return result;
    }
    
    private Comparator<Interval> IntervalComparator = new Comparator<Intervals.Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	}; 
	
	@Test
	public void test() {
		Interval interval1 = new Interval(1,3);
		Interval interval2 = new Interval(4,5);
		Interval interval3 = new Interval(7,10);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		System.out.println(intervalSum(intervals));
		
	}
    
    
    class Interval {
    	int start;
    	int end;
    	Interval() {
    		start = 0;
    		end = 0;
    	}
    	Interval(int s, int e) {
    		start = s;
    		end = e;
    	}
    }
}
