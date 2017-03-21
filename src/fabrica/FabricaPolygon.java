package fabrica;

import paintShapes.Polygon;
import paintShapes.Shapes;

/**
 * Created by lisa on 20.3.17.
 */
public class FabricaPolygon extends Fabrica {
    public Shapes createShape() {
        return new Polygon();
    }
}
