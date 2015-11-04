package com.jiaxin.dataStructure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Improvement: when hit capacity, doube size. 
public class ResourcePool {
	Queue<Connection> available;
	Set<Connection> used;
	int capacity;
	
	public ResourcePool(int capacity) {
		this.capacity = capacity;
		available = new LinkedList<Connection>();
		used = new HashSet<Connection>();
		
		// add some conn(capacity) into queue.
	}
	
	public Object obtain() {
		// we could ensureCapacity here.
		if (used.size() == capacity) {
			return null; // should wait for realse? 
		}
		
		Connection conn = available.poll();
		used.add(conn);
		
		return conn;		
	}
	
	public void release(Connection conn) {
		used.remove(conn);
		available.offer(conn);
	}
	
	class Connection {
		
	}
}
