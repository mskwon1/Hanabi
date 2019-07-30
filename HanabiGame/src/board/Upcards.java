package board;

import java.util.Arrays;

import entity.Card;

public class Upcards {
	private int[] onCards;
	
	public Upcards(int NUM_COLORS) {
		onCards = new int[NUM_COLORS];
		
		for (int num : onCards) {
			num = 0;
		}
	}
	
	public boolean putCard(Card card) {
		int index = card.getColor().ordinal();
		
		if (onCards[index]+1 == card.getNum()) {
			/*
			 * ���� �� �ִ� ī��
			 */
			onCards[index]++;
			return true;
		} else {
			/*
			 * ���� �� ���� ī��
			 */
			return false;
		}
	}
	
	public int[] getOnCards() {
		int[] tempArr = Arrays.copyOf(onCards, onCards.length);
		
		return tempArr;
	}
}
