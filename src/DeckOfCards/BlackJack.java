package DeckOfCards;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
	static private ArrayList<Card> player = new ArrayList<Card>();
	static private ArrayList<Card> dealer = new ArrayList<Card>();
	static Deck gameDeck= new Deck();
	static int wins;
	static int losses;
	public static void setUp()
	{	Random rand=new Random();
		int i = rand.nextInt(51000) + 0;
		System.out.println(i);
		gameDeck.shuffle(i);
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
	
	private static int valueofPlayerHand()
	{
		int value=0;
		for(int i=0; i<player.size(); i++)
		{	int temp=player.get(i).getValue();
			if(temp>=10)
				temp=10;
			else if(temp==1)
				temp=11;
			value+=temp;
		}
		int count=0;
		for(int x=0; x<player.size(); x++)
		{
			if(player.get(x).getValue()==1&&value>21)
			{
				count++;
			}
		}
		for(int x=0; x<count; x++)
		{
			value-=10;
		}
		return value;
		
	}
	private static int valueofDealerHand()
	{
		int value=0;
		for(int i=0; i<dealer.size(); i++)
		{	int temp=dealer.get(i).getValue();
			if(temp>=10)
				temp=10;
			else if(temp==1)
				temp=11;
			value+=temp;
		}
		int count=0;
		for(int x=0; x<dealer.size(); x++)
		{
			if(dealer.get(x).getValue()==1&&value>21)
			{
				count++;
			}
		}
		for(int x=0; x<count; x++)
		{
			value-=10;
		}
		return value;
	}
	public static void play()
	{
		System.out.println("Would you like to (H)it or (S)tay?");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		System.out.println(input);
		if(input.equals("h")||input.equals("H"))
		{   Card temp=gameDeck.deal();
			player.add(temp);
			System.out.println("You draw a "+temp.decodePrint());
			int value=valueofPlayerHand();
			System.out.println("Your new value is "+value);
			if(value>21)
			{
				System.out.println("you lose");
				losses++;
				reset();
			}
			play();

		}
		else if(input=="s"||input=="S")
		{
			dealer();
			int dealerValue=valueofDealerHand();
			int playerValue=valueofPlayerHand();
			System.out.println("You finished with a " +playerValue);
			System.out.println("The Dealer finished with a " +dealerValue);
			if(dealerValue>=playerValue)
			{
				System.out.println("you lose");
				losses++;
				reset();
			}
			else
			{
				System.out.println("you win");
				wins++;
				reset();
			}
		}
		else
		{
			reset();
		}
	}
	public static void dealer()
	{
		int dealerValue=valueofDealerHand();
		while (dealerValue<17)
		{
			System.out.println("dealer hits");
			Card tempDealer=gameDeck.deal();
			dealer.add(tempDealer);
			System.out.println("and draws a "+tempDealer.decodePrint());
			dealerValue=valueofDealerHand();
		}
	
			
		
	}
	public static void reset()
	{
		
			gameDeck.done();
			player.clear();
			dealer.clear();
			dealHand();
			play();
			
	}
	public static void main(String[] args) {
		setUp();
		dealHand();
		play();
		

	}

}
