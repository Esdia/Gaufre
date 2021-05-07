package bobnard.gaufre.UI.buttons;

import bobnard.gaufre.UI.GameController;

public class ButtonResetScores extends CustomButton {
    public ButtonResetScores(GameController controller) {
        super(controller, "Reset Scores");
    }

    @Override
    void action() {
        // TODO implement action
        System.out.println("Reset Scores");
    }
}
