package carte;

import java.util.ArrayList;

/**
 * @author cleme
 * Possibility nous est utile pour calculer la meilleur option de jeu a éffectué
 */
public class Possibility {
	
	ArrayList<Card> card=new ArrayList<Card>();
	int type;
	int proba;
	
	public Possibility(int type, ArrayList<Card> card) {
		this.card=card;
		this.type=type;
		this.proba=0;
	}
	
	public ArrayList<Card> getList(){
		return card;
	}
	
	public int getProba() {
		return proba;
	}
	
	public void setProba(int i) {
		proba=i;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int i) {
		type=i;
	}
}
