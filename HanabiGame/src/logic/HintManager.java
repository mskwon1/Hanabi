package logic;

import java.util.ArrayList;

import entity.Card;
import entity.Color;
import entity.Player;

public class HintManager {
	public boolean checkHint(int num, Player player) {
		boolean valid = false;
		
		for (Card card : player.getHand()) {
			if (card.getNum() == num) {
				card.setNumHint(true);
				valid = true;
			}
		}
		
		return valid;
	}
	
	public boolean checkHint(Color color, Player player) {
		boolean valid = false;
		
		for (Card card : player.getHand()) {
			if (card.getColor().name() == color.name()) {
				card.setColorHint(true);
				valid = true;
			}
		}
		
		return valid;
	}
	
	public static void main(String[] args) {
		HintManager h = new HintManager();
		
		Player p = new Player("Test Player");
		ArrayList<Card> cardList = new ArrayList<Card>();
		for (int i=0;i<5;i++) {
			cardList.add(new Card(i,Color.valueOf("RED")));
		}
	
		p.setHand(cardList);
		
		h.checkHint(1, p);
		h.checkHint(Color.valueOf("RED"), p);
		
		System.out.println(p);
	}
}
