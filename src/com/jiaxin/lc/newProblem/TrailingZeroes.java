package com.jiaxin.lc.newProblem;

/*
 * 
 * Trailing zeros of n!
 * 
 * Interger OverFlow
 * Reference: http://www.purplemath.com/modules/factzero.htm
 * http://www.cnblogs.com/EdwardLiu/p/4207498.html
 */
public class TrailingZeroes {
	public static int trailingZeroes(int n) {
		if (n < 0) {
			n = -1* n;
		}
		
 		int result = 0;
		
		for (int i = 5; n / i >= 1; n = n / 5) {
			result += n / i;
		}
		
		
		return result;
    }
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(1808548329));
		
	}
}
