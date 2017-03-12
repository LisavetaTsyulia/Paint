package paintShapes;

import java.awt.*;

/**
 * Created by lisa on 11.3.17.
 */
public class Circle extends Shapes {
    public void draw(Graphics graphics) {
        graphics.setColor(this.getFillrCol());
        graphics.fillOval(55, 55, 100, 100);
        graphics.setColor(this.getBorderCol());
        graphics.drawOval(55, 55, 100, 100);
    }
}
