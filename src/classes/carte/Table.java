package carte;

/**
 * 
 * @author cvericel
 * Class qui gère une Table de jeu
 */
public class Table {
		private Stock stock;
		private Discard discard;
		private int type;
		
		public Table(Stock stock, Discard discard){
			this.stock=stock;
			this.discard=discard;
		}
		
		public Stock getStock() {
			return stock;
		}

		public void setStock(Stock stock) {
			this.stock = stock;
		}

		public Discard getDiscard() {
			return discard;
		}

		public void setDiscard(Discard discard) {
			this.discard = discard;
		}
				
		public int getType() {
			return type;
		}		
}
