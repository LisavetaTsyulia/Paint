package paintField;

import paintShapes.Shapes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by lisa on 3.4.17.
 */
public class SelectActionListener implements ActionListener {
    ArrayList<Point> coords;

    public SelectActionListener(ArrayList<Point> coords) {
        this.coords = coords;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (coords.size() == 1) {
            Shapes shape = ShapesList.getInstance().trySelectedShapes(coords.get(0));
            if ( shape != null ) {
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                shape.setStroke(dashed);
                shape.setBorderCol(Color.ORANGE);
            }
        }
    }
}
