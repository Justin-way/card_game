package game;

import card.Card;
import person.Player;

import java.util.*;

public class SimpleGame {
    //+ show(card : SimpleGameCard, player : Player) : void
    //+ chooseWinner(play : Player) : void
    //+ compare(play : Player) : void

    Map<Player, Card> map = new LinkedHashMap<>();

    public void display() {
        for(Map.Entry<Player, Card> entry : map.entrySet()) {
            System.out.println("Player: " + entry.getKey().getName() + " , Card: " + entry.getValue().getSuit()+" "+entry.getValue().getRank());
        }
    }

    public void compare() {
        List<String> rankOrder = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
        List<String> suitOrder = Arrays.asList("club", "diamond", "heart", "spade");
        Player maxPlayer = null;
        Card maxCard = null;

        for (Map.Entry<Player, Card> entry : map.entrySet()) {
            Card card = entry.getValue();

            if (maxCard == null || isGreater(card, maxCard, rankOrder, suitOrder)) {
                maxCard = card;
                maxPlayer = entry.getKey();
            }
        }

        if (maxPlayer != null) {
            System.out.println("This round Winner：" + maxPlayer.getName() + ", Card：" + maxCard.getSuit() +" "+ maxCard.getRank());
            maxPlayer.addPoints();
            System.out.println("This round Winner：" + maxPlayer.getName() + ", Current point：" + maxPlayer.getPoints());

        } else {
            System.out.println("no cards to play");
        }

    }

    private boolean isGreater(Card card1, Card card2, List<String> rankOrder, List<String> suitOrder) {
        int rank1 = rankOrder.indexOf(card1.getRank());
        int rank2 = rankOrder.indexOf(card2.getRank());

        if (rank1 != rank2) {
            return rank1 > rank2;
        }

        int suit1 = suitOrder.indexOf(card1.getSuit());
        int suit2 = suitOrder.indexOf(card2.getSuit());
        return suit1 > suit2;

    }

    public void takeTurn(Player Player1, Player Player2, Player Player3, Player Player4) {
        System.out.println("----------start this run=-----------");
        map.put(Player1, Player1.choose());
        map.put(Player2, Player2.choose());
        map.put(Player3, Player3.choose());
        map.put(Player4, Player4.choose());
    }

    public void getWinner(){
        int maxPoints = -1;
        Player winner = null;
        for(Map.Entry<Player, Card> entry : map.entrySet()) {
             int playPoints = entry.getKey().getPoints();
             if(playPoints > maxPoints) {
                 maxPoints = playPoints;
                 winner = entry.getKey();
             }
        }
        assert winner != null;
        System.out.printf("Final Winner is %s !!", winner.getName());
    }
}
