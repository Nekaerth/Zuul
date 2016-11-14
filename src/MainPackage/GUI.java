package MainPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Lasse
 */
public class GUI extends Application {

	private Scene menuScene;
	private double sceneWidth = 720;
	private double sceneHeight = 800;

	private void setMenuScene() {
		HBox layout = new HBox(10);

		Button exitButton = new Button();
		exitButton.setText("Exit");
		exitButton.setMinSize(sceneWidth / 5, 40);
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("exit");
			}
		});

		Button helpButton = new Button();
		helpButton.setText("Help");
		helpButton.setMinSize(sceneWidth / 5, 40);
		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("help");
			}
		});

		Button timeDisplay = new Button();
		timeDisplay.setText("Time");
		timeDisplay.setMinSize(sceneWidth / 5, 40);
		timeDisplay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("time");
			}
		});

		Button inventoryButton = new Button();
		inventoryButton.setText("Inventory");
		inventoryButton.setMinSize(sceneWidth / 5, 40);
		inventoryButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("inventory");
			}
		});

		Button capacityDisplay = new Button();
		capacityDisplay.setText("Weight/Capacity");
		capacityDisplay.setMinSize(sceneWidth / 5, 40);
		capacityDisplay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("capacityDisplay");
			}
		});

		layout.getChildren().addAll(exitButton, helpButton, timeDisplay, inventoryButton, capacityDisplay);
		menuScene = new Scene(layout, sceneWidth, sceneHeight);
	}

	@Override
	public void start(Stage primaryStage) {
		setMenuScene();

		primaryStage.setTitle("Prison Break");
		primaryStage.setScene(menuScene);
		primaryStage.show();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
