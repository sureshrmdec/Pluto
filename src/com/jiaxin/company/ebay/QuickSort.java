package com.jiaxin.company.ebay;

/**
 * http://www.ardendertat.com/2011/10/27/programming-interview-questions-10-kth-largest-element-in-array/
 * @author jeffwan
 * @date Apr 22, 2014
 */
public class QuickSort {
	public static void main(String[] args) {
		int nums[] = {1,2,3,5,0,1,7,8,9,6,4};
		quicksort(nums, 0, nums.length - 1);
		for (int i : nums) {
			System.out.print(i + ", ");
		}
		
	}
	
	public static void quickSort(int[] nums, int start, int end) {
		int pivotIndex = quickSortHelper(nums, start, end);
		if (pivotIndex > start) {
			quickSort(nums, start, pivotIndex - 1); 
		}
		
		if (pivotIndex < end) {
			quickSort(nums, pivotIndex + 1, end); 
		}
	}

	private static int quickSortHelper(int[] nums, int start, int end) {
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
			
			if (left < right) {
				swap(nums, left, right);
			}
		}
		
		swap(nums, pivot, right); // Important
		return right;
	}
	
	public static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	
	// 别人的 http://blog.csdn.net/cinnamonjester7/article/details/11584899
	public static void quicksort(int[] data, int left, int right) {
		if (left >= right)
			return;
		else {
			int partition = partition(data, left, right);
			quicksort(data, left, partition - 1);
			quicksort(data, partition, right);
		}
	}

	static int partition(int[] data, int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = data[(left + right) / 2];

		while (i <= j) {
			while (data[i] < pivot)
				i++;
			while (data[j] > pivot)
				j--;
			if (i <= j) {
				tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
				i++;
				j--;
			}
		}
		;
		return i;
	}
	
	
}
