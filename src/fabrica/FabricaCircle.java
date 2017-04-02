package fabrica;

import paintShapes.*;

/**
 * Created by lisa on 20.3.17.
 */
public class FabricaCircle extends Fabrica {
    public Shapes createShape() {
        return new Circle();
    }

    @Override
    public String getName() {
        return "Circle";
    }
}
