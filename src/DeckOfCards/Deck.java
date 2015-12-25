package DeckOfCards;
import java.util.ArrayList;


public class Deck {
	
	ArrayList<Card> DeckOfCards;
	ArrayList<Card> Dealt;
	
	public Deck()
	{
		for(int x=0; x<13; x++){
			for(int y=0; y<4; y++){
				Card nCard= new Card(y, x);
				DeckOfCards.add(nCard);
			}	
		}	
				
	}

	public Card show()
	{
		Card topCard=DeckOfCards.get(DeckOfCards.size());
		return topCard;
	}
	public Card deal()
	{
		Card topCard=DeckOfCards.get(DeckOfCards.size());
		Dealt.add(topCard);
		DeckOfCards.remove(DeckOfCards.size());
		DeckOfCards.trimToSize();
		return topCard;
	}
	
	public void done()
	{
		while(!Dealt.isEmpty())
		{
			Card dealtTop=Dealt.remove(Dealt.size());
			Dealt.trimToSize();
			DeckOfCards.add(dealtTop);
		}
	}
	
	
}
