package paintShapes;

import java.awt.*;

/**
 * Created by lisa on 11.3.17.
 */
public class Line extends Shapes {
    public void draw(Graphics graphics) {
        graphics.setColor(this.getFillrCol());
        graphics.drawLine(35, 35, 68, 68);
    }
}
