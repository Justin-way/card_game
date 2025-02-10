package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.Card;

public abstract class Deck {
	protected List<Card> cards = new ArrayList<>();

	protected abstract void initializeDeck();
	protected abstract Card drawCard();

	public Deck() {
		initializeDeck();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Card card : cards) {
			sb.append(card.toString()).append("\n");
		}
		return sb.toString();
	}


}
