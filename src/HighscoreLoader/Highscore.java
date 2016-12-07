/*
 * 

 */
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

	ObservableList<String> highscore;

	public Highscore() {
		highscore = FXCollections.observableArrayList();
	}

	/**
	 * Loads in the highscore list from the file "highscore.dne" and returns an
	 * observablelist of the highscores
	 *
	 * @return ObservableList of type String
	 */
	public ObservableList<String> getHighscoreList() {
		try {
			Scanner scannerFile = new Scanner(new File("highscore.dne"));
			while (scannerFile.hasNext()) {
				highscore.add(scannerFile.nextLine());
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
	 *
	 * @return
	 */
	public ObservableList<String> sortHighscore() {

		Collections.sort(highscore, (String s1, String s2) -> {
			int score1 = Integer.parseInt(s1.split("\\s")[1]); // score in s1
			int score2 = Integer.parseInt(s2.split("\\s")[1]); // score in s2
			return score2 - score1;
		});
		return highscore;
	}

	/**
	 *
	 * @param highscore
	 */

	public void saveHighscore(String highscore) {
		this.highscore.add(highscore);
		sortHighscore();

		try (FileWriter highscoreFile = new FileWriter("highscore.dne", true)) {
			highscoreFile.write(highscore + System.lineSeparator());
			highscoreFile.flush();
		} catch (IOException ex) {
			System.out.println("IOException in method saveHighscore() in Highscore" + ex);
		}

	}

	/**
	 *
	 * @param time
	 * @param bossKill
	 * @return
	 */
	public static int calculateScore(int time, int bossKill) {

		int calculateScore = time + (bossKill * 600);

		return calculateScore;
	}
}
