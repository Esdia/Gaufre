package bobnard.gaufre.AI;

import bobnard.gaufre.UI.GameController;

public abstract class AI {
    GameController controller;

    public AI(GameController controller) {
        this.controller = controller;
    }

    public abstract void play();
}
