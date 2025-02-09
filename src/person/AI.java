package person;

import card.Card;

import java.util.List;
import java.util.Random;

public class AI extends Player{


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
