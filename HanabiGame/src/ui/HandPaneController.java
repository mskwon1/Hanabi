package ui;

import java.util.ArrayList;

import application.HanabiAssistant;
import entity.Card;
import entity.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.GameManager;

public class HandPaneController {
	private Player player;
	private GameManager gm;
	private boolean isMyHand = false;
	
	private boolean isDiscard = false;
	private boolean isPutOnBoard = false;
	private boolean isGiveNumHint = false;
	private boolean isGiveColorHint = false;
	
	@FXML
	private Button btnCard1;
	@FXML
	private Button btnCard2;
	@FXML
	private Button btnCard3;
	@FXML
	private Button btnCard4;
	@FXML
	private Button btnCard5;
	
	private ArrayList<Button> buttons;
	
	@FXML
	private Button btnDiscard;
	@FXML
	private Button btnPutOnBoard;
	@FXML
	private Button btnGiveNumHint;
	@FXML
	private Button btnGiveColorHint;
	
	public HandPaneController() {
	
	}
	
	@FXML
	private void handleBtn1() {
		if (isDiscard) {
			gm.discard(player, 0);
		} else if (isPutOnBoard) {
			gm.putOnBoard(player, 0);
		} else if (isGiveColorHint) {
			gm.giveColorHint(player, 0);
		} else if (isGiveNumHint) {
			gm.giveNumHint(player, 0);
		} else {
			/*
			 * 오류
			 */
			return;
		}

		disableHand();	
		setHand(player);
		disableFlags();
	}
	
	@FXML
	private void handleBtn2() {
		if (isDiscard) {
			gm.discard(player, 1);
		} else if (isPutOnBoard) {
			gm.putOnBoard(player, 1);
		} else if (isGiveColorHint) {
			gm.giveColorHint(player, 1);
		} else if (isGiveNumHint) {
			gm.giveNumHint(player, 1);
		} else {
			/*
			 * 오류
			 */
			return;
		}

		disableHand();	
		setHand(player);
		disableFlags();
	}
	
	@FXML
	private void handleBtn3() {
		if (isDiscard) {
			gm.discard(player, 2);
		} else if (isPutOnBoard) {
			gm.putOnBoard(player, 2);
		} else if (isGiveColorHint) {
			gm.giveColorHint(player, 2);
		} else if (isGiveNumHint) {
			gm.giveNumHint(player, 2);
		} else {
			/*
			 * 오류
			 */
			return;
		}

		disableHand();	
		setHand(player);
		disableFlags();
	}
	
	@FXML
	private void handleBtn4() {
		if (isDiscard) {
			gm.discard(player, 3);
		} else if (isPutOnBoard) {
			gm.putOnBoard(player, 3);
		} else if (isGiveColorHint) {
			gm.giveColorHint(player, 3);
		} else if (isGiveNumHint) {
			gm.giveNumHint(player, 3);
		} else {
			/*
			 * 오류
			 */
			return;
		}

		disableHand();	
		setHand(player);
		disableFlags();
	}
	
	@FXML
	private void handleBtn5() {
		if (isDiscard) {
			gm.discard(player, 4);
		} else if (isPutOnBoard) {
			gm.putOnBoard(player, 4);
		} else if (isGiveColorHint) {
			gm.giveColorHint(player, 4);
		} else if (isGiveNumHint) {
			gm.giveNumHint(player, 4);
		} else {
			/*
			 * 오류
			 */
			return;
		}

		disableHand();	
		setHand(player);
		disableFlags();
	}
	
	private void disableFlags() {
		isDiscard = false;
		isPutOnBoard = false;
		isGiveColorHint = false;
		isGiveNumHint = false;
	}
	
	@FXML
	private void handleDiscard() {
		isDiscard = true;
		isPutOnBoard = false;
		
		enableHand();
	}
	
	@FXML
	private void handlePutOnBoard() {
		isDiscard = false;
		isPutOnBoard = true;
		
		enableHand();
	}
	
	@FXML
	private void handleGiveNumHint() {
		isGiveNumHint = true;
		isGiveColorHint = false;
		
		enableHand();
	}
	
	@FXML
	private void handleGiveColorHint() {
		isGiveNumHint = false;
		isGiveColorHint = true;
		
		enableHand();
	}
	
	private void enableHand() {
		for (int i=0; i<player.getHand().size();i++) {
			buttons.get(i).setDisable(false); 
		}
	}
	
	public void setGM(GameManager gm) {
		this.gm = gm;
	}
	
	public void setHand(Player player) {
		this.player = player;
		ArrayList<Card> tempHand = player.getHand();
		
		for (int i=0;i<tempHand.size();i++) {
			if (this.isMyHand) {
				buttons.get(i).setText(tempHand.get(i).getNumWithHint());
				setColor(buttons.get(i), tempHand.get(i).getColorWithHint());
			} else {
				String temp = "";
				temp += tempHand.get(i).getNum();
				buttons.get(i).setText(temp);
				setColor(buttons.get(i), tempHand.get(i).getColor().name());
			}
		}
	}
	
	private void setColor(Button button, String color) {
		switch (color) {
		case "RED":
			button.setStyle("-fx-base: red; -fx-font-size:50px;");
			break;
		case "BLUE":
			button.setStyle("-fx-base: blue; -fx-font-size:50px;");
			break;
		case "GREEN":
			button.setStyle("-fx-base: green; -fx-font-size:50px;");
			break;
		case "BLACK":
			button.setStyle("-fx-base: black; -fx-font-size:50px;");
			break;
		case "YELLOW":
			button.setStyle("-fx-base: yellow; -fx-font-size:50px;");
			break;
		case "?":
			button.setStyle("-fx-base: white; -fx-font-size:50px;");
			break;
		}
	}
	
	public void setMyHand() {
		isMyHand = true;
		
		btnDiscard.setVisible(true);
		btnPutOnBoard.setVisible(true);
		btnGiveNumHint.setVisible(false);
		btnGiveColorHint.setVisible(false);
		
		disableHand();
	}
	
	public void setPartnerHand() {
		isMyHand = false;
		
		btnDiscard.setVisible(false);
		btnPutOnBoard.setVisible(false);
		btnGiveNumHint.setVisible(true);
		btnGiveColorHint.setVisible(true);
		
		disableHand();
	}
	
	private void disableHand() {
		for (Button button : buttons) {
			button.setDisable(true);
		}
	}
	
	@FXML
	private void initialize() {
		buttons = new ArrayList<Button>();
		
		buttons.add(btnCard1);
		buttons.add(btnCard2);
		buttons.add(btnCard3);
		buttons.add(btnCard4);
		buttons.add(btnCard5);
	}
}
