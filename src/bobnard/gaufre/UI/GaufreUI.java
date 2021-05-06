package bobnard.gaufre.UI;

import bobnard.gaufre.model.Game;

import javax.swing.*;
import java.awt.*;

public class GaufreUI extends JComponent {
    Game game;

    GaufreUI(Game game) {
        this.game = game;
    }

    @Override public void paintComponent(Graphics g) {

    }
}
