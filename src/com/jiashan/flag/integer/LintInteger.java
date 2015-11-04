package com.jiashan.flag.integer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LintInteger {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int index = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[index++] = A[i];
            }
        }
        
        return index;
    }
    
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int index = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        
        return index + 1;
    }
    
    
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>(A.size());
        
        if (A == null || A.size() == 0) {
            return result;
        }
        
        if (A.size() == 1) {
            result.add((long)1);
            return result; 
        }
        
        long[] left = new long[A.size()];
        long[] right = new long[A.size()];
        left[0] = 1;
        right[A.size() - 1] = 1;
        
        for (int i = 1; i < A.size(); i++) {
            left[i] = left[i - 1] * A.get(i - 1);    
        }
        
        for (int i = A.size() - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A.get(i + 1);
        }
        
        for (int i = 0; i < A.size(); i++) {
            result.add((long)left[i] * right[i]);
        }
        
        return result;
    }
    
    
    
    @Test
    public void test() {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	ArrayList<Integer> result = new ArrayList<Integer>(1);
    	result.add(1);
    	result.add(2);
    	result.add(3);
    	System.out.println(productExcludeItself(result));
    }
	
}
