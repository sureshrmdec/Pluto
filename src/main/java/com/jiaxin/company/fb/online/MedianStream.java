package com.jiaxin.company.fb.online;

import java.util.PriorityQueue;

/**
 * 
 * 
 * @author jiashan
 *
 */

public class MedianStream {
	
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(); //left
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // right
	
	public int median() {
		/* maxHeap is always at least as big as minHeap. So if maxHeap
		* is empty, then minHeap is also. */
		if (maxHeap.isEmpty()) {
			return 0;
		}
		
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2;
		} else {
			return maxHeap.peek();
		}
	}
	
	/* Note: addNewNumber maintains a condition that * maxHeap.sizeQ >= minHeap.size*/
	public void addNewNumber(int number) {
		if (maxHeap.size() == minHeap.size()) {
			if (minHeap.peek() != null && number > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(number);
			} else {
				maxHeap.offer(number);
			}
		} else {
			if (number < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(number);
			} else {
				minHeap.offer(number);
			}
		}
	}
}
