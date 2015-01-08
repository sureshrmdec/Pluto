package com.jiaxin.company.simple;

public class GcdTwoNumber {
	public static void main(String[] args) {
//		System.out.println(gcd(45, 75));
		max(1.5, 2);
	}
	
	public static int gcd(int num1, int num2) {
		int gcd = 1;
		
		for (int k = 2; k <= num1 && k < num2; k++) {
			if (num1 % k == 0 && num2 % k == 0) {
				gcd = k;
			}
		}
		
		return gcd;
	}
	
	public static void max(int x, int y) {
		System.out.println(x + y);
	}
	
	private static int max(double x, int y) {
		System.out.println(x + y);
		return (int) (x+y);
	}
}
