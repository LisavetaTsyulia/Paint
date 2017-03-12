package paintShapes;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by lisa on 11.3.17.
 */
public class Polygon extends Shapes {

    public void draw(Graphics graphics) {
        int xPoly[] = {150,250,325,375,450,275,100};
        int yPoly[] = {150,100,125,225,250,375,300};
        graphics.setColor(this.getFillrCol());
        graphics.fillPolygon(xPoly, yPoly, xPoly.length);
        graphics.setColor(this.getBorderCol());
        graphics.drawPolygon( xPoly, yPoly, xPoly.length);
    }
}
