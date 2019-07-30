package board;

import entity.Card;

public class Upcards {
	private boolean[] red = new boolean[5];
	private boolean[] green = new boolean[5];;
	private boolean[] white = new boolean[5];;
	private boolean[] yellow = new boolean[5];;
	private boolean[] blue = new boolean[5];;
	
	public Upcards() {
		for (int i=0; i<5; i++) {
			red[i] = false;
			green[i] = false;
			white[i] = false;
			yellow[i] = false;
			blue[i] = false;
		}
	}
	
	public boolean putCard(Card card) {
		String name = card.getColor().name();
		
		switch (name) {
		case "RED":
			for (int i=0; i<card.getNum()-1; i++) {
				if (!red[i]) {
					return false;
				}
			}
			
			red[card.getNum()-1] = true;
			return true;
			
		case "GREEN":
			for (int i=0; i<card.getNum()-1; i++) {
				if (!green[i]) {
					return false;
				}
			}
			
			green[card.getNum()-1] = true;
			return true;
			
		case "WHITE":
			for (int i=0; i<card.getNum()-1; i++) {
				if (!white[i]) {
					return false;
				}
			}
			
			white[card.getNum()-1] = true;
			return true;
			
		case "YELLOW":
			for (int i=0; i<card.getNum()-1; i++) {
				if (!yellow[i]) {
					return false;
				}
			}
			
			yellow[card.getNum()-1] = true;
			return true;
			
		case "BLUE":
			for (int i=0; i<card.getNum()-1; i++) {
				if (!blue[i]) {
					return false;
				}
			}
			
			blue[card.getNum()-1] = true;
			return true;
		default:
			/*
			 * 오류처리 (색깔 정보가 잘못됨)
			 */
			return false;
		}
	}
}
