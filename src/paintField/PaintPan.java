package paintField;

import paintShapes.Shapes;

import javax.swing.*;
import java.awt.*;
/**
 * Created by lisa on 11.3.17.
 */
public class PaintPan extends JPanel {
    public void paint(Graphics g){
        g.clearRect (0, 0, this.getWidth(), this.getHeight());
        ShapesList.getInstance().drawList(g);
        this.repaint();
    }
}
