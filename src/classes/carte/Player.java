package carte;
/**
 * 
 * @author cvericel
 * Class qui gére les joueurs de la partie
 */
public class Player {
		
	private String username;
	private Scoreboard score;
	private Hand hand= new Hand();
	private int type;
	private int toPass;
	
	public Player(String username, Scoreboard score, int type, Hand hand, int toPass) {
		this.username=username;
		this.score=score;
		this.hand=hand;
		this.type=type;
		this.toPass=toPass;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Scoreboard getScore() {
		return score;
	}

	public void setScore(Scoreboard score) {
		this.score = score;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public void pass() {
		toPass=1;
	}
	public int getToPass() {
		return toPass;
	}
	
	public void reset() {
		toPass=0;
	}
	public String toString() {
		String str="\n";
		str= getUsername() + "\n "+" nombre de carte: " + hand.cardCount()+ "\n" + getHand()  +"\n\n";
		return str;
	}
}
