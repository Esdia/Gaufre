package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;

public class ButtonNewGame extends CustomButton {
    public ButtonNewGame(GameController controller) {
        super(controller, "New Game");
    }

    @Override
    void action() {
        // TODO implement action
        System.out.println("New Game");
    }
}
