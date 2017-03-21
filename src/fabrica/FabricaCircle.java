package fabrica;

import paintShapes.Circle;
import paintShapes.Shapes;

/**
 * Created by lisa on 20.3.17.
 */
public class FabricaCircle extends Fabrica {
    public Shapes createShape() {
        return new Circle();
    }
}
