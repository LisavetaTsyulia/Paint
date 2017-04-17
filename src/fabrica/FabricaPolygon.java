package fabrica;

import paintShapes.Polygon;
import paintShapes.Shape;

public class FabricaPolygon extends Fabrica {
    public Shape createShape() {
        return new Polygon();
    }

    @Override
    public String getName() {
        return "Polygon";
    }
}
