package com.jiaxin.company.ebay;

public class TestQueue {
	public static void main(String[] args) {
		GenericQueue<String> queue = new GenericQueue<String>();
		queue.offer("Tom");
		System.out.println("7. " + queue);
		
		queue.offer("John");
		System.out.println("8. " + queue);
		
		queue.offer("George");
		queue.offer("Michael");
		System.out.println("9. " + queue);
		
		System.out.println("7. " + queue.poll());
		System.out.println("7. " + queue.size());
		System.out.println("7. " + queue.empty());
		System.out.println("7. " + queue.poll());
		System.out.println("7. " + queue);
		System.out.println("7. " + queue.poll());
		System.out.println("7. " + queue.poll());
		System.out.println("7. " + queue.empty());
		System.out.println("9. " + queue.size());
	}
}
