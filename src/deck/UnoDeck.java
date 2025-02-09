package deck;

import card.Card;
import card.UnoCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.shuffle;

public class UnoDeck {

    List<Card> cards = new ArrayList<>();
    List<Card> tableCards = new ArrayList<>();
    private Card lastCard;
    public UnoDeck() {
        initializeDeck();
        shuffle();
        flop();
    }

    private void initializeDeck() {
        String[] color = {"BLUE", "RED", "YELLOW", "GREEN"};
        String[] number = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (String suit : color) {
            for (String rank : number) {
                cards.add(new UnoCard(suit, rank));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            resetDeck();
        }
        if (cards.isEmpty()) {
            throw new IllegalStateException("No more cards available! The game must end.");
        }
        return cards.removeFirst();

    }


    public void flop() {

        if (cards.isEmpty()) {
            resetDeck(); // 先補充牌堆
        }
        if (!cards.isEmpty()) {
            lastCard = cards.removeFirst();
            tableCards.add(lastCard);
        } else {
            throw new IllegalStateException("Flop failed: No available cards!");
        }
    }


    private void resetDeck() {
        if (tableCards.size() <= 1) { // 確保至少有兩張牌
            throw new IllegalStateException("No more cards available to reset! The game must end.");
        }

        Card last = lastCard;  // 保留最後出的牌
        tableCards.remove(last); // 避免將最後一張牌回收

        cards = new ArrayList<>(tableCards); // 回收桌面上的牌
        tableCards.clear(); // 清空桌面
        tableCards.add(last); // 只留下最後一張牌
        shuffle(); // 重新洗牌

    }


    public Card getLastCard() {
        if (lastCard == null) {
            flop();
        }
        return lastCard;
    }

    public void setLastCard(Card card) {
        lastCard = card;
        tableCards.add(card);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }
}
