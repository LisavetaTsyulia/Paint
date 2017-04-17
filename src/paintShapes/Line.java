package paintShapes;

import interfaces.Editable;
import interfaces.Selectable;

import java.awt.*;

public class Line extends Shape implements Selectable, Editable {
    Point pointStart;
    Point pointEnd;

    @Override
    public boolean isSelected(Point point) {
        int width = (int) Math.abs(pointStart.getX() - pointEnd.getX());
        int height = (int) Math.abs(pointStart.getY() - pointEnd.getY());
        int minX = (int) Math.min(pointStart.getX(), pointEnd.getX());
        int minY = (int) Math.min(pointStart.getY(), pointEnd.getY());
        int sign = pointStart.getY() < pointEnd.getY() ? 1 : -1;
        if (point.getX() < minX || point.getY() < minY || point.getX() > minX + width || point.getY() > minY + height) {
            return false;
        }
        int wPoint = (int) (point.getX() - minX);
        double part = (double)wPoint / width;
        int hPoint = (int)(minY + sign * height * part + (sign > 0 ? 0 : height));
        return Math.abs(hPoint - point.getY()) < 15;
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2 = setG2D(graphics);
        graphics2.setColor(this.getFillrCol());
        int i = this.getCoords().size();
        if (i >= 2) {
            Point [] arr = new Point[2];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = this.getCoords().get(j);
            }
            pointStart = arr[0];
            pointEnd = arr[1];
            graphics2.setStroke(this.getStroke());
            graphics2.drawLine(arr[0].x, arr[0].y, arr[1].x, arr[1].y);
        }
    }

    @Override
    public void move(int dx, int dy) {
            for (Point pt:
                    getCoords()) {
                pt.move(dx, dy);
                System.out.println(pt.getX() + pt.getY());
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
}
