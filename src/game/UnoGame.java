package game;

import card.Card;
import deck.UnoDeck;
import person.Player;

import java.util.ArrayList;
import java.util.List;

public class UnoGame {

    private UnoDeck deck;
    public boolean hasWinner = false;
    public UnoGame(UnoDeck deck) {
        this.deck = deck;
    }

    public void takeTurn(List<Player> players) {
        for (Player player : players) {
            List<Card> tempCards = new ArrayList<>(player.getCards());
            System.out.println("last card "+deck.getLastCard().getSuit()+","+ deck.getLastCard().getRank());
            for (Card card : tempCards) {
                if (card.getSuit().equals(deck.getLastCard().getSuit()) || card.getRank().equals(deck.getLastCard().getRank())) {
                    System.out.println("Player "+player.getName()+" has "+card.getSuit() + ", " + card.getRank());
                    deck.setLastCard(card);
                    player.unoChoose(card);
                    checkWinner(player);
                    break;
                } else {
                    player.addCard(deck.drawCard());
                }
            }
        }
    }

    public void checkWinner(Player player) {
        if (player.getCards().isEmpty()) {
            System.out.println(player.getName()+" win!");
            hasWinner = true;
        }
    }
}
