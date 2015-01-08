package homework;

import java.util.ArrayList;

public class CopyBooks {
	ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		int[] m = {1,2,3,4,5,6,7,8,9};
		System.out.println(copyBooks(m, 3));
	}
	
	public static ArrayList<Integer> copyBooks(int[] m, int k) {
		ArrayList<Integer> result = null;
		if (m == null || m.length == 0) {
			return result;
		}
		
		int sumPages = 0;
		for (int page : m) {
			sumPages += page;
		}
		
		int start, end, mid;
		start = 0;
		end = sumPages;
		
		while (start + 1 < sumPages) {
			mid = start + (end - start) / 2;
			
			result = count(m, mid);
			if (result.size() == k) {
				return result;
			} 
			
			if (result.size() > k) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		
		if (count(m, start).size() == k) {
			return count(m, start);
		}
		
		if (count(m, end).size() == k) {
			return count(m, end);
		}
		
		return null;
	}

	private static ArrayList<Integer> count(int[] m, int mid) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int counter = 0;
		int i;
		for(i = 0; i < m.length; i++) {
			counter += m[i];
			if ((i + 1 < m.length) && (counter + m[i + 1] >= mid)) {
				
				System.out.println(counter);
				counter = 0;
				
				result.add(i);
			}
		}
		result.add(i - 1);
		return result;
	}
	
	
}
