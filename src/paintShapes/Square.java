package paintShapes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lisa on 11.3.17.
 */
public class Square extends Shapes {

    public void draw( Graphics graphics) {
        int i = this.getCoords().size();
        if (i >= 2) {
            Point [] arr = new Point[2];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = this.getCoords().get(j);
            }
            int width = Math.abs(arr[1].x - arr[0].x);
            int heigth = Math.abs(arr[1].y - arr[0].y);
            graphics.setColor(this.getFillrCol());
            graphics.fillRect(arr[0].x, arr[0].y, width, heigth);
            graphics.setColor(this.getBorderCol());
            graphics.drawRect(arr[0].x, arr[0].y, width, heigth);
        }

    }
}
