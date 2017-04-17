package fabrica;

import paintShapes.Oval;
import paintShapes.Shape;

public class FabricaOval extends Fabrica {
    public Shape createShape() {
        return new Oval();
    }

    @Override
    public String getName() {
        return "Oval";
    }
}
