package com.jiaxin.company.yahoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Interview {
	public static void main(String[] args) {
		String str = "abrcbamc";
//		System.out.println(firstSingle2(str));
		int[] list1 = { 1, 2, 3, 3, 4 };
		int[] list2 = { 2, 4 };
//		System.out.println(findDiff(list1, list2));
		int[] A = {1,2,4,6,10,10,11};
		int[] B = {1,3,5,6,10,11,11,19,234};
		
		System.out.println(symmetricDiff2(A, B));
	}
	
	
	// For the numbers between 1 and 100, print "Fizz" if it's a multiple of 3, "Buzz" if multiple of 5 and "FizzBuzz" if multiple of both
	public static String fizzBuzz(int n) {
	    String result = "";
	    result += (n % 3 == 0) ? "Fizz" : "";
	    result += (n % 5 == 0) ? "Buzz" : "";
	    return result;
	}


	public static void print() {
	    for (int i = 0; i <= 100; i++) {
	       System.out.println(fizzBuzz(i)); 
	    }
	}

	//Given two lists/arrays of integers, call them A and B, find the symmetric difference of them. Find all the elements that are in A and not in B and all the elements that are in B and not A.

	public static ArrayList<Integer> symmetricDiff(int[] A, int[] B) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if (A == null || B == null) {
	        return result;
	    }

	    HashSet<Integer> set = new HashSet<Integer>();
	    for (int i : B) {
	        set.add(i);
	    }
	    
	    for (int i : A) {
	        if (!set.contains(i)) {
	            result.add(i);
	        }
	    }
	    
	    set.clear();
	    for (int i : A) {
	        set.add(i);
	    }
	    
	    for (int i : B) {
	        if (!set.contains(i)) {
	            result.add(i);
	        }
	    }
	    
	    return result;
	}

	public static ArrayList<Integer> symmetricDiff2(int[] A, int[] B) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if (A == null || B == null) {
	        return result;
	    }
	    
	    int i = 0;
	    int j = 0;
	    while (i < A.length && j < B.length) {
	        if (A[i] == B[j]) {
	        	int value = A[i];
	            while (i < A.length && A[i] == value) {
	            	i++;
	            }
	            while (j < B.length && B[j] == value) {
	            	j++;
	            }
	            
	        } else if (A[i] < B[j]) {
	        	result.add(A[i++]);
	        } else {
	        	result.add(B[j++]);
	        }
	    }
	    
	    while (i < A.length) {
	        result.add(A[i++]);
	    }
	    
	    while (j < B.length) {
	        result.add(B[j++]);
	    }
	    
	    return result;
	}


	public static ArrayList<Integer> findDiff(int[] list1, int[] list2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (list1 == null || list2 == null || list1.length == 0
				|| list2.length == 0) {
			return result;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : list2) {
			map.put(i, 1);
		}

		for (int i : list1) {
			if (!map.containsKey(i)) {
				result.add(i);
			}
		}

		return result;
	}

	public static Character firstSingle1(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		return null;
	}

	public static Character firstSingle2(String str) {
		Set<Character> repeating = new HashSet<Character>();
		List<Character> nonRepeating = new ArrayList<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			
			if (repeating.contains(letter)) {
				continue;
			}
			
			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		
		return nonRepeating.get(0);
	}

	public static Character firstSingle3(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}

		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

}
