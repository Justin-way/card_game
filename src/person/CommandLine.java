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

        System.out.println("Please enter the card suit (e.g., heart, spade, diamond, club): ");
        String suit = scanner.nextLine().trim();

        System.out.println("Please enter the card rank (e.g., A, 2, 3, 4...): ");
        String rank = scanner.nextLine().trim();


        Card selectedCard = null;

        // check rank and suit
        for (Card card : cards) {
            if (card.getRank().equalsIgnoreCase(rank) && card.getSuit().equalsIgnoreCase(suit)) {
                selectedCard = card;
                break;
            }
        }

        if (selectedCard == null) {
            System.out.println("Invalid rank or suit. Please try again.");
            return execute(cards);
        }

        cards.remove(selectedCard);
        return selectedCard;
    }
}
