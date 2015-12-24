package DeckOfCards;
import java.util.ArrayList;
public class Deck {
	
	private ArrayList Deck;
	public Deck()
	{
		for(int x=0; x<13; x++){
			for(int y=0; y<4; y++){
				Card temp= new Card(y, x);
				Deck.add(temp);
			}	
		}	
				
	}

	
	
}
