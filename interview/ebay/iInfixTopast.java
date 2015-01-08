package interview.ebay;

import java.util.ArrayList;
import java.util.Stack;

public class iInfixTopast {
	public static void main(String[] args) {
		System.out.println(infixToPos("1000-5*6/3*2+1"));
	}
	
	public static int calculate(String infix) {
		ArrayList<String> posfix = infixToPos(infix);
		int result = evalRPN(posfix);
		return result;
	}
	
	public static ArrayList<String> infixToPos(String infix) {
		Stack<Character> stack = new Stack<Character>();
		ArrayList<String> pos = new ArrayList<String>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			// digits
//			if (c != '+' && c != '-' && c != '*' && c != '/') {
			if (!"+-*/".contains(String.valueOf(c))) {
				int start = i; 
				while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
					i++;
				}
				pos.add(infix.substring(start, i--));
				
			} else if (stack.empty()) {
				
				stack.push(c);
				
			} else {
				if (c == '*' || c == '/') {
					System.out.println("Peek" + stack.peek());
					while (stack.peek() == '*' || stack.peek() == '/') {
						if (!stack.isEmpty()) {
							pos.add(stack.pop() + "");
						}
					}
					stack.push(c);
				} else {
					while (!stack.isEmpty()) {
						pos.add(stack.pop() + "");
					}
					stack.push(c);
				}
			}
		}

		while (!stack.empty()) {
			pos.add(stack.pop() + "");
		}

		return pos;
	}
	
	
	public static int evalRPN(ArrayList<String> tokens) {
		if (tokens == null || tokens.size() == 0) {
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		String operators = "+-*/";
		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(Integer.parseInt(token));
				continue;
			} 
			
			int a = stack.pop();
			int b = stack.pop();
			switch(token.charAt(0)) {
				case '+':
					stack.push(b + a);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '*':
					stack.push(b * a);
					break;
				case '/':
					stack.push(b / a);
					break;
			}
		}
		return stack.pop();	
	}
	
}
