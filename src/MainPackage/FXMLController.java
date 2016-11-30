/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import Items.Item;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lasse
 */
public class FXMLController implements Initializable {

	private GamePlay game;
	private Item currentItem = null;

	//Main Pane
	@FXML
	private Pane prisonBreak;

	//In game Pane
	@FXML
	private Pane gameScene;
	//Top menu HBox
	@FXML
	private HBox topMenu;
	@FXML
	private Button topMenuExitButton;
	@FXML
	private Button topMenuHelpButton;
	@FXML
	private Label topMenuTimeLabel;
	@FXML
	private Button topMenuInventoryButton;
	@FXML
	private Label topMenuCapacityLabel;
	//Bottom menu HBox
	@FXML
	private HBox bottomMenu;
	@FXML
	private Button bottomMenuMapButton;
	@FXML
	private Label bottomMenuCurrentRoomLabel;
	@FXML
	private Label bottomMenuLevelLabel;
	//Room Pane
	@FXML
	private Pane roomScene;
	@FXML
	private Label roomSceneInfoTitel;
	@FXML
	private Label roomSceneInfoLabel;
	@FXML
	private Label roomSceneCurrentItemLabel;
	@FXML
	private Button roomSceneUseButton;
	@FXML
	private Label roomSceneItemLabel;
	@FXML
	private ListView<?> roomSceneItemList;
	@FXML
	private Button roomScenePickUpButton;
	@FXML
	private Button roomSceneNorthButton;
	@FXML
	private Button roomSceneEastButton;
	@FXML
	private Button roomSceneSouthButton;
	@FXML
	private Button roomSceneWestButton;
	//Help Pane
	@FXML
	private Pane helpScene;
	@FXML
	private Label helpSceneTitle;
	@FXML
	private TextArea helpSceneTextArea;
	@FXML
	private Button helpSceneCloseButton;
	//Inventory Pane
	@FXML
	private Pane inventoryScene;
	@FXML
	private Label inventorySceneTitle;
	@FXML
	private ListView<Item> inventorySceneItemList;
	@FXML
	private Button inventorySceneDropButton;
	@FXML
	private Button inventorySceneChooseButton;
	@FXML
	private Label inventorySceneCurrentItemLabel;
	@FXML
	private Label inventorySceneItemAmountLabel;
	@FXML
	private Label inventorySceneWeightLabel;
	@FXML
	private Button inventorySceneCloseButton;
	//Map Pane
	@FXML
	private Pane mapScene;
	@FXML
	private Label mapSceneTitle;
	@FXML
	private Button mapSceneCloseButton;
	//Boss Pane
	@FXML
	private Pane bossScene;

	//Start menu Pane
	@FXML
	private Pane startMenu;
	@FXML
	private Label startMenuTitel;
	@FXML
	private Button startMenuStartButton;
	@FXML
	private Button startMenuHighScoreButton;
	@FXML
	private Button startMenuQuitButton;

	//Difficulty Pane
	@FXML
	private Pane difficultyScene;
	@FXML
	private Label difficultySceneTitle;
	@FXML
	private Button difficultySceneEasyButton;
	@FXML
	private Button difficultySceneMediumButton;
	@FXML
	private Button difficultySceneHardButton;
	@FXML
	private Button difficultySceneBackButton;

	//High score Pane
	@FXML
	private Pane highScoreScene;
	@FXML
	private Label highScoreSceneTitle;
	@FXML
	private ListView<?> highScoreSceneScoreList;
	@FXML
	private Button highScoreSceneBackButton;

	//Victory Pane
	@FXML
	private Pane victoryScene;
	@FXML
	private Label victorySceneTitle;
	@FXML
	private Label victorySceneScoreLabel;
	@FXML
	private Label victorySceneNameLabel;
	@FXML
	private TextField victorySceneTextField;
	@FXML
	private Button victorySceneEnterButton;

