package ui;

import java.io.IOException;

import application.HanabiAssistant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class RootLayoutController {
	private HanabiAssistant assistant;
	
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
	private Button graveButton;
	
	public RootLayoutController() {

	}
	
	public void setAssistant(HanabiAssistant assistant) {
		this.assistant = assistant;
	}
	
	@FXML
	private void initialize() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HanabiAssistant.class.getResource("/fxml/HandPane.fxml"));
			AnchorPane loadedPane = (AnchorPane) loader.load();
			
			myHand.getChildren().add(loadedPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
