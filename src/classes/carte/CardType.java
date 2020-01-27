package carte;

import java.util.ArrayList;

public class CardType {
	ArrayList<Card> list;
	String name;
	int key;
	
	public CardType(String name, int key) {
		this.name=name;
		this.key=key;
	}
	
	public ArrayList<Card> getList(){
		return list;
	}
	
	public void setList(ArrayList<Card> cardList) {
		list=cardList;
	}
	
	public int getKey() {
		return key;
	}
}
