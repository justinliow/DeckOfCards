package DeckOfCards;

import java.util.ArrayList;


public class War 
{
	static ArrayList<Card> playerOne = new ArrayList<Card>();
	static ArrayList<Card> playerTwo = new ArrayList<Card>();
	
	public static void SetUp()
	{
		Deck GameDeck = new Deck();
		GameDeck.shuffle(100000);
		for(int i = 0; i < 26; i ++)
		{
			//System.out.println(GameDeck.show().getValue());
			playerTwo.add(GameDeck.deal());
			//System.out.println(GameDeck.show().getValue());
			playerOne.add(GameDeck.deal());
		}
	}
	
	public static Card DrawSoldier(ArrayList<Card> deck)
	{
		return deck.get(deck.size()-1);
	}
	
	public static int Fight(Card one, Card two)
	{
		//System.out.println("Player 1: " + one.getValue() + " Player 2:" + two.getValue());
		if(one.getValue() > two.getValue())
		{
			return 0;
		}
		else if(one.getValue() < two.getValue())
		{
			return 1;
		}
		else
		{
			if(one.getSuit() > two.getSuit())
			{
				return 0;
			}
			return 1;
		}
	}
	
	public static void Game()
	{
		while(playerOne.size() > 5 && playerTwo.size() > 5)
		{
			Card playerOneDraw = DrawSoldier(playerOne);
			playerOne.remove(playerOne.size()-1);
			Card playerTwoDraw = DrawSoldier(playerTwo);
			playerTwo.remove(playerTwo.size()-1);
			if(Fight(playerOneDraw, playerTwoDraw) == 0)
			{
				playerOne.add(0, playerOneDraw);
				playerOne.add(0, playerTwoDraw);
			}
			else
			{
				playerTwo.add(0, playerTwoDraw);
				playerTwo.add(0, playerOneDraw);
			}
		}
		System.out.println(playerTwo.size());
	}
	
	public static void main(String[] args) 
	{
		SetUp();
		Game();
	}
	
	class WarPlayer
	{
		//ArrayList<Card> Cards = new ArrayList<Card>();
		
	}
}

