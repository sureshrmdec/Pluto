package com.jiashan.ninechapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Classic {
	public ArrayList<ArrayList<Integer>> permutionI(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (nums == null || nums.size() == 0) {
            return result;
        }
        
        helper(result, list, nums);
        
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }
            
            list.add(nums.get(i));
            helper(result, list, nums);
            list.remove(nums.get(i));
        }
    }
    
    
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.size()];
        
        if (nums == null || nums.size() == 0) {
            return result;
        }
        
        Collections.sort(nums);
        helper(result, list, visited, nums); 
        
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, boolean[] visited, ArrayList<Integer> nums) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] || (i != 0 && nums.get(i - 1) == nums.get(i) && !visited[i - 1])) {
                continue;
            }
            
            visited[i] = true;
            list.add(nums.get(i));
            helper(result, list, visited, nums);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
    
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Collections.sort(S);
        helper(result, list, S, 0);
        
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> S, int start) {
        
        result.add(new ArrayList<Integer>(list));
        
        for (int i = start; i < S.size(); i++) {
            list.add(S.get(i));
            helper(result, list, S, i + 1);
            list.remove(list.size() - 1); 
        }
    }
    
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Collections.sort(S);
        helper2(result, list, S, 0); 
        
        return result;
    }
    
    public void helper2(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, 
        ArrayList<Integer> S, int start) {
        result.add(new ArrayList<Integer>(list));
        
        for (int i = start; i < S.size(); i++) {
            if (i != start && S.get(i) == S.get(i - 1)) {
                continue; 
            }
                
            list.add(S.get(i));
            helper2(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    
    public int findPeak(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; 
            
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            
            if (A[mid] > A[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
        
    }
    
    
    public int findFirstBadVersion(int n) {
        if (n < 1) {
            return -1;
        }
        
        int start = 1;
        int end = n;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (VersionControl.isBadVersion(mid)) {
                end = mid; 
            } else {
                start = mid;
            }
        }
        
        if (VersionControl.isBadVersion(start)) {
            return start;
        }  
        
        if (VersionControl.isBadVersion(end)) {
            return end;
        }  
        
        return -1;
    }
    
   
    public int[] twoSum(int[] numbers, int target) {
    	int[] result = {-1, -1};
        
        if (numbers == null || numbers.length <= 0) {
            return result;
        }
        
        int[] copy = new int[numbers.length];
        System.arraycopy(numbers, 0, copy, 0, numbers.length);
        Arrays.sort(copy);
        
        int start = 0;
        int end = numbers.length - 1;
        
        while (start < end) {
            int sum = copy[start] + copy[end];
            
            if (sum == target) {
                break;
            }
            
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        
        if (start == end) {
            return result;
        }
        
        int number1 = copy[start];
        int number2 = copy[end];
        
        for (int i = 0; i < numbers.length; i++) {
            if ((numbers[i] == number1) || (numbers[i] == number2)) {
                if (result[0] == -1) {
                    result[0] = i + 1;
                } else {
                    result[1] = i + 1;
                    break;
                }
            }   
        }
        
        Arrays.sort(result);
        return result;
    }
    
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = {-1, -1};
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        
        return result;
    }
    

    
    static class VersionControl {
    	static boolean isBadVersion(int n) {
			return false;
		}
    }
    
    public class TwoSum {

    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	public void add(int number) {
    		if (map.containsKey(number)) {
    			map.put(number, map.get(number) + 1);
    		} else {
    			map.put(number, 1);
    		}
    	}

        // Find if there exists any pair of numbers which sum is equal to the value.
    	public boolean find(int value) {
			for (int key : map.keySet()) {
				if (key * 2 == value) {
					if (map.get(key) >= 2) {
						return true;
					}
				} else if (map.containsKey(value - key)){
					return true;
				}
			}
			
    		return false;
    	}
    }

    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = heights.length - 1; 
        int max = Integer.MIN_VALUE;
        
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(heights[start], heights[end]));
            
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }
        
        return max;
    }
    
    @Test
    public void test() {
    	int[] A = {1,10,9,8,7,6,5,4};
    	int[] numbers = {2,7,10,11};
//    	System.out.print(twoSum2(numbers, 9));
    	int[] heights = {1,3,2};
    	System.out.print(maxArea(heights));
//    	System.out.println(findPeak(A));
    }
}
