package DeckOfCards;

import java.util.ArrayList;


public class War 
{
	static ArrayList<Card> playerOne = new ArrayList<Card>();
	static ArrayList<Card> playerTwo = new ArrayList<Card>();
	static int playerOneWins = 0;
	static int playerTwoWins = 0;
	
	public static void SetUp()
	{
		Deck GameDeck = new Deck();
		GameDeck.shuffle(10000);
		playerOne.clear();
		playerTwo.clear();
		/*
		for(int i = 0; i < 26; i ++)
		{
			//System.out.println(GameDeck.show().getValue());
			playerTwo.add(GameDeck.deal());
			//System.out.println(GameDeck.show().getValue());
			playerOne.add(GameDeck.deal());
		}
		*/
		/*
		for(int x = 0; x < 52; x++)
		{
			Card tempCard = GameDeck.deal();
			System.out.println("Value: " + tempCard.getValue());
			System.out.println("Suit: " + tempCard.getSuit());
		}
		*/
		
		for(int i = 0; i < 52; i +=2)
		{
			playerTwo.add(GameDeck.DeckOfCards.get(i));
			playerOne.add(GameDeck.DeckOfCards.get(i+1));
		}
	}
	
	public static Card DrawSoldier(ArrayList<Card> deck)
	{
		return deck.get(deck.size()-1);
	}
	
	public static int Fight(Card one, Card two)
	{
		System.out.println("Player 1: " + one.getValue() + " Player 2: " + two.getValue());
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
	
	public static void Game(int gameReps, int winCondition)
	{
		for(int i = 0; i < gameReps; i++)
		{
			while(playerOne.size() > winCondition && playerTwo.size() > winCondition)
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
			if(playerOne.size() > playerTwo.size())
			{
				playerOneWins ++;
			}
			else
			{
				playerTwoWins ++;
			}
			SetUp();
		}
		System.out.println("Player One Won " + playerOneWins + " times.");
		System.out.println("Player Two Won " + playerTwoWins + " times.");
	}
	
	public static void main(String[] args) 
	{
		SetUp();
		Game(1,10);
	}
	
	class WarPlayer
	{
		//ArrayList<Card> Cards = new ArrayList<Card>();
		
	}
}

