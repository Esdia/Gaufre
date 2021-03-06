package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;

public class ButtonLoad extends CustomButton {
    public ButtonLoad(GameController controller) {
        super(controller, "Load");
    }

    @Override
    void action() {
        this.controller.getGame().load("Save");
    }
}
