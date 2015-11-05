package com.diorsding.advance.twopointer;

/**
 * http://www.lintcode.com/en/problem/partition-array/
 * 
 * Solution: same as sort colors
 * Take care position. 
 * 
 * 
 * http://www.lintcode.com/en/problem/partition-array-by-odd-and-even/
 * Given [1, 2, 3, 4], return [1, 3, 2, 4] 
 * Challenge: Do it in-place.
 * 
 * 
 * http://www.lintcode.com/en/problem/sort-letters-by-case/
 * Challenge: Do it in one-pass and in-place.
 * 
 * 
 * @author jiashan
 *
 */
public class PartitionArray {

    public int partitionArray(int[] nums, int k) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
		
    	int rightIndex = nums.length - 1;
    	int i = 0;
    	
    	while (i <= rightIndex) {
    		if (nums[i] >= k) {
    			int temp = nums[rightIndex];
    			nums[rightIndex] = nums[i];
    			nums[i] = temp;
    			
    			rightIndex--;
    		} else {
    			i++;
    		}
    	}
    		
    	return i;
    }
    
    
    public void partitionArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		int rightIndex = nums.length - 1; 
		int i = 0;
		
		while (i <= rightIndex) {
			if (nums[i] % 2 == 0) {
				int temp = nums[rightIndex]; 
				nums[rightIndex] = nums[i];
				nums[i] = temp;
				
				rightIndex--;
			} else {
				i++;
			}
		}
    }
    
    
    public void sortLetters(char[] chars) {
		if (chars == null || chars.length == 0) {
			return;
		}
		
		int i = 0;
		int rightIndex = chars.length - 1;
		
		while (i <= rightIndex) {
			if (chars[i] >= 'A' && chars[i] <= 'Z') {
				char temp = chars[rightIndex]; 
				chars[rightIndex] = chars[i];
				chars[i] = temp;
				
				rightIndex--;
			} else {
				i++;
			}
		}
    }
    
}
