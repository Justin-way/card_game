package person;

import java.util.Random;

import card.Card;

public class AiPlayer extends Player{


	@Override
	public Card choose() {
		if (cards == null || cards.isEmpty()) {
			return null;
		}
		Random random = new Random();
		return cards.get(random.nextInt(cards.size()));
	}

	@Override
	public void unoChoose(Card card) {
		cards.remove(card);
	}
}
