package paintField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BackToPaintListener implements ActionListener {
    ArrayList<Point> coords;
    MenuPan menuPan;
    public BackToPaintListener(MenuPan menuPan, ArrayList<Point> coords) {
        this.coords = coords;
        this.menuPan = menuPan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        coords.clear();
        if (ShapesList.getInstance().getSelectedShape() != null) {
            ShapesList.getInstance().getSelectedShape().setStroke(new BasicStroke(3));
            ShapesList.getInstance().setSelectedShape(null);
            menuPan.getBorderBtn().setSelectedColor(new Color(0x310683));
            menuPan.getFill().setSelectedColor(new Color(0x1B832A));
            for (JButton btn :
                    menuPan.buttons) {
                btn.setEnabled(true);
            }
        }
    }
}
