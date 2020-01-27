package traitement;


import java.util.ArrayList;

import carte.BotPlayer;
import carte.Card;
import carte.CardType;
import carte.Discard;
import carte.Game;
import carte.Hand;
import carte.Player;
import carte.Scoreboard;
import carte.Stock;
import carte.Table;
/**
 * 
 * @author cvericel
 * Initialise la partie
 */
public class Init{
	
	private static  ArrayList<Player> players=new ArrayList<Player>();
	private static  Stock stock=new Stock();
	private static Discard discard=new Discard();
	private static Table table ;
	private Game game;
	private static int nbPlayer;
	private static int nbPlayerHumain;
	private static int nbPlayerBot;

	/*
	 * Initialise la Partie
	 */
	public static Game initGame() {
		//On initialise la table
		table=initTable();
		
		//On y ajoute les joueurs humain
		for(int i=0; i<nbPlayerHumain; i++) {
			players.add(initPlayer(i, stock));
		}
		//On y ajoute les joueurs "bot"
		for(int i=0; i<nbPlayerBot; i++) {
			players.add(initBot(i, stock));
		}
		Game game=new Game(table, players);
		return game;
	}
	/*
	 * initialise la table
	 */
	public static Table initTable() {
		//On creer la nouvelle pioche et on l'initialise
		stock=new Stock();
		stock=initStock();
		Table intertable=new Table(stock, discard);
		return intertable;
	}
	
	/*
	 * Methode qui va initialiser un joueur humain
	 * @param i | l'id du joueur
	 */
	public static Player initPlayer(int i, Stock stock) {
		//On creer le joueur
		Player p=new Player("Player"+i, null, 0, null, 0);
		Hand h= new Hand();
		Scoreboard score=new Scoreboard(100);
		p.setScore(score);
		p.setHand(h);
		//On initialise sa main
		initHand(p, stock);
		return p;
	}
	/*
	 * Methode qui va initialiser un joueur "bot"
	 */
	public static Player initBot(int i, Stock stock) {
		//On creer le joueur
		Player p=new BotPlayer("Bot"+i, null, null, 0);
		Hand h= new Hand();
		Scoreboard score=new Scoreboard(100);
		p.setScore(score);
		p.setHand(h);
		//On initialise sa main
		initHand(p, stock);
		return p;
	}
	/*
	 *  Initialise une main
	 */
	public static void initHand(Player player, Stock stock) {
		for(int i=0; i<5; i++) {
			/*
			 * On appele la methode static qui gere la pioche
			 */
			Management.stockManagement(player.getHand(), stock);
		}
	}

