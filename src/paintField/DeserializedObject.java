package paintField;

import fabrica.Fabrica;

import java.awt.*;
import java.util.ArrayList;

public class DeserializedObject {
    private String name;
    private Color fillColor;
    private Color borderColor;
    private Fabrica fabrica;
    private ArrayList<Point> coords;

    public String getName() {
        return name;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public ArrayList<Point> getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<Point> coords) {

        this.coords = coords;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }
}
