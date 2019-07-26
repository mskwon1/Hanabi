package entity;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand;
	private String name;
	
	public Player(String name) {
		this.hand = new ArrayList<Card>();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public String toString() {
		String result = "";
		
		result += "Player Name : " + name + "\n";
		
		result += "----------------------\nCard List\n";
		for (Card card : hand) {
			result += card + "\n";
		}
		result += "----------------------";
		return result;
	}
}
