package com.jiaxin.company.linkedin;

import java.util.PriorityQueue;

import org.junit.Test;

public class ReplaceString {
	char[] value;
	
	//http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html KMP

	public String replace(char oldChar, char newChar) {
		if (oldChar != newChar) {
			int len = value.length;
			int i = -1;
			char[] val = value; /* avoid getfield opcode */

			while (++i < len) {
				if (val[i] == oldChar) {
					break;
				}
			}
			if (i < len) {
				char buf[] = new char[len];
				for (int j = 0; j < i; j++) {
					buf[j] = val[j];
				}
				while (i < len) {
					char c = val[i];
					buf[i] = (c == oldChar) ? newChar : c;
					i++;
				}
				
			}
		}
		return new String(value);
	}
	
	@Test
	public void test() {
		System.out.println("apples".replace("pp", "bb"));
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		heap.add(1);
		heap.add(1);
		
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}
}
