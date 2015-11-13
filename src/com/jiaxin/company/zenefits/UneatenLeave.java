package com.jiaxin.company.zenefits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * http://www.careercup.com/question?id=5288825291014144
 * http://stackoverflow.com/questions/27248327/caterpillars-and-leaves-can-we-do-better-than-onc
 * http://www.1point3acres.com/bbs/thread-129214-1-1.html
 * 
 * Solution: 
 * Brute Force: 
 * For every integer, if n % A[i] (i => 0..A.length-1) == 0. means its multiple, skip. or count++.
 * O(n * k). space O(1)
 * 
 * Optimized:
 * 1. We just calculate count, don't care every number. So no need to iterate array, 
 * Just consider N and A relationships. 
 * 2. Avoid duplicate calulation. 
 * For example, A = [2,4]. as we calculate multiple for 2, no need to calculate 4.  
 * 
 * LCM - Lease common multiple. 
 * Inclusion - Exclusion Principle.
 * 
 * two problems with detail.
 * http://www.1point3acres.com/bbs/thread-136079-1-1.html
 * 
 * 
 * @author jiashan
 *
 */
public class UneatenLeave {

	int countUneatenLeaveNaive(int N, int[] A) {		
		int count = 0;
		Arrays.sort(A);
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < A.length; j++) {
				if (i % A[j] == 0) {
					count++;
					break;
				}
			}
		}
		
		return count;
	}
	
	int countUneatenLeave(int N, int[] A) {		
		int count = 0;
		
		return count;
	}
	
	public int lcm(List<Integer> list) throws Exception {
		if (list.size() == 2) {
			return lcm(list.get(0), list.get(1));
		}
		
		while (list.size() > 2) {
			int temp = list.get(0);
			list.remove(0);
			return lcm(temp, lcm(list));
		}
		
		throw new Exception("hehe");
	}
	
	public int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	public int gcd(int a, int b) {
		while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
		
		return a;
	}
	
	@Test
	public void test() throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(4);
		list.add(3);
		list.add(2);
		System.out.println(lcm(list));
	}
}
