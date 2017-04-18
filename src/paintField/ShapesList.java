package paintField;

import fabrica.Fabrica;
import interfaces.Selectable;
import paintShapes.Shape;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ShapesList {
    private static ShapesList ourInstance = new ShapesList();
    ArrayList<Shape> list = new ArrayList<>();
    private Shape selectedShape = null;
    public String status = "";

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape selectedShape) {

        this.selectedShape = selectedShape;
    }

    public static ShapesList getInstance()
    {
        return ourInstance;
    }

    private ShapesList() {
    }

    public void addShape(Fabrica fabrica, Color bcl, Color fcl, ArrayList<Point> pointArrayList){
        Shape newShape = fabrica.createShape();
        newShape.setBorderCol(bcl);
        newShape.setFillCol(fcl);
        newShape.setName(fabrica.getName());
        newShape.setCoords(pointArrayList);
        list.add(newShape);
        //showList();
    }

    public void drawList(Graphics graphics){
        for (Shape sh:
             list) {
            sh.draw(graphics);
        }
    }

    public void clearList(){
        list.clear();
    }

    public void showList(){
        for (Shape sh:
             list) {
            System.out.println(sh.getName());
            System.out.println(sh.getCoords().toString());
        }
    }

    public void serializeList(FileWriter writer) {
        for (Shape sh:
             list) {
            try {
                writer.write(toString(sh));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String toString(Shape sh) {
        String result = sh.getName() + "/" + getPointArray(sh) + "/" +
                        String.valueOf(sh.getFillrCol().getRed()) + "." +
                        String.valueOf(sh.getFillrCol().getGreen()) + "." +
                        String.valueOf(sh.getFillrCol().getBlue()) + "/" +
                        String.valueOf(sh.getBorderCol().getRed()) + "." +
                        String.valueOf(sh.getBorderCol().getGreen()) + "." +
                        String.valueOf(sh.getBorderCol().getBlue()) + "\r\n";
        return result;
    }

    private String getPointArray( Shape sh ) {
        String result = "";
        for (Point point:
             sh.getCoords()) {
            result += (int)point.getX() + "," + (int)point.getY() + ";" ;
        }
        return result;
    }

    public Shape trySelectedShapes(Point point) {
        Shape result = null;
        for ( Shape sh:
             list) {
            if (sh instanceof Selectable) {
                if ( ((Selectable) sh ).isSelected(point)) {
                    result = sh;
                }
            }
        }
        return result;
    }
}
