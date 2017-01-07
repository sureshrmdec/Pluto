package com.jiaxin.company.ebay;

import java.util.ArrayList;
import java.util.Arrays;


public class Store {
	private static final int DOLLAR  = 100;
	private static int[] qoins; 
	private static int[] changes;
	
	public Store (int[] qoins) {
		this.qoins = qoins;
		this.changes = new int[qoins.length]; 
	}
	
	public static int getChangeValue(int cost) {
		if (cost < 0 || cost > 100) {
			new IllegalArgumentException("input is not valid");
		}
		
		return DOLLAR - cost;
	}
	
	public static int[] getChangeType(int change) {
		 
		for (int i = qoins.length - 1; i >= 0; i--) {
			while ((change - qoins[i]) >= 0) {
				change -= qoins[i];
				changes[i]++;
			}
		}
		
		return changes;
	}
	
	public static void main(String[] args) {
		int[] qoins = {1, 5, 10, 25};
		Store store = new Store(qoins);
//		int itemPrice = 99;
//		int change = getChangeValue(itemPrice);
//		System.out.println(Arrays.toString(getChangeType(change)));
		
		System.out.println(findAllways(20));
// [[15, 0, 0, 0], [10, 1, 0, 0], [5, 2, 0, 0], [5, 0, 1, 0], [0, 3, 0, 0], [0, 1, 1, 0]]
	}
	
	public static ArrayList<ArrayList<Integer>> findAllways(int change) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < qoins.length; i++) {
			list.add(0);
		}
		
		if (change < 0 || change > 100) {
			return result;
		}
		
		helper(result, list, change, 0);
		return result;
		
	}

	private static void helper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int change, int position) {
		if (change < 0) {
			return;
		}
		
		if (change == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = position; i < qoins.length; i++) {
			change -= qoins[i];
			list.set(i, list.get(i) + 1);
			
			helper(result, list, change, i);

			//back track
			change += qoins[i];			
		    list.set(i, list.get(i) - 1);
			
		}
	}
}
