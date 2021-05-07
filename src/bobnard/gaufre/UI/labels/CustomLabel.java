package bobnard.gaufre.UI.labels;

import bobnard.gaufre.UI.Updatable;
import bobnard.gaufre.model.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class CustomLabel extends JLabel implements Updatable {
    Game game;

    CustomLabel(Game game) {
        this.game = game;
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setBorder(new EmptyBorder(10, 0, 10, 0));

        this.refresh();
    }
}
