import fabrica.Fabrica;
import interfaces.Editable;
import interfaces.Selectable;
import paintField.ShapesList;
import paintShapes.Shape;

import java.awt.*;

public class FabricaCircle extends Fabrica {

    public FabricaCircle() {

    }

    @Override
    public Shape createShape() {
        return new FabricaCircle.Circle();
    }

    @Override
    public String getName() {
        setName("Circle");
        return fabricaName;
    }

    @Override
    public void setName(String name) {
        fabricaName = name;
    }

    public static class Circle extends Shape implements Editable, Selectable {
        int radius ;
        Point center;
        Graphics2D graphics2 ;

        public void draw(Graphics graphics) {
            graphics2 = setG2D(graphics);
            int i = getCoords().size();
            if (i >= 2) {
                Point [] arr = new Point[2];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = getCoords().get(j);
                }
                int width = Math.abs(arr[1].x - arr[0].x);
                int heigth = Math.abs(arr[1].y - arr[0].y);
                radius = getMin(width, heigth) / 2;
                center = new Point(getMin(arr[0].x, arr[1].x) + radius,
                        getMin(arr[0].y, arr[1].y) + radius);
                graphics2.setColor(this.getFillrCol());
                graphics2.fillOval(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y),
                        getMin(width, heigth), getMin(width, heigth));
                graphics2.setColor(this.getBorderCol());
                graphics2.setStroke(this.getStroke());
                graphics2.drawOval(getMin(arr[0].x, arr[1].x), getMin(arr[0].y, arr[1].y),
                        getMin(width, heigth), getMin(width, heigth));
            }
        }

        public boolean isSelected(Point point) {
            if ( (int)Math. pow((point.getX() - center.getX()), 2) +
                    (int)Math. pow((point.getY() - center.getY()), 2) < (int)Math. pow(radius, 2)) {
                return true;
            }
            return false;
        }


        public void update(Color fill, Color border) {
            if (fill != null) {
                setFillCol(fill);
            }
            if (border != null) {
                setBorderCol(border);
            }
        }

        public void move(int dx, int dy) {
            for (Point pt:
                    getCoords()) {
                Point newPt = new Point(getCoords().get(getCoords().indexOf(pt)).x + dx,
                        getCoords().get(getCoords().indexOf(pt)).y + dy);
                getCoords().set(getCoords().indexOf(pt), newPt);
                ShapesList.getInstance().status = "changed";
            }
        }
    }

}
