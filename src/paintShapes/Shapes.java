package paintShapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lisa on 11.3.17.
 */
public abstract class Shapes {
    private Stroke stroke = new BasicStroke(3);
    private String name;
    private Color borderCol = new Color(98, 19, 82);
    private Color fillCol = new Color(59, 30, 88);
    private ArrayList<Point> coords = new ArrayList<>();

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public void setBorderCol(Color cl){
        borderCol = cl;
    }
    public Color getBorderCol(){
        return borderCol;
    }

    public void setFillCol(Color cl){
        fillCol = cl;
    }
    public Color getFillrCol(){
        return fillCol;
    }

    public void setCoords(ArrayList<Point> point){
        for (Point item : point) coords.add((Point) item.clone());
    }
    public ArrayList<Point> getCoords(){
        return coords;
    }
    public abstract void draw(Graphics graphics);
    public int getMin(int a, int b){
        if (a < b){
            return a;
        } else {
            return b;
        }
    }

    public Graphics2D setG2D(Graphics g){
        Graphics2D graphics2 = (Graphics2D) g;

        graphics2.setStroke(new BasicStroke(3));
        return graphics2;
    }

    public abstract boolean isSelected(Point point);

}
