/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HighscoreLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Danieln Johansen
 */
public class Highscore {

	ObservableList<String> highscore;

	public Highscore() {
		highscore = FXCollections.observableArrayList();
	}

	public ObservableList<String> getHighscoreList() {
		try {

			Scanner scannerFile = new Scanner(new File("highscore.dne"));
			while (scannerFile.hasNext()) {
				highscore.add(scannerFile.nextLine());
			}

			sortHighscore();

		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		return highscore;
	}

	public ObservableList<String> sortHighscore() {

		Collections.sort(highscore, (String s1, String s2) -> {
			int score1 = Integer.parseInt(s1.split("\\s")[1]); // score in s1
			int score2 = Integer.parseInt(s2.split("\\s")[1]); // score in s2
			return score2 - score1;
		});
		return highscore;
	}

	public void saveHighscore(String highscore) {
		this.highscore.add(highscore);
		sortHighscore();

		try (FileWriter highscoreFile = new FileWriter("highscore.dne", true)) {
			highscoreFile.write(highscore + System.lineSeparator());
			highscoreFile.flush();
		} catch (IOException ex) {
			System.out.println(ex);
		}

	}

	public static int calculateScore(int time, int bossKill) {

		int calculateScore = time + (bossKill * 600);

		return calculateScore;
	}
}
