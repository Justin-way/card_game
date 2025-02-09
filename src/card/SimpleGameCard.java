package card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimpleGameCard implements Card {

    int id = -1;
    String rank;
    String suit;
      final Set<String> validRanks = new HashSet<>(Arrays.asList(
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"
    ));

      final Set<String> validsuits = new HashSet<>(Arrays.asList(
            "club","diamond","heart","spade"

    ));
    public SimpleGameCard(String suit, String rank) {
        setRank(rank);
        setSuit(suit);
    }

    public int getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        if (validRanks.contains(rank)){
            this.rank = rank;
        } else {
            throw new IllegalArgumentException("Invalid rank! Please enter a valid rank (2, 3, 4, ..., A).");
        }
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        if (validsuits.contains(suit)){
            this.suit = suit;
        }  else {
            throw new IllegalArgumentException("Invalid rank! Please enter a valid rank (club, diamond, heart, spade).");
        }
    }
    @Override
    public String toString() {
        return suit + " " + rank;
    }
}
