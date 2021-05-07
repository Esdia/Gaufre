package bobnard.gaufre.UI.labels;

import bobnard.gaufre.model.Game;

public class LabelScore extends CustomLabel {
    public LabelScore(Game game) {
        super(game);
    }

    @Override
    public void refresh() {
        int score1 = game.getScore(1);
        int score2 = game.getScore(2);

        this.setText(
                "<html>Scores : <br />" +
                "Player 1 : " + score1 + "<br />" +
                "Player 2 : " + score2 + "</html>"
        );
    }
}
