package com.diorsding.advance.followup;

/**
 * Quick Select
 * We select start as pivot. We need to compare k & current sequence. 
 * Every time throw (start, pivot position) or (pivot position, end)
 * 
 * Time Complexity O(n)
 * 
 * Quick Sort
 * 
 * 
 * Nuts & Blots Problem.
 * http://www.lintcode.com/en/problem/nuts-bolts-problem/
 * 
 * 
 * 
 * @author jiashan
 *
 */
public class QuickSelect {

	public int quickSelect(int[] nums, int start, int end, int k) {
		int pivot = start;
		int left = start;
		int right = end;
		
		while (left <= right) {
			while (left <= right && nums[left] <= nums[pivot]) {
				left++;
			}
			
			while (left <= right && nums[right] >= nums[pivot]) {
				right--;
			}
 			
			swap(nums, left, right);
		}
		
		if (k == right + 1) {
			return nums[right];
		} else if (k > right + 1) {
			return quickSelect(nums, right + 1, end, k);
		} else {
			return quickSelect(nums, start, right - 1, k);
		}
	}
	
	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public int quickSort(int[] A) {
		
		
		return 0;
	}
	
	
	public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
    }
	
	public class NBComparator {
		public int cmp(String a, String b) {
			return 0;
		}
	}
	
}
