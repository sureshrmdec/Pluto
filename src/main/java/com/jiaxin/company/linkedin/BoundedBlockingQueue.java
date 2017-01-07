package com.jiaxin.company.linkedin;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue<T> {
	private final List<T> queue;
	private final Semaphore availableItem;
	private final Semaphore availableSpace;
	
	public BoundedBlockingQueue(int size) {
		this.queue = new LinkedList<T>();
		availableItem = new Semaphore(0);
		availableSpace = new Semaphore(size);
	}
	
	public void add(T element) throws InterruptedException {
		availableSpace.acquire();
		boolean isAdded = false;
		try {
			synchronized (this) {
				isAdded = queue.add(element);
			}
		} finally {
			if (!isAdded) {
				availableSpace.release();
			} else {
				availableItem.release();
			}
		}
	}
	
	public T remove() throws InterruptedException {
		availableItem.acquire();
		T element;
		synchronized (this) {
			element = queue.remove(queue.size() - 1);
			availableSpace.release();
		}
		return element;
	}
	
}
