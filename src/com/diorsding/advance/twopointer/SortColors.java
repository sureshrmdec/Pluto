package com.diorsding.advance.twopointer;

/**
 * http://www.lintcode.com/en/problem/sort-colors/
 * 
 * Naive Solution: Counting sort. Two Pass.
 * Solution: Two Pointer.  One-Pass. + O(1) space. 
 * 
 * Follow up: 
 * http://www.lintcode.com/en/problem/sort-colors-ii/ II.
 * Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
 * 
 * Naive: Counting Sort. O(k) memory.
 * Solution:  Do not use extra memory.
 *  
 * @author jiashan
 *
 */

public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int redIndex = 0;
		int blueIndex = nums.length - 1;
		int i = 0;
		
		while (i <= blueIndex) {
			if (nums[i] == 0) {
				int temp = nums[redIndex];
				nums[redIndex] = nums[i]; 
				nums[i] = temp; 
				
				redIndex++;
				i++;  // must swap with 0. so need increase 1.
			} else if (nums[i] == 2) {
				int temp = nums[blueIndex];
				nums[blueIndex] = nums[i]; 
				nums[i] = temp; 
				
				blueIndex--;
			} else {
				i++;
			}
		}
    }
	
	
	
	public void sortColors2(int[] colors, int k) {
        // write your code here
    }
	
	
}
