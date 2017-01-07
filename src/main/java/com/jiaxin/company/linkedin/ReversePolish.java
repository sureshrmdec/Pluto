package com.jiaxin.company.linkedin;

import java.util.Stack;

/** Compute the value of an expression in Reverse Polish Notation. Supported operators are "+", "-", "*" and "/". 
* Reverse Polish is a postfix mathematical notation in which each operator immediately follows its operands. 
* Each operand may be a number or another expression. 
* For example, 3 + 4 in Reverse Polish is 3 4 + and 2 * (4 + 1) would be written as 4 1 + 2 * or 2 4 1 + * 
* 
* @param ops a sequence of numbers and operators, in Reverse Polish Notation 
* @return the result of the computation 
* @throws IllegalArgumentException ops don't represent a well-formed RPN expression 
* @throws ArithmeticException the computation generates an arithmetic error, such as dividing by zero 
* 
* <p>Some sample ops and their results: 
* ["4", "1", "+", "2.5", "*"] -> ((4 + 1) * 2.5) -> 12.5 
* ["5", "80", "40", "/", "+"] -> (5 + (80 / 40)) -> 7 
*/


public class ReversePolish {
	public int reversePolish(String[] params) {
		if (params == null || params.length == 0) {
			throw new IllegalArgumentException("params are not valid");
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (String param : params) {
			if (!"+-*/".contains(param)) {
				stack.push(Integer.parseInt(param));
			} 
			
			int b = stack.pop();
			int a = stack.pop();
			
			switch (param.charAt(0)) {
				case '+':
					stack.push(a + b);
					break;
				case '-':
					stack.push(a - b);
					break;
				case '*':
					stack.push(a * b);
					break;
				case '/':
					if (b == 0) {
						throw new ArithmeticException("can't be zero");
					}
					
					stack.push(a / b);
					break;
				default:
					throw new IllegalArgumentException("not well formed RPN");
			}
		}
		
		return stack.pop();
	}

	
}
