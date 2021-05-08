package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;
import bobnard.gaufre.UI.Updatable;

public class ButtonUndo extends CustomButton implements Updatable {
    public ButtonUndo(GameController controller) {
        super(controller, "Undo");
        this.setEnabled(false);
    }

    @Override
    void action() {
        this.controller.getGame().undo();
    }

    @Override
    public void refresh() {
        this.setEnabled(!this.controller.getGame().UndoIsEmpty() && !this.controller.getAI_in_game());
    }
}
