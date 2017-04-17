package fabrica;

import paintShapes.*;

public class FabricaCircle extends Fabrica {
    public Shape createShape() {
        return new Circle();
    }

    @Override
    public String getName() {
        return "Circle";
    }
}
