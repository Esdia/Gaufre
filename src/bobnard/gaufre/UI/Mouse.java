package bobnard.gaufre.UI;

import bobnard.gaufre.model.Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
    GaufreUI gaufreUI;
    Game game;

    public Mouse(GaufreUI gaufreUI, Game game) {
        this.gaufreUI = gaufreUI;
        this.game = game;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Mouse click

        int x = (e.getX() - this.gaufreUI.getStartX()) / this.gaufreUI.getTileSize();
        int y = (e.getY() - this.gaufreUI.getStartY()) / this.gaufreUI.getTileSize();

        this.game.turn(x, y);

        this.gaufreUI.repaint();
    }
}
