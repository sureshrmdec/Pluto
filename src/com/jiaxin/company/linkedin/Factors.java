package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author jiashan
 * 
 * input 12
 * ----------
 * 2*2*3
 * 3*4
 * 2*6
 * 1*12
 * 
 */
public class Factors {
	public void printFactors(int num) {
		List<Integer> factors = new ArrayList<Integer>();
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> combo = new ArrayList<Integer>();
		
		helper(result, combo, factors, num, 0);
		System.out.println("1*" + num);
	}

	private void helper(List<List<Integer>> result, List<Integer> combo,
			List<Integer> factors, Integer num, int position) {
		if (getProduct(combo) == num) {
			printProduct(combo);
			return;
		}
		
		if (getProduct(combo) > num) {
			return;
		}
		
		for (int i = position; i < factors.size(); i++) {
			combo.add(factors.get(i));
			helper(result, combo, factors, num, i);
			combo.remove(combo.size() - 1);
		}
		
	}

	private void printProduct(List<Integer> combo) {
		String result = "";
		for (int factor : combo) {
			result += String.valueOf(factor) + "*";
		}
		
		System.out.println(result.substring(0, result.length() - 1));
	}

	private Integer getProduct(List<Integer> combo) {
		int product = 1;
		for (int factor : combo) {
			product *= factor;
		}
		
		return product;
	}
	
	/****************************************************************************************************/
	public void printFactorsRecursive2(int number) {
	    printFactors("", number, number);
	}

	public void printFactors(String expression, int dividend, int previous) {
	    if(expression == "")
	        System.out.println(previous + " * 1");

	    for (int factor = dividend - 1; factor >= 2; --factor) {
	        if (dividend % factor == 0 && factor <= previous) {
	            int next = dividend / factor;
	            if (next <= factor && next <= previous) {
	            	System.out.println(expression + factor + " * " + next);
	            }
	            
	            printFactors(expression + factor + " * ", next, factor);
	        }
	    }
	}
	
	
	
	
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void test2() {
		String filename = "/Users/jiashan/Downloads/TextFile.java";
		
		Iterator iterator = new TextFile(filename).iterator();
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
	}
}
