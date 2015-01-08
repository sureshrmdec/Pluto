package com.jiaxin.cc.Moderate;

import java.util.HashMap;

/**
 * 17.9 Design a method to find the frequency of occurrences of any given word in a book
 * 
 * 这题要我直接就上HashMap了，但是Solution里面还做了讨论.
 * 1. 是只访问一次，还是以后还要用, 
 * 		只访问一次就O(n) word by word 计算一下就OK了，(这里其实不是O(n), strStr 要要废时间，但是我们忽略).
 * 		访问多次，用hashTable 统计个数pre processgin，下次就O(1)了，第一次比O(n)还慢, 因为不仅算target，还得管其他的
 * 2. 处理上要注意lowercase这些小细节，The 和the 是一个词，因为情景说了这是书
 * 
 * HashMap Hashtable 区别: 1. concurrency ConcurrentHashMap 用这个解决线程安全 2. Map allows null value
 * 
 * @author jeffwan
 * @date May 24, 2014
 */
public class WordFrequency {
	public static void main(String[] args) {
		String[] book = {"hehe", "haha", "world", "hehe"};
		String target = "world";
		System.out.println(wordFrequency(book, target));
	}
	
	public static int wordFrequency(String[] book, String target) {
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		for (String word : book) {
			word = word.toLowerCase();
			if (table.containsKey(word)) {
				table.put(word, table.get(word) + 1);
			} else {
				table.put(word, 1);
			}
		}
		
		if (table.containsKey(target)) {
			return table.get(target);
		}
	
		return 0;
	}
}
