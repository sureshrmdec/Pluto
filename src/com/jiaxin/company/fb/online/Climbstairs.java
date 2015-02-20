package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
 

/**
 * 1. All solutions(steps)
 * 2. Print all solutions, no need to return. 
 * 3. How many solutions. - Recursive | Iterative  O(n) + O(1)
 * 4. How many solutions. log(n)
 * 
 * fn+1 = 1 1 ^n-1 * f1
 * fn     1 0  	     f0
 * --> use pow to calculate n
 * 
 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * http://www.cnblogs.com/kedebug/archive/2012/11/28/2792333.html
 * http://www.gocalf.com/blog/calc-fibonacci.html
 * 
 * @author jiashan
 *
 */
public class Climbstairs {
	// DP + memory
	int[] sum;
    public int climbStairs(int n) {
        if (n <= 0) {
        	return 0;
        }
    	
    	this.sum = new int[n + 1];
		
		return search(n);
    }
    
    private int search(int i) {
		if (i == 1) {
			return 1;
		}
		
		if (i == 2) {
			return 2; 
		}
		
		if (sum[i] != 0) {
			return sum[i];
		}
		
		sum[i] = search(i - 1) + search(i - 2);
		return sum[i];
	}
    
    // claim stair - O(n) + O(1) space. Better than recursive
    public int climbStairsIterative(int n) {
    	int first = 1;
		int second = 2;
		
    	if (n == 1) {
			return first;
		}
		
		if (n == 2) {
			return second;
		}
		
		
		int step = 0;
		for (int i = 3; i <= n; i++) {
			step = first + second;
			first = second;
			second = step;
		}
    	
    	return step;
    }
    
    
    
    
    // all solutions - save result space but still need O(n);
    public List<List<Integer>> climbStairsSolutions(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
        
		search(result, list, n);
		
		return result;
    }

	private void search(List<List<Integer>> result, List<Integer> list, int i) {
		if (i == 0) {
			result.add(new ArrayList(list));
			return;
		}
		
		if (i < 0) {
			return;
		}
		
		list.add(1);
		search(result, list, i - 1);
		list.remove(list.size() - 1);
		
		list.add(2);
		search(result, list, i - 2);
		list.remove(list.size() - 1);
	}
    
	@Test
	public void test() {
		System.out.println(climbStairs(5));
		System.out.println(climbStairsIterative(5));
		System.out.println(climbStairsSolutions(5).size());
		System.out.println(climbStairsSolutions(5));
	}
    
}
