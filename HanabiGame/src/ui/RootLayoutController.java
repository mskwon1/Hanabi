package ui;

import java.io.IOException;
import java.util.ArrayList;

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
			AnchorPane tempPane = (AnchorPane) myHand.getChildren().get(0);
			
			myHand.getChildren().set(0, partnerHand.getChildren().get(0));
			partnerHand.getChildren().add(tempPane);
			
	}
	
	@FXML
	private void initialize() {
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("A"));
		playerList.add(new Player("B"));

		gm = new GameManager(playerList);
		gm.startGame();
		
		try {
			// 내 핸드 SET
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/HandPane.fxml"));
			AnchorPane loadedPane = (AnchorPane) loader.load();
			
			HandPaneController myController = loader.getController();
			myController.setMyHand();
			myController.setGM(gm);
			myController.setHand(gm.getPlayer().get(0));
			
			myHand.getChildren().add(loadedPane);

			// 파트너 핸드 SET
			loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/HandPane.fxml"));
			loadedPane = (AnchorPane) loader.load();
			
			HandPaneController partnerController = loader.getController();
			partnerController.setPartnerHand();
			partnerController.setGM(gm);
			partnerController.setHand(gm.getPlayer().get(1));
			
			partnerHand.getChildren().add(loadedPane);					
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
