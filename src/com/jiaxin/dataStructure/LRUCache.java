package com.jiaxin.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Map - Key, key. Value Node
 * Node- key & value
 * @author jiashan
 *
 */
public class LRUCache {

	Map<Integer, Node> map = new HashMap<Integer, Node>();
	int capacity;
	Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
    	
		Node node = map.get(key);
		node.next.prev = node.prev;
		node.prev.next = node.next;
		
    	addToTail(node);
    	return node.value;
    }
    
	public void set(int key, int value) {
		if (get(key) != -1) {
			map.get(key).value = value; // Here, talk to interviewer, if we needs update to tail.
			return;
		}
		
		if (map.size() == capacity) {
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}
		
		Node node = new Node(key, value);
		map.put(key, node);
		
		addToTail(node);
    }
	
	private void addToTail(Node node) {
		node.prev = tail.prev;
		tail.prev = node;
		node.prev.next = node;
		node.next = tail;
	}

    
    class Node {
    	int key;
    	int value;
    	Node prev;
    	Node next;
    	
    	public Node(int key, int value) {
    		this.key = key;
    		this.value = value;
    	}
    }
}
