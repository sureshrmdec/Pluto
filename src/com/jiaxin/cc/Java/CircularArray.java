package com.jiaxin.cc.Java;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
	private T[] items;
	private int head;
	
	public CircularArray(int size) {
		items  = (T[]) new Object[size];
	}
	
	private int convert(int index) {
		if (index < 0) {
			index += items.length;
		}
		return (head + index) % items.length;
	}
	
	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}
	
	public T get(int i) {
		if (i < 0 | i > items.length) {
			throw new IndexOutOfBoundsException("input is not valid");
		}
		
		return items[convert(i)]; 
	}

	public void set(int i, T item) {
		items[convert(i)] = item;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIteractor<T>(this);
	}
	
	private class CircularArrayIteractor<T> implements Iterator<T> {
		private int _current = -1;
		private T[] _items;
		
		public CircularArrayIteractor(CircularArray<T> array) {
			_items = array.items;
		}

		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}

		@Override
		public T next() {
			_current++;
			T item = _items[convert(_current)];
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("not supported");
		}
	}
	
}



