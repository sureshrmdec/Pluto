package com.jiaxin.company.twosigma;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


/**
 * N people here. grid[x][y] mean relationship 'Y' means Friend, 'N' means not Frind. 
 * How many Friend cycles. 
 * 
 * YYNN
 * YYNN
 * NNYN
 * NNNY
 * 
 * https://crypticarticles.wordpress.com/2015/07/17/friend-circles-hacker-earth-bankbazaar-online-coding-test/
 * 
 * @author jiashan
 *
 */
public class FriendCircle {
	
	static Queue<Integer> queue = new LinkedList<Integer>();
	
	public static int friend(String[] friends) {
		int circle = 0;
		
		for (int i = 0; i < friends.length; i++) {
			if (friends[i].contains("Y")) {
				circle++;  // new circle
				
				friends[i] = process(friends[i]);
				
				while (!queue.isEmpty()) {
					int head = queue.poll();
					friends[head] = process(friends[head]);
				}
			}
		}
		
		return circle;
	}
	
	private static String process(String row) {
		int j = row.indexOf('Y');

		// Replace all 'Y' and enqueue them.  
		while (j != -1) {
			queue.add(j);
			row = row.replaceFirst("Y", "N");
			j = row.indexOf('Y');
		}
		return row ;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] friends = new String[n]; 
		
		for (int i = 0; i < n; i++) {
			friends[i] = scanner.nextLine();
		}
		
		System.out.println(friend(friends));
	}
	
	
	
}
