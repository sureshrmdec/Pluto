package com.jiaxin.cc.Hard;

public class RandomGenerateNums {
	public int[] pickMRandom(int[] original, int m) {
		if (original == null || original.length == 0) {
			return null;
		}
		
		int[] result = new int[original.length];
		int[] nums = original.clone();
		
		for (int i = 0; i < m; i++) {
			int index = rand(i, nums.length);
			result[i] = nums[index];
			nums[index] = nums[i];
		}
		
		return result;
	}

	private int rand(int lower, int higher) {
		return lower + (int)((higher - lower + 1) * Math.random());
	}
}
