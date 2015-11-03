package com.jiaxin.company.twosigma;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * 
 * https://en.wikipedia.org/wiki/Fibonacci_coding
 * @author jiashan
 *
 */
public class FibbonacciCoding {

	public String encode(int n) {
		if (n < 1) {
			return "";
		}
		
		// find useful fibbonacci
		List<Integer> fib = new ArrayList<Integer>();
		
		int a = 1;
		int b = 1;
		fib.add(b);
		while (b <= n) {  // must go to next round. 
			int c = a + b;
			a = b;
			b = c;
			fib.add(c);
		}
		
		fib.remove(fib.size() - 1); // remove last large one.
		int[] digit = new int[fib.size()]; 
		digit[digit.length - 1] = 1;
		
		n -= a;
		for (int i = fib.size() - 1; i >= 0; i--) {  // for loop will make sure n = 0 finally.
			if (n >= fib.get(i)) {
				n -= fib.get(i);
				digit[i] = 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : digit) {
			sb.append(i);
		}
		sb.append(1); // append extra 1. 
		
		return sb.toString();
	}
	
	@Test
	public void test() {
		System.out.println("1: " + encode(1));
		System.out.println("2: " + encode(2));
		System.out.println("3: " + encode(3));
		System.out.println("4: " + encode(4));
		System.out.println("5: " + encode(5));
		System.out.println("6: " + encode(6));
		System.out.println("7: " + encode(7));
		System.out.println("8: " + encode(8));
		System.out.println("9: " + encode(9));
		System.out.println("10: " + encode(10));
		System.out.println("11: " + encode(11));
		System.out.println("12: " + encode(12));
		System.out.println("13: " + encode(13));
		System.out.println("14: " + encode(14));

	}
	
}
