package fabrica;

import paintShapes.Rectangle;
import paintShapes.Shapes;

/**
 * Created by lisa on 21.3.17.
 */
public class FabricaRectangle extends Fabrica {
    public Shapes createShape() {
        return new Rectangle();
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
