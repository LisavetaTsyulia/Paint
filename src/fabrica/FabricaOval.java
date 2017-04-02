package fabrica;

import paintShapes.Oval;
import paintShapes.Shapes;

/**
 * Created by lisa on 21.3.17.
 */
public class FabricaOval extends Fabrica {
    public Shapes createShape() {
        return new Oval();
    }

    @Override
    public String getName() {
        return "Oval";
    }
}
