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
}
