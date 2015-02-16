package com.jiaxin.company.fb.online;

import org.junit.Test;

/**
 * A robot is asked to navigate a maze. 
 * It is placed at a certain position (the starting position) in the maze 
 * and is asked to try to reach another position (the goal position). 
 * Positions in the maze will either be open or blocked. Positions are identified by (x,y) coordinates.  
 * Tell me whether or not there is a path in the maze given a starting position and a goal position.
 * 
 * If the candidate gives an interative solution, try to encourage a recursive one.  
 * Also ask about backtracking.  
 * If they jump to a good recursive solution, ask further if they can print out the solution path.  
 * Ask about complexity and test cases they would write for it.
 * 
 * 
 * @author jiashan
 *
 */
public class robotMaze {
	boolean[][] visited;
	public boolean canFindPath(int[][] boggle, int startX, int startY, int endX, int endY) {
		if (boggle == null || boggle.length == 0 || boggle[0].length == 0) {
			return false;
		}
		
		visited = new boolean[boggle.length][boggle[0].length];
	
		for (int i = startX; i < boggle.length; i++) {
			for (int j = startY; j < boggle[i].length; j++) {
				StringBuilder sb = new StringBuilder();
				if (hasResult(boggle, i, j, endX, endY, sb)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	
	private boolean hasResult(int[][] boggle, int i, int j, int endX, int endY,
			StringBuilder sb) {
		if (i < 0 || i >= boggle.length || j < 0 || j >= boggle[0].length || boggle[i][j] == 0) {
			return false;
		}
		
		// append
		sb.append(i * 10 + j + " ");
		visited[i][j] = true;

		if (i == endX && j == endY) {
			System.out.println(sb.toString());
			return true;
		}

		// for direction
//		for (int x = i - 1; x <= i + 1; x++) {
//			for (int y = j - 1; y <= j + 1; y++) {
//				if ((x != i || y != j) && x >= 0 && x < 4 && y >= 0 && y < 4
//						&& !visited[x][y]) {
//					if (hasResult(boggle, x, y, endX, endY, sb)) {
//						return true;
//					}
//				}
//			}
//		}

		// forways
		if (hasResult(boggle, i - 1, j, endX, endY, sb)) {
			return true;
		}
		
		
		
		// delete and backtrack
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false;
		return false;
	}

	@Test
	public void test() {
		int[][] maze = {
				{0,0,0,1},
				{1,0,1,1},
				{1,0,0,1},
				{0,1,1,1},
			};
		
		System.out.println(canFindPath(maze,0,3, 3,1));
	}
	
}
