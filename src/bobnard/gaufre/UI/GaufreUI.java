package bobnard.gaufre.UI;

import bobnard.gaufre.model.Game;
import bobnard.gaufre.model.Grid;

import javax.swing.*;
import java.awt.*;

public class GaufreUI extends JComponent {
    Game game;
    int startX;
    int startY;
    int tileSize;

    GaufreUI(Game game) {
        this.game = game;
    }

    @Override public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        Grid grid = this.game.getGrid();

        this.tileSize = Math.min(
                this.getWidth() / grid.getC(),
                this.getHeight() / grid.getL()
        );

        this.startX = this.getWidth() / 2 - (grid.getC() * tileSize / 2);
        this.startY = this.getHeight() / 2 - (grid.getL() * tileSize / 2);

        System.out.println("startX = " + startX);

        int endX = startX + (tileSize * grid.getC());
        int endY = startY + (tileSize * grid.getL());

        int x = startX;
        int y = startY;

        drawable.setColor(Color.ORANGE.darker());
        int val;
        for (int i = 0; i < grid.getL(); i++) {
            for (int j = 0; j < grid.getC(); j++) {

                val = grid.getCell(i, j);
                if (val != 0) {
                    drawable.fillRect(x, y, tileSize, tileSize);
                    if (val == 2) {
                        drawable.setColor(Color.GREEN.darker());
                        drawable.fillOval(x + tileSize / 4, y + tileSize / 4, tileSize / 2, tileSize / 2);
                        drawable.setColor(Color.ORANGE.darker());
                    }
                }
                x += tileSize;
            }
            x = startX;
            y += tileSize;
        }

        drawable.setColor(Color.BLACK);
        for (int i = startX; i <= endX; i += tileSize) {
            drawable.drawLine(i, startY, i, endY);
        }
        for (int j = startY; j <= endY; j += tileSize) {
            drawable.drawLine(startX, j, endX, j);
        }
    }

    public int getStartX() {
        return this.startX;
    }
    public int getStartY() {
        return this.startY;
    }
    public int getTileSize() {
        return this.tileSize;
    }
}
