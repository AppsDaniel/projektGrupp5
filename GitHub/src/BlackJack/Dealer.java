package BlackJack;

public class Dealer extends Hand {
	Hand playingDeck = new Hand();
	Hand dealerDeck = new Hand();

	protected void generateCard(Hand playingDeck) {

		dealerDeck.draw(playingDeck);
		dealerDeck.draw(playingDeck);
		

	}

	protected int dealerChoice(Hand playingDeck) {
		System.out.println("\nDealers card: " + dealerDeck);
		int summan = dealerDeck.cardValue();
		
		if (summan <= 16) {
			System.out.println("Dealer draw card, needs to draw until 17 or more");
			do {
				dealerDeck.draw(playingDeck);
				System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
				summan = dealerDeck.cardValue();
			} while (summan <= 16);
		}
		summan = dealerDeck.cardValue();
		System.out.println("Deler's hand is valued at: " + summan);

		return summan;
	}
	protected void newDeck()
	{
		dealerDeck.moveAllToDeck(playingDeck);
	}
	@Override
	public String toString() {
		return ("Dealers Cards is " + dealerDeck.getCard(0).toString() + " and [Hidden]");
	}
}