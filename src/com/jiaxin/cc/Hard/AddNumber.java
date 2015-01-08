package com.jiaxin.cc.Hard;

/**
 * 18.1 Write a function that adds two number. You should not use + or any arithmetic operators.
 * 算数运算符不能用，肯定是bit operation
 * 
 * 759 + 674
 * 1. 算sum, 不算carry, 就是323, XOR
 * 2. 只算carry, 1110.shift 1位
 * 3. combine 1110 + 323.
 * @author jeffwan
 * @date May 24, 2014
 */
public class AddNumber {
	public static void main(String[] args) {
		System.out.println(add(759, 674));
	}
	
	public static int add(int a , int b) {
		if (b == 0) {
			return a;
		}
		
		int sum = a ^ b;
		int carry = (a & b) << 1;
		System.out.println("sum: " + sum + " carry: " + carry);
		return add(sum, carry);	
	}
}
