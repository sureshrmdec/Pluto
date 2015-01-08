package com.jiaxin.cc.Hard;

import java.util.Arrays;

public class ShuffleArray {
	public static void main(String[] args) {
		int[] cards = {1,2,3,4,5,6,7};
		shuffleArray(cards);
		System.out.println(Arrays.toString(cards));
	}
	
	public static void shuffleArray(int[] cards) {
		int temp, index;
		for (int i = 0; i < cards.length; i++) {
			index = (int)(Math.random() * (cards.length - i)) + i;
			temp = cards[i];
			cards[i] = cards[index];
			cards[index] = temp;
		}
	}
}
