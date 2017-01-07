package com.jiaxin.company.yahoo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1. 2sum
 * 2. combination of phone number
 * 3. reverse words - sentence
 * 4. given continuous data stream , design data structure to return 15 min stock information  -- circular buffer problem 不会
 * 5. hadoop count word frequency
 * 6. external merge sorting
 * 7. What is Np ? -- 不会
 * 
 * @author jeffwan
 * @date May 12, 2014
 */

public class Part1 {
	// 1. Two Sum -- 这里写了HashMap 方法，排序的方法，注意new int[] 一定要用System.arraycopy. 而且最后的result 需要sort一下确保升序
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		if (numbers == null || numbers.length == 0) {
			result[0] = result[1] = -1;
			return result;
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				result[0] = map.get(numbers[i]) + 1;
				result[1] = i + 1;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
		}
		
		return result;
	}
	
	// 2. Combination of phone numbers
	char[][] map = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, 
			{'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
	
	public ArrayList<String> letterCombination(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		if (digits == null || digits.length() == 0) {
			return result;
		}

		helper(result, sb, digits);
		return result;
	}

	public void helper(ArrayList<String> result, StringBuilder sb, String digits) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}

		int index = Character.getNumericValue(digits.charAt(sb.length()));
		for (int i = 0; i < map[index].length; i++) {
			sb.append(map[index][i]);
			helper(result, sb, digits);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	// 3. Reverse Words Test Case:  "" " " " 1" "a b" "a    b"
	// test case: " 1" --> ["", "1"] -> 这样会 "1  " 连加两个space， 最后即便去掉一个，还是"1 ".所以要丢弃""的可能
	public String reverseWords(String s) {
	    if (s == null || s.length() == 0) {
	        return "";
	    }

	    String[] words = s.split(" ");
	    String result = "";
	    
	    for (int i = words.length - 1; i >= 0; i--) {
	        if (!"".contains(words[i])) {
	            result += words[i] + " ";        
	        }
	    }
	    
	    return result.length() == 0 ? result : result.substring(0, result.length() - 1);
	}

	/*
	 * 5. Hadoop,  count word frequency
	 * mapper --> ("a", 1) ("b", 1) ("a", 1) | ("a", 1)  map输出时候是逐步放入内存，需要排序，有一个缓存区
	 * shuffle --> （"a",2) ("b", 1) | ("a", 1)
	 * reducer --> ("a", 2) ("b", 1)
	 * 
	 * map -> partition ->写入内存 -> combiner -> sorted -> 写入磁盘
	 * http://my.oschina.net/leejun2005/blog/82587
	 * http://www.cnblogs.com/editice/archive/2012/05/03/2481282.html Shuffle Partition Combiner 区别
	 */
	
	
	/*
	 * 6. External Sort
	 * Memory 100MB
	 * file chunks could be 100MB.
	 * f1, 100 MB. f2, 100MB. load 50Mb of each into the memory, Buffer 50MB.
	 * 
	 * 1. Write buffer data into disk 2. Retrieve data from the file contribute to the Buffer.
	 */
	
	/*
	 * 7. Np?
	 */
}
