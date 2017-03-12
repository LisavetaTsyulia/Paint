package paintShapes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lisa on 11.3.17.
 */
public class Square extends Shapes {

    public void draw( Graphics graphics) {
        graphics.setColor(this.getFillrCol());
        graphics.fillRect(10, 10, 100, 100);
        graphics.setColor(this.getBorderCol());
        graphics.drawRect(10, 10, 100, 100);
    }
}
