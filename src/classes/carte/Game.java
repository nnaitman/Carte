package carte;

import java.util.ArrayList;

import traitement.Init;

/**
 * @author cvericel
 * Game est la class qui regroupe les tables de jeux 
 * Ainsi que tous les joueurs de la partie
 */
public class Game {
	ArrayList<Table> game;
	ArrayList<Player> players;
	int id=0;
	int playingPlayer=0;
	
	public Game(Table table, ArrayList<Player> players) {
		game=new ArrayList<Table>();
		addTable(table);
		this.players=players;
	}

	public void addTable(Table table) {
		game.add(table);
	}

	public Table getTable(int i) {
		return game.get(i);
	}

	public void addPlayers(Player card) {
		players.add(card);
	}
	
	public void removePlayers(Player player) {
		players.remove(player);
	}
	
	
	public int playersCount() {
		return players.size();
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public int tableCount() {
		return game.size();
	}
	
	public void setId(int i) {
		id=i;
	}
	
	public int getId() {
		return id;
	}
	
	public  int getPlayingPlayer() {
		return playingPlayer;
	}
	
	public int getNextPlayingPlayer() {
		if((getPlayingPlayer() + 1) < Init.getNbPlayer() ) {
			return getPlayingPlayer() + 1;
		}
		else {
			return 0;
		}
	}

	public  void setPlayingPlayer(int index) {
		playingPlayer=index;
	}
}
