package com.jiaxin.lc.newProblem;

import java.util.Arrays;
import java.util.Comparator;
/*
 * Integer Camparation is complicated, Transfer to string, connect s1+s2 and s2+s1.
 */

public class LargestNumber {
	// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
    public static String largestNumber(int[] num) {
    	if (num == null || num.length == 0) {
    		return "";
    	}
    	
    	String[] array = new String[num.length];
    	for (int i = 0; i < num.length; i++) {
    		array[i] = String.valueOf(num[i]);
    	}
    	
    	Arrays.sort(array, comparator);
    	
    	String result = "";
    	
    	for (String str: array) {
    		result = str + result;
    	}
    	
    	int i = 0; 
    	while (i < result.length() - 1) {
    		if (result.charAt(i) != '0') {
    			break;
    		}
    		i++;
    	}
    	
    	return result.substring(i);
    }

    public static Comparator<String> comparator = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			String comb1 = o1 + o2; 
			String comb2 = o2 + o1;
			
			return comb1.compareTo(comb2);
		}
	};
		
	public static void main(String[] args) {
		int[] num = {0, 0};
		
		System.out.println(largestNumber(num));
	}
}
