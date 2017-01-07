package com.jiaxin.company.fb.careercup;

import org.junit.Test;

/**
 * Input: A string equation that contains numbers, '+' and '*'
 * Output: Result as int.
 * 
 * For example:
 * Input: 3*5+8 (as String)
 * Output: 23 (as int)
 * 
 * ------------------------------------------------------------
 * Only contains positive number, +, - , * (what if negative number allows?)
 * 
 * 
 * case: negative number 1+2 *3+-2+4+5 *6+7-1
 * 
 * Wrong: 
 * preNum * helper(nextNum, expression). we need to care priority of * 
 * preNum - helper(nextNum, expression);  here. will - all of rest, like with - ()
 *  
 * helper(preNum * nextNum, expression) 
 * preNum + helper((-1) * nextNum, expression);
 * 
 * ----------------------------------------------------------------
 * 2X + y = 1
 * 
 * @author jiashan
 *
 */
public class Formula {
	int i;
	
	public int evaluate(String expression) {
		i = 0;
		int firstNum = getNumber(expression);
		
		return helper(firstNum, expression);		
	}

	private int helper(int preNum, String expression) {
		if (i == expression.length()) {
			return preNum;
		}
		
		char operator = expression.charAt(i++);
		
		int nextNum = getNumber(expression);
		
		switch (operator) {
		case '+':
			return preNum + helper(nextNum, expression);
		case '-':
			return preNum + helper((-1) * nextNum, expression);
		case '*':
			return helper(preNum * nextNum, expression);  // take care.
		case '/':
			return helper(preNum / nextNum, expression);
		default:
			throw new IllegalArgumentException("character is not valid");
		}
		
	}

	private int getNumber(String expression) {
		int num = 0;
		
		while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
			num = num * 10 + (expression.charAt(i) - '0');
			i++;
		}
		
		return num;
	}
	
	@Test
	public void test() {
		String expression = "7+3*4*5+2+4-3-1";
		System.out.println(evaluate(expression));
	}
}
