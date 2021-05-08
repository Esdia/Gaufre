package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;

public class ButtonReset extends CustomButton {
    public ButtonReset(GameController controller) {
        super(controller, "Reset");
    }

    @Override
    void action() {
        // TODO implement action
        System.out.println("Reset");
    }
}
