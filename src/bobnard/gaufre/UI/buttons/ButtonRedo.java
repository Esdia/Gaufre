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
        // TODO implement action
        System.out.println("Redo");
    }

    @Override
    public void refresh() {
        // TODO implement refresh
        System.out.println("Refresh Redo");
    }
}
