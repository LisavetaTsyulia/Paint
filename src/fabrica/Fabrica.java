package fabrica;

import paintShapes.Shape;

public abstract class Fabrica {
    public abstract Shape createShape();
    public abstract String getName();
}
