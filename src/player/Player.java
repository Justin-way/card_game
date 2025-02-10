package player;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public abstract class Player  {
	int id;
	List<Card> cards = new ArrayList<>();
	String name;
	int points = 0;
	Card card;

	public abstract void unoChoose(Card card1);
	public void addCard(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void setName(String name){
		this.name = name;
	}
	public void addPoints() {
		points++;
	}
	public abstract Card simpleChoose();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append("\t");
		for (Card card : cards) {
			sb.append(card.getSuit()).append(" ").append(card.getRank()).append("\t");
		}
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
}
