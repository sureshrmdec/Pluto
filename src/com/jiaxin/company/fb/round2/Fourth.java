package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Android, skip
 * 
 * Phone: 
 * 1. in-place palindrome
 * 2. 3sum 
 * 3. Add Binary
 * 
 * Onsite: 
 * 1. Design a smooth scrolling newsfeed / http downloader (Pirate)
 * 2. Serialize / Deserialize a binary tree (Ninja)
 * 3. Anagram bucket (Jedi)
 */
public class Fourth {

	// 1. in-place palindrome. LC: Valid Palindrome
	public static boolean isPalindrome(String s) {
		if ( s == null) {
			return false;
		}
		
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			char head = Character.toLowerCase(s.charAt(left));
			char rear = Character.toLowerCase(s.charAt(right));
			
			if (!Character.isLetterOrDigit(head)) {
				left++;
				continue;
			}
			
			if (!Character.isLetterOrDigit(rear)) {
				right--;
				continue;
			}
			
			if (head != rear) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	// 2. 3sum
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (num == null || num.length == 0) {
			return result;
		}
		
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			
			int start = i + 1;
			int end = num.length - 1;
			
			while (start < end) {
				int sum = num[start] + num[end] + num[i];
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[start]);
					list.add(num[end]);
					list.add(num[i]);
					
					result.add(list);
					
					start++;
					end--;
					
					while (start < end && num[start] == num[start - 1]) {
						start++;
					}
					
					while (start < end && num[end] == num[end + 1]) {
						end--;
					}
				} else if (sum < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		
		return result;
	}
	
	
	// 3. Serialize / Deserialize a binary tree
	
	
	
	
	// 4. Anagram bucket (Jedi)
	
	public static void main(String[] args) {
		String s = "1a2";
		
		System.out.print(isPalindrome(s));
	}
	
}
