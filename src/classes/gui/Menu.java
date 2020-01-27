package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import traitement.Init;

public class Menu extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JButton buttonEntrainement = new JButton("Mode Entrainement");
	JButton buttonNormal = new JButton("Mode Normal");
	JButton info = new JButton("i");
	@SuppressWarnings("rawtypes")
	JList list = new JList();
	JButton buttonPlay = new JButton("Jouer");
	JTextField txt = new JTextField();
	JButton buttonMore = new JButton("+");
	JButton buttonLess = new JButton("-");
	JTextField txt2 = new JTextField();
	JButton buttonMore2 = new JButton("+");
	JButton buttonLess2 = new JButton("-");
	Init launchTable;
	MainGUI main = new MainGUI();
	int nbPlayer=2;
	int nbPlayerHumain=1;
	int nbPlayerBot=1;
	int rulesTypes=0;
	
	public Menu() {
		setTitle("Tu n'y peux rien ! MENU");
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 615);
		build();
		panel();
		
		this.setVisible(true);
		
		//construction de la fenetre
				
	}
	/*
	 * Construit le menu
	 */
	public void build() {
		

		buttonEntrainement.setForeground(Color.WHITE);
		buttonEntrainement.setBackground(Color.DARK_GRAY);
		buttonEntrainement.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonEntrainement.setBounds(313, 203, 340, 136);
		buttonEntrainement.addActionListener(new modeEntrainementListener());
		
		
		buttonNormal.setForeground(Color.WHITE);
		buttonNormal.setBackground(Color.LIGHT_GRAY);
		buttonNormal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonNormal.setBounds(313, 42, 340, 136);
		buttonNormal.addActionListener(new modeNormalListener());
		
		
		//Liste comportant toutes les spécificités de l'IA !!
		list.setForeground(Color.WHITE);
		list.setBackground(Color.DARK_GRAY);
		list.setBounds(64, 42, 174, 297);
		
		
		buttonPlay.setForeground(Color.WHITE);
		buttonPlay.setBackground(Color.DARK_GRAY);
		buttonPlay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPlay.setBounds(64, 369, 174, 71);
		buttonPlay.addActionListener(new playListener());
		
		
		txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt.setForeground(Color.WHITE);
		txt.setBackground(Color.DARK_GRAY);
		txt.setBounds(306, 371, 206, 71);
		txt.setText("Nombre d'humain: " + nbPlayerHumain);
	

		buttonMore.setForeground(Color.WHITE);
		buttonMore.setBackground(Color.DARK_GRAY);
		buttonMore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonMore.setBounds(633, 371, 97, 71);
		buttonMore.addActionListener(new incrementListener());
		
		
		buttonLess.setForeground(Color.WHITE);
		buttonLess.setBackground(Color.DARK_GRAY);
		buttonLess.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonLess.setBounds(524, 371, 97, 71);
		buttonLess.addActionListener(new decrementListener());
		
		
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt2.setForeground(Color.WHITE);
		txt2.setBackground(Color.DARK_GRAY);
		txt2.setBounds(306, 471, 206, 71);
		txt2.setText("Nombre de Bot: " + nbPlayerBot);
	

		buttonMore2.setForeground(Color.WHITE);
		buttonMore2.setBackground(Color.DARK_GRAY);
		buttonMore2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonMore2.setBounds(633, 471, 97, 71);
		buttonMore2.addActionListener(new incrementListener2());
		
		
		buttonLess2.setForeground(Color.WHITE);
		buttonLess2.setBackground(Color.DARK_GRAY);
		buttonLess2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonLess2.setBounds(524, 471, 97, 71);
		buttonLess2.addActionListener(new decrementListener2());
		
		

		info.setBackground(Color.white);
		info.setFont(new Font("Tahoma", Font.PLAIN, 10));
		info.setBounds(0, 0, 30, 30);
		info.addActionListener(new infoListener());
	}
	
	
	public void panel() {

		
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		panel.add(info);
		panel.add(buttonEntrainement);
		panel.add(buttonNormal);
		panel.add(list);
		panel.add(buttonPlay);
		panel.add(buttonMore);
		panel.add(buttonLess);
		panel.add(txt);
		panel.add(buttonMore2);
		panel.add(buttonLess2);
		panel.add(txt2);
		
		
	}
	
	public void quit() {
		this.dispose();
	}
	
	public Init getInit() {
		return launchTable;
		
	}
	
	class modeEntrainementListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(rulesTypes == 0) {
				rulesTypes=1;
				buttonEntrainement.setBackground(Color.LIGHT_GRAY);
				buttonNormal.setBackground(Color.DARK_GRAY);
			}
			buttonMore.setEnabled(false);
			buttonLess.setEnabled(false);
			buttonMore2.setEnabled(false);
			buttonLess2.setEnabled(false);
			txt.setText("Nombre d'humain: 1");
			txt2.setText("Nombre de Bot: 4");
		}
	}
	
	class modeNormalListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(rulesTypes == 1) {
				rulesTypes=0;
				buttonEntrainement.setBackground(Color.DARK_GRAY);
				buttonNormal.setBackground(Color.LIGHT_GRAY);
			}
			buttonMore.setEnabled(true);
			buttonLess.setEnabled(true);
			buttonMore2.setEnabled(true);
			buttonLess2.setEnabled(true);
			txt.setText("Nombre d'humain: " + nbPlayerHumain);
			txt2.setText("Nombre de Bot: " + nbPlayerHumain);
		}
	}
	
	class playListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			quit();
			if(rulesTypes == 0) {
				MainGUI main = new MainGUI();
				Init.setNbPlayer(nbPlayer);
				Init.setNbPlayerBot(nbPlayerBot);
				Init.setNbPlayerHumain(nbPlayerHumain);
				main.show();
			}
			else {
				trainingGui main=new trainingGui();
				Init.setNbPlayer(5);
				Init.setNbPlayerBot(4);
				Init.setNbPlayerHumain(1);
				main.show();
			}
			
		}
	}
	
	class incrementListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nbPlayer<5) {
				nbPlayerHumain++;
				nbPlayer++;
			}
			else {
				JOptionPane.showMessageDialog( null, "MAXIMUM 5 JOUEUR!!", "ERREUR NOMBRE DE JOUEUR", JOptionPane.ERROR_MESSAGE);
			}
			txt.setText("Nombre d'humain: " + nbPlayerHumain);
		}
	}
	
	class decrementListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nbPlayer>2 && nbPlayerHumain>1) {
				nbPlayerHumain--;
				nbPlayer--;
			}
			else {
				JOptionPane.showMessageDialog( null, "MINIMUM 2 JOUEUR!! AVEC UN JOUEUR HUMAIN AU MINIMUM", "ERREUR NOMBRE DE JOUEUR", JOptionPane.ERROR_MESSAGE);
			}
			txt.setText("Nombre d'humain: " + nbPlayerHumain);
		}
	}
	
	class incrementListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nbPlayer<5) {
				nbPlayerBot++;
				nbPlayer++;
			}
			else {
				JOptionPane.showMessageDialog( null, "MAXIMUM 5 JOUEUR!!", "ERREUR NOMBRE DE JOUEUR", JOptionPane.ERROR_MESSAGE);
			}
			txt2.setText("Nombre de Bot: " + nbPlayerBot);
		}
	}
	
	class decrementListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nbPlayer >2) {
				nbPlayerBot--;
				nbPlayer--;
			}
			else {
				JOptionPane.showMessageDialog( null, "MINIMUM 2 JOUEUR!!", "ERREUR NOMBRE DE JOUEUR", JOptionPane.ERROR_MESSAGE);
			}
			txt2.setText("Nombre de Bot: " + nbPlayerBot);
		}
	}
	
	class infoListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			rulesGui frame= new rulesGui();
		}
	}
}


