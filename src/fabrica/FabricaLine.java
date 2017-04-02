package fabrica;

import paintShapes.*;

/**
 * Created by lisa on 20.3.17.
 */
public class FabricaLine extends Fabrica {

    public Shapes createShape() {
        return new Line();
    }

    @Override
    public String getName() {
        return "Line";
    }
}
