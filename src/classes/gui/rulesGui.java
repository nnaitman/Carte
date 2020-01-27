package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;


public class rulesGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel();
	JTextArea textArea = new JTextArea("Règles de base:");
	JTextArea textArea_2 = new JTextArea(
			"Le jeu se joue avec un paquet de 54 cartes (2 jokers inclus) qui sera mélangé de manière hasardeuse, puis\r\n"
					+ "sera distribué selon le nombre de joueurs sélectionné précédemment. 5 cartes par joueur seront distribuées à\r\n"
					+ "chaque début de partie\n\n" + "Système de score : \n"
					+ "Le premier joueur qui réussit à se débarrasser de toutes ses cartes a gagné ! \r\n"
					+ "Chaque joueur commence la partie avec un score de 100pts.\n"
					+ "Les scores finals se calculent seulement à la fin de \nchaque manche de la façon suivante: \r\n"
					+ "on compte le nombre de cartes que chaque joueur possède. \r\n"
					+ "On soustrait au score de chaque joueur le nombre de cartes qu’il possède (par ex si J1 a 4 cartes à la fin de la manche, \n"
					+ "il perdra 4pts). \r\n"
					+ "Le gagnant gagne autant de points qu’il y a de cartes possédées par ses adversaires (par ex si J1\r\n"
					+ "est le gagnant, que J2 a 3 cartes, J3 a 6 cartes et J4 a 1 carte, J1 gagnera 10pts). \r\n"
					+ "Exception : Lorsqu’un joueur\r\n"
					+ "possède une bombe (voir plus loin) ou un joker, la valeur des points seras doublé (on multiplie ses points par\r\n"
					+ "2 pour chaque bombe ou joker en main, si le joueur a 2 joker le score de sa main seras alors multiplié par 4)\n"
					+ "Pour pouvoir poser une carte, il faut qu’elle suive la carte posée par le joueur précédent (exemple : La carte\r\n"
					+ "4 suit la carte 3). \r\n\n"
					+ "Si le joueur ne peut pas jouer, alors il « n’y peut rien » et devras alors sauter son tour.");

	/**
	 * Create the application.
	 */
	@SuppressWarnings("null")
	public rulesGui() {
		setBackground(new Color(0, 0, 128));
		setFont(new Font("Arial Black", Font.ITALIC, 20));
		setForeground(new Color(0, 0, 255));
		setType(Type.POPUP);
		setTitle("RULES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1469, 674);

		add();
		this.setVisible(true);
	}

	/**
	 * Initialise le contenu de la fenetre
	 */
	private void add() {

		textArea.setBackground(new Color(0, 255, 255));
		textArea.setFont(new Font("Arial", Font.BOLD, 33));
		textArea.setBounds(12, 13, 1427, 49);

		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea_2.setForeground(new Color(255, 255, 255));
		textArea_2.setBackground(new Color(0, 0, 128));
		textArea_2.setBounds(12, 85, 1427, 510);

		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBackground(new Color(0, 0, 128));
		panel.setLayout(null);
		panel.add(textArea);
		panel.add(textArea_2);
	}

}
