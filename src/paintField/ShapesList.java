package paintField;

import fabrica.Fabrica;
import paintShapes.*;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
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
        newShape.setName(fabrica.getName());
        newShape.setCoords(pointArrayList);
        list.add(newShape);
        //showList();
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

    public void serializeList(FileWriter writer) {
        for (Shapes sh:
             list) {
            try {
                writer.write(toString(sh));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String toString(Shapes sh) {
        String result = sh.getName() + "/" + getPointArray(sh) + "/" +
                        String.valueOf(sh.getFillrCol().getRed()) + "." +
                        String.valueOf(sh.getFillrCol().getGreen()) + "." +
                        String.valueOf(sh.getFillrCol().getBlue()) + "/" +
                        String.valueOf(sh.getBorderCol().getRed()) + "." +
                        String.valueOf(sh.getBorderCol().getGreen()) + "." +
                        String.valueOf(sh.getBorderCol().getBlue()) + "\r\n";
        return result;
    }

    private String getPointArray( Shapes sh ) {
        String result = "";
        for (Point point:
             sh.getCoords()) {
            result += (int)point.getX() + "," + (int)point.getY() + ";" ;
        }
        return result;
    }

    public Shapes trySelectedShapes(Point point) {
        Shapes result = null;
        for ( Shapes sh:
             list) {
            if (sh.isSelected(point)) {
                result = sh;
            }
        }
        return result;
    }
}
