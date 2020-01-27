package carte;

/**
 * 
 * @author cvericel
 * Cette classe gère le score des joueurs de la table
 */
public class Scoreboard {
	private int score;

	public Scoreboard(int score) {
		this.score = score;
	}

	public void increment(int x) {
		score = score + x;
	}

	public void decrement(int x) {
		score = score - x;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return " " + getScore();
	}
}
