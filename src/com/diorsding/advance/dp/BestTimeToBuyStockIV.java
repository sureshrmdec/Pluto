package com.diorsding.advance.dp;

/**
 * http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iv/
 * Simple Way
 * f[i][j] means i days have at most j transactions.
 * f[i][j] = max{ f[x][j - 1] + profit(x + 1,j)}   {x= 0->i -1}
 * f[i][0] = 0, f[0][i] = Integer.MIN_VALUE
 * result = f[n][k]
 * 
 * O(n^2 * k) -> we have room to optimize this algo, store some local var then,
 * do need to iterate (0, i-1) to find maximum  
 * 
 * ------------------>
 * 1. State
 * local[i][j]  i days, at most j transactions, ith day must sell
 * global[i][j] i days, at most j transactions, ith day no need to seel. 
 * 
 * 2. Function
 * gain = prices[i] - prices[i - 1];
 * local[i][j] = max(global[i-1][j-1] + gain, local[i - 1][j] + gain)  -> means bought some day already, and sell on j
 * global[i][j] = max(global[i - 1][j], local[i][j])
 * 
 * 3. local[0][i] = global[0][i] = 0
 * 4. result = global[n-1][k] 
 * 
 * O(nk) -> save O(n) search time, need more space
 * 
 * Test case : k very large 
 * 
 * 
 * @author jiashan
 */
public class BestTimeToBuyStockIV {

	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
	
		if (k > prices.length) {
			return maxProfit(prices);
		}
		
		int n = prices.length;
		
		int[][] local = new int[n][k + 1];
		int[][] global = new int[n][k + 1];
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				int profit = prices[i] - prices[i - 1];
				local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + profit;
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}
		
		return global[n - 1][k];
    }

	private int maxProfit(int[] prices) {
		int profit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			int singleProfit = prices[i] - prices[i - 1];
			if (singleProfit > 0) {
				profit += singleProfit;
			}
		}
		
		return profit;
	}
	
	
}
