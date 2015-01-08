package com.jiaxin.company.simple;

import java.util.ArrayList;

public class Primes {
	public static void main(String[] args) {
		System.out.println(printPrimes(20));
	}
	
	public static ArrayList<Integer> printPrimes(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) {
				result.add(i);
			}
		}
		
		return result;
	}
	
	public static boolean isPrime(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
