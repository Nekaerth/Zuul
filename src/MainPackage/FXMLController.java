/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Lasse
 */
public class FXMLController implements Initializable {

	@FXML
	private Button exitButton;
	@FXML
	private Button helpButton;
	@FXML
	private Button inventoryButton;
	@FXML
	private Button mapButton;
	@FXML
	private Label timeLabel;
	@FXML
	private Label capacityLabel;
	@FXML
	private Label currentRoomLabel;
	@FXML
	private Label levelLabel;

	@FXML
	private void handleExitButton() {
		System.out.println("a");
	}

	@FXML
	private void handleHelpButton() {
		System.out.println("a");
	}

	@FXML
	private void handleInventoryButton() {
		System.out.println("a");
	}

	@FXML
	private void handleMapButton() {
		System.out.println("a");
	}

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//TODO
	}
}
