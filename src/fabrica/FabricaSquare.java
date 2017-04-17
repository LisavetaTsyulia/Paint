package fabrica;

import paintShapes.*;

public class FabricaSquare extends Fabrica {
    public Shape createShape() {
        return new Square();
    }

    @Override
    public String getName() {
        return "Square";
    }
}
