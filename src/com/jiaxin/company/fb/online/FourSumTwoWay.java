package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Give an array with unique doubles, find all quadruples that match the condition a+b+c+d = 0 (Ninja)
 * 1. Two Pointer
 * 2. HashSet
 * 
 * @author jiashan
 *
 */
public class FourSumTwoWay {
	// O(n^3)
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	 
    	if (num == null || num.length == 0) {
    		return result;
    	}
    	
    	Arrays.sort(num);
   
    	for (int i = 0; i < num.length - 3; i++) {
    		if (i != 0 && num[i] == num[i - 1]) {
    			continue;
    		}
    		
    		for (int j = i + 1; j < num.length - 2; j++) {
    			if (j != i + 1 && num[j] == num[j - 1]) {
    				continue;
    			}
    			
    			int left = j + 1;
    			int right = num.length - 1;
    			
    			while (left < right) {
    				int sum = num[i] + num[j] + num[left] + num[right];
    				if (sum == target) {
    					List<Integer> list = new ArrayList<Integer>();
    					list.add(num[i]);
    					list.add(num[j]);
    					list.add(num[left]);
    					list.add(num[right]);
    					
    					result.add(list);
    					left++;
    					right--;
    					
    					while (left < right && num[left] == num[left - 1]) {
    						left++;
    					}
    					
    					while (left < right && num[right] == num[right + 1]) {
    						right--;
    					}
    				} else if (sum < target) {
    					left++;
    				} else {
    					right--;
    				}
    			}
    		}
    	}
    	
    	return result;
    }
	
    // O(n^3)
    public List<List<Integer>> fourSumHashMap(int[] num, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();

    	Arrays.sort(num);
    	if (num == null || num.length == 0) {
    		return result;
    	}

    	for (int i = 0; i < num.length - 3; i++) {
    		if (i != 0 && num[i] == num[i - 1]) {
    			i++;
    		}

    		for (int j = i + 1; j < num.length - 2; j++) {
    			if (j != i + 1 && num[j] == num[j - 1]) {
    				j++;
    			}

    			Set<Integer> dict = new HashSet<Integer>();

    			for (int k = j + 1; k < num.length; k++) {
    				int rest = target - num[i] - num[j] - num[k];
    				if (rest < 0) {
    					break;
    				}
    				
    				if (dict.contains(rest)) {
    					List<Integer> list = new ArrayList<Integer>();
    					list.add(num[i]);
    					list.add(num[j]);
    					list.add(rest);
    					list.add(num[k]);
    					
    					result.add(list);

    				} else {
    					dict.add(num[k]);
    				}
    			}
    		}
    	}

    	return result;
    }
}
