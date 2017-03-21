package paintShapes;

import java.awt.*;

/**
 * Created by lisa on 11.3.17.
 */
public class Line extends Shapes {
    public void draw(Graphics graphics) {
        Graphics2D graphics2 = setG2D(graphics);
        graphics2.setColor(this.getFillrCol());
        int i = this.getCoords().size();
        if (i >= 2) {
            Point [] arr = new Point[2];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = this.getCoords().get(j);
            }
            graphics2.drawLine(arr[0].x, arr[0].y, arr[1].x, arr[1].y);
        }
    }
}
