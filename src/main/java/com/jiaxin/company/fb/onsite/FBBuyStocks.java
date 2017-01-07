package com.jiaxin.company.fb.onsite;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. One Transaction
 * 2. Unlimited Transaction
 * 3. Two Transaction
 * 4. At Most K Transaction - not exactly K times. Totally different
 * https://gist.github.com/ElninoFong/d08051d98e634991cd93
 * http://blog.csdn.net/fightforyourdream/article/details/14503469
 * https://oj.leetcode.com/discuss/15153/a-clean-dp-solution-which-generalizes-to-k-transactions
 * 
 * @author jiashan
 *
 */
public class FBBuyStocks {
	// 1. One Transaction
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int profit = 0;
		int min = Integer.MAX_VALUE;
		
		for (int currentPrices : prices) {
			min = Math.min(min, currentPrices);
			profit = Math.max(profit, currentPrices - min);
		}
		
		return profit;
    }
	
	/**********************************************************************************************/
	// Unlimited Transaction
	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int profit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			int singleProfit = prices[i] - prices[i - 1];
			if (singleProfit > 0) {
				profit += singleProfit;
			}
		}
		
		return profit;
	}
	
	/**********************************************************************************************/
	public int maxProfit3(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int profit = 0;
		
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		
		left[0] = 0; // first day can't sell
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
		
		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}
		
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}
		
		return profit;
	}
	
	
	/**********************************************************************************************/
	public int maxProfit(int k, int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		if (k >= prices.length) {
			return maxProfit2(prices);
		}
		
		int length = prices.length; 
		// local[i][j]: max profit till i day, j transactions,  where there is transaction happening on i day
		int[][] local = new int[length][k + 1];
		int[][] global = new int[length][k + 1]; // global[i][j]: max profit across i days, j transactions
		
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - prices[i - 1];
			
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(profit, 0), // at most K trans, 0 means give up this one. 
						// continious. so we could treat it as one transaction.(k-2, k) =(k-2,k-1) + (k-1,k).
						local[i - 1][j] + profit);
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}
		
		return global[length - 1][k];
	}
	
	
	
	@Test
	public void test() {
		Assert.assertEquals(0, maxProfit(new int[] {1})); // expect 0. can't sail.
		Assert.assertEquals(0,maxProfit(new int[] {2, 1})); // expect 0. can't sail.
		
		int[] prices = {1,6,3,9,7,4,5};
		System.out.println(maxProfit(5, prices));
		Assert.assertEquals(7, maxProfit(2, new int[] {6,1,3,2,4,7}));
	}
	
}
