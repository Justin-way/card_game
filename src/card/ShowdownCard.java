package card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShowdownCard extends Card {

    private String number;
    private String color;

    private static final Set<String> validNumber = new HashSet<>(Arrays.asList(
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    ));
    private static final Set<String> validColor = new HashSet<>(Arrays.asList(
            "club", "diamond", "heart", "spade"
    ));

    public ShowdownCard(String color, String number) {
        setColor(color);
        setNumber(number);
    }

    private void validateSuit(String suit) {
        if (!validColor.contains(suit)) {
            throw new IllegalArgumentException("Invalid suit! Allowed: " + validColor);
        }
    }

    private void validateRank(String rank) {
        if (!validNumber.contains(rank)) {
            throw new IllegalArgumentException("Invalid rank! Allowed: " + validNumber);
        }
    }

    public void setColor(String color) {
        validateSuit(color);
        this.color = color;
    }

    public void setNumber(String number) {
        validateRank(number);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }
}



