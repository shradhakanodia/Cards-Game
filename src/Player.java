import java.util.ArrayList;
import java.util.List;

public class Player {

	List<Card> cards;
	int numOfCards;
	public String playerName;
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public int getNumOfCards() {
		return numOfCards;
	}

	public void setNumOfCards(int numOfCards) {
		this.numOfCards = numOfCards;
	}
	
	public void addCard(Card card){
		if(cards==null)
			cards = new ArrayList<>();
		cards.add(card);
		this.numOfCards++;
	}
	
	public void showAllCards(){
		System.out.println("Player" + this.playerName + "Cards:\n");
		for(Card card : cards){
			System.out.print(card.suit+" "+card.val+",");
		}
	}

	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}
	
}
