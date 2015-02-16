package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
// http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
public class Climbstairs {
	// how many solutions/
	int[] sum;
    public int climbStairs(int n) {
        this.sum = new int[n];
		
		for (int i = 0; i < sum.length; i++) {
			sum[i] = Integer.MIN_VALUE;
		}
		
		return search(n - 1);
    }
    
    private int search(int i) {
		if (i == 0) {
			return 1;
		}
		
		if (i == 1) {
			return 2; 
		}
		
		if (sum[i] != Integer.MIN_VALUE) {
			return sum[i];
		}
		
		sum[i] = search(i - 1) + search(i - 2);
		return sum[i];
	}
    
    // claim stair - O(n) + O(1)
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
    
    
    // all solutions
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
		
		System.out.println(climbStairs(10));
		System.out.println(climbStairsSolutions(10).size());
		System.out.println(climbStairsIterative(10));
	}
    
}
