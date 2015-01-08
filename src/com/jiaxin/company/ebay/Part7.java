package com.jiaxin.company.ebay;

import java.util.Arrays;

/**
 * 7.1 实现一个简化版的boggle game，给定一个dictionary，我用dfs做的
 * 7.2 给一个int array, 不用division,replace each element with the multiplication of all elements other than that element
 * 7.3 给一个method char[] read(int n)，读入n个字符，输出到数组中，让实现一个String readline()，字符流以null结尾
 * 7.4 实现method: int getNthPrime(int n)，找出第n个质数，n从0开始，这题没打好，想错了，用了sieve of eratosthenes.
 * @author jeffwan
 * @date May 4, 2014
 */
public class Part7 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		System.out.println(Arrays.toString(replaceElment(nums)));
		System.out.println(getNthPrime(3));
	}
	
	
	// 7.1 实现一个简化版的boggle game，给定一个dictionary，我用dfs做的
	
	/*
	 *  7.2 是否需要in-place，inplace应该是没法做的，必须要额外空间，要不之前数据都丢失了.
	 *  如果对于每一位做乘法，Time Complexity is O(n^2). 小心define是0, 如果直接 *= 就都是0了，需要判断第一次
	 */
	
	public static int[] replaceElment(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i< result.length; i++) {
			result[i] = Integer.MIN_VALUE;
		}
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				if (j == i) {
					continue;
				}
				if (result[i] == Integer.MIN_VALUE) {
					result[i] = nums[j];	
				} else {
					result[i] *= nums[j];
				}
			}
		}
		
		return result;
	}
	
	
	// 7.3
	
	// 7.4 找第N个素数，是从2 开始找素数？ 2，3，5, 7, 11, 13 就这么找？ 从0开始是指第0个素数？
	// 这题到底考什么呢？http://stackoverflow.com/questions/14742509/find-nth-prime-number 是Sieve方法么？ 用sieve做
	public static int getNthPrime(int n) {
		int count = 0;
		
		int i;
		for (i = 2; i < Integer.MAX_VALUE; i++) {
			if (isPrime(i)) {
				count++;
			} 
			
			if (count == n) {
				break;
			}
		}
		
		return i;
	}


	private static boolean isPrime(int n) {
		for(int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
	
}
