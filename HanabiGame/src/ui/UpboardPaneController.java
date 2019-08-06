package ui;

import board.Upcards;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UpboardPaneController {
	@FXML
	private Label red;
	@FXML
	private Label blue;
	@FXML
	private Label green;
	@FXML
	private Label black;
	@FXML
	private Label yellow;
	
	private Upcards upcards;
	
	public UpboardPaneController() {
		
	}
	
	public void setUpcards(Upcards upcards) {
		this.upcards = upcards;
		
		refreshUpcards();
	}
	
	public void refreshUpcards() {
		String[] oncards = {"","","","","",""};
		for (int i=0;i<5;i++) {
			oncards[i] += upcards.getOnCards()[i];
		}
		
		red.setText(oncards[0]);
		blue.setText(oncards[1]);
		green.setText(oncards[2]);
		black.setText(oncards[3]);
		yellow.setText(oncards[4]);
	}
	
	@FXML
	private void initailize() {
		
	}
}