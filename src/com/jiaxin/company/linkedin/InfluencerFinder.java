package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class InfluencerFinder {
	/** 
	* Given a matrix of following between N LinkedIn users (with ids from 0 to N-1): 
	* followingMatrix[i][j] == true iff user i is following user j 
	* thus followingMatrix[i][j] doesn't imply followingMatrix[j][i]. 
	* Let's also agree that followingMatrix[i][i] == false 
	* 
	* Influencer is a user who is: 
	* - followed by everyone else and 
	* - not following anyone himself 
	* 
	* This method should find an Influencer by a given matrix of following, 
	* or return -1 if there is no Influencer in this group.
	* 
	* Implement: 
	* int getInfluencer(boolean[][] followingMatrix);
	*  
	*  http://www.geeksforgeeks.org/the-celebrity-problem/
	*  
	*/ 
	
	// find j -> matrix[x][j] = true.  matrix[j][x] = false; -> O(n^2)
	public int getInfluencerImpl(boolean[][] followingMatrix) {
		int i, j = 0;
		for (i = 0; i < followingMatrix.length; i++) {
			boolean flag = true;
			for (j = 0; j < followingMatrix[0].length; j++) {
				if (i == j) {
					continue;
				}
				
				if (followingMatrix[i][j] || !followingMatrix[j][i]) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				return i;
			}
		}
		
		return -1;
	}
	
	// O(n) --> need to say there's only one if exists
	public int getInfluencer(boolean[][] followingMatrix) {
		int candidate = 0;
		
		for (int i = 1; i < followingMatrix.length; i++) {
			if (followingMatrix[candidate][i] || !followingMatrix[i][candidate]) {
				candidate = i;
			}
		}
		
		// need verify
		for (int j = 0; j < followingMatrix.length; j++) {
			if (j == candidate) {
				continue;
			}
			if (followingMatrix[candidate][j] || !followingMatrix[j][candidate]) {
				return -1;
			}
		}
		
		return candidate;
	}
	
	
	@Test
	public void test() {
		boolean[][] followingMatrix = {
				{ false, true, true, false },
				{ true, false, true, true },
				{ false, false, false, false },
				{ true, true, true, false }
		};
		
		System.out.println(getInfluencer(followingMatrix));
	}
	
}


