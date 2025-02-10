package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.Card;
import card.SimpleCard;

public class SimpleDeck extends Deck {

	List<Card> cards = new ArrayList<>();

	public SimpleDeck() {
		initializeDeck();
	}

	@Override
	protected void initializeDeck() {
		String[] suits = {"heart", "diamond", "club", "spade"};
		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

		for (String suit : suits) {
			for (String rank : ranks) {

				cards.add(new SimpleCard(suit, rank));
			}
		}
	}


	@Override
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

	@Override
	public Card drawCard() {
		if (cards.isEmpty()) {
			return null;
		}
		return cards.remove(0);
	}
}
