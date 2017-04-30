package fabrica;

import paintShapes.Polygon;
import paintShapes.Shape;

public class FabricaPolygon extends Fabrica {
    public FabricaPolygon() {
        setName("Polygon");
    }

    public Shape createShape() {
        return new Polygon();
    }

    @Override
    public String getName() {
        return "Polygon";
    }

    @Override
    public void setName(String name) {
        fabricaName = name;
    }
}