	//Game over Pane
	@FXML
	private Pane gameOverScene;
	@FXML
	private Label gameOverSceneTitle;
	@FXML
	private Button gameOverSceneExitButton;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		game = new GamePlay();
		game.constructWorld("testfile.dne");
		inventorySceneItemList.setItems(game.getPlayerInventory());
		topMenuCapacityLabel.setText("Item Amount: " + game.getCurrentItemAmount() + "/" + game.getItemCapacity() + "\nWeight: " + game.getCurrentWeight() + "/" + game.getWeightCapacity());
	}

	@FXML
	private void handleStartMenuButtons(ActionEvent event) {
		if (event.getSource() == startMenuStartButton) {
			startMenu.setVisible(false);
			difficultyScene.setVisible(true);
		} else if (event.getSource() == startMenuHighScoreButton) {
			startMenu.setVisible(false);
			highScoreScene.setVisible(true);
		} else if (event.getSource() == startMenuQuitButton) {
			Stage stage = (Stage) startMenuQuitButton.getScene().getWindow();
			stage.close();
		}
	}

	@FXML
	private void handleDifficultySceneButtons(ActionEvent event) {
		if (event.getSource() == difficultySceneEasyButton) {
			difficultyScene.setVisible(false);
			gameScene.setVisible(true);
			roomScene.setVisible(true);
		} else if (event.getSource() == difficultySceneMediumButton) {
			difficultyScene.setVisible(false);
			gameScene.setVisible(true);
		} else if (event.getSource() == difficultySceneHardButton) {
			difficultyScene.setVisible(false);
			gameScene.setVisible(true);
		} else if (event.getSource() == difficultySceneBackButton) {
			difficultyScene.setVisible(false);
			startMenu.setVisible(true);
		}
	}

	@FXML
	private void handleGameMenuButtons(ActionEvent event) {
		if (event.getSource() == topMenuExitButton) {
			gameScene.setVisible(false);
			startMenu.setVisible(true);
		} else if (event.getSource() == topMenuHelpButton) {
			roomScene.setVisible(false);
			helpScene.setVisible(true);
		} else if (event.getSource() == topMenuInventoryButton) {
			roomScene.setVisible(false);
			inventoryScene.setVisible(true);
			inventorySceneItemAmountLabel.setText("Item amount: " + game.getCurrentItemAmount() + "/" + game.getItemCapacity());
			inventorySceneWeightLabel.setText("Weight: " + game.getCurrentWeight() + "/" + game.getWeightCapacity());
		} else if (event.getSource() == bottomMenuMapButton) {
			roomScene.setVisible(false);
			mapScene.setVisible(true);
		}
	}

	@FXML
	private void handleRoomSceneButtons(ActionEvent event) {
		if (event.getSource() == roomSceneUseButton) {

		} else if (event.getSource() == roomScenePickUpButton) {

		} else if (event.getSource() == roomSceneNorthButton) {

		} else if (event.getSource() == roomSceneEastButton) {

		} else if (event.getSource() == roomSceneSouthButton) {

		} else if (event.getSource() == roomSceneWestButton) {

		}
	}

	@FXML
	private void handleHelpCloseButton(ActionEvent event) {
		helpScene.setVisible(false);
		roomScene.setVisible(true);
	}

	@FXML
	private void handleInventoryButtons(ActionEvent event) {
		if (event.getSource() == inventorySceneDropButton) {
			if (currentItem != null) {
				game.drop(currentItem);
			}
		} else if (event.getSource() == inventorySceneChooseButton) {
			currentItem = inventorySceneItemList.getSelectionModel().getSelectedItem();
			if (currentItem != null) {
				roomSceneCurrentItemLabel.setText("Current Item: " + currentItem.getName());
				inventorySceneCurrentItemLabel.setText("Current Item: " + currentItem.getName());
			}
		} else if (event.getSource() == inventorySceneCloseButton) {
			inventoryScene.setVisible(false);
			roomScene.setVisible(true);
		}
	}

	@FXML
	private void handleMapCloseButton(ActionEvent event) {
		mapScene.setVisible(false);
		roomScene.setVisible(true);
	}

	@FXML
	private void handleHighScoreSceneCloseButton(ActionEvent event) {
		highScoreScene.setVisible(false);
		startMenu.setVisible(true);
	}

	@FXML
	private void handleVictorySceneEnterButton(ActionEvent event) {
		gameOverScene.setVisible(false);
		startMenu.setVisible(true);
		String name = victorySceneTextField.getText();
		int highscore = game.getHighScore();
		game.saveHighScore(name, highscore);
	}

	@FXML
	private void handleGameOverSceneExitButton(ActionEvent event) {
		gameOverScene.setVisible(false);
		startMenu.setVisible(true);
	}

	private void setAllGameSceneInvisibleButOne(Pane pane) {
		if (pane != roomScene) {
			roomScene.setVisible(false);
		}
		if (pane != helpScene) {
			roomScene.setVisible(false);
		}
		if (pane != inventoryScene) {
			roomScene.setVisible(false);
		}
		if (pane != mapScene) {
			roomScene.setVisible(false);
		}
		if (pane != bossScene) {
			roomScene.setVisible(false);
		}
		pane.setVisible(true);
	}
}
