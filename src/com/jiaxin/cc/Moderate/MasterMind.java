package com.jiaxin.cc.Moderate;
/**
 * 17.5 The Game of Master Mind 
 * solution: RGBY. guess: GGRR. --> one hit and one preudo-hit
 * 这题目主要是跟数量有关，我刚开始向用Hashset，后来想一下不可以的，
 * 
 * 像这种返回两个结果值的直接定义class好了
 * @author jeffwan
 * @date May 24, 2014
 */
public class MasterMind {
	public Result estimate(String guess, String solution) {
		if (guess == null || solution == null || guess.length() != solution.length()) {
			return null;
		}
		
		Result result = new Result();
		int[] frequencies = new int[guess.length() + 1]; // extra 1 is for not valid chars
		
		// calculate hits
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				result.hits++;
			} else {
				frequencies[code(solution.charAt(i))]++;
			}
		}
		
		// calculate presudo-hits
		for (int i = 0; i < guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code > 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
				result.preudoHits++;
				frequencies[code(solution.charAt(i))] --;
			}
		}
		
		return result;	
	}
	
	public class Result {
		public int hits = 0;
		public int preudoHits = 0;
		@Override
		public String toString() {
			return "(" + hits + " , " + preudoHits + ")";
		}
	}
	
	public int code(char c) {
		switch (c) {
		case 'R':
			return 0;
		case 'Y':
			return 1;
		case 'G':
			return 2;
		case 'B':
			return 3;
		default:
			return -1;
		}
	}
	
	
}
