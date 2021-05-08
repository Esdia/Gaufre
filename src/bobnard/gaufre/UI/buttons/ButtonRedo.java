package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;
import bobnard.gaufre.UI.Updatable;

public class ButtonRedo extends CustomButton implements Updatable {
    public ButtonRedo(GameController controller) {
        super(controller, "Redo");
        this.setEnabled(false);
    }

    @Override
    void action() {
        this.controller.getGame().redo();
    }

    @Override
    public void refresh() {
        this.setEnabled(!this.controller.getGame().RedoIsEmpty());
    }
}
