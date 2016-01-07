package DeckOfCards;

public class Card {
	private int suit;
	private int value;
	
	public Card(int suit, int value)
	{
		this.suit=suit;
		this.value=value;
	}
	
	public int getSuit()
	{
		return this.suit;
	}
	
	public int getValue()
	{
		return this.value;
	}
	public String decodePrint()
	{
		String printSuit="";
		String printValue="";
		String printOut="";
		int currSuit=this.getSuit();
		int currValue=this.getValue();
		if(currSuit==0)
		{
			printSuit="Clovers";
		}
		else if(currSuit==1)
		{
			printSuit="Diamonds";
		}
		else if(currSuit==2)
		{
			printSuit="Hearts";
		}
		else if(currSuit==3)
		{
			printSuit="Spades";
		}
		if(currValue==1)
		{
			printValue="Ace";
		}
		else if(currValue==11)
		{
			printValue="Jack";
		}
		else if(currValue==12)
		{
			printValue="Queen";
		}
		else if(currValue==13)
		{
			printValue="King";
		}
		else
		{
			printValue=printValue+=currValue;
		}
		printOut+=printValue+" of "+printSuit;
		return printOut;
	}
}
