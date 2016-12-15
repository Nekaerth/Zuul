package MainPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	private static String code;
	private static boolean shouldExit;

	/**
	 * Calls this method when currentRoom is escapableRoom and ask for a code.
	 * 
	 * @return 
	 */
	public static String getCode() {
		code = null;

		Stage window = new Stage();
		window.initModality(Modality.WINDOW_MODAL);
		window.setTitle("Code");

		Label label = new Label("Type in your 3-digit code:");
		label.setPrefWidth(360);
		label.setAlignment(Pos.CENTER);
		label.setLayoutX(0);
		label.setLayoutY(30);

		TextField textField = new TextField();
		textField.setPrefWidth(120);
		textField.setLayoutX(120);
		textField.setLayoutY(55);

		Button enterButton = new Button("Enter");
		enterButton.setPrefWidth(90);
		enterButton.setPrefHeight(30);
		enterButton.setLayoutX(80);
		enterButton.setLayoutY(110);

		Button cancelButton = new Button("Cancel");
		cancelButton.setPrefWidth(90);
		cancelButton.setPrefHeight(30);
		cancelButton.setLayoutX(190);
		cancelButton.setLayoutY(110);

		enterButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String inputText = textField.getText();
				if (inputText.length() == 3 && isANumber(inputText)) {
					window.close();
					code = inputText;
				}
			}
		});

		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});

		Pane pane = new Pane();
		pane.getChildren().addAll(label, textField, enterButton, cancelButton);
		pane.setPrefWidth(360);
		pane.setPrefHeight(200);

		Scene alertBox = new Scene(pane);

		window.setScene(alertBox);
		window.showAndWait();
		return code;
	}

	/**
	 * Calls this method if you click the exitButton, ask if you are sure you want to quit
	 * 
	 * @return 
	 */
	public static boolean shouldExit() {
		shouldExit = false;

		Stage window = new Stage();
		window.initModality(Modality.WINDOW_MODAL);
		window.setTitle("Exit");
		//Makes first label and sets size and coordinates
		Label label = new Label("Are you sure you want to exit this game?");
		label.setPrefWidth(360);
		label.setAlignment(Pos.CENTER);
		label.setLayoutX(0);
		label.setLayoutY(30);
		//Makes second label and sets size and coordinates
		Label label2 = new Label("Any progress you've made so far will be deleted.");
		label2.setPrefWidth(360);
		label2.setAlignment(Pos.CENTER);
		label2.setLayoutX(0);
		label2.setLayoutY(50);

		Button exitButton = new Button("Exit");
		exitButton.setPrefWidth(90);
		exitButton.setPrefHeight(30);
		exitButton.setLayoutX(80);
		exitButton.setLayoutY(100);

		Button cancelButton = new Button("Cancel");
		cancelButton.setPrefWidth(90);
		cancelButton.setPrefHeight(30);
		cancelButton.setLayoutX(190);
		cancelButton.setLayoutY(100);

		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				window.close();
				shouldExit = true;
			}
		});

		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				window.close();
			}
		});

		Pane pane = new Pane();
		pane.setPrefWidth(360);
		pane.setPrefHeight(200);
		pane.getChildren().addAll(label, label2, exitButton, cancelButton);

		Scene scene = new Scene(pane);

		System.out.println(label.getPrefWidth() + ", " + label.getMinWidth() + ", " + label.getMaxWidth());

		window.setScene(scene);
		window.showAndWait();
		return shouldExit;
	}

	/**
	 * Checks if the code written, only consists of numbers, if so it returns true.
	 * 
	 * @param text
	 * @return 
	 */
	private static boolean isANumber(String text) {
		try {
			Integer.parseInt(text);
		} catch (NumberFormatException event) {
			return false;
		}
		return true;
	}
}
