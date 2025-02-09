package person;

import card.Card;

import java.util.Random;

public class AiPlayer extends Player{




    @Override
    public Card choose() {
        if (cards == null || cards.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));
    }

    public void unoChoose(Card card) {
        cards.remove(card);
    }
}
