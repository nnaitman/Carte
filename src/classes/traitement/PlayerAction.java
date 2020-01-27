
package traitement;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import carte.*;

/**
 * @author cvericel
 *
 * PlayerAction s'occupe de vérifier si une action suit les régles
 */
public class PlayerAction {

	
	/**
	 * @param cards
	 * Carte(s) jouée(s)
	 * 
	 * @param discard
	 * défausse
	 * 
	 * @return 1
	 * Action qui suit les régles
	 * 
	 * @return 2
	 * Cette action met fin au tour, bombe, combinaison de deux
	 * 
	 * 
	 * @return -1
	 * Action qui ne suit pas les règles
	 */
	public static int verify(ArrayList<Card> cards, Discard discard) {
		
		/*
		 * Selon le nombre de cartes que le joueur joue
		 * On appele différentes méthodes de isLegit
		 */
		switch (cards.size()) {
		case 1:
			int val=isLegit(cards.get(0), discard);
			if (val == 1) {
				return 1;
			} else if (val == 0) {
				return -1;
			} else {
				return 2;
			}
		case 2:
			int val2=isLegit(cards.get(0), cards.get(1), discard);
			if (val2 == 1) {
				return 1;
			} else if (val2 == 0) {
				return -1;
			} else {
				return 2;
			}

		case 3:
			int val3=isLegit(cards, discard);
			if (val3 == 2) {
				return 2;
			}
			if (val3 != 0) {
				return 3;
			} else {
				return -1;
			}
		case 4:
			int val4=isLegit(cards, discard);
			if (val4 == 2) {
				return 2;
			}
			if (val4 != 0) {
				return 4;
			} else {
				return -1;
			}
		default:
			return -1;
		}
	}

	/**
	 * Cette méthode isLegit gére "les cartes une par unes"
	 * 
	 * 
	 * @param card
	 * Carte jouée
	 * 
	 * @param lastPlay
	 * Défausse
	 * 
	 * @return 1
	 * Action qui suit les règles
	 * 
	 * @return 2
	 * Cette action met fin au tour, bombe, combinaison de deux
	 * 
	 * 
	 * @return -1
	 * Action qui ne suit pas les règles
	 * 
	 */
	public static int isLegit(Card card, Discard lastPlay) {
		/*
		 * Si le type est 0
		 */
		if (lastPlay.getType() == 0) {
			if (Math.abs(card.getKey() - 200) < 5) {
				return 2;
			} else if(isJoker(card.getKey())){ //On refuse les jokers en ouverture
				return 0;
			}
			else {
				return 1;
			}
		} else if (lastPlay.getType() == 1) {
			int cardPlayKey = card.getKey();
			int nbr = lastPlay.cardCount();
			int lastKey = lastPlay.getCards().get(nbr - 1).getKey();
			if (isJoker(lastKey)) {
				if (isJoker(cardPlayKey)) { //On ne peut jouer deux joker consécutifs
					return 0;
				}
				lastKey = lastPlay.getCards().get(nbr - 2).getKey() + 10;
			}
			
			if (isJoker(cardPlayKey)) {
				if(Math.abs(lastKey - 140) < 5) { // Si la carte est un joker on accepte la carte seulement si la cartes précedante n'est pas un as.
					return 0;
				}
				else {
					lastPlay.setType(1);
					return 1;
				}
				
			} else if (Math.abs(cardPlayKey-200) < 5) { //Si c'est un deux
				return 2;
			} else {
				int a = cardPlayKey - lastKey;
				if (Math.abs(a) > 14 || cardPlayKey - lastKey < 5) { // Si la carte ne suit pas celle d'avant on refuse
					return 0;
				} else {
					lastPlay.setType(1); //On indique a la défausse le type de jeu actuel
					return 1;
				}
			}
		} else {  //S'il faut jouer par exemple des doubles ou suites et pas une seule carte
			return 0;
		}

	}
	
	/**
	 * 
	 * Cette méthode isLegit gère "les doubles"
	 * 
	 * @param card
	 * Carte 1 jouée
	 * 
	 * @param card
	 * Carte 2 jouée
	 * 
	 * @param lastPlay
	 * Défausse
	 * 
	 * @return 1
	 * Action qui suit les règles
	 * 
	 * @return 2
	 * Cette action met fin au tour, bombe, combinaison de deux
	 * 
	 * @return -1
	 * Action qui ne suit pas les règles
	 * 
	 */
	public static int isLegit(Card c1, Card c2, Discard lastPlay) {
		if (lastPlay.getType() == 0) {
			if (isDouble(c1, c2)) {
				if(isJoker(c1.getKey()) && isJoker(c2.getKey())) { //pas de double joker accepté
					return 0;
				}
				return 1;
			}
			return 0;
		} else if (lastPlay.getType() == 2) {

			int nbr = lastPlay.cardCount();
			int lastKey = lastPlay.getCards().get(nbr - 1).getKey();
			
			if(isJoker(c1.getKey()) && isJoker(c2.getKey())) { //pas de double joker accepté
				return 0;
			}
			
			if (isJoker(lastKey)) {
				lastKey = lastPlay.getCards().get(nbr - 2).getKey() + 10;
			}
			
			if (Math.abs(c1.getKey() - 200) < 5 && isDouble(c1, c2, lastKey)) {
				return 2;
			} else {
				if (c1.getKey() == lastKey || c2.getKey() == lastKey || c1.getKey() < lastKey) {
					return 0;
				} else if (Math.abs(c1.getKey() - lastKey) < 14 && isDouble(c1, c2, lastKey)) {
					return 1;
				} else {
					return 0;
				}
			}
		} else {
			return 0;
		}
	}
	
