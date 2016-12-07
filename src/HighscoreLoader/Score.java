package HighscoreLoader;

/**
 *
 * @author Termproject Group 13 (Autumn 2016)
 */
public class Score implements Comparable<Score> {

	private String name;
	private int scoreValue;

	public Score(String name, int scoreValue) {
		this.name = name;
		this.scoreValue = scoreValue;
	}

	/**
	 * @return the name as a String
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the scoreValue as an int
	 */
	public int getScoreValue() {
		return scoreValue;
	}

	/**
	 * Compares two score objects and returns an int based on whether the score is
	 * higher, lower or equal
	 *
	 * @param o a Score
	 * @return
	 */
	@Override
	public int compareTo(Score o) {
		return o.getScoreValue() - this.scoreValue;
	}

	/**
	 * Returns a representation of a score object as a String
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return name + " " + scoreValue;
	}

}
