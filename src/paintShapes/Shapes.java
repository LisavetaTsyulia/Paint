package paintShapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lisa on 11.3.17.
 */
public abstract class Shapes {
    private String name;
    private Color borderCol = new Color(98, 19, 82);
    private Color fillCol = new Color(59, 30, 88);
    private ArrayList<Point> coords = new ArrayList<Point>();

    public String getName(){
        return name;
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

    public void addCoords(Point pt){
        coords.add(pt);
    }

    public abstract void draw(Graphics graphics);
}
