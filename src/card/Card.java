package card;

import java.util.Set;

public abstract class Card {

    protected String rank;
    protected String suit;
    public Card(String suit, String rank) {
        setSuit(suit);
        setRank(rank);
    }
    protected abstract void validateSuit(String suit);
    protected abstract void validateRank(String rank);
    protected void setSuit(String suit) {validateSuit(suit);this.suit = suit;};
    protected void setRank(String rank){validateRank(rank);this.rank = rank;};
    public String getRank() {return rank;}
    public String getSuit() {return suit;}
}
