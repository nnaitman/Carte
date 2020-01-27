package traitement;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import carte.Card;
import carte.Game;
import carte.Hand;
import carte.Possibility;

/**
 * @author cvericel
 * 
 * C'est la classe qui va s'occuper des joueurs "bot" et qui va selectionner la meilleure combinaison de cartes pour eux et la jouer
 */
public class BotManager {
	
	/**
	 * @param game
	 * La partie actuelle
	 * 
	 * @param pan  
	 * Le JPanel principal pour y afficher les cartes jouées
	 *   
	 * @param text 
	 * Le JTextArea où l'on affiche les logs du joueur
	 */
	public static void botCanPlay(Game game, JPanel pan, JTextArea text) {
		/*
		 * On crée une arrayList de possibilités où l'on stockera toutes les possibilités du joueur
		 */
		ArrayList<Possibility> posibility = new ArrayList<Possibility>();
		Hand hand = game.getPlayers().get(game.getPlayingPlayer()).getHand(); // On récupère sa main 

		/*
		 * Ce switch va permettre de trier les possibilités que l'on va chercher
		 * Par exemple si le type de la défausse est deux 
		 * Alors on va chercher uniquement des doubles ou bien une bombe
		 */
		switch (game.getTable(game.getId()).getDiscard().getType()) {
		
		case 0:
			/*
			 * On teste toutes les cartes une par une
			 */
			for (int index = 0; index < hand.cardCount(); index++) {
				// On récupère la valeur retournée par isLegit
				int val = PlayerAction.isLegit(hand.getList().get(index), game.getTable(game.getId()).getDiscard());
				/*
				 * Si la val retournée par isLegit est 2 cela veut dire que c'est une bombe ou une combinaison de deux 
				 * Si val == 1 c'est une action valide normale
				 * Sinon les cartes sont injouables
				 */
				if (val == 2) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Possibility play = new Possibility(0, card); //On indique que cette possibilité de jeu mettra fin à la "manche"
					posibility.add(play);
				} else if (val == 1) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Possibility play = new Possibility(1, card); //On indique que cette possibilité de jeu ne mettra pas fin à la "manche"
					posibility.add(play);
				}
			}
			//S'il n'y a pas 2 carte ou plus on ne teste pas les doubles
			if(hand.cardCount()>=2) {
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						// On récupère la valeur retournée par isLegit pour deux cartes
						int val = PlayerAction.isLegit(hand.getList().get(index), hand.getList().get(index_2),
								game.getTable(game.getId()).getDiscard());
						if (val == 1) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							Possibility play = new Possibility(1, card); //On indique que cette possibilité de jeu ne mettra pas fin à la "manche"
							posibility.add(play);
						}
						else if (val == 2) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							Possibility play = new Possibility(0, card); //On indique que cette possibilité de jeu mettra  fin a la "manche"
							posibility.add(play);
						}
					}
				}
			}
			//S'il n'y a pas 3 cartes ou plus on ne teste pas les suites de 3
			if(hand.cardCount()>=3) {
				/*
				 * Triple boucles for qui vont nous permettre de tester toutes les possibilités de suites de trois cartes
				 * On n'y cherche pas les bombes
				 */
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							card.add(hand.getList().get(index_3));
							int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
							if (val == 3) {
								Possibility play = new Possibility(1, card);
								posibility.add(play);
							}
						}
					}
				}
			}
			//S'il n'y a pas 3 cartes ou plus on ne teste pas les suites de 4
			if(hand.cardCount()>=4) {
				/*
				 * Quadruple boucle for qui va nous permettre de tester toutes les possibilité de suites de trois cartes
				 * On n'y cherche pas les bombes
				 */
				for (int index = 0; index < hand.cardCount(); index++) {
					for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
						for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
							for (int index_4 = index_3 + 1; index_4 < hand.cardCount(); index_4++) {
								ArrayList<Card> card = new ArrayList<Card>();
								card.add(hand.getList().get(index));
								card.add(hand.getList().get(index_2));
								card.add(hand.getList().get(index_3));
								card.add(hand.getList().get(index_4));
								int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
								if (val == 4) {
									Possibility play = new Possibility(1, card);
									posibility.add(play);
								}
							}
						}
					}
				}
			}
			break;
		//Si onjoue des cartes une par une on cherche toute carte qui suit celle précédente
		case 1:
			for (int index = 0; index < hand.cardCount(); index++) {
				// On récupère la valeur retournée par isLegit
				int val = PlayerAction.isLegit(hand.getList().get(index), game.getTable(game.getId()).getDiscard());
				//Si c'est un deux on indique que cette possibilité met fin à la manche
				if (val == 2) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Possibility play = new Possibility(0, card);
					posibility.add(play);
				//Sinon c'est une carte valide qui suit les règles
				} else if (val == 1) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					Possibility play = new Possibility(1, card);
					posibility.add(play);
				}
			}
			break;
		//Si on joue des paires
		case 2:
			/*
			 * Double boucle for qui vont nous permettre de tester toutes les possibilités de doubles
			 * On n'y cherche pas les bombes
			 */
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					// On récupère la valeur retournée par isLegit pour deux cartes
					int val = PlayerAction.isLegit(hand.getList().get(index), hand.getList().get(index_2),
							game.getTable(game.getId()).getDiscard());
					//Si c'est un double deux alors on indique que la possibilité met fin à la manche
					if (val == 2) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						Possibility play = new Possibility(0, card);
						posibility.add(play);
					//Sinon c'est des doubles valides qui suivent les règles
					} else if (val == 1) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						Possibility play = new Possibility(1, card);
						posibility.add(play);
					}
				}
			}
			break;
		//Si on joue des suites de trois
		case 3:
			/*
			 * triple boucle for qui vont nous permettre de tester toutes les possibilités de suites de trois cartes
			 * On n'y cherche pas les bombes
			 */
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
						ArrayList<Card> card = new ArrayList<Card>();
						card.add(hand.getList().get(index));
						card.add(hand.getList().get(index_2));
						card.add(hand.getList().get(index_3));
						int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
						if (val == 3) {
							Possibility play = new Possibility(1, card);
							posibility.add(play);
						}
					}
				}
			}
			break;
			//Si on joue des suites de quatre	
		case 4:
			/*
			 * Quadruple boucle for qui vont nous permettre de tester toutes les possibilités de suites de trois cartes
			 * On n'y cherche pas les bombes
			 */
			for (int index = 0; index < hand.cardCount(); index++) {
				for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
					for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
						for (int index_4 = index_3 + 1; index_4 < hand.cardCount(); index_4++) {
							ArrayList<Card> card = new ArrayList<Card>();
							card.add(hand.getList().get(index));
							card.add(hand.getList().get(index_2));
							card.add(hand.getList().get(index_3));
							card.add(hand.getList().get(index_4));
							int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
							if (val == 4) {
								Possibility play = new Possibility(1, card);
								posibility.add(play);
							}
						}
					}
				}
			}
		}
		/*
		 * Désormais on cherche toutes les possibilités de bombes dans la main du joueur
		 * On cherche uniquement des bombes potentielles
		 */
		for (int index = 0; index < hand.cardCount(); index++) {
			for (int index_2 = index + 1; index_2 < hand.cardCount(); index_2++) {
				for (int index_3 = index_2 + 1; index_3 < hand.cardCount(); index_3++) {
					ArrayList<Card> card = new ArrayList<Card>();
					card.add(hand.getList().get(index));
					card.add(hand.getList().get(index_2));
					card.add(hand.getList().get(index_3));
					int val = PlayerAction.isLegit(card, game.getTable(game.getId()).getDiscard());
					if (val == 2) {
						Possibility play = new Possibility(0, card);//On indique que la possibilité mettre fin à la manche
						posibility.add(play);
					}
				}
			}
		}
		
		/*
		 * Si le bot peut jouer au moins une carte	
		 */
		if(posibility.size()>0) {
			/*
			 * On appelle la méthode static bestPlay qui retournera la meilleure possibilité de l'ArrayList
			 */
			Possibility bestPossibility=Probability.bestPlay(posibility, game);
			
			//SI LA PROBA EST SUPERIEURE A 0 
			//Une proba inférieure a 0 est une action "très risquée" à jouer on la joue pas, alors
			if(bestPossibility.getProba()>=0) {
				TurnManagement.turnManagement(game, pan, text, bestPossibility);			}
			//Sinon le joueur passe son tour
			else {
				TurnManagement.turnManagement(game, pan, text);
			}
		}
		//Sinon le joueur passe son tour
		else {
			TurnManagement.turnManagement(game, pan, text);			
		}
	}
}
