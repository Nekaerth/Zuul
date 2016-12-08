package MainPackage;

import HighscoreLoader.Score;
import Items.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

	private GUIdisplayable game;
	private Player player;
	private Boss currentBoss;
	private Item currentItem;
	private ArrayList<Room> alreadyMappedRooms = new ArrayList<>(); //Keeps track of which rooms has been printed on the map

	//Main Pane
	@FXML
	private Pane prisonBreak;

	//In game Pane
	@FXML
	private Pane gameScene;
	@FXML
	private Canvas gameSceneCanvas;
	//Top menu
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
	//bottom menu
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
	private GridPane mapSceneGridPane;
	@FXML
	private Button mapSceneCloseButton;
	//Boss Pane
	@FXML
	private Pane bossScene;
	@FXML
	private Label bossSceneTitle;
	@FXML
	private Label bossSceneBossAttackLabel;
	@FXML
	private Label bossSceneCounterMoveLabel;
	@FXML
	private Button bossSceneAttackButton1;
	@FXML
	private Button bossSceneAttackButton2;
	@FXML
	private Button bossSceneAttackButton3;
	@FXML
	private Button bossSceneAttackButton4;
	@FXML
	private Label bossSceneInfoLabel;
	@FXML
	private Label bossScenePlayerHitpointLabel;
	@FXML
	private Label bossSceneBossHitpointLabel;

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
	private Button difficultySceneBackButton;
	@FXML
	private ListView<String> difficultySceneMapList;
	//High score Pane
	@FXML
	private Pane highScoreScene;
	@FXML
	private Label highScoreSceneTitle;
	@FXML
	private ListView<Score> highScoreSceneScoreList;
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
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		game = new GamePlay();
		highScoreSceneScoreList.setItems(game.getHighScoreList());
		difficultySceneMapList.setItems(game.getListOfFiles());
		//Gives color to background
		GraphicsContext background = gameSceneCanvas.getGraphicsContext2D();
		background.setFill(Color.WHITE);
		background.fillRect(0, 40, 720, 720);
		background.fillRect(575, 760, 2, 40);
	}

	@FXML
	private void handleStartMenuButtons(ActionEvent event) {
		if (event.getSource() == startMenuStartButton) {
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
		String fileToRead = difficultySceneMapList.getSelectionModel().getSelectedItem();
		if (event.getSource() == difficultySceneEasyButton && fileToRead != null) {
			bottomMenuLevelLabel.setText("Level: " + fileToRead);
			setAllButOneMainSceneInvisible(gameScene);
			setAllButOneGameSceneInvisible(roomScene);
			startGame(fileToRead);
		}else if (event.getSource() == difficultySceneBackButton) {
			setAllButOneMainSceneInvisible(startMenu);
		}
	}

	@FXML
	private void handleGameMenuButtons(ActionEvent event) {
		if (event.getSource() == topMenuExitButton) {
			if (AlertBox.shouldExit()) {
				setAllButOneMainSceneInvisible(startMenu);
			}
		} else if (event.getSource() == topMenuHelpButton) {
			if (!bossScene.isVisible()) {
				setAllButOneGameSceneInvisible(helpScene);
			}
		} else if (event.getSource() == topMenuInventoryButton) {
			if (!bossScene.isVisible()) {
				setAllButOneGameSceneInvisible(inventoryScene);
				updateWeightAndItemAmount();
			}
		} else if (event.getSource() == bottomMenuMapButton) {
			if (!bossScene.isVisible()) {
				//Clears the map and the alreadyMappedRooms-list before constructing the map again
				mapSceneGridPane.getChildren().clear();
				alreadyMappedRooms.clear();
				updateMap(player.getRoom(), 2, 2);
				setAllButOneGameSceneInvisible(mapScene);
			}
		}
	}

	@FXML
	private void handleRoomSceneButtons(ActionEvent event) {
		if (event.getSource() == roomSceneUseButton) {
			use(currentItem);
		} else if (event.getSource() == roomScenePickUpButton) {
			Item selectedItem = roomSceneItemList.getSelectionModel().getSelectedItem();
			if (selectedItem != null) {
				if (!game.pickUp(selectedItem)) {
					roomSceneInfoLabel.setText("You can't pick " + selectedItem.getName() + " up!");
				}
				updateAndCheckTime();
				updateWeightAndItemAmount();
			}
		} else if (event.getSource() == roomSceneNorthButton) {
			goRoom(Direction.NORTH);
		} else if (event.getSource() == roomSceneEastButton) {
			goRoom(Direction.EAST);
		} else if (event.getSource() == roomSceneSouthButton) {
			goRoom(Direction.SOUTH);
		} else if (event.getSource() == roomSceneWestButton) {
			goRoom(Direction.WEST);
		}
	}

	@FXML
	private void handleHelpButtons(ActionEvent event) {
		setAllButOneGameSceneInvisible(roomScene);
	}

	@FXML
	private void handleInventoryButtons(ActionEvent event) {
		if (event.getSource() == inventorySceneDropButton) {
			Item selectedItem = inventorySceneItemList.getSelectionModel().getSelectedItem();
			//Drops only item, if a item is selected
			if (selectedItem != null) {
				game.drop(selectedItem);
			}
			//The two CurrentItemLabel is updated, if you drop the item that you have chosen as your current item
			if (selectedItem == currentItem) {
				updateCurrentItemLabel("None");
			}
			updateWeightAndItemAmount();
		} else if (event.getSource() == inventorySceneChooseButton) {
			currentItem = inventorySceneItemList.getSelectionModel().getSelectedItem();
			if (currentItem != null) {
				updateCurrentItemLabel(currentItem.getName());
			}
		} else if (event.getSource() == inventorySceneCloseButton) {
			setAllButOneGameSceneInvisible(roomScene);
		}
	}

	@FXML
	private void handleMapButtons(ActionEvent event) {
		setAllButOneGameSceneInvisible(roomScene);
	}

	@FXML
	private void handleBossButtons(ActionEvent event) {
		if (event.getSource() == bossSceneAttackButton1) {
			oneAttackCycle(player.getMoves().get(0));
		} else if (event.getSource() == bossSceneAttackButton2) {
			oneAttackCycle(player.getMoves().get(1));
		} else if (event.getSource() == bossSceneAttackButton3) {
			oneAttackCycle(player.getMoves().get(2));
		} else if (event.getSource() == bossSceneAttackButton4) {
			oneAttackCycle(player.getMoves().get(3));
		}
	}

	@FXML
	private void handleHighScoreSceneButtons(ActionEvent event) {
		setAllButOneMainSceneInvisible(startMenu);
	}

	@FXML
	private void handleVictorySceneButtons(ActionEvent event) {
		setAllButOneMainSceneInvisible(startMenu);
		String name = victorySceneTextField.getText();
		int highscore = game.calculateHighScore();
		game.saveHighScore(name, highscore);
	}

	@FXML
	private void handleGameOverSceneButtons(ActionEvent event) {
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

	private void startGame(String fileName) {
		game.constructWorld(fileName);
		player = game.getPlayer();
		//updates the players inventory
		inventorySceneItemList.setItems(player.getInventory().getAllItems());
		//updates the current rooms inventory
		roomSceneItemList.setItems(game.getCurrentRoomInventory());
		//updates the time label
		updateAndCheckTime();
		//updates the capacity labels
		updateWeightAndItemAmount();
		//updates the current room label
		bottomMenuCurrentRoomLabel.setText(player.getRoom().getName());
		//updates the info label
		roomSceneInfoLabel.setText("");
		//updates the current chosen item label in roomScene and in inventoryScene
		roomSceneCurrentItemLabel.setText("Current Item: None");
		inventorySceneCurrentItemLabel.setText("Current Item: None");
		//updates the help textarea
		helpSceneTextArea.setText(game.getHelpDescription());
	}

	private void updateAndCheckTime() {
		//Updates all time labels
		if (player.getTime() % 60 < 10) {
			topMenuTimeLabel.setText("Time: " + player.getTime() / 60 + ":0" + player.getTime() % 60);
		} else {
			topMenuTimeLabel.setText("Time: " + player.getTime() / 60 + ":" + player.getTime() % 60);
		}
		//Makes the game over, if time has run out
		if (player.getTime() == 0) {
			setAllButOneMainSceneInvisible(gameOverScene);
		}
	}

	private void updateWeightAndItemAmount() {
		int itemAmount = player.getInventory().getTotalItemCapacity();
		int itemCapacity = player.getMaxItemCapacity();
		int weight = player.getInventory().getTotalItemWeight();
		int Maxweight = player.getMaxWeight();

		topMenuCapacityLabel.setText("Item Amount: " + itemAmount + "/" + itemCapacity + "\nWeight: " + weight + "/" + Maxweight);
		inventorySceneItemAmountLabel.setText("Item Amount: " + itemAmount + "/" + itemCapacity);
		inventorySceneWeightLabel.setText("Weight: " + weight + "/" + Maxweight);
	}

	private void use(Item item) {
		//Checks if current item is null
		if (item == null) {
			roomSceneInfoLabel.setText("You have not selected an item to use!");
			return;
		}
		//Try using the item. If it fails the method stops. Otherwise it continue
		if (!game.use(item)) {
			roomSceneInfoLabel.setText("You can't use " + currentItem.getName() + " here!");
			return;
		}
		updateWeightAndItemAmount();
		//Set current item to null, if the item was used up
		if (!player.getInventory().getAllItems().contains(item)) {
			currentItem = null;
			updateCurrentItemLabel("None");
		}
		//Gives different messages in the info label depending on which item was used
		switch (item.getItemType()) {
			case KEY:
				Key key = (Key) item;
				roomSceneInfoLabel.setText("You have unlocked the door to " + key.getNameOfRoomThatFitsThisKey() + "!");
				break;
			case FLASHLIGHT:
				Flashlight flashlight = (Flashlight) item;
				//Updates info label depending on if you find something or not
				if (player.getRoom().hasEscapeCode()) {
					roomSceneInfoLabel.setText("You have used the flashlight. You find the number " + player.getRoom().getNumber() + ".\nYou have " + flashlight.getCharges() + " charges left!");
				} else {
					roomSceneInfoLabel.setText("You have used the flashlight. You find nothing!\nYou have " + flashlight.getCharges() + " charges left!");
				}
				break;
			case BLUEPRINT:
				roomSceneInfoLabel.setText("You examine the blueprint and discover all hidden rooms!");
				break;
			case BOLTCUTTER:
				roomSceneInfoLabel.setText("You use the bolt cutter to cut down the fence!\nYou can now go through the fence!s");
				break;
			default:
				break;
		}
	}

	private void goRoom(Direction direction) {
		Room previousRoom = player.getRoom();
		Room nextRoom = player.getRoom().getExit(direction);
		//Checks if there is a door in that direction
		if (nextRoom == null || nextRoom.isHidden()) {
			roomSceneInfoLabel.setText("There is no door in this direction.");
			return;
		}

		//TODO - Checks if the escapeable room is in that direction and if it is locked
		/*
		if (nextRoom.isEscapeableRoom() && nextRoom.isLocked()) {
			roomSceneInfoLabel.setText("A fence is blocking your way.");
			return;
		}*/
		//Goes to room if the door is not locked
		if (game.goRoom(direction)) {
			roomSceneInfoLabel.setText("");
			roomSceneItemList.setItems(game.getCurrentRoomInventory());
			bottomMenuCurrentRoomLabel.setText(player.getRoom().getName());
			updateAndCheckTime();
			//Checks if a boss is present
			for (Boss boss : game.getBosses()) {
				if (boss.getRoom() == player.getRoom()) {
					beginBossFight();
				}
			}
			//Checks if room is escape able
			if (nextRoom.isEscapeableRoom()) {
				//Checks if you type the correct code or not
				if (game.isCodeCorrect(AlertBox.getCode())) {
					//If correct you win
					victorySceneScoreLabel.setText("Score: " + game.calculateHighScore());
					setAllButOneMainSceneInvisible(victoryScene);
				} else {
					//If incorrect you go back to previous room
					goRoom(nextRoom.getDirection(previousRoom));
					roomSceneInfoLabel.setText("You failed to enther the correct code, and are now back in " + player.getRoom().getName());
				}
			}
		} else {
			roomSceneInfoLabel.setText("This door is locked, you need a key.");
		}
	}

	private void updateCurrentItemLabel(String itemName) {
		roomSceneCurrentItemLabel.setText("Current Item: " + itemName);
		inventorySceneCurrentItemLabel.setText("Current Item: " + itemName);
	}

	private void updateMap(Room room, int row, int column) {
		Pane pane = new Pane();
		//Adds the room name to pane
		Label roomName = new Label(room.getName());
		roomName.setPrefWidth(90);
		roomName.setAlignment(Pos.CENTER);
		//Adds all children
		pane.getChildren().addAll(roomName);
		//Only draw the room if it is within the grid pane
		int gridWidth = mapSceneGridPane.getColumnConstraints().size();
		int gridHeight = mapSceneGridPane.getRowConstraints().size();
		if (0 <= row && row < gridWidth && 0 <= column && column < gridHeight) {
			mapSceneGridPane.add(pane, row, column);
		}
		alreadyMappedRooms.add(room);
		for (Direction direction : room.getListOfExitDirections()) {
			switch (direction) {
				case NORTH:
					if (!alreadyMappedRooms.contains(room.getExit(direction)) && !room.getExit(direction).isHidden()) {
						updateMap(room.getExit(direction), row, column - 1);
					}
					break;
				case EAST:
					if (!alreadyMappedRooms.contains(room.getExit(direction)) && !room.getExit(direction).isHidden()) {
						updateMap(room.getExit(direction), row + 1, column);
					}
					break;
				case SOUTH:
					if (!alreadyMappedRooms.contains(room.getExit(direction)) && !room.getExit(direction).isHidden()) {
						updateMap(room.getExit(direction), row, column + 1);
					}
					break;
				case WEST:
					if (!alreadyMappedRooms.contains(room.getExit(direction)) && !room.getExit(direction).isHidden()) {
						updateMap(room.getExit(direction), row - 1, column);
					}
					break;
				case UNKNOWN:
					break;
			}
		}
	}

	private void beginBossFight() {
		setAllButOneGameSceneInvisible(bossScene);
		//Finds which boss to fight
		for (Boss boss : game.getBosses()) {
			if (player.getRoom() == boss.getRoom()) {
				currentBoss = boss;
				break;
			}
		}
		//If there was no boss to fight, cancel the boss fight
		if (currentBoss == null) {
			return;
		}
		//Updates the title in bossScene
		bossSceneTitle.setText("You are fighting " + currentBoss.getName());
		//Updates counter attack buttons
		bossSceneAttackButton1.setText(game.getPlayer().getMoves().get(0).getName());
		bossSceneAttackButton2.setText(game.getPlayer().getMoves().get(1).getName());
		bossSceneAttackButton3.setText(game.getPlayer().getMoves().get(2).getName());
		bossSceneAttackButton4.setText(game.getPlayer().getMoves().get(3).getName());
		//Updates player and boss hitpoints
		bossScenePlayerHitpointLabel.setText("Your Hitpoints: " + game.getPlayer().getHitpoint());
		bossSceneBossHitpointLabel.setText(currentBoss.getName() + " Hitpoints: " + currentBoss.getHitpoint());
		//The boss makes first attack
		currentBoss.setCurrentMoveAtRandom();
		bossSceneBossAttackLabel.setText(currentBoss.getName() + " uses: " + currentBoss.getCurrentMove().getName());
	}

	private void oneAttackCycle(Move playerMove) {
		player.setCurrentMove(playerMove);
		//Executes an attack and checks who hits who
		if (currentBoss.playerHitsBoss(player)) {
			//Updates the info label
			bossSceneInfoLabel.setText("You countered " + currentBoss.getName() + "'s " + currentBoss.getCurrentMove().getName()
					+ " and you deal " + player.getCurrentMove().getDamage() + " damage!");
		} else {
			//Updates the info label
			bossSceneInfoLabel.setText("You failed to counter " + currentBoss.getName() + "'s " + currentBoss.getCurrentMove().getName()
					+ " and " + currentBoss.getName() + " deals " + currentBoss.getCurrentMove().getDamage() + " damage to you!");
		}
		//The bosses next move is chosen
		currentBoss.setCurrentMoveAtRandom();
		bossSceneBossAttackLabel.setText(currentBoss.getName() + " uses: " + currentBoss.getCurrentMove().getName());
		//Updates player and boss hitpoints
		bossScenePlayerHitpointLabel.setText("Your Hitpoints: " + game.getPlayer().getHitpoint());
		bossSceneBossHitpointLabel.setText(currentBoss.getName() + " Hitpoints: " + currentBoss.getHitpoint());
		//Checks if the boss is defeated
		if (currentBoss.getHitpoint() == 0) {
			player.addOneBossKill();
			player.getRoom().getInventory().putInventory(currentBoss.getInventory());
			currentBoss.setRoom(null);
			roomSceneInfoLabel.setText("You defeated " + currentBoss.getName() + "!");
			setAllButOneGameSceneInvisible(roomScene);
		}
		//Updates time label and checks if time has run out
		updateAndCheckTime();
		//Checks if the player is defeated or if the time has run out
		if (player.getHitpoint() == 0) {
			setAllButOneMainSceneInvisible(gameOverScene);
		}
	}
}
