package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.Card;
import card.UnoCard;

public class UnoDeck {

	List<Card> cards = new ArrayList<>();
	List<Card> tableCards = new ArrayList<>();
	private Card lastCard;
	public UnoDeck() {
		initializeDeck();
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
			System.out.println("Deck is empty! Trying to reset...");
			if (!resetDeck()) {
				System.out.println("Deck reset failed! No more cards.");
				return null; // 真的無牌可用時才結束遊戲
			}
		}
		return cards.remove(0); // 抽取第一張牌
	}



	public void flop() {

		if (cards.isEmpty()) {
			resetDeck(); // 先補充牌堆
		}
		if (!cards.isEmpty()) {
			lastCard = cards.remove(0);
			tableCards.add(lastCard);
			System.out.println("last card: " + lastCard.getSuit() + ", " + lastCard.getRank());
		} else {
			throw new IllegalStateException("Flop failed: No available cards!");
		}
	}


	public boolean resetDeck() {
		if (tableCards.size() <= 1) {
			System.out.println("牌堆不足，無法重置！");
			return false; // 不能重置，因為沒有足夠的牌
		}

		Card last = lastCard; // 保留最後出的牌
		tableCards.remove(last); // 只移除最後一張，剩下的才回收

		if (tableCards.isEmpty()) {
			System.out.println("牌堆已經空了，無法重置！");
			return false; // 確保有可用的牌
		}

		System.out.println("Resetting deck with " + tableCards.size() + " cards.");
		cards.addAll(tableCards); // 把棄牌堆加入牌堆
		tableCards.clear(); // 清空棄牌堆
		tableCards.add(last); // 只保留最後一張

		shuffle(); // 重新洗牌
		return true;
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

	public List<Card> getTableCards() {
		return tableCards;
	}

	public void setTableCards(List<Card> tableCards) {
		this.tableCards = tableCards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
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
