package game;

import java.util.ArrayList;
import java.util.List;

import card.Card;
import deck.UnoDeck;
import person.Player;

public class UnoGame {

	private UnoDeck deck;
	public boolean hasWinner = false;
	public UnoGame(UnoDeck deck) {
		this.deck = deck;
	}

	public void takeTurn(List<Player> players) {

		if (deck.getLastCard() == null) {
			System.out.println("Last card is null, resetting the deck...");
			Card card = deck.drawCard();
			deck.setLastCard(card);
		}

		for (Player player : players) {

			System.out.println("last card " + deck.getLastCard().getSuit() + "," + deck.getLastCard().getRank());
			System.out.println("Player " + player.getName() + " has:");
			player.getCards().forEach(card -> {
				System.out.println("  " + card.getRank() + " of " + card.getSuit());
			});

			List<Card> tempCards = new ArrayList<>(player.getCards());
			boolean hasPlayed = false; // play this round or not
			for (Card card : tempCards) {
				if (card.getSuit().equals(deck.getLastCard().getSuit()) || card.getRank().equals(deck.getLastCard().getRank())) {

					deck.setLastCard(card);
					System.out.println("Player " + player.getName() + " has " + card.getSuit() + ", " + card.getRank());

					player.unoChoose(card);
					System.out.println("Player " + player.getName() + " has " + player.getCards().size() + " cards");

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

	public void checkWinner(Player player) {
		if (player.getCards().isEmpty()) {
			System.out.println(player.getName() + " win!");
			hasWinner = true;
		}
	}
}
