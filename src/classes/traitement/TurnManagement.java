package traitement;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import carte.Game;
import carte.Player;
import carte.Possibility;

/**
 * @author cvericel
 * 
 *         Class qui g�re les tours de jeu des joueurs
 *
 */
public class TurnManagement {

	private static int lastPlay;

	/*
	 * M�thode qui va permettre de stocker l'ID du dernier joueur ayant pos� une ou
	 * des cartes sur le terrain
	 */
	public static void lastPlayerWhoPlay(int i) {
		lastPlay = i;
	}

	/*
	 * M�thode qui va r�cuperer l'ID du dernier joueur ayant pos� une ou des cartes
	 * sur le terrain
	 */
	public static int getLastPlayerWhoPlay() {
		return lastPlay;
	}

	public static boolean endGame(ArrayList<Player> players) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getHand().cardCount() == 0) {
				return true;
			}
		}
		return false;
	}

	/*
	 * @param game | La partie actuel
	 * 
	 * @param pan | Le JPanel de la fen�tre aux cas o� le prochain joueur est un
	 * robot pour afficher ses gestes
	 * 
	 * @param text | Le Champ de texte ou afficher les logs
	 * 
	 * G�re les joueurs Humain et Bot qui passent leur tours
	 * 
	 */
	public static void turnManagement(Game game, JPanel pan, JTextArea text) {

		game.getPlayers().get(game.getPlayingPlayer()).pass();
		PrintDiscard.printLog(text, game);
		endTurn(game, text, pan);
		// Si la valeur du type de jeu actuel est diff�rent de 0 alors on passe au
		// joueur suivant
		if (game.getTable(game.getId()).getDiscard().getType() != 0) {
			game.setPlayingPlayer(game.getNextPlayingPlayer());
		}

		// On pioche seulement si le pioche n'est pas vide
		if (game.getTable(game.getId()).getStock().cardCount() > 0) {
			Management.stockManagement(game.getPlayers().get(game.getPlayingPlayer()).getHand(),
					game.getTable(game.getId()).getStock());
		}

		// Si le prochain joueur est un bot on joue pour lui machinalement
		if (game.getPlayers().get(game.getPlayingPlayer()).getType() == 1) {
			BotManager.botCanPlay(game, pan, text);
		}
	}

	public static void turnManagement(Game game, JPanel pan, JTextArea text, Possibility pos) {

		for (int index = 0; index < pos.getList().size(); index++) {
			game.getTable(game.getId()).getDiscard().add(pos.getList().get(index));
			game.getPlayers().get(game.getPlayingPlayer()).getHand().remove(pos.getList().get(index).getKey());
		}

		if (endGame(game.getPlayers())) {
			/*
			 * On g�re le score des joueurs
			 */
			game.setPlayers(EndGame.scoreManager(game.getPlayers(), game.getPlayingPlayer()));
			/*
			 * On demande si le joueur veut encore jouer
			 */
			String str = "Score : \n";
			for (int index = 0; index < Init.getNbPlayer(); index++) {
				str = str + game.getPlayers().get(index).getUsername() + " : " + game.getPlayers().get(index).getScore()
						+ "\n";
			}
			String menu[] = { "Oui", "Non" };
			int choix = JOptionPane.showOptionDialog(null, str + "Voulez vous rejouez", "Fin de partie :", 0,
					JOptionPane.QUESTION_MESSAGE, null, menu, menu[1]);

			if (choix == 0) {
				for(int index=0; index< game.getPlayers().size(); index++) {
					game.getPlayers().get(index).reset();
				}
				game.setPlayingPlayer(0);
				game.getTable(game.getId()).getDiscard().setType(0);
				text.setText("");

			} else {
				System.exit(0);
			}
			/*
			 * On initialise une nouvelle table de jeu comportant une pioche et un defausse
			 */
			game.addTable(Init.initTable());
			game.setId(game.getId() + 1);// On incremente l'id de la game
			EndGame.resetHand(game.getPlayers());// On reset les mains
			EndGame.initNewHand(game.getTable(game.getId()).getStock(), game.getPlayers());

		}
		/*
		 * Si ce n'est pas la fin de la partie
		 */
		else {
			/*
			 * On change les valeurs de la defausse
			 */
			game.getTable(game.getId()).getDiscard().setType(pos.getList().size());
			game.getTable(game.getId()).getDiscard().setLastPlaySize(pos.getList().size());

			/*
			 * On affiche ce que le joueur a est jou� dans les logs
			 */
			PrintDiscard.printLog(text, game);
			try {
				/*
				 * On affiche les cartes jou�es dans la d�fausse
				 */
				PrintDiscard.printCard(pan, game.getTable(game.getId()).getDiscard());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Si les cartes jou�es sont une bombes, un ou plusieurs deux
			if (pos.getType() == 0) {
				endTurn(game, text, pan);
				game.getTable(game.getId()).getDiscard().setType(0);
				// On refait piocher le joueur actuel
				if (game.getTable(game.getId()).getStock().cardCount() > 0) {
					Management.stockManagement(game.getPlayers().get(game.getPlayingPlayer()).getHand(),
							game.getTable(game.getId()).getStock());
				}

				// Si c'est un bot il rejoue machinalement
				if (game.getPlayers().get(game.getPlayingPlayer()).getType() == 1) {
					BotManager.botCanPlay(game, pan, text);
				}
			} else {
				// On r�initialise les joueurs pr�cedents ayant pass�s leur tour
				endTurn(game, text, pan);
				// On passe au joueur suivant
				game.setPlayingPlayer(game.getNextPlayingPlayer());
				// On le fait piocher
				if (game.getTable(game.getId()).getStock().cardCount() > 0) {
					Management.stockManagement(game.getPlayers().get(game.getPlayingPlayer()).getHand(),
							game.getTable(game.getId()).getStock());
				}

				// Si c'est un bot il joue machinalement
				if (game.getPlayers().get(game.getPlayingPlayer()).getType() == 1) {
					BotManager.botCanPlay(game, pan, text);
				}
			}
		}
	}

	public static void endTurn(Game game, JTextArea area, JPanel pan) {
		/*
		 * Si le joueur actuel vient de jouer alors on tous les joueurs pr�c�dent
		 * peuvent rejouer
		 */
		if (game.getPlayers().get(game.getPlayingPlayer()).getToPass() == 0) {
			int index = game.getPlayingPlayer();
			if (game.getPlayingPlayer() == 0) {
				index = Init.getNbPlayer() - 1;
			} else {
				index--;
			}
			while (game.getPlayers().get(index).getToPass() != 0) {
				game.getPlayers().get(index).reset();
				if (index == 0) {
					index = Init.getNbPlayer() - 1;
				} else {
					index--;
				}
			}
			/*
			 * Sinon on teste si tous les joueurs avant le joueur qui va jouer ont pass�s
			 * leur tour pour r�initialiser la manche Toute combinaison de cartes et alors
			 * jouable par le dernier joueur ayant jou�
			 */
		} else {
			int nextPlayerPlace = game.getNextPlayingPlayer();
			int index = game.getPlayingPlayer();
			while (index != nextPlayerPlace && game.getPlayers().get(index).getToPass() != 0) {
				if (index == 0) {
					index = Init.getNbPlayer() - 1;
				} else {
					index--;
				}
			}
			// Si index est �gal � l'id du prochain joueur cela veut dire que tout les
			// joueurs ont pass�s leur tour sauf lui.
			if (index == nextPlayerPlace) {
				area.append("----------------- \n");
				area.append("reset \n");
				game.setPlayingPlayer(nextPlayerPlace);
				game.getTable(game.getId()).getDiscard().setType(0);
			}
		}
	}
}
