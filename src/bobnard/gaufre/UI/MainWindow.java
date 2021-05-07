package bobnard.gaufre.UI;

import bobnard.gaufre.UI.buttons.*;
import bobnard.gaufre.UI.labels.CustomLabel;
import bobnard.gaufre.UI.labels.LabelScore;
import bobnard.gaufre.UI.labels.LabelTurn;
import bobnard.gaufre.model.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow implements Runnable {
    GameController controller;
    JFrame frame;

    private void initGameController() {
        Game game = new Game(5, 10);
        GaufreUI gaufreUI = new GaufreUI(game);

        ArrayList<Updatable> updatables = new ArrayList<>();

        this.controller = new GameController(
                gaufreUI,
                game,
                updatables
        );
    }

    private ArrayList<CustomLabel> createLabels() {
        ArrayList<CustomLabel> labels = new ArrayList<>();

        labels.add(new LabelTurn(controller.getGame()));
        labels.add(new LabelScore(controller.getGame()));

        return labels;
    }

    private JPanel createUndoRedoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0, 20, 20));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ButtonRedo redo = new ButtonRedo(controller);
        ButtonUndo undo = new ButtonUndo(controller);

        controller.addUpdatable(redo);
        controller.addUpdatable(undo);

        panel.add(redo);
        panel.add(undo);

        return panel;
    }

    private JPanel createSaveLoadPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 0, 20, 20));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        ButtonSave save = new ButtonSave(controller);
        ButtonLoad load = new ButtonLoad(controller);

        panel.add(save);
        panel.add(load);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 20, 20));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(new ButtonNewGame(controller));
        panel.add(new ButtonResetScores(controller));

        panel.add(this.createUndoRedoPanel());
        panel.add(this.createSaveLoadPanel());

        panel.add(new ButtonQuit(controller));

        return panel;
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(0, 30, 0 ,30));

        /* Space before the rest */
        panel.add(Box.createGlue());

        /* Labels */
        for (CustomLabel label: this.createLabels()) {
            controller.addUpdatable(label);
            panel.add(label);
        }

        /* Buttons */
        panel.add(this.createButtonPanel());

        panel.add(Box.createGlue());

        return panel;
    }

    private void createBaseFrame() {
        this.frame = new JFrame("Gaufre empoisonnée");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setMinimumSize(new Dimension(480, 360));
        frame.setSize(
                screenSize.width * 3 / 4,
                screenSize.height * 3 / 4
        );
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createFrame() {
        this.createBaseFrame();

        this.frame.add(controller.getGaufreUI());
        this.frame.add(this.createMainPanel(), BorderLayout.EAST);

        this.frame.setVisible(true);
    }

    private void linkMouseListener() {
        Mouse mouse = new Mouse(controller);
        GaufreUI gaufreUI = controller.getGaufreUI();

        gaufreUI.addMouseListener(mouse);
    }

    @Override
    public void run() {
        this.initGameController();

        this.createFrame();
        this.linkMouseListener();
    }

    public static void start() {
        SwingUtilities.invokeLater(new MainWindow());
    }
}
