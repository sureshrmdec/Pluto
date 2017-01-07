package com.jiaxin.company.ebay;

import java.util.Stack;

/**
 * 9.1 给一个表达式，计算返回值，不带括号, "7-12/6" "1000-5*6/3*2+1"
 * 
 * 我自己小结的是，面试碰到：
 * 1.prefix即波兰表达式，用递归最方便（因为操作符和操作数不是一种类型，操作符也没有一种对应的文件类型，所以把操作符push进stack稍微麻烦点）；
 * 2.postfix即逆波兰表达式，用stack最方便（因为总是先碰到操作数，不用push操作符）。
 * 3.infix即中缀表达式，不要求括号的话用longway大侠的方法，要求的话太麻烦了gg
 * 
 * You need to:
 * 1) convert it into post-fix expression by using stack, which will eliminate any brackets ( ).
 * 2) compute result using stack.There are many resources available online about 'Infix to postfix expression' algorithm. 
 * 
 * @author jeffwan
 * @date May 4, 2014
 */
public class Part9 {
	public static void main(String[] args) {
		System.out.println(calculate("1000-5*6/3*2+1"));
	}
		
	// 这种应该算是longway大侠说的方法，因为就两种优先级，先算* /, 用stack维护好，其他都push stack, 最后统一算 * /. 两遍 O(n)
	// 这先留着吧，有个问题, 就是 1000 20 1, operatorStack - + 最后因为是stack，结果变成979 而不是981, 相当于多了括号了，暴力一点的方法肯定可以解决，想想有什么一步到位的
	public static int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<Character> operateStack = new Stack<Character>(); 
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int start = i;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					i++;
				}
				
				numStack.push(Integer.valueOf(s.substring(start, i--)));
			} else {
				// store - +
				if ("-+".contains(String.valueOf(s.charAt(i)))) {
					operateStack.push(s.charAt(i));
					continue;
				} 
				
				if ('*' == s.charAt(i)) {
					int numA = numStack.pop();
					int start = ++i;
					while (i < s.length() && Character.isDigit(s.charAt(i))) {
						i++;
					}
					int numB = Integer.valueOf(s.substring(start, i--));
					numStack.push(numA * numB);
				}
				
				if ('/' == s.charAt(i)) {
					int numA = numStack.pop();
					int start = ++i;
					while (i < s.length() && Character.isDigit(s.charAt(i))) {
						i++;
					}
					int numB = Integer.valueOf(s.substring(start, i--));
					numStack.push(numA / numB);
				}	
			}
		}
	
		// calculate - +, hasError here
		while (!operateStack.isEmpty()) {
			int numA = numStack.pop();
			int numB = numStack.pop();
			char operator = operateStack.pop();
			if (operator == '+') {
				numStack.push(numB + numA);
			}
			
			if (operator == '-') {
				numStack.push(numB - numA);
			}
		}
		
		
		return numStack.peek();
	}
	
	
	// 这个比上面简单很多了，可能一起出follow up leetcode上原题，直接用一个stack就搞搞定了.
	// 查了一下，这个属于后缀表达式，还有中缀和前缀的，这属于一类问题， Leetcode这个题目叫 Evalue Reverse Polish Notation.. 计算逆序波兰表达式，显然我一开始没有认真去理解他
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < tokens.length; i++) {
			if (!"+-*/".contains(tokens[i])) {
				stack.push(Integer.valueOf(tokens[i]));
			} else {
				int numA = stack.pop();
				int numB = stack.pop();
				switch (tokens[i].charAt(0)) {
				case '+':
					stack.push(numB + numA);
					break;
				case '-':
					stack.push(numB - numA);
					break;
				case '*':
					stack.push(numB * numA);
					break;
				case '/':
					stack.push(numB / numA);
					break;
				default:
					break;
				}
			}
		}
		
		return stack.pop();
	}
	
	
}
