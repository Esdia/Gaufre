package bobnard.gaufre.UI;

import bobnard.gaufre.model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainWindow implements Runnable {
    Game game;
    GaufreUI gaufreUI;
    JFrame frame;

    private void createGame() {
        this.game = new Game(5, 5);
    }

    private void createGaufreUI() {
        this.gaufreUI = new GaufreUI(this.game);
        this.gaufreUI.addMouseListener(new Mouse(this.gaufreUI, this.game));
    }

    private void createFrame() {
        this.frame = new JFrame("Gaufre empoisonnée");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setMinimumSize(new Dimension(480, 360));
        this.frame.setSize(
                screenSize.width * 3 / 4,
                screenSize.height * 3 / 4
        );
        this.frame.setLocationRelativeTo(null);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box menuBox = Box.createVerticalBox();
        menuBox.setSize(this.frame.getWidth() / 4, this.frame.getHeight());
        menuBox.setBackground(Color.CYAN);

        this.frame.addComponentListener(
                new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        super.componentResized(e);
                        gaufreUI.setSize(frame.getContentPane().getWidth() * 3 / 4, frame.getContentPane().getHeight());
                    }
                }
        );


        this.frame.add(this.gaufreUI);
        this.frame.add(menuBox);


        frame.setVisible(true);
    }

    @Override
    public void run() {
        this.createGame();
        this.createGaufreUI();
        this.createFrame();
    }

    public static void start() {
        SwingUtilities.invokeLater(new MainWindow());
    }
}
