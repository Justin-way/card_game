package game;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import card.Card;
import person.Player;

public class SimpleGame extends Game {
	private Map<Player, Card> map = new LinkedHashMap<>();

	@Override
	protected void takeTurn(List<Player> players) {
		System.out.println("---------- Start this round ----------");
		map.clear();

		for (Player player : players) {
			map.put(player, player.choose());
		}

		display();
		compare();
	}

	private void display() {
		for (Map.Entry<Player, Card> entry : map.entrySet()) {
			System.out.println("Player: " + entry.getKey().getName() + " , Card: " + entry.getValue().getSuit() + " " + entry.getValue().getRank());
		}
	}

	private void compare() {
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
			System.out.println("This round Winner: " + maxPlayer.getName() + ", Card: " + maxCard.getSuit() + " " + maxCard.getRank());
			maxPlayer.addPoints();
		} else {
			System.out.println("No cards to play.");
		}
	}

	private static boolean isGreater(Card card1, Card card2, List<String> rankOrder, List<String> suitOrder) {
		int rank1 = rankOrder.indexOf(card1.getRank());
		int rank2 = rankOrder.indexOf(card2.getRank());

		if (rank1 != rank2) {
			return rank1 > rank2;
		}
		return suitOrder.indexOf(card1.getSuit()) > suitOrder.indexOf(card2.getSuit());
	}

	@Override
	protected void announceWinner() {
		int maxPoints = -1;
		Player winner = null;

		for (Player player : map.keySet()) {
			if (player.getPoints() > maxPoints) {
				maxPoints = player.getPoints();
				winner = player;
			}
		}

		if (winner != null) {
			System.out.printf("Final Winner is %s !!%n", winner.getName());
		} else {
			System.out.println("No final winner.");
		}
	}
}
