package carte;

import java.util.ArrayList;

/**
 * @author cvericel
 *
 */
public class Discard {
	/*
	 * type est un int qui correspond au "type de jeu" actuel, 1 pour des cartes uniques, 2 pour paire
	 * 3 pour suite de trois .., et 0 pour n'importe quelle combinaison de carte valable
	 */
	private int type=0;
	private int lastPlaySize=0;
	private ArrayList<Card> cards;
	
	public Discard() {
		cards=new ArrayList<Card>();
	}
	
	public void add(Card card) {
		cards.add(card);
	}
	
	public void remove(Card card) {
		cards.remove(card);
	}
	
	public int cardCount() {
		return cards.size();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int typePlayed) {
		type=typePlayed;
	}
	
	public int getLastCardPlay() {
		int nbr=cardCount();
		if(cards.get(nbr-1).getKey() > 250) {
			if(cards.get(nbr-2).getKey() > 250) {
				return cards.get(nbr-3).getKey()+20;
			}
			else {
				return cards.get(nbr-2).getKey()+10;
			}	
		}
		else {
			return cards.get(nbr-1).getKey();
		}
	}

	public int getLastPlaySize() {
		return lastPlaySize;
	}

	public void setLastPlaySize(int lastPlaySize) {
		this.lastPlaySize = lastPlaySize;
	}
}
