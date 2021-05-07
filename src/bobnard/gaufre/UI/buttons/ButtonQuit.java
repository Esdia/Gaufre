package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;

public class ButtonQuit extends CustomButton {
    public ButtonQuit(GameController controller) {
        super(controller, "Quit Game");
    }

    @Override
    void action() {
        // TODO implement action
        System.out.println("Quit Game");
    }
}
