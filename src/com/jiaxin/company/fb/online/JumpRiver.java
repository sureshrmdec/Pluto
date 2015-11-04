package com.jiaxin.company.fb.online;

import java.util.HashMap;

import org.junit.Test;

/**
 * 给一个0/1数组R代表一条河，0代表水，1代表石头。起始位置R[0]等于1，
 * 初速度为1. 每一步可以选择以当前速度移动，或者当前速度加1再移动。只能停留在石头上。问最少几步可以跳完整条河流。
 * 
 * 给定数组为R=[1,1,1,0,1,1,0,0]，最少3步能过河：
 * 第一步先提速到2，再跳到R[2]；
 * 第二步先提速到3，再跳到R[5]；
 * 第三步保持速度3，跳出数组范围，成功过河
 * 
 * 
 * http://www.mitbbs.com/article_t/JobHunting/32617501.html
 * 
 * R = [1,1,1,0,1,1,0,0]
 * n = R.length
 * dp = ([] for i in [0...n])
 * 
 * for i in [n-1..0]
 * for j in [1..n]
 * dp[i][j] = 1
 * dp[i][j] += Math.min(dp[i+j][j], dp[i+j+1][j+1]) if i+j+1 < n 
 * 
 * @author jiashan
 *
 */
public class JumpRiver {
	public int minJump(int[] river) {
		HashMap<Node, Integer> memory = new HashMap<Node, Integer>();
		
		return dfs(river, memory, 0, 1);
	}
	
	private int dfs(int[] river, HashMap<Node, Integer> memory, int id, int speed) {
		if (id >= river.length) {
			return 0;
		}
		
		Node node = new Node(id, speed);
		
		if (memory.containsKey(node)) {
			return memory.get(node);
		}
		
		int result = -1;
		if (river[id] == 1) {
			int result0 = dfs(river, memory, id + speed, speed);
			int result1 = dfs(river, memory, id + speed + 1, speed + 1);
			
			if (result0 >= 0 && result1 >= 0) {
				result = Math.min(result0, result1) + 1; 
			} else if (result0 < 0 && result1 < 0) {
				result = -1;
			} else {
				result = Math.max(result0, result1) + 1;
			}
		}
		
		memory.put(node, result);
		return result;
	}

	@Test
	public void test() {
		int[] river = {1,1,1,0,1,1,0,0};
		System.out.println(minJump(river));
	}
	
	
	class Node {
		int id;
		int speed;
		public Node(int id, int speed) {
			this.id = id;
			this.speed = speed;
		}
	}
}
