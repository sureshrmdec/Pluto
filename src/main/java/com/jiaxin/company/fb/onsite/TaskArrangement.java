package com.jiaxin.company.fb.onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

/**
 * DAG
 * http://www.cnblogs.com/skywang12345/p/3711494.html
 * 
 * 
 * @author jiashan
 *
 */
public class TaskArrangement {
	
	public List<Task> rightOrder(List<Task> tasks) {
		List<Task> result = new ArrayList<Task>();
		if (tasks == null || tasks.size() == 0) {
			return result;
		}
		
		helper(result, tasks);
		
		return result;		
	}
	
	
	private void helper(List<Task> result, List<Task> tasks) {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).dependencies.size() != 0) {
				helper(result, tasks.get(i).dependencies);
			} 
			
			if (!result.contains(tasks.get(i))) {
				result.add(tasks.get(i));
			}
		}
	}

    public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n, int[] result) {
    	Map<Integer, List<Integer>> dict = new HashMap<Integer, List<Integer>>();
    	int[] indegree = new int[n + 1];
    	
    	for (Map.Entry<Integer, List<Integer>> entry : deps.entrySet()) {
    		int jobId = entry.getKey();
    		
    		for (int id : entry.getValue()) {
    			if (!dict.containsKey(id)) dict.put(id, new ArrayList<Integer>());
    			dict.get(id).add(jobId);
    			indegree[jobId]++;
    		}
    	}
    	
    	// reason use stack is because it could follow the path. list also works 
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i <= n; i++) {
    		if (indegree[i] == 0) stack.push(i);
    	}
    	
    	for (int i = 0; i < n; i++) {
    		// if there's valid sequence, sequence length is n, every loop should have a task. 
    		if (stack.isEmpty()) {
    			return false;
    		}
    		
    		int id = stack.pop(); 
    		result[i] = id;
    		
    		if (dict.containsKey(id)) {
    			for (int jobId : dict.get(id)) {
    				indegree[jobId] --; 
    				if (indegree[jobId] == 0) {
    					stack.push(jobId);
    				}
    			}
    		}
    		
    	}
    	
    	return true;
    }
	

	@Test
	public void test() {
		Task task1 = new Task(1);
		Task task2 = new Task(2);
		Task task3 = new Task(3);
		Task task4 = new Task(4);
		
		
		task1.dependencies.add(task4);
		task2.dependencies.add(task3);
		task3.dependencies.add(task4);
		
		List<Task> tasks = new ArrayList<TaskArrangement.Task>();
		tasks.add(task1); tasks.add(task2); tasks.add(task3); tasks.add(task4);
		
		System.out.println(tasks);
		System.out.println(rightOrder(tasks));
		
		
	}
	
	class Task {
		int taskId;
		List<Task> dependencies;
		
		Task(int taskId) {
			this.taskId = taskId;
			dependencies = new ArrayList<Task>();
		}

		@Override
		public String toString() {
			return "Task [taskId=" + taskId + "]";
		}
	}
}
