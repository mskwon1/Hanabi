package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

import application.HanabiAssistant;
import entity.Card;
import entity.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import logic.GameManager;

public class RootLayoutController {
	private HanabiAssistant assistant;
	
	private GameManager gm;
	
	private TokenPaneController tokenController;
	private UpboardPaneController upboardController;
	private ScorePaneController scoreController;
	
	@FXML
	private HBox opHand;
	
	@FXML
	private HBox myHand;
	
	@FXML
	private AnchorPane scorePane;
	@FXML
	private AnchorPane upboardPane;
	@FXML
	private AnchorPane tokenPane;
	
	@FXML
	private Button endButton;
	@FXML
	private Button graveButton;
	
	@FXML
	private Button btnNumHint;
	@FXML
	private Button btnColorHint;
	@FXML
	private Label lbNumber;
	@FXML
	private Label lbColor;
	
	@FXML
	private Button btnPut;
	@FXML
	private Button btnDiscard;
	
	private Player myPlayer;
	private Player opPlayer;
	
	private int currentIndex;
	
	public RootLayoutController() {
	}
	
	@FXML
	private void initialize() {
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("A"));
		playerList.add(new Player("B"));

		gm = new GameManager(playerList);
		gm.startGame();
		
		Queue<Player> turnQueue = gm.getTurnQueue();
		
		myPlayer = gm.getNextPlayer();
		setHand(myPlayer, myHand, 0);
		
		opPlayer = gm.getNextPlayer();
		setHand(opPlayer, opHand, 1);
		
		disableHintButtons();
		disableCardButtons();
		
