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
        System.out.println("Mouse click on : " + e.getX() + " " + e.getY());
    }
}
