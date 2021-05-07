package bobnard.gaufre.UI.labels;

import bobnard.gaufre.model.Game;

public class LabelTurn extends CustomLabel {
    public LabelTurn(Game game) {
        super(game);
    }

    @Override
    public void refresh() {
        int currentPlayer = this.game.getCurrentPlayer();
        this.setText("Player " + currentPlayer + "'s turn");
    }
}
