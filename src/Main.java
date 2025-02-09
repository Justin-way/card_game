import card.Card;
import card.SimpleGameCard;
import person.AI;
import person.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Card simpleGameCard1 = new SimpleGameCard(1);
        Card simpleGameCard2 = new SimpleGameCard(2);
        Card simpleGameCard3 = new SimpleGameCard(3);
        Card simpleGameCard4 = new SimpleGameCard(4);
        List<Card> cards = new ArrayList<>();

        cards.add(simpleGameCard1);
        cards.add(simpleGameCard2);
        cards.add(simpleGameCard3);
        cards.add(simpleGameCard4);

        AI ai = new AI();
        ai.setCards(cards);

        while (!cards.isEmpty()) {
            SimpleGameCard card = (SimpleGameCard) ai.choose(cards);
            System.out.println("choose cards:" + card.getId());
        }
    }
}