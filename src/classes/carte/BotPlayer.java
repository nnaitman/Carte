package carte;
import carte.Hand;
import carte.Player;
import carte.Scoreboard;
import carte.Stock;
import traitement.Init;

/**
 * @author cvericel
 *
 */
public class BotPlayer extends Player{
	/*
	 * Constructeur des joueurs de type robot, leur type est égale à 1
	 */
	public BotPlayer(String username, Scoreboard score, Hand hand, int toPass) {
		super(username, score, 1, hand, toPass);
	}
}
