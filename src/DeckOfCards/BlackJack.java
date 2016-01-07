package DeckOfCards;

import java.util.ArrayList;

public class BlackJack {
	static private ArrayList<Card> player = new ArrayList<Card>();
	static private ArrayList<Card> dealer = new ArrayList<Card>();
	static Deck gameDeck= new Deck();
	public void setUp()
	{
		gameDeck.shuffle(100000);
	}
	public void dealHand()
	{
		for(int i=0; i<2; i++)
		{
			player.add(gameDeck.deal());
			dealer.add(gameDeck.deal());
		}
		System.out.println(player.get(1).decodePrint());
		System.out.println(dealer.get(1).decodePrint());
	}
	
	
	public void reset()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
