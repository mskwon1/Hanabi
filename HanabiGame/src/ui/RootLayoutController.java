package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

import application.HanabiAssistant;
import entity.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logic.GameManager;

public class RootLayoutController {
	private HanabiAssistant assistant;
	private GameManager gm;
	
	private HandPaneController myController;
	private HandPaneController partnerController;
	private TokenPaneController tokenController;
	private UpboardPaneController upboardController;
	
	@FXML
	private AnchorPane myHand;
	@FXML
	private AnchorPane partnerHand;
	
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
	
	public RootLayoutController() {
	}
	
	public void setAssistant(HanabiAssistant assistant) {
		this.assistant = assistant;
	}
	
	@FXML
	private void handleTurnEnd() {
		Queue<Player> turnQueue = gm.getTurnQueue();
		
		Player tempPlayer = turnQueue.poll();
		myController.setHand(tempPlayer);
		turnQueue.add(tempPlayer);
		
		tempPlayer = turnQueue.poll();
		partnerController.setHand(tempPlayer);
		turnQueue.add(tempPlayer);
		
		tokenController.refreshToken();
		upboardController.refreshUpcards();
	}
	
	@FXML
	private void initialize() {
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("A"));
		playerList.add(new Player("B"));

		gm = new GameManager(playerList);
		gm.startGame();
		
		Queue<Player> turnQueue = gm.getTurnQueue();
		
		try {
			// 내 핸드 SET
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/HandPane.fxml"));
			AnchorPane loadedPane = (AnchorPane) loader.load();
			
			myController = loader.getController();
			myController.setMyHand();
			myController.setGM(gm);
			
			Player tempPlayer = turnQueue.poll();
			myController.setHand(tempPlayer);
			turnQueue.add(tempPlayer);
			
			myHand.getChildren().add(loadedPane);

			// 파트너 핸드 SET
			loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/HandPane.fxml"));
			loadedPane = (AnchorPane) loader.load();
			
			partnerController = loader.getController();
			partnerController.setPartnerHand();
			partnerController.setGM(gm);
			
			tempPlayer = turnQueue.poll();
			partnerController.setHand(tempPlayer);
			turnQueue.add(tempPlayer);
			
			partnerHand.getChildren().add(loadedPane);
	
			// 토큰 SET
			loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/TokenPane.fxml"));
			loadedPane = (AnchorPane) loader.load();
	
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
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
