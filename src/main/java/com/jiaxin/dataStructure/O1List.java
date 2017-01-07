package com.jiaxin.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author jiashan
 *
 *题是设计一个data structrue, 要求O(1) add, search, random remove。
 *这题答得也不好，不过国人大哥提醒了好多，最后也算是答出来了，用一个hashmap和array即可
 *http://stackoverflow.com/questions/5682218/data-structure-insert-remove-contains-get-random-element-all-at-o1
 *
 * Implement a data structure similar to LinkedList. Need to have the following function.
 * 1. void add(T t) 2. T get(int index) 3. int size() 4. void remove(T t)
 * add 必须o1, 用hashMap + linked list
 *
 *
 * @param <T>
 */
public class O1List<T> {
	public static final int INITIAL_CAPACITY = 6;
	private T[] data = (T[]) new Object[INITIAL_CAPACITY];
	private Map<T, Integer> map = new HashMap<T, Integer>();
	protected int size = 0;
	
	void add(T t) {
		ensureCapacity();
		
		data[size] = t;
		map.put(t, size);
		size++;
	}
	
	void remove(T t) {
		if (!map.containsKey(t)) {
			return;
		}
		
		int index = map.get(t);
		data[index] = data[size - 1];
		map.put(data[index], index);
		size--;
	}
	
	T random() {
		int index = (int)(Math.random() * size);
		return data[index];
	}
	
	boolean contains(T t) {
		return map.containsKey(t);
	} 
	
	int size() {
		return size;
	}
	
	private void ensureCapacity() {
        if (size >= data.length) {
            T[] newData = (T[]) new Object[size * 2 + 1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
	
	
}
