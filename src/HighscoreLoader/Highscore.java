/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HighscoreLoader;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Danieln Johansen
 */
public class Highscore {

	public static ArrayList<String> getHighscoreList() {
		ArrayList<String> scores = new ArrayList<>();
		try {

			Scanner scannerFile = new Scanner(new File("highscore.dne"));
			while (scannerFile.hasNext()) {
				scores.add(scannerFile.nextLine());
			}

			scores = sortHighscore(scores);

		} catch (Exception e) {
			System.out.println("The method getHighscoreList has thrown an exception. " + e);
		}
		return scores;
	}

	public static ArrayList<String> sortHighscore(ArrayList<String> scores) {

		Collections.sort(scores, (String s1, String s2) -> {
			int score1 = Integer.parseInt(s1.split("\\s")[1]); // score in s1
			int score2 = Integer.parseInt(s2.split("\\s")[1]); // score in s2
			return score2 - score1;
		});
		return scores;
	}

	public static void saveHighscore(String highscore) {
		
		try (FileWriter highscoreFile = new FileWriter("highscore.dne",true)) {
			highscoreFile.write(highscore + System.lineSeparator());
			highscoreFile.flush();
		} catch (Exception e) {
			System.out.println("The method saveHighscore has thrown an exception. " + e);
		}
	}
        
        public static String calculateScore (int time, int bossKill) {
            StringBuilder sb = new StringBuilder();
            int calculateScore = time + (bossKill * 600);
            sb.append(calculateScore);
            String score = sb.toString();
            return score;
        }
}
