package com.jiaxin.company.fb.careercup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * http://www.sjsjw.com/kf_code/article/38_6987_6902.asp
 * http://www.icrany.com/533.html  this is better
 * @author jiashan
 *
 */
public class CoinDPandCombinationSum {
	// 1. Coin DP
	
	// 2. Combination Sum - Recursive
	public List<List<Integer>> combinationSum(int[] num, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> list = new ArrayList<Integer>();
	    Arrays.sort(num);

	    if (num == null || num.length == 0) {
	        return result;
	    }
	    
	    helper(result, list, num, target, 0);
	    
	    return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> list, int[] num, int target, int position) {
	    int sum = getSum(list);
	    
	    if (sum == target) {
	        result.add(new ArrayList<Integer>(list));
	        return;
	    }
	    
	    if (sum > target) {
	        return;
	    }
	    
	    for (int i = position; i < num.length; i++) {
	        list.add(num[i]);
	        helper(result, list, num, target, i);
	        list.remove(list.size() - 1);
	    }
	}

	// Better to use target - num, do not need to calculate again. 
	public int getSum(List<Integer> list) {
	    int sum = 0;
	    for (int i = 0; i < list.size(); i++) {
	        sum += list.get(i);
	    }
	    return sum;
	}
		
	@Test
	public void test() {
		int[] num = {2,3,7};
		System.out.println(combinationSum(num, 10));
	}
}
