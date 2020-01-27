package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import carte.Table;
import traitement.Init;
import traitement.PlayerAction;
import traitement.PrintDiscard;
import traitement.PrintPlayerPossibility;
import traitement.TurnManagement;
import carte.PicturePath;
import carte.Card;
import carte.Game;
import carte.Possibility;

public class trainingGui {

	int turn = 0;
	int gameId = 0;
	private JFrame frame;
	Table table;
	int i = 0;
	JScrollPane scrollHand;
	private ArrayList<JButton> listButton = new ArrayList<JButton>();
	private PanelImage pannel = new PanelImage();
	private JPanel pan = new JPanel();
	private ArrayList<String> cards = new ArrayList<String>();
	private ArrayList<Card> card = new ArrayList<Card>();
	Game game;
	JTextArea textArea = new JTextArea();
	JPanel otherPlayerHand;
	JPanel possibility;

	/**
	 * Créer la fenêtre.
	 */
	public trainingGui() {
		initialize();
	}

	/**
	 * Initialise la fenêtre
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1500, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pannel.setLayout(null);
		try {
			pannel.setImage("D://Games/background.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * textArea servira pour les logs de Game
		 */
		textArea = new JTextArea();
		JScrollPane scrollText = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollText.setBounds(1132, 5, 348, 593);
		scrollText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scrollText.setBackground(new Color(0, 0, 0, 0));
		scrollText.getViewport().setOpaque(false);

		textArea.setForeground(Color.white);
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		pannel.add(scrollText);

		/*
		 * ScrollPane pour la main du joueur
		 */
		JScrollPane scrollPane = new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(405, 430, 520, 170);
		pannel.add(scrollPane);
		pan.setBackground(new Color(0, 0, 0, 0));
		scrollPane.setOpaque(false);
		scrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				scrollPane.repaint();
			}
		});
		
		/*
		 * ScrollPane des mains des autres joueurs
		 */
		otherPlayerHand = new JPanel();
		scrollHand = new JScrollPane(otherPlayerHand, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollHand.setBounds(0, 0, 564, 200);
		scrollHand.setBackground(new Color(0, 0, 0, 0));
		otherPlayerHand.setLayout(null);
		otherPlayerHand.setBounds(0, 0, 400, 400);
		otherPlayerHand.setBackground(new Color(0, 0, 0, 0));
		pannel.add(scrollHand);
		scrollHand.setOpaque(false);
		scrollHand.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				scrollHand.repaint();
			}
		});
		scrollHand.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				scrollHand.repaint();
			}
		});

		/*
		 * Combinaison de cartes jouables pour le joueur
		 */
		possibility = new JPanel();
		JScrollPane scrollPos = new JScrollPane(possibility, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPos.setOpaque(false);

		scrollPos.setBounds(0, 200, 400, 400);
		possibility.setBackground(new Color(0, 0, 0, 0));
		possibility.setLayout(null);
		pannel.add(scrollPos);
		scrollPos.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				scrollPos.repaint();
			}
		});

		//bouton passer
		JButton passerButton = new JButton("PASSER");
		passerButton.setBounds(928, 530, 202, 50);
		pannel.add(passerButton);
		passerButton.addActionListener(new PasserListener());

		//bouton jouer
		JButton jouerButton = new JButton("JOUER");
		jouerButton.setBounds(928, 480, 202, 50);
		jouerButton.addActionListener(new jouerListener());
		pannel.add(jouerButton);
		frame.getContentPane().add(pannel, BorderLayout.CENTER);
	}

	/*
	 * Gère l'affichage des cartes dans la main du joueur
	 */
	public void tempor() {

		for (int k = 0; k < game.getPlayers().get(game.getPlayingPlayer()).getHand().cardCount(); k++) {
			int key = game.getPlayers().get(game.getPlayingPlayer()).getHand().getCardKey(k);
			JButton cartButton = new JButton(new ImageIcon(PicturePath.getPicturePath(key)));
			cartButton.setPreferredSize(new Dimension(97, 143));
			listButton.add(cartButton);
			cartButton.setActionCommand(String.valueOf(key));
			cartButton.addActionListener(new SelectionListener());
			pan.add(cartButton);
		}
	}

	/*
	 * Gère la suppression des cartes dans la main du joueur
	 */
	public void tempor2() {
		int j = listButton.size() - 1;
		while (j >= 0) {
			pan.remove(listButton.get(j));
			listButton.remove(j);
			j = j - 1;
		}
		pan.repaint();
		pan.revalidate();

		tempor();
	}

	/*
	 * Initialise la Game principale
	 */
	public void Init() {
		game = Init.initGame();
	}

	/*
	 * Affiche la fenêtre
	 */
	public void show() {
		this.frame.setVisible(true);
		Init();
		tempor();
		/*
		 * Affiche les mains et possibilités des joueurs
		 */
		PrintDiscard.printOtherPlayerHand(otherPlayerHand, game);
		PrintPlayerPossibility.printHandPossibility(game, possibility);
	}

	/*
	 * ActionListener dans le cas où ou le joueur n'y peut rien
	 */
	class PasserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// On appele turnManagement version "passer"
			TurnManagement.turnManagement(game, pannel, textArea);
			// on affiche les mains des autres joueurs
			PrintDiscard.printOtherPlayerHand(otherPlayerHand, game);
			PrintPlayerPossibility.printHandPossibility(game, possibility);
			tempor2();
		}
	}
	
	/*
	 * Gère les cartes qui seront sélectionnées par le joueurs
	 */
	class SelectionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int i;
			int test = 0;
			for (i = 0; i < cards.size(); i++) {
				if (String.valueOf(cards.get(i)) == String.valueOf(e.getActionCommand())) {
					cards.remove(i);//On la supprime de cards si elle était déjà selectionée
					test = 1;

				}
			}
			if (test == 0) {
				//on ajoute à cards, la carte sélectionnée
				cards.add(e.getActionCommand());
			}

		}
	}

	class jouerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Si aucune carte n'est selectionée on ne peut pas jouer
			 */
			if (!cards.isEmpty()) {
				/*
				 * On va tester si les cartes jouées suivent les règles du jeu Pour cela on
				 * récupère les cartes correspondantes aux clés de celles jouées
				 */
				for (int a = 0; a < cards.size(); a++) {
					Integer inter = Integer.valueOf(cards.get(a));
					card.add(Card.getCardWithKey(inter));
				}

				int isValid = PlayerAction.verify(card, game.getTable(gameId).getDiscard());
				// Si les cartes ont passés les tests et sont valides
				if (isValid == 2) {
					Possibility pos = new Possibility(0, card);
					TurnManagement.turnManagement(game, pannel, textArea, pos);
				} else if (isValid > 0) {

					Possibility pos = new Possibility(1, card);
					TurnManagement.turnManagement(game, pannel, textArea, pos);
				} else {
					JOptionPane.showMessageDialog(null, "mauvaise carte", "mauvaise carte jouée",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			/*
			 * On appele la fonction qui va gérer le tour des joueurs
			 */
			tempor2();
			cards.clear(); //On clear les deux ArrayList
			card.clear();
			//on affiche les mains et possibilités des autres joueurs
			PrintDiscard.printOtherPlayerHand(otherPlayerHand, game);
			PrintPlayerPossibility.printHandPossibility(game, possibility);
		}
	}
}
