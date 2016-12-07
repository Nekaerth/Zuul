/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author niklasbruun
 */
public class AlertBox {

	public static boolean shouldExit = false;
	public static boolean isCodeCorrect = false;

	public static boolean tryCode(int code) {
		Stage window = new Stage();
		window.initModality(Modality.WINDOW_MODAL);
		window.setTitle("Code");
		window.setMinWidth(300);
		window.setMinHeight(200);

		TextField textfield = new TextField();
		textfield.setMaxWidth(100);
		textfield.setMaxHeight(50);

		Label label = new Label();
		label.setText("Type in your 3-digit code:");

		Button enterButton = new Button("Enter");

		enterButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String inputText = textfield.getText();
				if (inputText.length() == 3 && isANumber(inputText)) {
					window.close();
					if (true) {

					}
				}
			}
		});

		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, textfield, enterButton);
		layout.setAlignment(Pos.CENTER);

		Scene alertBox = new Scene(layout);
		window.setScene(alertBox);
		window.showAndWait();
		return false;
	}

	public static boolean exitInfoBox() {
		shouldExit = false;

		Stage window = new Stage();
		window.initModality(Modality.WINDOW_MODAL);
		window.setTitle("Exit game?");
		window.setMinWidth(300);
		window.setMinHeight(200);

		Label label = new Label();
		label.setText("Are you sure you want to exit?\n" + "Any progress you've made so far will be deleted.");

		Button yesButton = new Button("Yes");
		Button noButton = new Button("No");

		yesButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				window.close();
				shouldExit = true;
			}
		});

		noButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});

		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, yesButton, noButton);
		layout.setAlignment(Pos.CENTER);

		Scene alertBox = new Scene(layout);
		window.setScene(alertBox);
		window.showAndWait();
		return shouldExit;
	}

	private static boolean isANumber(String text) {
		try {
			Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