	/**
	 * 
	 * Cette méthode isLegit gère "les suites de cartes"
	 * 
	 * @param list
	 * ArrayList contenant les cartes jouées
	 * 
	 * @param lastPlay
	 * Défausse
	 * 
	 * @return card.size()
	 * Action qui suit les règles
	 * 
	 * @return 2
	 * Cette action met fin au tour, bombe, combinaison de deux
	 * 
	 * @return 0
	 * Action qui ne suit pas les règles
	 * 
	 */
	public static int isLegit(ArrayList<Card> list, Discard lastPlay) {
		if (list.size() == 3) {
			if (isBomb(list.get(0), list.get(1), list.get(2))) {
				return 2;
			} else {
				if (isSuit(list, lastPlay)) {
					return list.size();
				} else {
					return 0;
				}
			}
		} else {
			if (isSuit(list, lastPlay)) {
				return list.size();
			} else {
				return 0;
			}
		}
	}

	/**
	 * Méthode qui test si les cartes sont une suites
	 * 
	 * @param list
	 * ArrayList de carte
	 * 
	 * @param lastPlay
	 * défausse
	 * 
	 * @return 1 
	 * l'ArrayList de carte suit les règles
	 */
	public static Boolean isSuit(ArrayList<Card> list, Discard lastPlay) {
		ArrayList<Integer> keyList = Management.calculate(list);
		if (lastPlay.getType() == 0) {
			for (int i = 0; i < keyList.size() - 1; i++) {
				if ( (keyList.get(i) - keyList.get(i+1)) >= 0 || (keyList.get(i) - keyList.get(i+1)) < -14 || Math.abs(keyList.get(i) - keyList.get(i+1))<5) {
					return false;
				}
			}
			return true;
		} else {
			int lastSuitPlay = lastPlay.getType();
			int discardWidth = lastPlay.cardCount();

			if (list.size() == lastSuitPlay) {
				ArrayList<Card> lastSuitKeyList = new ArrayList<Card>();

				// On recupere la suite de carte joué auparavant
				for (int i = ((discardWidth - (lastSuitPlay))); i < discardWidth; i++) {
					lastSuitKeyList.add(lastPlay.getCards().get(i));
				}

				/* On la trie désormais par Key 
				 * On remplace les jokers par les valeurs qu'ils
				 * remplacent
				 */ 
				ArrayList<Integer> lastKeyList = Management.calculate(lastSuitKeyList);
				Collections.reverse(lastKeyList);

				if ((lastKeyList.get(0) - keyList.get(0)) >= 0 || (lastKeyList.get(0) - keyList.get(0)) < -14 || Math.abs(lastKeyList.get(0) - keyList.get(0))<5) {
					return false;
				} else {
					for (int i = 0; i < keyList.size() - 1; i++) {
						if ((keyList.get(i) - keyList.get(i+1)) >= 0 || (keyList.get(i) - keyList.get(i+1)) < -14 || Math.abs(keyList.get(i) - keyList.get(i+1))<5) {
							return false;
						}
					}
					return true;
				}
			} else {
				return false;
			}
		}
	}

	//isDouble pour les débuts de partie
	public static Boolean isDouble(Card c1, Card c2) {
		int val = c1.getKey() - c2.getKey();
		if (Math.abs(val) < 4 || (isJoker(c1.getKey()) || (isJoker(c2.getKey())))) {
			return true;
		} else {
			return false;
		}
	}

	//Teste si les cartes sont bien des doubles
	public static Boolean isDouble(Card c1, Card c2, int lastKey) {
		int val = c1.getKey() - c2.getKey();
		if (Math.abs(val) < 4 || (isJoker(c1.getKey()) && (c2.getKey() - lastKey < 14)
				|| (isJoker(c2.getKey()) && (c1.getKey() - lastKey < 14)))) {
			return true;
		} else {
			return false;
		}
	}
	
	//Teste si les cartes sont une bombe
	public static Boolean isBomb(Card c1, Card c2, Card c3) {
		if (isDouble(c1, c2) && isDouble(c2, c3) && isDouble(c1, c3)) {
			return true;
		} else {
			return false;
		}
	}
	
	//Teste si une carte est un joker
	public static Boolean isJoker(int key) {
		if (key == 251 || key == 252) {
			return true;
		} else {
			return false;
		}
	}
}
