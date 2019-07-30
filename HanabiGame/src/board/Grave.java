package board;

import java.util.Arrays;
import java.util.LinkedList;

import entity.Card;

public class Grave {
	private int[][] cards;
	
	public Grave(int NUM_COLORS) {
		cards = new int[NUM_COLORS][5];
	}
	
	public void addCard(Card card) {
		int colorIndex = card.getColor().ordinal();
		int numIndex = card.getNum() -1;
		
		cards[colorIndex][numIndex]++;
	}

	public int[][] getGraveCards() {
		int[][] graveCards = Arrays.copyOf(cards, cards.length);
		
		return graveCards;
	}
}
