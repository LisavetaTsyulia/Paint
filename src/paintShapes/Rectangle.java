package paintShapes;

import java.awt.*;

/**
 * Created by lisa on 21.3.17.
 */
public class Rectangle extends Shapes{
    Point startPoint;
    Point endPoint;
    @Override
    public boolean isSelected(Point point) {
        if ((point.getX() >= startPoint.getX()) && (point.getX() >= startPoint.getY()) &&
                (point.getX() <= endPoint.getX()) && (point.getY() <= endPoint.getY())) {
            return true;
        }
        return false;
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2 = setG2D(graphics);
        int i = this.getCoords().size();
        if (i >= 2) {
            Point [] arr = new Point[2];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = this.getCoords().get(j);
            }
            int width = Math.abs(arr[1].x - arr[0].x);
            int heigth = Math.abs(arr[1].y - arr[0].y);
            startPoint = new Point(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y));
            endPoint = new Point (getMin(arr[0].x, arr[1].x) + width,
                    getMin(arr[0].y, arr[1].y) + heigth);
            graphics2.setColor(this.getFillrCol());
            graphics2.fillRect(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y), width, heigth);
            graphics2.setColor(this.getBorderCol());
            graphics2.setStroke(this.getStroke());
            graphics2.drawRect(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y), width, heigth);
        }
    }
}
