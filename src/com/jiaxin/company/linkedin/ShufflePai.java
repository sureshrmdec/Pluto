package com.jiaxin.company.linkedin;

/**
 *  CC 150 
 * @author jiashan
 *
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle -- in other 
 * words, each of the 52! permutation of the deck has to be equally likely. Assume 
 * that you are give a random number generator which is perfect. 
 * 
 * Solution: We could first shuffle the first n - 1 elements, Then, we would take the nth 
 * element and randomly swap it with an element in the array. That's it!
 * 
 * Iterative:
 * For each element, swapping array[i] with a random element between 0 and i, inclusive. 
 *
 * http://www.gocalf.com/blog/shuffle-algo.html
 */

public class ShufflePai {
	int[] shuffleArayRecursive(int[] cards, int i) {
		if (cards == null || cards.length == 0 || i == 0) {
			return cards;
		}
		
		shuffleArayRecursive(cards, i - 1);
		int k = rand(0, i);
		
		int temp = cards[k];
		cards[k] = cards[i];
		cards[i] = temp;
		
		return cards;
	}

	private int rand(int lower, int higher) {
		return lower + (int)(Math.random() * (higher - lower + 1));
	}
	 
	
	/***************************************************************************/ 
	void shuffleArrayIteratively(int[] cards) {
		for (int i = 0; i < cards.length; i++) {
			int k = rand(0, i);
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		}
	}
}
