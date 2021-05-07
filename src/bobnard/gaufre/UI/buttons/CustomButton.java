package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;

import javax.swing.*;

public abstract class CustomButton extends JButton {
    GameController controller;

    CustomButton(GameController controller, String text) {
        super(text);
        this.controller = controller;

        this.addActionListener(actionEvent -> action());
    }

    abstract void action();
}
