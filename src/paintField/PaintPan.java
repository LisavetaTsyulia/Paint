package paintField;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lisa on 11.3.17.
 */
public class PaintPan extends JPanel {
    public ArrayList<Point> coords = new ArrayList<>();
    public void clearCoords(){
        coords.clear();
    }
    public void paint(Graphics g){
        g.clearRect (0, 0, this.getWidth(), this.getHeight());
        ShapesList.getInstance().drawList(g);
        this.repaint();
    }

}
