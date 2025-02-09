package person;

import card.Card;
import card.SimpleGameCard;
import card.UnoCard;

import java.util.List;

public abstract class Player  {
    int id;
    String name;
    int point = 0;
    List<Card> cards;


    protected void setName(String name){
        this.name = name;
    };
    protected void addPoint() {
        point++;
    };
    public abstract Card choose(List<Card> cards);

}
