import java.util.List;

import deck.SimpleDeck;
import game.SimpleGame;
import player.AiPlayer;
import player.Player;

public class AiSimpleTest {
	public static void main(String[] args) {

		Player aiPlayer1 = new AiPlayer();
		Player aiPlayer2 = new AiPlayer();
		Player aiPlayer3 = new AiPlayer();
		Player aiPlayer4 = new AiPlayer();

		aiPlayer1.setName("P1");
		aiPlayer2.setName("P2");
		aiPlayer3.setName("P3");
		aiPlayer4.setName("P4");

		SimpleDeck simpleDeck = new SimpleDeck();
		SimpleGame simple = new SimpleGame();

		simpleDeck.shuffle();

		for (int round = 0; round < 13; round++) {
			aiPlayer1.addCard(simpleDeck.drawCard());
			aiPlayer2.addCard(simpleDeck.drawCard());
			aiPlayer3.addCard(simpleDeck.drawCard());
			aiPlayer4.addCard(simpleDeck.drawCard());
		}
		List<Player> players = List.of(aiPlayer1, aiPlayer2, aiPlayer3, aiPlayer4);

		players.forEach(player -> {
			System.out.println("Player " + (players.indexOf(player) + 1) + "'s hand:");
			player.getCards().forEach(card -> System.out.println("  " + card.getRank() + " " + card.getSuit()));
		});

		simple.playGame(players);

	}
}
