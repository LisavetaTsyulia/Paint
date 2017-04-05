package paintShapes;

import interfaces.IEditable;
import interfaces.ISelectable;

import java.awt.*;

/**
 * Created by lisa on 11.3.17.
 */
public class Square extends Shapes implements ISelectable, IEditable {
    Point startPoint;
    Point endPoint;

    @Override
    public boolean isSelected(Point point) {
        if ((point.getX() >= startPoint.getX()) && (point.getY() >= startPoint.getY()) &&
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
            endPoint = new Point(getMin(arr[0].x, arr[1].x) + getMin(width, heigth),
                                    getMin(arr[0].y, arr[1].y) + getMin(width, heigth));
            graphics2.setColor(this.getFillrCol());
            graphics2.fillRect(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y),
                                            getMin(width, heigth), getMin(width, heigth));
            graphics2.setColor(this.getBorderCol());
            graphics2.setStroke(this.getStroke());
            graphics2.drawRect(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y),
                                            getMin(width, heigth), getMin(width, heigth));
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
