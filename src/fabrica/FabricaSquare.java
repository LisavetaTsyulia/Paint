package fabrica;

import paintShapes.*;

/**
 * Created by lisa on 20.3.17.
 */
public class FabricaSquare extends Fabrica {
    public Shapes createShape() {
        return new Square();
    }
}
