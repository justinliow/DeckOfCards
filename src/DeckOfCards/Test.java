package DeckOfCards;

public class Test {

	public static void main(String[] args) {
		Deck test = new Deck();
		int deckSize = test.DeckOfCards.size();
		test.shuffle(100000);

		for(int x = 0; x < deckSize; x++)
		{
			Card tempCard = test.deal();
			System.out.println("Value: " + tempCard.getValue());
			System.out.println("Suit: " + tempCard.getSuit());
		}
		
	}
}
