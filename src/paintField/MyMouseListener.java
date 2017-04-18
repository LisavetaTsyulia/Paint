package paintField;

import interfaces.Editable;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class MyMouseListener extends MouseMotionAdapter implements MouseInputListener{
    private ArrayList<Point> listenerPoints ;
    private PaintPan paintPan;
    private Point oldPoint;
    public MyMouseListener(ArrayList<Point> arrPt, PaintPan paintPan){
        listenerPoints = arrPt;
        this.paintPan = paintPan;
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
        if (ShapesList.getInstance().getSelectedShape() != null) {
        oldPoint = e.getPoint();
        ShapesList.getInstance().status = "changed";
        }
    }
    public void mouseReleased(MouseEvent e) {
        if (!(ShapesList.getInstance().getSelectedShape() == null))
            ShapesList.getInstance().status = "stop";
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
        if ( ShapesList.getInstance().getSelectedShape() instanceof Editable && !ShapesList.getInstance().getSelectedShape().equals(null)) {
            int dx = (int) (e.getX() - oldPoint.getX());
            int dy = (int) (e.getY() - oldPoint.getY());
            oldPoint.setLocation(oldPoint.getX() + dx, oldPoint.getY() + dy);

            ((Editable)ShapesList.getInstance().getSelectedShape()).move(dx, dy);
        }
    }
    public void mouseMoved(MouseEvent e) {
    }
}
