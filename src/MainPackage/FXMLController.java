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
	private ListView<Item> roomSceneItemList;
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

	}

	@FXML
	private void handleStartMenuButtons(ActionEvent event) {
		if (event.getSource() == startMenuStartButton) {
			startGame();
			setAllButOneMainSceneInvisible(difficultyScene);
		} else if (event.getSource() == startMenuHighScoreButton) {
			setAllButOneMainSceneInvisible(highScoreScene);
		} else if (event.getSource() == startMenuQuitButton) {
			Stage stage = (Stage) startMenuQuitButton.getScene().getWindow();
			stage.close();
		}
	}

	@FXML
	private void handleDifficultySceneButtons(ActionEvent event) {
		if (event.getSource() == difficultySceneEasyButton) {
			bottomMenuLevelLabel.setText("Level: Easy");
			setAllButOneMainSceneInvisible(gameScene);
			setAllButOneGameSceneInvisible(roomScene);
		} else if (event.getSource() == difficultySceneMediumButton) {
			bottomMenuLevelLabel.setText("Level: Medium");
			setAllButOneMainSceneInvisible(gameScene);
			setAllButOneGameSceneInvisible(roomScene);
		} else if (event.getSource() == difficultySceneHardButton) {
			bottomMenuLevelLabel.setText("Level: Hard");
			setAllButOneMainSceneInvisible(gameScene);
			setAllButOneGameSceneInvisible(roomScene);
		} else if (event.getSource() == difficultySceneBackButton) {
			setAllButOneMainSceneInvisible(startMenu);
		}
	}

	@FXML
	private void handleGameMenuButtons(ActionEvent event) {
		if (event.getSource() == topMenuExitButton) {
			setAllButOneMainSceneInvisible(startMenu);
		} else if (event.getSource() == topMenuHelpButton) {
			setAllButOneGameSceneInvisible(helpScene);
		} else if (event.getSource() == topMenuInventoryButton) {
			setAllButOneGameSceneInvisible(inventoryScene);
			inventorySceneItemAmountLabel.setText("Item amount: " + game.getCurrentItemAmount() + "/" + game.getItemCapacity());
			inventorySceneWeightLabel.setText("Weight: " + game.getCurrentWeight() + "/" + game.getWeightCapacity());
		} else if (event.getSource() == bottomMenuMapButton) {
			setAllButOneGameSceneInvisible(mapScene);
		}
	}

	@FXML
	private void handleRoomSceneButtons(ActionEvent event) {
		if (event.getSource() == roomSceneUseButton) {
			if (currentItem != null) {
				if (!game.use(currentItem)) {
					roomSceneInfoLabel.setText("You can't use " + currentItem.getName() + " here!");
				}
			}
			updateWeightAndItemAmount();
		} else if (event.getSource() == roomScenePickUpButton) {
			Item selectedItem = roomSceneItemList.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				if (!game.pickUp(selectedItem)) {
					roomSceneInfoLabel.setText("You can't pick " + selectedItem.getName() + " up!");
				}
			}
			updateWeightAndItemAmount();
		} else if (event.getSource() == roomSceneNorthButton) {

		} else if (event.getSource() == roomSceneEastButton) {

		} else if (event.getSource() == roomSceneSouthButton) {

		} else if (event.getSource() == roomSceneWestButton) {

		}
	}

	@FXML
	private void handleHelpCloseButton(ActionEvent event) {
		setAllButOneGameSceneInvisible(roomScene);
	}

	@FXML
	private void handleInventoryButtons(ActionEvent event) {
		if (event.getSource() == inventorySceneDropButton) {
			Item selectedItem = inventorySceneItemList.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				game.drop(selectedItem);
			}
			updateWeightAndItemAmount();
		} else if (event.getSource() == inventorySceneChooseButton) {
			currentItem = inventorySceneItemList.getSelectionModel().getSelectedItem();
			if (currentItem != null) {
				roomSceneCurrentItemLabel.setText("Current Item: " + currentItem.getName());
				inventorySceneCurrentItemLabel.setText("Current Item: " + currentItem.getName());
			}
		} else if (event.getSource() == inventorySceneCloseButton) {
			setAllButOneGameSceneInvisible(roomScene);
		}
	}

	@FXML
	private void handleMapCloseButton(ActionEvent event) {
		setAllButOneGameSceneInvisible(roomScene);
	}

	@FXML
	private void handleHighScoreSceneCloseButton(ActionEvent event) {
		setAllButOneMainSceneInvisible(startMenu);
	}

	@FXML
	private void handleVictorySceneEnterButton(ActionEvent event) {
		setAllButOneMainSceneInvisible(startMenu);
		String name = victorySceneTextField.getText();
		int highscore = game.getHighScore();
		game.saveHighScore(name, highscore);
	}

	@FXML
	private void handleGameOverSceneExitButton(ActionEvent event) {
		setAllButOneMainSceneInvisible(startMenu);
	}

	private void setAllButOneGameSceneInvisible(Pane pane) {
		if (pane != roomScene) {
			roomScene.setVisible(false);
		}
		if (pane != helpScene) {
			helpScene.setVisible(false);
		}
		if (pane != inventoryScene) {
			inventoryScene.setVisible(false);
		}
		if (pane != mapScene) {
			mapScene.setVisible(false);
		}
		if (pane != bossScene) {
			bossScene.setVisible(false);
		}
		pane.setVisible(true);
	}

	private void setAllButOneMainSceneInvisible(Pane pane) {
		if (pane != startMenu) {
			startMenu.setVisible(false);
		}
		if (pane != difficultyScene) {
			difficultyScene.setVisible(false);
		}
		if (pane != gameScene) {
			gameScene.setVisible(false);
		}
		if (pane != highScoreScene) {
			highScoreScene.setVisible(false);
		}
		if (pane != victoryScene) {
			victoryScene.setVisible(false);
		}
		if (pane != gameOverScene) {
			gameOverScene.setVisible(false);
		}
		pane.setVisible(true);
	}

	private void updateWeightAndItemAmount() {
		topMenuCapacityLabel.setText("Item Amount: " + game.getCurrentItemAmount() + "/" + game.getItemCapacity() + "\nWeight: " + game.getCurrentWeight() + "/" + game.getWeightCapacity());
		inventorySceneItemAmountLabel.setText("Item Amount: " + game.getCurrentItemAmount() + "/" + game.getItemCapacity());
		inventorySceneWeightLabel.setText("Weight: " + game.getCurrentWeight() + "/" + game.getWeightCapacity());
	}

	private void startGame() {
		game = new GamePlay();
		game.constructWorld("testfile.dne");
		//updates the players inventory
		inventorySceneItemList.setItems(game.getPlayerInventory());
		//updates the current rooms inventory
		roomSceneItemList.setItems(game.getCurrentRoomInventory());
		//updates the time label (lav en general metode senere)
		if (game.getTime() % 60 < 10) {
			topMenuTimeLabel.setText("Time: " + game.getTime() / 60 + ":0" + game.getTime() % 60);
		} else {
			topMenuTimeLabel.setText("Time: " + game.getTime() / 60 + ":" + game.getTime() % 60);
		}
		//updates the capacity labels
		updateWeightAndItemAmount();
		//updates the current room label
		bottomMenuCurrentRoomLabel.setText(game.getCurrentRoom().getName());
		//updates the info label
		roomSceneInfoLabel.setText("");
		//updates the current chosen item label
		roomSceneCurrentItemLabel.setText("Current Item: None");
	}
}
