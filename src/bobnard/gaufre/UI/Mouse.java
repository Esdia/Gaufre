package bobnard.gaufre.UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Mouse click
        System.out.println("Mouse click on : " + e.getX() + " " + e.getY());
    }
}
