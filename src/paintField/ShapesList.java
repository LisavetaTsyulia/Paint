package paintField;

import paintShapes.*;
import paintShapes.Polygon;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lisa on 11.3.17.
 */
public class ShapesList {
    private static ShapesList ourInstance = new ShapesList();
    ArrayList<Shapes> list = new ArrayList<Shapes>();

    public static ShapesList getInstance()
    {
        return ourInstance;
    }

    private ShapesList() {
    }

    public void addShape(String type, Color bcl, Color fcl){
        Shapes newShape = createShape(type);
        newShape.setBorderCol(bcl);
        newShape.setFillCol(fcl);
        list.add(newShape);
    }
    //fabric method
    protected Shapes createShape(String type){
        Shapes sh = null;
        if (type.equals("line")){
            sh = new Line();
        } else if (type.equals("square")){
            sh = new Square();
        } else if (type.equals("circle")){
            sh = new Circle();
        } else if (type.equals("polygon")){
            sh = new Polygon();
        }
        return sh;
    }

    public void drawList(Graphics graphics){
        for (Shapes sh:
             list) {
            sh.draw(graphics);
        }
    }

    public void clearList(){
        list.clear();
    }
}
