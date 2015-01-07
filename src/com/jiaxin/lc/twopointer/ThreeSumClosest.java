package com.jiaxin.lc.twopointer;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int closest = Integer.MAX_VALUE / 2;
		
		for (int i = 0; i < num.length - 1; i ++) {
			int left = i + 1;
			int right = num.length - 1;
			
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				
				if (sum == target) {
					return sum;
				} 
				
				if (sum < target) {
					left++;
				} else {
					right--;
				}
				
				closest = Math.abs(closest - target) > Math.abs(sum - target) ? closest : sum;
			}
		}
		
		return closest;
    }
}
