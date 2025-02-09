import card.Card;
import card.SimpleGameCard;
import card.SimpleGameDeck;
import person.AI;
import person.Human;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Card simpleGameCard1 = new SimpleGameCard("heart","A" );
        Card simpleGameCard2 = new SimpleGameCard("heart","2" );
        Card simpleGameCard3 = new SimpleGameCard("heart","3" );
        Card simpleGameCard4 = new SimpleGameCard("heart","4" );
        List<Card> cards = new ArrayList<>();

        cards.add(simpleGameCard1);
        cards.add(simpleGameCard2);
        cards.add(simpleGameCard3);
        cards.add(simpleGameCard4);
        AI ai = new AI();
        ai.setCards(cards);
//
//        Human human = new Human();
//        human.setCards(cards);
//
        while (!cards.isEmpty()) {
            SimpleGameCard card = (SimpleGameCard) ai.choose(cards);
            System.out.println("choose cards: " + card);
        }

        SimpleGameDeck deck = new SimpleGameDeck();
        deck.shuffle();
        System.out.println(deck.toString());


    }
}