package card;

import java.util.*;

public class UnoCard extends Card {



    private static final Set<String> validateRank = new HashSet<>(Arrays.asList(
            "0","1","2", "3", "4", "5", "6", "7", "8", "9"
    ));

    private static final Set<String> validateSuit = new HashSet<>(Arrays.asList(
            "BLUE","RED","YELLOW","GREEN"

    ));

    public UnoCard(String suit, String rank) {
        super(suit, rank);
    }

    @Override
    protected void validateSuit(String suit) {
        if (!validateSuit.contains(suit)) {
            throw new IllegalArgumentException("Invalid suit! Allowed: " + validateSuit);
        }
    }

    @Override
    protected void validateRank(String rank) {
        if (!validateRank.contains(rank)) {
            throw new IllegalArgumentException("Invalid rank! Allowed: " + validateRank);
        }
    }


}
