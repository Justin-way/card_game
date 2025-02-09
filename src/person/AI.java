package person;

import card.Card;

import java.util.List;
import java.util.Random;

public class AI extends Player{
    List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public Card choose(List<Card> cards) {
        if (cards == null || cards.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(cards.size());
        return cards.remove(index);
    }

}
