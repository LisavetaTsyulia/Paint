package fabrica;

import paintShapes.Shape;

public abstract class Fabrica {
    public String fabricaName;
    public abstract Shape createShape();
    public abstract String getName();
    public abstract void setName(String name);
}
