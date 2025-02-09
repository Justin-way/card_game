package person;

import card.Card;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CommandLine {

    public Card execute(List<Card> cards) {

        if (cards == null || cards.isEmpty()) {
            return null;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the card number (id): ");

        int cardId = scanner.nextInt();

        Card selectedCard = null;

        // check id
        for (Card card : cards) {
            if (card.getId() == cardId) {
                selectedCard = card;
                break;
            }
        }

        if (selectedCard == null) {
            System.out.println("Invalid card number. Please try again.");
            return execute(cards);
        }

        cards.remove(selectedCard);
        return selectedCard;

    }
}
