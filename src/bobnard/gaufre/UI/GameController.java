package bobnard.gaufre.UI;

import bobnard.gaufre.model.Game;
import bobnard.gaufre.model.Grid;

import java.util.ArrayList;

public class GameController {
    private final GaufreUI gaufreUI;
    private final Game game;

    private final ArrayList<Updatable> updatables;

    GameController(GaufreUI gaufreUI, Game game, ArrayList<Updatable> updatables) {
        this.gaufreUI = gaufreUI;
        this.game = game;

        this.updatables = updatables;
    }

    void addUpdatable(Updatable updatable) {
        this.updatables.add(updatable);
    }

    public void refreshUpdatables() {
        for (Updatable updatable: updatables) {
            updatable.refresh();
        }
    }

    private void play(int x, int y) {
        this.game.turn(x, y);

        this.refreshUpdatables();

        this.gaufreUI.repaint();
    }

    void interpretClick(int x, int y) {
        x -= this.gaufreUI.getStartX();
        y -= this.gaufreUI.getStartY();

        // Out of bounds on left or top
        if (x < 0 || y < 0) {
            return;
        }

        x /= this.gaufreUI.getTileSize();
        y /= this.gaufreUI.getTileSize();

        Grid grid = this.game.getGrid();

        // Out of bounds on right or bottom
        if (x >= grid.getC() || y >= grid.getL()) {
            return;
        }

        // Cell already empty
        if (grid.getCell(y, x) == 0) {
            return;
        }

        this.play(x ,y);
    }

    public GaufreUI getGaufreUI() {
        return gaufreUI;
    }

    public Game getGame() {
        return game;
    }
}
