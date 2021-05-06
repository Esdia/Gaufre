package bobnard.gaufre.UI;

import bobnard.gaufre.model.Game;
import bobnard.gaufre.model.Grid;

import javax.swing.*;
import java.awt.*;

public class MainWindow implements Runnable {
    @Override
    public void run() {
        JFrame frame = new JFrame("Gaufre empoisonnée");
        Game game = new Game(5,5);

        GaufreUI gaufreUI = new GaufreUI(game);

        gaufreUI.addMouseListener(new Mouse());
        frame.add(gaufreUI);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(
                screenSize.width * 3 / 4,
                screenSize.height * 3 / 4
        );
        frame.setLocation(
                (screenSize.width - frame.getWidth()) / 2,
                (screenSize.height - frame.getHeight()) / 2
        );
        frame.setVisible(true);
    }

    public static void start() {
        SwingUtilities.invokeLater(new MainWindow());
    }
}
