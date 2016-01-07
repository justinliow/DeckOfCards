package DeckOfCards;

import java.util.ArrayList;

public class BlackJack {
	static private ArrayList<Card> player = new ArrayList<Card>();
	static private ArrayList<Card> dealer = new ArrayList<Card>();
	static Deck gameDeck= new Deck();
	public static void setUp()
	{
		gameDeck.shuffle(100000);
	}
	public static void dealHand()
	{
		for(int i=0; i<2; i++)
		{
			player.add(gameDeck.deal());
			dealer.add(gameDeck.deal());
		}
		System.out.println("The dealer is showing " + dealer.get(1).decodePrint());
		System.out.println("You are showing "+ player.get(1).decodePrint());
		System.out.println("Your other card is "+ player.get(0).decodePrint());
	}
	
	public int valueofPlayerHand()
	{
		int value=0;
		for(int i=0; i<2; i++)
		{
			value+=player.get(i).getValue();
		}
		return value;
	}
	public int valueofDealerrHand()
	{
		int value=0;
		for(int i=0; i<2; i++)
		{
			value+=dealer.get(i).getValue();
		}
		return value;
	}
	
	public void reset()
	{
		
	}
	public static void main(String[] args) {
		setUp();
		dealHand();
	

	}

}
