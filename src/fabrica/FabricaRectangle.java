package fabrica;

import paintShapes.Rectangle;
import paintShapes.Shape;

public class FabricaRectangle extends Fabrica {
    public FabricaRectangle() {
        setName("Rectangle");
    }

    public Shape createShape() {
        return new Rectangle();
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void setName(String name) {
        fabricaName = name;
    }
}
