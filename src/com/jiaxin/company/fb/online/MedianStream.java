package com.jiaxin.company.fb.online;

import java.util.PriorityQueue;

/**
 * 
 * 1、每遇到新元素，和max heap的top比较（min的top也可），小于则插入max heap中，否则插入min heap。
2、heap之间的平衡：如果两个heap的size差在1以上，则把多的那个的top摘下来放进另一个里，两个堆重新heapify。
3、输出较大的那个堆的top，若相等则按题目要求输出max 的top
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
