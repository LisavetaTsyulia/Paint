package paintField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectActionListener implements ActionListener {
    ArrayList<Point> coords;
    MenuPan menuPan;

    public SelectActionListener(MenuPan menuPan, ArrayList<Point> coords) {
        this.menuPan = menuPan;
        this.coords = coords;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (coords.size() == 1) {
            ShapesList.getInstance().setSelectedShape(ShapesList.getInstance().trySelectedShapes(coords.get(0)));
            if ( ShapesList.getInstance().getSelectedShape() != null ) {
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                ShapesList.getInstance().getSelectedShape().setStroke(dashed);
                for (JButton btn:
                        menuPan.buttons) {
                    if (!btn.getText().equals("Fill") && !btn.getText().equals("Border"))
                        btn.setEnabled(false);
                }
                ShapesList.getInstance().list.remove(ShapesList.getInstance().getSelectedShape());
                ShapesList.getInstance().list.add(ShapesList.getInstance().getSelectedShape());
            }
            coords.clear();
        }
    }
}
