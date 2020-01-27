package carte;

import java.util.ArrayList;

/**
 * @author cvericel
 *
 * Class qui s'occupe de la pioche de la partie
 */
public class Stock {
	private ArrayList<CardType> cards;
	
	public Stock() {
		cards=new ArrayList<CardType>();
	}
	
	public void add(CardType card) {
		cards.add(card);
	}
	
	public void remove(CardType card) {
		cards.remove(card);
	}
	
	public int cardCount() {
		return cards.size();
	}

	public CardType getCard(int index) {
		return cards.get(index);
	}
	
	public ArrayList<CardType> getStock(){
		return cards;
	}

	public int size() {
		return cards.size();
	}

	public CardType searchByKey(int key) {
		for(int index=0; index<cards.size(); index++) {
			if(cards.get(index).getKey() == key) {
				return cards.get(index);
			}
		}
		return null;
	}
	
	public boolean keyCardExist(int key) {
		for(int index=0; index<cards.size(); index++) {
			if(cards.get(index).getKey() == key) {
				return true;
			}
		}
		return false;
	}
}
