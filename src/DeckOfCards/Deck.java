package DeckOfCards;
import java.util.ArrayList;


public class Deck {
	
	ArrayList<Card> DeckOfCards = new ArrayList<Card>();
	ArrayList<Card> Dealt = new ArrayList<Card>();
	
	public Deck()
	{
		for(int x=1; x <= 13; x++){
			for(int y = 1; y <= 4; y++){
				Card nCard= new Card(y, x);
				DeckOfCards.add(nCard);
			}	
		}	
				
	}

	public Card show()
	{
		Card topCard=DeckOfCards.get(DeckOfCards.size()-1);
		return topCard;
	}
	public Card deal()
	{
		Card topCard=DeckOfCards.get(DeckOfCards.size()-1);
		Dealt.add(topCard);
		DeckOfCards.remove(DeckOfCards.size()-1);
		//DeckOfCards.trimToSize();
		return topCard;
	}
	
	public void done()
	{
		while(!Dealt.isEmpty())
		{
			Card dealtTop=Dealt.remove(Dealt.size()-1);
			Dealt.trimToSize();
			DeckOfCards.add(dealtTop);
		}
	}
	
	
}