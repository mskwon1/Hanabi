package logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import board.Deck;
import board.Grave;
import board.Upcards;
import entity.Card;
import entity.Color;
import entity.Player;

public class GameManager {
	private static final int MAX_SCORE = 25;
	private static final int NUM_COLORS = 5;
	
	private List<Player> players;
	private HintManager hintManager;
	private TokenManager tokenManager;
	private Queue<Player> turnQueue;
	
	private int turnCount;
	private int score;
	
	private Deck deck;
	private Grave grave;
	private Upcards upcards;
	
	boolean end = false;
	boolean endFlag = false;
	int endCounter;
	
	public GameManager(List<Player> players) {
		this.players = new ArrayList<Player>();
		this.players.addAll(players);
		turnQueue = new LinkedList<Player>();
		turnQueue.addAll(players);
		
		hintManager = new HintManager();
		tokenManager = new TokenManager();
		
		turnCount = 1;
		score = 0;
		
		endCounter = players.size();
		
		deck = new Deck();
		grave = new Grave(NUM_COLORS);
		upcards = new Upcards(NUM_COLORS);
	}
	
	
	public boolean isEnd() {
		return end;
	}


	public int getTurnCount() {
		return turnCount;
	}


	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public TokenManager getTokenManager() {
		return tokenManager;
	}

	public Upcards getUpcards() {
		return upcards;
	}
	
	public void startGame() {
		initialHandout();
	}
	
	public void discard(Player player, int index) {
		Card targetCard = player.getHand().get(index);
		grave.addCard(targetCard);
		
		tokenManager.addBlue();
		
		Card newCard = deck.getTopCard();
		
		if (newCard != null) {
			player.getHand().set(index, newCard);
		} else {
			player.getHand().remove(index);
			endFlag = true;
		}
		
		turnCount++;
		
		if (endFlag && --endCounter == 0) {
			end = true;
		}
	}
	
	public boolean putOnBoard(Player player, int index) {
		boolean success;
		
		Card targetCard = player.getHand().get(index);
		if(!upcards.putCard(targetCard)) {
			tokenManager.useRed();
			grave.addCard(targetCard);
			success = false;
		} else {
			score++;
			success = true;
			
			if (targetCard.getNum() == 5) {
				tokenManager.addBlue();
			}
		}
		
		Card newCard = deck.getTopCard();
		
		if (newCard != null) {
			player.getHand().set(index, newCard);
		} else {
			player.getHand().remove(index);
			endFlag = true;
		}

		turnCount++;
		
		if (endFlag && --endCounter == 0) {
			end = true;
		}
		
		return success;
	}
	
	public boolean giveColorHint(Player player, int index) {
		if (tokenManager.getBlueToken() == 0) {
			return false;
		}
		
		Card targetCard = player.getHand().get(index);
		
		hintManager.checkHint(targetCard.getColor(), player);
		tokenManager.useBlue();
		
		turnCount++;
		
		if (endFlag && --endCounter == 0) {
			end = true;
		}
		
		return true;
	}
	
	public boolean giveNumHint(Player player, int index) {
		if (tokenManager.getBlueToken() == 0) {
			return false;
		}
		
		Card targetCard = player.getHand().get(index);
		
		hintManager.checkHint(targetCard.getNum(), player);
		tokenManager.useBlue();

		turnCount++;

		if (endFlag && --endCounter == 0) {
			end = true;
		}
		
		return true;
	}
	
	private void initialHandout() {
		for (Player player : players) {
			for (int i=0;i<5;i++) {
				player.getHand().add(deck.getTopCard());
			}
		}
	}
	
	public int getLeftCards() {
		return deck.getCount();
	}
	
	public List<Player> getPlayer() {
		return players;
	}
	
	public Queue<Player> getTurnQueue() {
		return turnQueue;
	}
	
	public Player getNextPlayer() {
		Player tempPlayer = turnQueue.poll();
		turnQueue.add(tempPlayer);
		
		return tempPlayer;
	}
	
//	public static void main(String[] args) {
//		ArrayList<Player> playerList = new ArrayList<Player>();
//		playerList.add(new Player("A"));
//		playerList.add(new Player("B"));
//		
//		GameManager gm = new GameManager(playerList);
//		
//		gm.startGame();
//	}
}
