package HighscoreLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Termprojekt gruppe 13 (Autumn 2016)
 */
public class Highscore {

	ObservableList<Score> highscore;

	public Highscore() {
		highscore = FXCollections.observableArrayList();
	}

	/**
	 * Loads in the highscore list from the file "highscore.dne" and returns an
	 * observablelist of the highscores
	 *
	 * @return ObservableList of type String
	 */
	public ObservableList<Score> getHighscoreList() {
		try {

			int scoreValue = -1;
			String name = null;
			boolean shouldAddScore = false;
			Scanner scannerFile = new Scanner(new File("highscore.dne"));
			while (scannerFile.hasNext()) {
				if (scannerFile.hasNextInt()) {
					shouldAddScore = true;
					scoreValue = scannerFile.nextInt();
				} else {
					name = scannerFile.next();
				}

				if (shouldAddScore) {
					addHighscore(scoreValue, name);
					shouldAddScore = false;
				}
			}
			sortHighscore();
		} catch (FileNotFoundException ex) {
			try {
				System.out.println("FileNotFoundException in getHighscoreList method in Highscore" + ex);
				File f = new File("highscore.dne");
				f.createNewFile();
			} catch (IOException ex1) {
				System.out.println("IOException " + ex1);
			}
		}
		return highscore;
	}

	/**
	 * Sorts the highscore
	 *
	 * @return the ObservableList of Score objects
	 */
	public ObservableList<Score> sortHighscore() {
		Collections.sort(highscore);
		return highscore;
	}

	/**
	 * Saves a given score value and name as a score and adds it to the list of
	 * highscores
	 *
	 * @param scoreValue is an int
	 * @param name is a String
	 */
	public void saveHighscore(int scoreValue, String name) {
		this.highscore.add(new Score(name, scoreValue));
		sortHighscore();

		try (FileWriter highscoreFile = new FileWriter("highscore.dne", true)) {
			highscoreFile.write(name + " " + scoreValue + System.lineSeparator());
			highscoreFile.flush();
		} catch (IOException ex) {
			System.out.println("IOException in method saveHighscore() in Highscore" + ex);
		}

	}

	/**
	 * Calculates a score based on the time left and the amount of bosskills
	 *
	 * @param time is an int
	 * @param bossKill is an int
	 * @return an the calculateScore as an int
	 */
	public static int calculateScore(int time, int bossKill) {

		int calculateScore = time + (bossKill * 600);

		return calculateScore;
	}

	/**
	 * Adds a scoreValue and name to the highscore list as a score
	 *
	 * @param int score value
	 * @param String name	 *
	 */
	private void addHighscore(int scoreValue, String name) {
		if (scoreValue != -1 && name != null) {
			highscore.add(new Score(name, scoreValue));
		}
	}
}
