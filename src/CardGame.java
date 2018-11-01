import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CardGame {

	public static void main(String args[]){
	
		List<Card> cardDeck = new LinkedList<>();
		HashMap<Card,Integer> deckOrderMap = new HashMap<>();
		List<Card> shuffledDeck = null;
		
		addSuiteToDeck('D',deckOrderMap);
		addSuiteToDeck('H',deckOrderMap);
		addSuiteToDeck('C',deckOrderMap);
		addSuiteToDeck('S',deckOrderMap);
		
		shuffledDeck = shuffleDeck(cardDeck, deckOrderMap);
		
//		for(Card card : deckOrderMap.keySet()){
//			System.out.print(card.suit+" "+card.val+" , ");
//		}
		
		List<Player> players = new ArrayList<>();
		players.add(new Player("P1"));
		players.add(new Player("P2"));
		players.add(new Player("P3"));
		players.add(new Player("P4"));
		distributeCards(shuffledDeck , players);
		for(Player player : players){
			player.showAllCards();
		}
	}
	
	public static void addSuiteToDeck(char suit, HashMap<Card,Integer> cardMap){
		
		cardMap.put(new Card(suit,"Ace"), 1);
		
		int n=2;
		while(n<=10){
			cardMap.put(new Card(suit,String.valueOf(n)), n);
			n++;
		}
		
		cardMap.put(new Card(suit,"Jack"), 11);
		cardMap.put(new Card(suit,"Queen"), 12);
		cardMap.put(new Card(suit,"King"), 13);	
	}
	
	public static List<Card> shuffleDeck(List<Card> cardDeck , HashMap<Card,Integer> deckOrderMap){
		List<Card> shuffledDeck = new LinkedList<>();
		cardDeck.addAll(deckOrderMap.keySet());
		
		Random random = new Random();
		while(!cardDeck.isEmpty()){
			int index = random.nextInt(cardDeck.size());
			
			if(!shuffledDeck.isEmpty() && shuffledDeck.get(shuffledDeck.size()-1).suit == cardDeck.get(index).suit
				&& Math.abs(deckOrderMap.get(shuffledDeck.get(shuffledDeck.size()-1))
						- deckOrderMap.get(cardDeck.get(index)))==1){
				
				continue;
			}
			
			shuffledDeck.add(cardDeck.get(index));
			cardDeck.remove(index);
			
		}
		
		return shuffledDeck;
	}
	
	public static void distributeCards(List<Card> shuffledDeck, List<Player> players){
		int playerIndex = 0;
		for(Card card : shuffledDeck){
			if(playerIndex==players.size())
				playerIndex = 0;
			Player currPlayer = players.get(playerIndex++);
			currPlayer.addCard(card);
		}
	}
	
}
