package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


import org.junit.Test;

/**
 * 1. Given a array of pairs where each pair contains the start and end time of a meeting (as in int)
 * Determine if a single person can attend all the meetings
 * Input array(pair(1,4), pair(4, 5), pair(3,4), pair(2,3)) => false
 * 
 * 2. most meetings he can attend
 * 
 * 3. determine the minimum number of meeting rooms needed to hold all the meetings.
 * 
 * https://gist.github.com/shadabahmed/5123498
 * http://www.cs.rit.edu/~zjb/courses/800/lec8.pdf
 * 
 * https://github.com/garudareiga/algo-java/blob/master/src/main/java/greedy/IntervalScheduling.java
 * 
 * @author jiashan
 *
 */
public class Meeting {
	// can't have any overlapping
	public boolean attendMettings(Interval[] pairs) {
		if (pairs == null || pairs.length == 0) {
			return true;
		}
		
		Interval last = pairs[0];
		for (int i = 1; i < pairs.length; i++) {
			Interval current = pairs[i];
			if (last.end <= current.start) {
				last = current;
			} else {
				return false;
			}
		}
		
		return true;		
	}
	
	// how to many x, y to x??
	public int miniRoom(Interval[] pairs) {
		if (pairs == null || pairs.length == 0) {
			return 0;
		}
		
		Arrays.sort(pairs, IntervalComparator);
		
		List<Integer> endTimes = new ArrayList<Integer>();
		int room = 1;
		
		Interval meeting = pairs[0];
		endTimes.add(meeting.end);
		
		for (int i = 1; i < pairs.length; i++) {
			Interval current = pairs[i];
			boolean flag = false;
			
			for (int j = 0; j < endTimes.size(); j++) {
				if (current.start >= endTimes.get(j)) {
					flag = true; 
					endTimes.remove(j);
					endTimes.add(current.end);
					break;
				}
			}
			
			if (!flag) {
				room++;
				endTimes.add(current.end);
			}
		}
		
		return room;
	}
	
	public Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	};
	
	
	@Test
	public void test() {
		Interval interval1 = new Interval(1,4);
		Interval interval2 = new Interval(4,5);
		Interval interval3 = new Interval(3,4);
		Interval interval4 = new Interval(2,3);
		
		Interval[] pairs = {interval1, interval2, interval3, interval4};
		
		System.out.println(attendMettings(pairs));
		System.out.println(miniRoom(pairs));
	}
	
	
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
			Interval(int s, int e) { start = s; end = e; }
		}
}
