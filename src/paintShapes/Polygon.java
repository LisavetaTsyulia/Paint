package paintShapes;

import java.awt.*;

/**
 * Created by lisa on 11.3.17.
 */
public class Polygon extends Shapes {

    @Override
    public boolean isSelected(Point point) {
        int i = this.getCoords().size();
        int [] arrX = new int[i];
        int [] arrY = new int[i];
        if (i >= 3) {
            for (int j = 0; j < arrX.length; j++) {
                arrX[j] = (int) this.getCoords().get(j).getX();
                arrY[j] = (int) this.getCoords().get(j).getY();
            }
        }
        java.awt.Polygon polygon = new java.awt.Polygon(arrX, arrY, arrX.length);
        return polygon.contains(point.getX(), point.getY());
    }

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
        graphics2.setColor(this.getFillrCol());
        graphics2.fillPolygon(arrX, arrY, arrX.length);
        graphics2.setColor(this.getBorderCol());
        graphics2.setStroke(this.getStroke());
        graphics2.drawPolygon( arrX, arrY, arrX.length);
    }
}
