package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;

public class ButtonSave extends CustomButton {
    public ButtonSave(GameController controller) {
        super(controller, "Save");
    }

    @Override
    void action() {
        // TODO implement action
        System.out.println("Save");
    }
}
