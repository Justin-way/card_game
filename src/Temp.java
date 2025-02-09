import card.SimpleCard;
import deck.SimpleDeck;
import person.AiPlayer;

public class Temp {
    public static void main(String[] args) {


//        Card simpleGameCard1 = new SimpleGameCard("heart","A" );
//        Card simpleGameCard2 = new SimpleGameCard("heart","2" );
//        Card simpleGameCard3 = new SimpleGameCard("heart","3" );
//        Card simpleGameCard4 = new SimpleGameCard("heart","4" );
//        List<Card> cards = new ArrayList<>();
//
//        cards.add(simpleGameCard1);
//        cards.add(simpleGameCard2);
//        cards.add(simpleGameCard3);
//        cards.add(simpleGameCard4);
        AiPlayer aiPlayer = new AiPlayer();
        aiPlayer.setName("P1");

        SimpleDeck deck = new SimpleDeck();
//        deck.shuffle();

        aiPlayer.addCard(deck.drawCard());
//
//        Human human = new Human();
//        human.setCards(cards);
//

        SimpleCard card = (SimpleCard) aiPlayer.choose();
        System.out.println("choose cards: " + card);

//        while (!ai.getCards().isEmpty()) {
//            SimpleGameCard card = (SimpleGameCard) ai.choose(cards);
//            System.out.println("choose cards: " + card);
//        }




    }
}
