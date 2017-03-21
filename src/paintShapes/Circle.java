package paintShapes;

import java.awt.*;

/**
 * Created by lisa on 11.3.17.
 */
public class Circle extends Shapes {
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
            graphics2.setColor(this.getFillrCol());
            graphics2.fillOval(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y),
                                            getMin(width, heigth), getMin(width, heigth));
            graphics2.setColor(this.getBorderCol());
            graphics2.drawOval(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y),
                                            getMin(width, heigth), getMin(width, heigth));
        }
    }
}
