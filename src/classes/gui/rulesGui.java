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
	JTextArea textArea = new JTextArea("R�gles de base:");
	JTextArea textArea_2 = new JTextArea(
			"Le jeu se joue avec un paquet de 54 cartes (2 jokers inclus) qui sera m�lang� de mani�re hasardeuse, puis\r\n"
					+ "sera distribu� selon le nombre de joueurs s�lectionn� pr�c�demment. 5 cartes par joueur seront distribu�es �\r\n"
					+ "chaque d�but de partie\n\n" + "Syst�me de score : \n"
					+ "Le premier joueur qui r�ussit � se d�barrasser de toutes ses cartes a gagn� ! \r\n"
					+ "Chaque joueur commence la partie avec un score de 100pts.\n"
					+ "Les scores finals se calculent seulement � la fin de \nchaque manche de la fa�on suivante: \r\n"
					+ "on compte le nombre de cartes que chaque joueur poss�de. \r\n"
					+ "On soustrait au score de chaque joueur le nombre de cartes qu�il poss�de (par ex si J1 a 4 cartes � la fin de la manche, \n"
					+ "il perdra 4pts). \r\n"
					+ "Le gagnant gagne autant de points qu�il y a de cartes poss�d�es par ses adversaires (par ex si J1\r\n"
					+ "est le gagnant, que J2 a 3 cartes, J3 a 6 cartes et J4 a 1 carte, J1 gagnera 10pts). \r\n"
					+ "Exception : Lorsqu�un joueur\r\n"
					+ "poss�de une bombe (voir plus loin) ou un joker, la valeur des points seras doubl� (on multiplie ses points par\r\n"
					+ "2 pour chaque bombe ou joker en main, si le joueur a 2 joker le score de sa main seras alors multipli� par 4)\n"
					+ "Pour pouvoir poser une carte, il faut qu�elle suive la carte pos�e par le joueur pr�c�dent (exemple : La carte\r\n"
					+ "4 suit la carte 3). \r\n\n"
					+ "Si le joueur ne peut pas jouer, alors il � n�y peut rien � et devras alors sauter son tour.");

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
