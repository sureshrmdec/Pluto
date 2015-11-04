package com.jiaxin.company.fb.online;

import java.util.Stack;

import org.junit.Test;


public class PrefixPression {

	public int prefixPression(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = tokens.length - 1; i >= 0; i--) {
			String c = tokens[i];
			if (!"+-*/".contains(String.valueOf(c))) {
				stack.push(Integer.parseInt(c)); 
			} else {
				int numA = stack.pop();
				int numB = stack.pop();
				
				int result= compute(c, numA, numB);
				stack.push(result);
			}
		}
		
		return stack.pop();
	}

	private int compute(String c, int numA, int numB) {
		int result = 0;
		switch (c) {
		case "+":
			result = numA + numB;
			break;
		case "-":
			result = numA - numB;
			break;
		case "*":
			result = numA * numB;
			break;
		case "/":
			result = numA / numB;
			break;
		}
		
		return result;
	}
	
	
	@Test
	public void test() {
		String[] tokens = new String[15];
		tokens[0] = "-";
		tokens[1] = "*";
		tokens[2] = "/";
		tokens[3] = "15";
		tokens[4] = "-";
		tokens[5] = "7";
		tokens[6] = "+";
		tokens[7] = "1";
		tokens[8] = "1";
		tokens[9] = "3";
		tokens[10] = "+";
		tokens[11] = "2";
		tokens[12] = "+";
		tokens[13] = "1";
		tokens[14] = "1";
		System.out.println(prefixPression(tokens));
	}
}
