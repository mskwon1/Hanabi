package board;

import java.util.LinkedList;

import entity.Card;

public class Grave {
	private LinkedList<Card> cards;
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public LinkedList<Card> getCards() {
		return cards;
	}
}
