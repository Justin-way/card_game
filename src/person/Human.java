package person;

import card.Card;

import java.util.List;

public class Human extends Player {

    CommandLine commandLine = new CommandLine();

    @Override
    public void unoChoose(Card card) {

    }

    @Override
    public Card choose() {
        return commandLine.execute(cards);
    }


}
