package paintField;

import fabrica.Fabrica;
import paintShapes.*;
import paintShapes.Polygon;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lisa on 11.3.17.
 */
public class ShapesList {
    private static ShapesList ourInstance = new ShapesList();
    ArrayList<Shapes> list = new ArrayList<>();

    public static ShapesList getInstance()
    {
        return ourInstance;
    }

    private ShapesList() {
    }

    public void addShape(Fabrica fabrica, Color bcl, Color fcl, ArrayList<Point> pointArrayList){
        Shapes newShape = fabrica.createShape();
        newShape.setBorderCol(bcl);
        newShape.setFillCol(fcl);
        newShape.setName("Sh" + list.size());
        newShape.setCoords(pointArrayList);
        list.add(newShape);
        showList();
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

    public void showList(){
        for (Shapes sh:
             list) {
            System.out.println(sh.getName());
            System.out.println(sh.getCoords().toString());
        }
    }
}
