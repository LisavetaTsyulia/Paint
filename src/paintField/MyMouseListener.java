package paintField;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by lisa on 14.3.17.
 */
public class MyMouseListener implements MouseInputListener{
    private ArrayList<Point> listenerPoints ;
    public MyMouseListener(ArrayList<Point> arrPt){
        listenerPoints = arrPt;
    }
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Point pt = new Point(x, y);
        System.out.println(" X: " + x);
        System.out.println(" Y: " + y);
        listenerPoints.add(pt);
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
    }
}
