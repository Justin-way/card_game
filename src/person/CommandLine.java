package person;

import card.Card;

import java.util.List;
import java.util.Random;

public class CommandLine {

    public Card execute(List<Card> cards) {

        if (cards == null || cards.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return cards.get(random.nextInt(cards.size()));

    }
}
