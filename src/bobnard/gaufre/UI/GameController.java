package bobnard.gaufre.UI;

import bobnard.gaufre.AI.AI;
import bobnard.gaufre.model.Game;
import bobnard.gaufre.model.Grid;

import javax.swing.*;
import java.util.ArrayList;

public class GameController {
    private final GaufreUI gaufreUI;
    private final Game game;

    private final ArrayList<Updatable> updatables;

    private final ArrayList<AI> players;

    private Boolean AI_in_game;

    GameController(GaufreUI gaufreUI, Game game, ArrayList<Updatable> updatables) {
        this.gaufreUI = gaufreUI;
        this.game = game;

        this.updatables = updatables;

        this.players = new ArrayList<>();
        this.AI_in_game = false;
        for (int i = 0; i < 2; i++) this.players.add(null);
    }

    void addAI(AI ai) {
        this.AI_in_game = true;
        if (this.players.get(1) == null) {
            this.players.set(1, ai);
        } else {
            this.players.set(0, ai);
        }
    }

    void addUpdatable(Updatable updatable) {
        this.updatables.add(updatable);
    }

    public void refreshUpdatables() {
        for (Updatable updatable: updatables) {
            updatable.refresh();
        }
    }

    private boolean isCurrentPlayerAI() {
        return players.get(game.getCurrentPlayer() - 1) != null;
    }

    public void playIfAI() {
        AI ai = players.get(game.getCurrentPlayer() - 1);

        if (ai != null) {
            Timer timer = new Timer(500, actionEvent -> ai.play());
            timer.setRepeats(false);
            timer.start();
        }
    }

    public void play(int x, int y) {

        this.game.turn(x, y);

        this.refreshUpdatables();

        this.gaufreUI.repaint();

        this.playIfAI();

    }

    void interpretClick(int x, int y) {
        if (this.isCurrentPlayerAI()) return;

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

    public Game getPlay() {
        return game;
    }

    public boolean getAI_in_game() {
        return AI_in_game;
    }
}
