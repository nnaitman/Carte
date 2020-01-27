package carte;

import java.util.ArrayList;

/**
 * @author bsadiki
 */
public class Card {

	private String name;
	private int key;
	
	public Card(String name, int key) {
		this.name = name;
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return name;
	}
	
	/*
	 * Retourne une carte selon la clé rentrée
	 */
	public static Card getCardWithKey(Integer searchKey){
	
		switch(searchKey) {
		
		case 141:
			Card as_trefle=new Card("as de trefle", 141);
			return as_trefle;
		case 142:
			Card as_coeur=new Card("as de coeur", 142);
			return as_coeur;
		case 143:
			Card as_pic=new Card("as de pic", 143);
			return as_pic;

		case 144:
			Card as_carreaux=new Card("as de carreaux", 144);
			return as_carreaux;
	
		case 201:
			Card deux_trefle=new Card("2 de trefle", 201);
			return deux_trefle;
	
		case 202:
			Card deux_coeur=new Card("2 de coeur", 202);
			return deux_coeur;
		
		case 203:
			Card deux_pic=new Card("2 de pic", 203);
			return deux_pic;
		 		
		case 204:
			Card deux_carreaux=new Card("2 de carreaux", 204);
			return deux_carreaux;
		 		
		case 31:
			Card trois_trefle=new Card("3 de trefle", 31);
			return trois_trefle;
		 		
		case 32:
			Card trois_coeur=new Card("3 de coeur", 32);
			return trois_coeur;		 
		
		case 33:
			Card trois_pic=new Card("3 de pic", 33);
			return trois_pic;		 
		
		case 34:
			Card trois_carreaux=new Card("3 de trecarreauxfle", 34);
			return trois_carreaux;
		 		
		case 41:
			Card quatre_trefle=new Card("4", 41);
			return quatre_trefle;		 
		
		case 42:
			Card quatre_coeur=new Card("4 de coeur", 42);
			return quatre_coeur;		 
		
		case 43:
			Card quatre_pic=new Card("4 de pic", 43);
			return quatre_pic;
		 		
		case 44:
			Card quatre_carreaux=new Card("4 de carreaux", 44);
			return quatre_carreaux;
		 		
		case 51:
			Card cinq_trefle=new Card("5 de trefle", 51);
			return cinq_trefle;		 
		
		case 52:
			Card cinq_coeur=new Card("5 de coeur", 52);
			return cinq_coeur;		 
		
		case 53:
			Card cinq_pic=new Card("5 de pic", 53);
			return cinq_pic;
		 		
		case 54:
			Card cinq_carreaux=new Card("5 de carreaux", 54);
			return cinq_carreaux;
		 		
		case 61:
			Card six_trefle=new Card("6 de trefle", 61);
			return six_trefle;
		 		
		case 62:
			Card six_coeur=new Card("6 de coeur", 62);
			return six_coeur;		 
		
		case 63:
			Card six_pic=new Card("6 de pic", 63);
			return six_pic;
		 		
		case 64:
			Card six_carreaux=new Card("6 de carreaux", 64);
			return six_carreaux;
		 		
		case 71:
			Card sept_trefle=new Card("7 de trefle", 71);
			return sept_trefle;
		 		
		case 72:
			Card sept_coeur=new Card("7 de coeur", 72);
			return sept_coeur;
		 		
		case 73:
			Card sept_pic=new Card("7 de pic", 73);
			return sept_pic;		 
		
		case 74:
			Card sept_carreaux=new Card("7 de carreaux", 74);
			return sept_carreaux;		 
		
		case 81:
			Card huit_trefle=new Card("8 de trefle", 81);
			return huit_trefle;
		 		
		case 82:
			Card huit_coeur=new Card("8 de coeur", 82);
			return huit_coeur;
		 
		case 83:
			Card huit_pic=new Card("8 de pic", 83);
			return huit_pic;
		 	
		case 84:
			Card huit_carreaux=new Card("8 de carreaux", 84);
			return huit_carreaux;
		 		
		case 91:
			Card neuf_trefle=new Card("9 de trefle", 91);
			return neuf_trefle;
		 	
		case 92:
			Card neuf_coeur=new Card("9 de coeur", 92);
			return neuf_coeur;	 
		
		case 93:
			Card neuf_pic=new Card("9 de pic", 93);
			return neuf_pic;
		 	
		case 94:
			Card neuf_carreaux=new Card("9 de carreaux", 94);
			return neuf_carreaux;		 
		
		case 101:
			Card dix_trefle=new Card("10 de trefle", 101);
			return dix_trefle;
							
		case 102:
			Card dix_coeur=new Card("10 de coeur", 102);
			return dix_coeur;
		 		
		case 103:
			Card dix_pic=new Card("10 de pic", 103);
			return dix_pic;
		 	
		case 104:
			Card dix_carreaux=new Card("10 de carreaux", 104);
			return dix_carreaux;	 
		
		case 111:
			Card valet_trefle=new Card("valet de trefle", 111);
			return valet_trefle;
		 		
		case 112:
			Card valet_coeur=new Card("valet de coeur", 112);
			return valet_coeur;
		 		
		case 113:
			Card valet_pic=new Card("valet de pic", 113);
			return valet_pic;
		 		
		case 114:
			Card valet_carreaux=new Card("valet de carreaux", 114);
			return valet_carreaux;
		 		
		case 121:
			Card dame_trefle=new Card("dame de trefle", 121);
			return dame_trefle;
		
		case 122:
			Card dame_coeur=new Card("dame de coeur", 122);
			return dame_coeur;
		
		case 123:
			Card dame_pic=new Card("dame de pic", 123);
			return dame_pic;
		 		
		case 124:
			Card dame_carreaux=new Card("dame de carreaux", 124);
			return dame_carreaux;
		 	
		case 131:
			Card roi_trefle=new Card("roi de trefle", 131);
			return roi_trefle;		 
		
		case 132:
			Card roi_coeur=new Card("roi de coeur", 132);
			return roi_coeur;
		 
		
		case 133:
			Card roi_pic=new Card("roi de pic", 133);
			return roi_pic;
		 		
		case 134:
			Card roi_carreaux=new Card("roi de carreaux", 134);
			return roi_carreaux;
		 		
		case 251:
			Card joker_a=new Card("joker rouge", 251);
			return joker_a;
		 		
		case 252:
			Card joker_b=new Card("joker noir", 252);
			return joker_b;
		 
		
		default:
			return null;
		}
	}
}
