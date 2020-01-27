package traitement;

import java.util.ArrayList;
import java.util.Collections;

import carte.Card;
import carte.CardType;
import carte.Hand;
import carte.Stock;

/**
 * @author cvericel Classe qui s'occupe de "g�rer" la pioche
 */
public class Management {

	public static void stockManagement(Hand hand, Stock stock) {
		CardType cardType = getRandomCard(stock); // On ressort "un type de carte" Il faut maintenant r�cuperer une
													// couleur
		Card card = getRandomCardColor(cardType);
		hand.add(card);
		deleteStockCard(cardType, card, stock);
	}

	public static CardType getRandomCard(Stock stock) {
		double index = Math.random() * (stock.cardCount() - 0);
		return stock.getCard((int) index);
	}

	public static Card getRandomCardColor(CardType card) {

		double index = Math.random() * (card.getList().size() - 0);
		return card.getList().get((int) index);
	}

	public static void deleteStockCard(CardType cardType, Card card, Stock stock) {
		cardType.getList().remove(card);
		if (cardType.getList().size() == 0) {
			stock.remove(cardType);
		}
	}

	/**
	 * m�thode pour g�rer la pioche fictive des joueurs robots qui sert � calculer les
	 * probabilit�s
	 * 
	 * @param cardList Liste des cartes � y supprimer. �a peut �tre la d�fausse ou
	 *                 bien une main de joueur
	 * 
	 * @param fictif   La pioche fictive
	 */
	public static void fictifManagement(ArrayList<Card> cardList, Stock fictif) {

		for (int index = 0; index < cardList.size(); index++) {
			int cardKey = cardList.get(index).getKey();

			CardType cardType = new CardType(null, 0);
			Card card = cardList.get(index);

			/*
			 * On arrondie la cl� pour obtenir une cl� multiple de 10
			 */
			cardKey = cardKey / 10;
			cardKey = (int) Math.round((double) cardKey);
			cardKey = cardKey * 10;
			cardType = fictif.searchByKey(cardKey);
			deleteStockCard(cardType, card, fictif);
		}
	}

	/**
	 * M�thode qui va trier une liste de cartes par cl�
	 * Elle va alors appeler une autre m�thode qui va supprimer de la liste les jokers 
	 * 
	 * @param list
	 * Liste de carte
	 *
	 * @return keyList
	 * Liste de carte tri�e
	 */
	public static ArrayList<Integer> calculate(ArrayList<Card> list) {
		ArrayList<Integer> keyList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			keyList.add(list.get(i).getKey());
		}
		//on trie dans l'ordre la liste
		Collections.sort(keyList);
		keyList = listWithoutJoker(keyList);//On y enleve les jokers s'il y'en a un
		return keyList;
	}

	/**
	 * M�thode qui supprime les jokers d'une ArrayList de Integer
	 * 
	 * @param list
	 * Liste de cartes dont il faut supprimer les jokers
	 * @return temp
	 * l'arrayList trie sans joker
	 */
	public static ArrayList<Integer> listWithoutJoker(ArrayList<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			//si c'est un joker on le supprime par la cl� qu'il doit remplacer
			if (PlayerAction.isJoker(list.get(i))) {
				for (int j = 0; j < list.size() - 1; j++) {
					if (Math.abs(list.get(j) - list.get(j + 1)) > 14) {
						temp.add(list.get(j) + 10);
					}
				}
			} else {
				temp.add(list.get(i));
			}
		}
		//trie la liste
		Collections.sort(temp);
		return temp;
	}
}
