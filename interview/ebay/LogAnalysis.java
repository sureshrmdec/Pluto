package interview.ebay;

/**
 * 这里我没初始化，而是直接i = 1， j = 1. a.charAt(i - 1)了，这样i = 0， j = 0 都没有意义了，声明array时候已经为0
 * maxLength时候切一些，也可以知道maxString
 * @author jeffwan
 * @date May 25, 2014
 */

public class LogAnalysis {
	public static void main(String[] args) {
		String a = "aaaba";
		String b = "abaa";
		System.out.println(longestCommonSubstring(a, b));
	}
	
	// 双层DP应该初始化横纵两列
	public static int longestCommonSubstring(String a, String b) {
		int maxLength = 0;
		String maxString = "";
		
		int[][] length = new int[a.length() + 1][b.length() + 1];
		int i, j;
		for (i = 1; i <= a.length(); i++) {
			for (j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					length[i][j] = length[i - 1][j - 1] + 1; 
				} else {
					length[i][j] = 0;
				}
				
				if (length[i][j] > maxLength) {
					maxLength = length[i][j];
				}
			}
		}
		
		maxString = a.substring(i - maxLength - 1, i - 1);
		return maxLength;
	}
}