		try {
	
			// 토큰 SET
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/TokenPane.fxml"));
			AnchorPane loadedPane = (AnchorPane) loader.load();
	
			tokenController = loader.getController();
			tokenController.setTokenManager(gm.getTokenManager());
			
			tokenPane.getChildren().add(loadedPane);
			
			// 업카드 SET
			loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/UpboardPane.fxml"));
			loadedPane = (AnchorPane) loader.load();
	
			upboardController = loader.getController();
			upboardController.setUpcards(gm.getUpcards());
			
			upboardPane.getChildren().add(loadedPane);
			
			// 스코어 SET
			loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/ScorePane.fxml"));
			loadedPane = (AnchorPane) loader.load();
	
			scoreController = loader.getController();
			scoreController.refreshScore(gm.getTurnCount(), gm.getScore(), gm.getLeftCards());
			
			scorePane.getChildren().add(loadedPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setAssistant(HanabiAssistant assistant) {
		this.assistant = assistant;
	}
	
	@FXML
	private void onGrave() {
		showAlert("TEST");
	}
	
	@FXML
	private void handleOp1() {
		enableHintButtons();
		disableCardButtons();
		currentIndex = 0; 
		lbNumber.setText("" + opPlayer.getHand().get(currentIndex).getNum());
		lbColor.setText(opPlayer.getHand().get(currentIndex).getColor().name());
	}
	
	@FXML
	private void handleOp2() {
		enableHintButtons();
		disableCardButtons();
		currentIndex = 1; 
		lbNumber.setText("" + opPlayer.getHand().get(currentIndex).getNum());
		lbColor.setText(opPlayer.getHand().get(currentIndex).getColor().name());
	}
	
	@FXML
	private void handleOp3() {
		enableHintButtons();
		disableCardButtons();
		currentIndex = 2; 
		lbNumber.setText("" + opPlayer.getHand().get(currentIndex).getNum());
		lbColor.setText(opPlayer.getHand().get(currentIndex).getColor().name());
	}
	
	@FXML
	private void handleOp4() {
		enableHintButtons();
		disableCardButtons();
		currentIndex = 3; 
		lbNumber.setText("" + opPlayer.getHand().get(currentIndex).getNum());
		lbColor.setText(opPlayer.getHand().get(currentIndex).getColor().name());
	}
	
	@FXML
	private void handleOp5() {
		enableHintButtons();
		disableCardButtons();
		currentIndex = 4; 
		lbNumber.setText("" + opPlayer.getHand().get(currentIndex).getNum());
		lbColor.setText(opPlayer.getHand().get(currentIndex).getColor().name());
	}
	
	@FXML
	private void onNumberHint() {
		boolean success = gm.giveNumHint(opPlayer, currentIndex);
		
		if (!success) {
			showAlert("파란 토큰이 부족합니다!");
			return;
		}
		
		lbNumber.setText("");
		lbColor.setText("");
		
		disableHintButtons();
		switchPlayers();
		refreshPanes();
	}
	
	@FXML
	private void onColorHint() {
		boolean success = gm.giveColorHint(opPlayer, currentIndex);

		if (!success) {
			showAlert("파란 토큰이 부족합니다!");
			return;
		}
		
		lbNumber.setText("");
		lbColor.setText("");
		
		disableHintButtons();
		switchPlayers();
		refreshPanes();
	}
	
	@FXML
	private void handleMy1() {
		enableCardButtons();
		disableHintButtons();
		currentIndex = 0;
	}
	
	@FXML
	private void handleMy2() {
		enableCardButtons();
		disableHintButtons();
		currentIndex = 1;
	}
	
	@FXML
	private void handleMy3() {
		enableCardButtons();
		disableHintButtons();
		currentIndex = 2;
	}
	
	@FXML
	private void handleMy4() {
		enableCardButtons();
		disableHintButtons();
		currentIndex = 3;
	}
	
	@FXML
	private void handleMy5() {
		enableCardButtons();
		disableHintButtons();
		currentIndex = 4;
	}
	
	@FXML
	private void handlePut() {
		boolean success = gm.putOnBoard(myPlayer, currentIndex);
		
		if (!success) {
			showAlert("Unavailable Card to put, 1 RED TOKEN REMOVED");
		}
		
		lbNumber.setText("");
		lbColor.setText("");
		
		disableCardButtons();
		switchPlayers();
		refreshPanes();
	}
	
	@FXML
	private void handleDiscard() {
		gm.discard(myPlayer, currentIndex);
		
		lbNumber.setText("");
		lbColor.setText("");
		
		disableCardButtons();
		switchPlayers();
		refreshPanes();
	}
	
	private void setHand(Player player, HBox hand, int mod) {		
		ArrayList<Card> tempHand = player.getHand();
		
		for (int i=0; i<5; i++) {
			Button tempBtn = (Button) hand.getChildren().get(i);
			if (i+1 > tempHand.size()) {
				tempBtn.setText("");
				setColor(tempBtn, "?");
				tempBtn.setDisable(true);
			} else {
				Card tempCard = tempHand.get(i);
				tempBtn.setDisable(false);
				if (mod == 0) {
					tempBtn.setText(tempCard.getNumWithHint());
					setColor(tempBtn, tempCard.getColorWithHint());
				} else {
					String tempStr = "";					
					tempStr += tempCard.getNum();
					tempBtn.setText(tempStr);
					
					setColor(tempBtn, tempCard.getColor().name());
				}
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
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initOwner(assistant.getPrimaryStage());
		alert.setTitle("Hanabi");
		alert.setHeaderText("실패");
		alert.setContentText(message);
		
		alert.showAndWait();
	}
	
	private void enableHintButtons() {
		btnNumHint.setDisable(false);
		btnColorHint.setDisable(false);
	}
	
	private void disableHintButtons() {
		btnNumHint.setDisable(true);
		btnColorHint.setDisable(true);
	}
	
	private void enableCardButtons() {
		btnPut.setDisable(false);
		btnDiscard.setDisable(false);
	}
	
	private void disableCardButtons() {
		btnPut.setDisable(true);
		btnDiscard.setDisable(true);
	}
	
	private void switchPlayers() {
		Player tempPlayer = myPlayer;
		myPlayer = opPlayer;
		opPlayer = tempPlayer;

		setHand(myPlayer, myHand, 0);
		setHand(opPlayer, opHand, 1);
	}
	
	private void refreshPanes() {
		scoreController.refreshScore(gm.getTurnCount(), gm.getScore(), gm.getLeftCards());
		tokenController.refreshToken();
		upboardController.refreshUpcards();
		
		if (gm.isEnd()) {
			showAlert("카드를 모두 소모했습니다. 게임오버!\n점수 = " + gm.getScore());
		}
		
		if (gm.getTokenManager().getRedToken() == 0) {
			showAlert("빨간 토큰을 모두 소모했습니다. 게임오버!");
			myHand.setDisable(true);
			opHand.setDisable(true);
		}
	}
}
