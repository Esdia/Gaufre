package bobnard.gaufre.AI;

import bobnard.gaufre.UI.GameController;

import java.util.Random;

public class AIRandom extends AI {
    private final Random random;
    private final int l;
    private final int c;

    public AIRandom(GameController controller) {
        super(controller);

        this.random = new Random();
        this.l = this.controller.getGame().getGrid().getL();
        this.c = this.controller.getGame().getGrid().getC();
    }

    @Override
    public void play() {
        int x;
        int y;

        do {
            x = random.nextInt(this.c);
            y = random.nextInt(this.l);
        } while (this.controller.getGame().getGrid().getCell(y, x) == 0);

        this.controller.play(x, y);
    }
}