	/*
	 * initialise la pioche
	 * Méthode BRUTE et SALE
	 * ON CREER CHAQUE CARTE UNE PAR UNE ET ON LES MET DANS LA PIOCHE
	 */
	public static Stock initStock() {
		Stock init= new Stock();
		CardType as=new CardType("As", 140);		
		CardType deux=new CardType("2", 200);		
		CardType trois=new CardType("3", 30);				
		CardType quatre=new CardType("4", 40);		
		CardType cinq=new CardType("5", 50);		
		CardType six=new CardType("6", 60);		
		CardType sept=new CardType("7", 70);		
		CardType huit=new CardType("8", 80);		
		CardType neuf=new CardType("9", 90);		
		CardType dix=new CardType("10", 100);		
		CardType valet=new CardType("Valet", 110);		
		CardType dame=new CardType("Dame", 120);		
		CardType roi=new CardType("Roi", 130);	
		CardType joker=new CardType("Joker", 250);
		
		Card as_trefle=new Card("as de trefle", 141);
		Card as_coeur=new Card("as de coeur", 142);
		Card as_pic=new Card("as de pic", 143);
		Card as_carreaux=new Card("as de carreaux", 144);
		ArrayList<Card> a=new ArrayList<Card>();
		a.add(as_trefle);
		a.add(as_coeur);
		a.add(as_pic);
		a.add(as_carreaux);
		

		Card deux_trefle=new Card("2 de trefle", 201);
		Card deux_coeur=new Card("2 de coeur", 202);
		Card deux_pic=new Card("2 de pic", 203);
		Card deux_carreaux=new Card("2 de carreaux", 204);
		ArrayList<Card> b=new ArrayList<Card>();
		b.add(deux_trefle);
		b.add(deux_coeur);
		b.add(deux_pic);
		b.add(deux_carreaux);
		
		Card trois_trefle=new Card("3 de trefle", 31);
		Card trois_coeur=new Card("3 de coeur", 32);
		Card trois_pic=new Card("3 de pic", 33);
		Card trois_carreaux=new Card("3 de trecarreauxfle", 34);
		ArrayList<Card> c=new ArrayList<Card>();
		c.add(trois_trefle);
		c.add(trois_coeur);
		c.add(trois_pic);
		c.add(trois_carreaux);
		
		Card quatre_trefle=new Card("4 de trefle", 41);
		Card quatre_coeur=new Card("4 de coeur", 42);
		Card quatre_pic=new Card("4 de pic", 43);
		Card quatre_carreaux=new Card("4 de carreaux", 44);
		ArrayList<Card> d=new ArrayList<Card>();
		d.add(quatre_trefle);
		d.add(quatre_coeur);
		d.add(quatre_pic);
		d.add(quatre_carreaux);
		
		Card cinq_trefle=new Card("5 de trefle", 51);
		Card cinq_coeur=new Card("5 de coeur", 52);
		Card cinq_pic=new Card("5 de pic", 53);
		Card cinq_carreaux=new Card("5 de carreaux", 54);
		ArrayList<Card> e=new ArrayList<Card>();
		e.add(cinq_trefle);
		e.add(cinq_coeur);
		e.add(cinq_pic);
		e.add(cinq_carreaux);
		
		Card six_trefle=new Card("6 de trefle", 61);
		Card six_coeur=new Card("6 de coeur", 62);
		Card six_pic=new Card("6 de pic", 63);
		Card six_carreaux=new Card("6 de carreaux", 64);
		ArrayList<Card> f=new ArrayList<Card>();
		f.add(six_trefle);
		f.add(six_coeur);
		f.add(six_pic);
		f.add(six_carreaux);
		
		Card sept_trefle=new Card("7 de trefle", 71);
		Card sept_coeur=new Card("7 de coeur", 72);
		Card sept_pic=new Card("7 de pic", 73);
		Card sept_carreaux=new Card("7 de carreaux", 74);
		ArrayList<Card> g=new ArrayList<Card>();
		g.add(sept_trefle);
		g.add(sept_coeur);
		g.add(sept_pic);
		g.add(sept_carreaux);
		
		Card huit_trefle=new Card("8 de trefle", 81);
		Card huit_coeur=new Card("8 de coeur", 82);
		Card huit_pic=new Card("8 de pic", 83);
		Card huit_carreaux=new Card("8 de carreaux", 84);
		ArrayList<Card> h=new ArrayList<Card>();
		h.add(huit_trefle);
		h.add(huit_coeur);
		h.add(huit_pic);
		h.add(huit_carreaux);
		
		Card neuf_trefle=new Card("9 de trefle", 91);
		Card neuf_coeur=new Card("9 de coeur", 92);
		Card neuf_pic=new Card("9 de pic", 93);
		Card neuf_carreaux=new Card("9 de carreaux", 94);
		ArrayList<Card> i=new ArrayList<Card>();
		i.add(neuf_trefle);
		i.add(neuf_coeur);
		i.add(neuf_pic);
		i.add(neuf_carreaux);
		
		Card dix_trefle=new Card("10 de trefle", 101);
		Card dix_coeur=new Card("10 de coeur", 102);
		Card dix_pic=new Card("10 de pic", 103);
		Card dix_carreaux=new Card("10 de carreaux", 104);
		ArrayList<Card> j=new ArrayList<Card>();
		j.add(dix_trefle);
		j.add(dix_coeur);
		j.add(dix_pic);
		j.add(dix_carreaux);
		
		Card valet_trefle=new Card("valet de trefle", 111);
		Card valet_coeur=new Card("valet de coeur", 112);
		Card valet_pic=new Card("valet de pic", 113);
		Card valet_carreaux=new Card("valet de carreaux", 114);
		ArrayList<Card> k=new ArrayList<Card>();
		k.add(valet_trefle);
		k.add(valet_coeur);
		k.add(valet_pic);
		k.add(valet_carreaux);
		
		Card dame_trefle=new Card("dame de trefle", 121);
		Card dame_coeur=new Card("dame de coeur", 122);
		Card dame_pic=new Card("dame de pic", 123);
		Card dame_carreaux=new Card("dame de carreaux", 124);
		ArrayList<Card> l=new ArrayList<Card>();
		l.add(dame_trefle);
		l.add(dame_coeur);
		l.add(dame_pic);
		l.add(dame_carreaux);
		
		Card roi_trefle=new Card("roi de trefle", 131);
		Card roi_coeur=new Card("roi de coeur", 132);
		Card roi_pic=new Card("roi de pic", 133);
		Card roi_carreaux=new Card("roi de carreaux", 134);
		ArrayList<Card> m=new ArrayList<Card>();
		m.add(roi_trefle);
		m.add(roi_coeur);
		m.add(roi_pic);
		m.add(roi_carreaux);
		
		Card joker_a=new Card("joker rouge", 251);
		Card joker_b=new Card("joker noir", 252);
		ArrayList<Card> n=new ArrayList<Card>();
		n.add(joker_a);
		n.add(joker_b);

		as.setList(a);
		deux.setList(b);
		trois.setList(c);
		quatre.setList(d);
		cinq.setList(e);
		six.setList(f);
		sept.setList(g);
		huit.setList(h);
		neuf.setList(i);
		dix.setList(j);
		valet.setList(k);
		dame.setList(l);
		roi.setList(m);
		joker.setList(n);
		
		
		init.add(as);
		init.add(deux);		
		init.add(trois);		
		init.add(quatre);
		init.add(cinq);
		init.add(six);	
		init.add(sept);	
		init.add(huit);	
		init.add(neuf);		
		init.add(dix);		
		init.add(valet);
		init.add(dame);
		init.add(roi);
		init.add(joker);
		return init;
	}
	
	public static void setNbPlayer(int nbrPlayer) {
		nbPlayer = nbrPlayer;
	}
	
	public static int getNbPlayer() {
		return nbPlayer;
	}
	
	public static int getNbPlayerHumain() {
		return nbPlayerHumain;
	}
	
	public static void setNbPlayerHumain(int nbPlayerHumain) {
		Init.nbPlayerHumain = nbPlayerHumain;
	}
	
	public static int getNbPlayerBot() {
		return nbPlayerBot;
	}
	
	public static void setNbPlayerBot(int nbPlayerBot) {
		Init.nbPlayerBot = nbPlayerBot;
	}
	
}