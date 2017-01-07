package com.jiaxin.company.fb.online;

import org.junit.Test;

/**
 * https://gist.github.com/ElninoFong/d08051d98e634991cd93
 * http://www.cnblogs.com/grandyang/p/4295761.html
 * 
 * why
 * local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff); 
 *  
 *  
 * @author jiashan
 *
 */
public class BuyStocksIV {
    public int max(int[] prices, int k) {       // k: k times transactions
        if (prices.length == 0) {
        	return 0;
        }
        
        int len = prices.length;
        
        if (k >= prices.length) {
        	return maxProfit(prices);
        }
        
		int[][] local = new int[len][k + 1];  // local[i][j]: max profit till i day, j transactions,
										  	  // where there is transaction happening on i day
		int[][] global = new int[len][k + 1]; // global[i][j]: max profit across i days, j transactions
		
		for (int i = 1; i < len; i++) {
			int diff = prices[i] - prices[i - 1];
			
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(
						global[i - 1][j - 1] + Math.max(diff, 0),
						local[i - 1][j] + diff);
				
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}
		
		return global[len - 1][k];
    }

	private int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			int signleProfit = prices[i + 1] - prices[i];
			if (signleProfit > 0) {
				profit += signleProfit;
			}
		}
		
		return profit;
	}
	
	@Test
	public void test() {
		int[] prices = {6,1,3,2,4,7};
		System.out.println(max(prices, 2)); //7
	}
}
