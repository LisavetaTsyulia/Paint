package fabrica;

import paintShapes.*;

public class FabricaSquare extends Fabrica {
    public FabricaSquare() {
        setName("Square");
    }

    public Shape createShape() {
        return new Square();
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public void setName(String name) {
        fabricaName = name;
    }
}
