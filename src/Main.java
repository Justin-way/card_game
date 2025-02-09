import card.SimpleGameCard;
import card.SimpleGameDeck;
import game.SimpleGame;
import person.AiPlayer;
import person.Player;

public class Main {
    public static void main(String[] args) {

        Player aiPlayer1 = new AiPlayer();
        Player aiPlayer2 = new AiPlayer();
        Player aiPlayer3 = new AiPlayer();
        Player aiPlayer4 = new AiPlayer();

        aiPlayer1.setName("P1");
        aiPlayer2.setName("P2");
        aiPlayer3.setName("P3");
        aiPlayer4.setName("P4");

        SimpleGameDeck deck = new SimpleGameDeck();
        deck.shuffle();

        for (int round = 0; round < 13; round++) {
            aiPlayer1.addCard(deck.drawCard());
            aiPlayer2.addCard(deck.drawCard());
            aiPlayer3.addCard(deck.drawCard());
            aiPlayer4.addCard(deck.drawCard());
        }
        System.out.println(aiPlayer1);
        System.out.println(aiPlayer2);
        System.out.println(aiPlayer3);
        System.out.println(aiPlayer4);

        SimpleGameCard card = (SimpleGameCard) aiPlayer1.choose();
        SimpleGame game = new SimpleGame();
        for (int round = 0; round < 13; round++) {
            game.takeTurn(aiPlayer1, aiPlayer2, aiPlayer3, aiPlayer4);
            game.display();
            game.compare();
        }

        game.getWinner();

    }
}