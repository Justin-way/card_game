package deck;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public abstract class Deck {
	protected List<Card> cards = new ArrayList<>();

	public Deck() {
		initializeDeck();
	}

	public List<Card> getCards() {
		return cards;
	}


	public Card drawCard() {
		if (cards.isEmpty()) {
			return null;
		}
		return cards.remove(0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card card : cards) {
			sb.append(card.toString()).append("\n");
		}
		return sb.toString();
	}

	protected abstract void initializeDeck();

}
