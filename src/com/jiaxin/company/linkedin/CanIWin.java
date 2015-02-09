package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CanIWin {
	/* In "the 100 game," two players take turns adding, to a running 
	total, any integer from 1..10. The player who first causes the running 
	total to reach or exceed 100 wins. 
	What if we change the game so that players cannot re-use integers? 
	For example, if two players might take turns drawing from a common pool of numbers 
	of 1..15 without replacement until they reach a total >= 100. This problem is 
	to write a program that determines which player would win with ideal play. 

	Write a procedure, "Boolean canIWin(int maxChoosableInteger, int desiredTotal)", 
	which returns true if the first player to move can force a win with optimal play. 

	Your priority should be programmer efficiency; don't focus on minimizing 
	either space or time complexity.
	
	http://blog.csdn.net/lsdtc1225/article/details/40342473
	http://www.mitbbs.com/article_t/JobHunting/32861097.html
	http://codeanytime.blogspot.com/2015_01_01_archive.html
	
	duplicate.
	target % (maxchoose + 1) == 0  player2 must win
	if not.  play1 1.get target %(maxchoose + 1). 2.get maxChoose + 1 -play2Num. and get target
	
	*/ 

	// Boolean canIWin(int maxChoosableInteger, int desiredTotal); 
	// Implementation here. Write yours 

	
	// Permutation. find one result that we select one number, and no matter what his choose make use win. 
	// like {1,2,3} 5 => we select 1. no matter 123 or 132. we win.
	enum Result {Win, Lost, Draw}
	public boolean canIWin(int max, int target) throws Exception {
		List<Integer> candidates = new ArrayList<Integer>();
		for (int i = 1; i <= max; i++) {
			candidates.add(i);
		}

		// handle draw
		if (getSum(candidates) < target) {
			throw new Exception("result is draw"); // better to use Enum here
		}
		
		return helper(candidates,target); 
	}

	private boolean helper(List<Integer> candidates, int target) {
		if (target <= 0) {
			return false;
		}
		
		for (int i = 0; i < candidates.size(); i++) {
			int removed = candidates.remove(i);
			if (!helper(candidates, target - removed)) {
				candidates.add(i, removed);
				return true;
			}
			
			candidates.add(i, removed);
		}
		
		return false;
	}
	
	private int getSum(List<Integer> candidates) {
		int sum = 0;
		for (int candidate : candidates) {
			sum += candidate;
		}
		return sum;
	}
	
	
	@Test
	public void test() throws Exception {
		System.out.println(canIWin(3, 4));
	}
	
}
