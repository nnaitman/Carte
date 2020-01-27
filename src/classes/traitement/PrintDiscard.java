package traitement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import carte.Discard;
import carte.Game;
import carte.PicturePath;
import gui.PanelImage;

public class PrintDiscard {
	static PanelImage discardButton_a = new PanelImage();
	static PanelImage discardButton_b = new PanelImage();
	static PanelImage discardButton_c = new PanelImage();
	static PanelImage discardButton_d = new PanelImage();

	public static void printCard(JPanel gui, Discard discard) throws IOException {

		int size = discard.cardCount();

		switch (discard.getType()) {
		case 1:
			discardButton_a.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 1).getKey()));
			discardButton_a.setBounds(600, 220, 97, 143);
			gui.add(discardButton_a);
			gui.remove(discardButton_b);
			gui.remove(discardButton_c);
			gui.remove(discardButton_d);
			break;

		case 2:
			discardButton_a.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 2).getKey()));
			discardButton_a.setBounds(600, 220, 97, 143);
			discardButton_b.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 1).getKey()));
			discardButton_b.setBounds(697, 220, 97, 143);
			gui.add(discardButton_a);
			gui.add(discardButton_b);
			gui.remove(discardButton_c);
			gui.remove(discardButton_d);

			break;

		case 3:
			discardButton_a.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 3).getKey()));
			discardButton_a.setBounds(600, 220, 97, 143);
			discardButton_b.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 2).getKey()));
			discardButton_b.setBounds(697, 220, 97, 143);
			discardButton_c.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 1).getKey()));
			discardButton_c.setBounds(794, 220, 97, 143);
			gui.add(discardButton_a);
			gui.add(discardButton_b);
			gui.add(discardButton_c);
			gui.remove(discardButton_d);

			break;
		case 4:
			discardButton_a.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 4).getKey()));
			discardButton_a.setBounds(600, 220, 97, 143);
			discardButton_b.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 3).getKey()));
			discardButton_c.setBounds(697, 220, 97, 143);
			discardButton_c.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 2).getKey()));
			discardButton_c.setBounds(794, 220, 97, 143);
			discardButton_d.setImage(PicturePath.getPicturePath(discard.getCards().get(size - 1).getKey()));
			discardButton_d.setBounds(891, 220, 97, 143);
			gui.add(discardButton_a);
			gui.add(discardButton_b);
			gui.add(discardButton_c);
			gui.add(discardButton_d);

			break;

		}
		gui.repaint();
	}

	public static void printLog(JTextArea area, Game game) {
		int id = game.getId();
		int type = game.getTable(id).getDiscard().getLastPlaySize();
		int size = game.getTable(id).getDiscard().cardCount();

		String str = game.getPlayers().get(game.getPlayingPlayer()).getUsername() + " : a joué ";

		if (game.getPlayers().get(game.getPlayingPlayer()).getToPass() == 1) {
			area.append(game.getPlayers().get(game.getPlayingPlayer()).getUsername() + ": n'y peux rien\n");
		} else {
			for (int playSize = (size - type); playSize < size; playSize++) {
				str = str + game.getTable(id).getDiscard().getCards().get(playSize).getName() + "  ";
			}
			str = str + "\n";
			area.append(str);
		}
	}

	public static void printOtherPlayerHand(JPanel pan, Game game) {

		int j = game.getNextPlayingPlayer();
		int x = 60;
		int y = 0;
		pan.removeAll();
		for (int index = game.getNextPlayingPlayer(); index != game.getPlayingPlayer(); index = j) {

			x = 60;
			for (int i = 0; i < game.getPlayers().get(index).getHand().cardCount(); i++) {
				PanelImage card = new PanelImage();
				try {
					card.setImage(PicturePath.getPicturePath(game.getPlayers().get(index).getHand().getCardKey(i)));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				card.setBounds(x, y, 97, 143);

				pan.add(card);
				x = x + 97;

			}

			JTextField text = new JTextField();
			text.setEditable(false);
			text.setBackground(Color.WHITE);
			text.setText(game.getPlayers().get(index).getUsername());
			text.setBounds(0, y, 58, 143);
			text.setFont(new Font("Arial", Font.PLAIN, 18));
			pan.add(text);
			pan.repaint();

			y = y + 150;

			if (j + 1 > Init.getNbPlayer() - 1) {
				j = 0;
			} else {
				j++;
			}

		}
		pan.setPreferredSize(new Dimension(x, y));
	}

	public static void printOtherHandSize(JPanel pan, Game game) {
		int y = 0;
		pan.removeAll();

		for (int index = 0; index < game.getPlayers().size(); index++) {
			JTextField text = new JTextField();
			text.setEditable(false);
			text.setOpaque(false);
			text.setBackground(new Color(0, 0, 0, 0));
			text.setText(game.getPlayers().get(index).getUsername() + " a encore "
					+ game.getPlayers().get(index).getHand().cardCount() + " cartes");
			text.setBounds(0, y, 250, 25);
			text.setFont(new Font("Arial", Font.PLAIN, 18));
			text.setForeground(Color.WHITE);
			text.setBorder(null);
			pan.add(text);
			y = y + 25;
		}
	}
}
