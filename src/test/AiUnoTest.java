package test;
import java.util.List;

import deck.UnoDeck;
import game.UnoGame;
import player.AiPlayer;
import player.Player;

public class AiUnoTest {
	public static void main(String[] args) {

		Player aiPlayer1 = new AiPlayer();
		Player aiPlayer2 = new AiPlayer();
		Player aiPlayer3 = new AiPlayer();
		Player aiPlayer4 = new AiPlayer();

		aiPlayer1.setName("P1");
		aiPlayer2.setName("P2");
		aiPlayer3.setName("P3");
		aiPlayer4.setName("P4");

		UnoDeck unoDeck = new UnoDeck();
		UnoGame unoGame = new UnoGame(unoDeck);

		unoDeck.shuffle();
		unoDeck.flop();
		for (int round = 0; round < 5; round++) {
			aiPlayer1.addCard(unoDeck.drawCard());
			aiPlayer2.addCard(unoDeck.drawCard());
			aiPlayer3.addCard(unoDeck.drawCard());
			aiPlayer4.addCard(unoDeck.drawCard());
		}
		List<Player> players = List.of(aiPlayer1, aiPlayer2, aiPlayer3, aiPlayer4);

		players.forEach(player -> {
			System.out.println("Player " + (players.indexOf(player) + 1) + "'s hand:");
			player.getCards().forEach(card -> System.out.println("  " + card.getRank() + " " + card.getSuit()));
		});

		unoGame.playGame(players);

	}
}
