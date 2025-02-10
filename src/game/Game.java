package game;

import java.util.List;

import player.Player;

public abstract class Game {
	public boolean hasWinner = false;

	public final void playGame(List<Player> players) {
		while (!hasWinner) {
			takeTurn(players);
		}
		announceWinner();
	}

	protected abstract void takeTurn(List<Player> players);

	protected abstract void announceWinner();
}
