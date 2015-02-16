package com.jiaxin.lc.hard;

import org.junit.Test;

public class PermutationSequence {
	
	public String getPermutation(int n, int k) {
		int[] num = new int[n];
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}
		
		for (int l = 0; l < k - 1; l++) {
			int i = num.length - 2;
			
			while (i >= 0 && num[i] >= num[i + 1]) {
				i--;
			}
			
			if (i >= 0) {
				int j = i + 1; 
				while (j < num.length && num[j] > num[i]) {
					j++;
				}
				j--;
				
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
			
			reverse(num, i + 1);
		}
		
		String result = "";
		for(int i: num) {
			result += i;
		}
		
		return result;
	}
	
	private void reverse(int[] num, int start) {
		int end = num.length - 1;
		
		while (start < end) {
			int temp = num[start];
			num[start] = num[end];
			num[end] = temp;
			start++;
			end--;
		}
    }
	
	@Test
	public void test() {
		System.out.println(getPermutation(3, 6));
	}
}
