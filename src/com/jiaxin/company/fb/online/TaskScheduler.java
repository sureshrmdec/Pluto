package com.jiaxin.company.fb.online;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * Tasks: AABABCD
 * Cooldown Time: 2
 * A__AB_ABCD
 * Output: 10
 * 
 * BAB -> not good but actually is good because AB_AB that's really
 * 
 * @author jiashan
 *
 */

public class TaskScheduler {
	
	public int taskScheduler(String task, int coolDown) {
		int total = 0;
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		char[] tasks = task.toCharArray();
		
		for (int i = 0; i < tasks.length; i++) {
			if (dict.containsKey(tasks[i])) {
				total += i - dict.get(tasks[i]) > 2 ? 1 : 3 - (i - dict.get(tasks[i])) + 1;  
			} else {
				total += 1;
			}
			
			dict.put(tasks[i], total); // update index
		}
		
		return total;
	}
	
	@Test
	public void test() {
		String task = "AABABCD";
		System.out.println(taskScheduler(task, 2));
	}
}
