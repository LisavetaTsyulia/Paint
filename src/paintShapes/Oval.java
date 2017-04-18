package paintShapes;

import interfaces.Editable;
import interfaces.Selectable;
import paintField.ShapesList;

import java.awt.*;

public class Oval extends Shape implements Selectable, Editable {
    Point center;
    int rx;
    int ry;
    @Override
    public boolean isSelected(Point point) {
        int s1 = ( int )Math.pow(point.getX() - center.getX(), 2) /
                 ( int )Math.pow(rx, 2);
        int s2 = ( int )Math.pow(point.getY() - center.getY(), 2) /
                 ( int )Math.pow(ry, 2);
        if (s1 + s2 <= 1) {
            return true;
        }
        return false;
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2 = setG2D(graphics);
        int i = getCoords().size();
        if (i >= 2) {
            Point [] arr = new Point[2];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = getCoords().get(j);
            }
            int width = Math.abs(arr[1].x - arr[0].x);
            int heigth = Math.abs(arr[1].y - arr[0].y);
            rx = width / 2;
            ry = heigth / 2;
            center = new Point(getMin(arr[0].x, arr[1].x),  getMin(arr[0].y, arr[1].y));
            graphics2.setColor(this.getFillrCol());
            graphics2.fillOval(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y), width, heigth);
            graphics2.setColor(this.getBorderCol());
            graphics2.setStroke(this.getStroke());
            graphics2.drawOval(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y), width, heigth);
        }
    }

    @Override
    public void update(Color fill, Color border) {
        if (fill != null) {
            setFillCol(fill);
        }
        if (border != null) {
            setBorderCol(border);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (Point pt:
                getCoords()) {
            Point newPt = new Point(getCoords().get(getCoords().indexOf(pt)).x + dx,
                    getCoords().get(getCoords().indexOf(pt)).y + dy);
            getCoords().set(getCoords().indexOf(pt), newPt);
            ShapesList.getInstance().status = "changed";
        }
    }
}
