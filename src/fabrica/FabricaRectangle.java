package fabrica;

import paintShapes.Rectangle;
import paintShapes.Shape;

public class FabricaRectangle extends Fabrica {
    public Shape createShape() {
        return new Rectangle();
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
