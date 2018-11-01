
public class Card {

	char suit;
	String val;
	
	public char getSuit() {
		return suit;
	}
	public void setSuit(char suit) {
		this.suit = suit;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public Card(char suit, String val) {
		super();
		this.suit = suit;
		this.val = val;
	}
	
}
