package fabrica;

import paintShapes.*;

public class FabricaLine extends Fabrica {

    public Shape createShape() {
        return new Line();
    }

    @Override
    public String getName() {
        return "Line";
    }
}
