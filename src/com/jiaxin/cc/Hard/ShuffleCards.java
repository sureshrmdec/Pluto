package com.jiaxin.cc.Hard;
/**
 * 18.2 Write a method to shuffle a deck of cards. It must be a perfect shuffle. 52!
 * Assume that you are given a random number generator which is perfect. 
 * 
 * Solution: 每次选一个，然后放在头，从后面再随机挑一个出来. 直到全部OK
 * 这种题目跟 hasCycle一样, 主要是理解算法.
 * 
 * 第一个数选中是 1/52, 第二个是 51/52 * 1/ 51 = 1/52. 所以概率是一样.
 * @author jeffwan
 * @date May 24, 2014
 */
public class ShuffleCards {
	public void shuffleArray(int[] cards) {
		int temp, index;
		for (int i = 0; i < cards.length; i++) {
			index = (int)(Math.random() * cards.length) + i;
			temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}
	}
}
