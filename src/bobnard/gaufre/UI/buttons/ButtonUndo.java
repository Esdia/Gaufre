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
        // TODO implement action
        System.out.println("Undo");
    }

    @Override
    public void refresh() {
        // TODO implement refresh
        System.out.println("Refresh Undo");
    }
}
