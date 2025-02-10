package game;

import java.util.ArrayList;
import java.util.List;

import card.Card;
import deck.UnoDeck;
import player.Player;

public class UnoGame extends Game {
	private UnoDeck deck;

	public UnoGame(UnoDeck deck) {
		this.deck = deck;
	}

	@Override
	public void takeTurn(List<Player> players) {
		if (deck.getLastCard() == null) {
			System.out.println("Last card is null, resetting the deck...");
			deck.setLastCard(deck.drawCard());
		}

		for (Player player : players) {
			System.out.println("Last card: " + deck.getLastCard().getSuit() + ", " + deck.getLastCard().getRank());
			System.out.println("Player " + player.getName() + " has:");
			player.getCards().forEach(card -> System.out.println("  " + card.getRank() + " of " + card.getSuit()));

			boolean hasPlayed = false;
			for (Card card : new ArrayList<>(player.getCards())) {
				if (card.getSuit().equals(deck.getLastCard().getSuit()) || card.getRank().equals(deck.getLastCard().getRank())) {
					deck.setLastCard(card);
					System.out.println("Player " + player.getName() + " plays " + card.getSuit() + ", " + card.getRank());
					player.unoChoose(card);
					deck.getTableCards().add(card);
					checkWinner(player);
					hasPlayed = true;
					break;
				}
			}

			if (!hasPlayed) {
				Card drawnCard = deck.drawCard();
				if (drawnCard != null) {
					player.addCard(drawnCard);
					System.out.println(player.getName() + " draws a card: " + drawnCard.getRank() + " " + drawnCard.getSuit());
				}
			}

			if (hasWinner) {
				break;
			}
		}
	}

	@Override
	protected void announceWinner() {
		System.out.println("Uno Game finished!");
	}

	private void checkWinner(Player player) {
		if (player.getCards().isEmpty()) {
			System.out.println(player.getName() + " wins!");
			hasWinner = true;
		}
	}
}
