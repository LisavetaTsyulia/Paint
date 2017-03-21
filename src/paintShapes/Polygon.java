package paintShapes;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by lisa on 11.3.17.
 */
public class Polygon extends Shapes {

    public void draw(Graphics graphics) {
        Graphics2D graphics2 = setG2D(graphics);
        int i = this.getCoords().size();
        int [] arrX = new int[i];
        int [] arrY = new int[i];
        if (i >= 3) {
            for (int j = 0; j < arrX.length; j++) {
                arrX[j] =(int) this.getCoords().get(j).getX();
                arrY[j] =(int) this.getCoords().get(j).getY();
            }
        }
        int xPoly[] = {150,250,325,375,450,275,100};
        int yPoly[] = {150,100,125,225,250,375,300};
        graphics2.setColor(this.getFillrCol());
        graphics2.fillPolygon(arrX, arrY, arrX.length);
        graphics2.setColor(this.getBorderCol());
        graphics2.drawPolygon( arrX, arrY, arrX.length);
    }
}
