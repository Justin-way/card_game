package card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimpleCard extends Card {

    private static final Set<String> validRanks = new HashSet<>(Arrays.asList(
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    ));
    private static final Set<String> validSuits = new HashSet<>(Arrays.asList(
            "club", "diamond", "heart", "spade"
    ));

    public SimpleCard(String suit, String rank) {
        super(suit, rank);
    }

    @Override
    protected void validateSuit(String suit) {
        if (!validSuits.contains(suit)) {
            throw new IllegalArgumentException("Invalid suit! Allowed: " + validSuits);
        }
    }

    @Override
    protected void validateRank(String rank) {
        if (!validRanks.contains(rank)) {
            throw new IllegalArgumentException("Invalid rank! Allowed: " + validRanks);
        }
    }
}




