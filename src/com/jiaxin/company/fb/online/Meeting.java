package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * 1. Given a array of pairs where each pair contains the start and end time of a meeting (as in int)
 * Determine if a single person can attend all the meetings
 * Input array(pair(1,4), pair(4, 5), pair(3,4), pair(2,3)) => false
 * 
 * 2. determine the minimum number of meeting rooms needed to hold all the meetings.
 * 
 * 3. most meetings he can attend
 * The interval scheduling maximization problem (ISMP) is to find a largest compatible set - a set of non-overlapping intervals of maximum size.
 * 
 * 4. a list of segment. find the one segment with others most
 * [1,3] [2,4] [7,8] [4,5]  return [2,4]. because [1,3] intersect with [4,5] 
 * O(n^2) or use dict to record
 * 
 * https://gist.github.com/shadabahmed/5123498
 * http://www.cs.rit.edu/~zjb/courses/800/lec8.pdf
 * 
 * https://github.com/garudareiga/algo-java/blob/master/src/main/java/greedy/IntervalScheduling.java
 * http://blog.sina.com.cn/s/blog_73428e9a010175py.html
 * 
 * 
 * PriorityQueue is based on a priority heap
 * 
 * @author jiashan
 *
 */
public class Meeting {
	// if there's overlapping?
	public boolean attendMettings(Interval[] pairs) {
		if (pairs == null || pairs.length == 0) {
			return true;
		}
		
		Arrays.sort(pairs, IntervalComparator);
		
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
	
	// max overlapping problem
	public int miniRoom(Interval[] pairs) {
		if (pairs == null || pairs.length == 0) {
			return 0;
		}
		
		Arrays.sort(pairs, IntervalComparator);
		
		List<Integer> endTimes = new ArrayList<Integer>();
		int room = 1;
		
		Interval meeting = pairs[0];
		endTimes.add(meeting.end);  // all the meetings not finished
		
		for (int i = 1; i < pairs.length; i++) {
			Interval current = pairs[i];
			boolean flag = false;
			
			for (int j = 0; j < endTimes.size(); j++) {
				if (current.start >= endTimes.get(j)) {
					flag = true; 
					endTimes.remove(j);             // not useful, meeting all ready ends
					endTimes.add(current.end);      // new times
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
	
	// max overlapping problem - Heap
	public int miniRoomHeap(Interval[] pairs) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		Arrays.sort(pairs, IntervalComparator);
		
		heap.add(pairs[0].end);
		
		for (int i = 1; i < pairs.length; i++) {
			Interval current = pairs[i];
			
			//O(1) find available room. if ends, use this one(poll - offer). if not ends, just add room(offer)
			if (heap.peek() <= current.start) {   
				heap.poll();
			}
			
			heap.offer(current.end);
		}
		
		return heap.size();
	}
	
	// max meeting he can attend
	public List<Interval> mostMeeting(Interval[] pairs) {
		List<Interval> result = new ArrayList<Interval>();
		
		Arrays.sort(pairs, IntervalComparatorEnding);
		
		Interval temp = pairs[0];
		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i].start >= temp.end) {
				result.add(temp);
				temp = pairs[i];
			}
		}
		
		result.add(temp);
		
		return result;
	}
	
	
	public Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	};
	
	public Comparator<Interval> IntervalComparatorEnding = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.end - o2.end;
		}
	};
	
	
	@Test
	public void test() {
		
		Interval interval0 = new Interval(-1,2);
		Interval interval1 = new Interval(1,4);
		Interval interval2 = new Interval(4,5);
		Interval interval3 = new Interval(3,4);
		Interval interval4 = new Interval(2,3);
		
//		Interval interval1 = new Interval(10,11);
//		Interval interval2 = new Interval(2,3);
//		Interval interval3 = new Interval(8,10);
//		Interval interval4 = new Interval(0,2);
		
		Interval[] pairs = {interval0, interval1, interval2, interval3, interval4};
		
		System.out.println(attendMettings(pairs));
		System.out.println(miniRoom(pairs));
		System.out.println(miniRoomHeap(pairs));
		System.out.println(mostMeeting(pairs));
	}
	
	
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
			Interval(int s, int e) { start = s; end = e; }
		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}
}
