package com.jiaxin.company.fb.careercup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Theft steel money from house. but he can't steel house next to each other. 
 * Question: Find maximum money he can steel. 
 * 
 * Follow up: detail steel plan 
 * 
 * http://www.amoduo.com/article/view/1003747.html
 * http://www.quora.com/What-are-the-top-10-most-popular-dynamic-programming-problems-among-interviewers
 * 
 * money[i] till i. = maxValue with stealon. or not stealon. 
 * 
 * There are n houses built in a line, each of which contains some value in it. 
 * A thief is going to steal the maximal value in these houses, but he cannot steal in two adjacent houses 
 * because the owner of a stolen house will tell his two neighbors on the left and right side. 
 * What is the maximal stolen value?
 * 
 * @author jiashan
 *
 */
public class TheftNotContinuous {
	
	public int stealMoney(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int[] money = new int[A.length];
		money[0] = A[0];
		if (A.length == 1) {
			return money[0];
		}
		
		money[1] = Math.max(A[0], A[1]);
		if (A.length == 2) {
			return money[1];
		}
		
		// Could save memory to O(1) with using array. Like fibonacci
		for (int i = 2; i < A.length; i++) {
			money[i] = Math.max(money[i - 1], money[i - 2] + A[i]);
		}
		
		return money[A.length - 1];
	}
	
	public List<Integer> stealMoneyPath(int[] A) {
		List<Integer> path = new ArrayList<Integer>();
		
		if (A == null || A.length == 0) {
			return path;
		}
		
		int[] money = new int[A.length];
		money[0] = A[0];
		path.add(A[0]);
		
		money[1] = Math.max(A[0], A[1]);
		path.add(A[1]);
		
		// Could save memory to O(1) with using array. Like fibonacci
		for (int i = 2; i < A.length; i++) {

			if (money[i - 2] + A[i] > money[i - 1]) {
				money[i] = money[i - 2] + A[i];
				path.add(A[i]);
				path.remove(path.size() - 1);
			} else {
				money[i] = money[i - 1];
			}
		}
		
		System.out.println("max stolen: " + money[A.length - 1]);
		return path;
	}
	
	@Test
	public void test() {
		int[] A = {4,6,7,1,2,9,12};
		System.out.println(stealMoney(A));
		System.out.println(stealMoneyPath(A));
	}
	
}
