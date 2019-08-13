package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import logic.TokenManager;

public class TokenPaneController {
	@FXML
	private Label lbBlue;
	@FXML
	private Label lbRed;
	
	private TokenManager tokenManager;
	
	public TokenPaneController() {
		
	}
	
	public void setTokenManager(TokenManager tokenManager) {
		this.tokenManager = tokenManager;

		refreshToken();
	}
	
	public void refreshToken() {
		String blue = "", red = "";
		blue += tokenManager.getBlueToken();
		red += tokenManager.getRedToken();
		
		lbBlue.setText(blue);
		lbRed.setText(red);
	}
	
	@FXML
	private void initialize() {
		
	}
}
